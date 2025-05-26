package pl.susfenix.course.backend.game.tictactoe.logic.player;

import pl.susfenix.course.backend.game.tictactoe.logic.TicTacToeApi;
//import org.apache.commons.text.StringEscapeUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class SmartComputerPlayerMover {

    private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(30L))
            .build();

    private String token;
    private String endpoint;

    private final DumbComputerPlayerMover dummyComputerPlayerMover;

    public SmartComputerPlayerMover(String token,
                                    String endpoint,
                                    DumbComputerPlayerMover dummyComputerPlayerMover) {
        this.token = token;
        this.endpoint = endpoint;
        this.dummyComputerPlayerMover = dummyComputerPlayerMover;
    }

    public int[] designatePosition(TicTacToeApi ticTacToeApi) {
        if (token.isBlank()) {
            return dummyComputerPlayerMover.designatePosition(ticTacToeApi);
        }

        String authorizationToken = this.token;
        String message = "Current board (3x3 grid, row by row):  \n"
                + ticTacToeApi.getGameState().getBoard().toString() + "\n"
                + "Player to move: " + ticTacToeApi.getGameState().getCurrentPlayer().getSymbol() + "\n"
                + "Return ONLY the best possible move (you are a master of this game) as JSON coordinates {move: [row, col]} where rows/cols are 0-2. So [3,3] does not exists";

        message = org.apache.commons.text.StringEscapeUtils.escapeJson(message);


        int[] extractedMove = null;
        final int MAX_RETRY = 3;
        int currentRetry = 0;
        boolean isMovePossible = false;

        try {
            while (!isMovePossible && currentRetry <= MAX_RETRY) {
                String chatResponse = makeCall(authorizationToken, message);
                System.out.println(chatResponse);

                extractedMove = extractMove(chatResponse);

                isMovePossible = ticTacToeApi.isMovePossible(extractedMove[0], extractedMove[1]);
                if (!isMovePossible) {
                    currentRetry++;
                }
            }
        } catch (Exception ex) {
            System.out.println("Error when get AI chat move. " + ex.getMessage());
            ex.printStackTrace();
            System.out.println("Make dummy move");
            return dummyComputerPlayerMover.designatePosition(ticTacToeApi);
        }

        if (!isMovePossible) {
            System.out.println("AI chat try " + MAX_RETRY + " times move that is not possible. Make dummy move");
            return dummyComputerPlayerMover.designatePosition(ticTacToeApi);
        }

        return extractedMove;
    }

    private String makeCall(String authorizationToken, String message) {
        try {
            URI deepseekEndpoint = new URI(this.endpoint);
            String body =
                    String.format("{" +
                            "\"messages\": [" +
                            "{ \"content\": \"%s\", \"role\": \"user\" }" +
                            "]," +
                            "\"model\": \"deepseek-chat\"," +
                            "\"response_format\": { \"type\": \"json_object\" }" +
                            "}", message);

            System.out.println("Request to chat is: " + body);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(deepseekEndpoint)
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .header("Authorization", "Bearer " + authorizationToken)
                    .timeout(Duration.ofSeconds(30L))
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();
            final HttpResponse<String> httpResponse = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

            if (httpResponse.statusCode() >= 200 && httpResponse.statusCode() <= 299) {
                return httpResponse.body();
            } else {
                throw new RuntimeException("Error when cal chat: " + httpResponse.body());
            }

        } catch (IOException | InterruptedException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private int[] extractMove(String chatResponse) {
        String chatMessageAsJSON = extractJSONElement(chatResponse, "\"message\"", "}");
        String chatMoveAsJSON = extractJSONElement(chatMessageAsJSON, "move", "}");

        System.out.println("\nEXTRACTED: " + chatMoveAsJSON);

        String chatMoveValue = extractJSONElement(chatMoveAsJSON, "[", "]");

        final String[] chatMoveValueSplit = chatMoveValue.substring(1, chatMoveValue.length() - 1).split(",");

        final int[] playerMove = new int[chatMoveValueSplit.length];
        for (int singleChatMoveValueIndex = 0; singleChatMoveValueIndex < chatMoveValueSplit.length; singleChatMoveValueIndex++) {
            playerMove[singleChatMoveValueIndex] = Integer.parseInt(chatMoveValueSplit[singleChatMoveValueIndex]
                    .replace("\\n", "")
                    .replace("\\t", "")
                    .trim());
        }
        return playerMove;
    }

    private static String extractJSONElement(String chatResponse, String prefix, String sufix) {
        final int prefixIndex = chatResponse.indexOf(prefix);
        if (prefixIndex == -1) {
            throw new RuntimeException(prefix + " prefix not found in " + chatResponse);
        }

        final int sufixIndex = chatResponse.indexOf(sufix, prefixIndex);
        if (sufixIndex == -1) {
            throw new RuntimeException(sufix + " sufix not found in " + chatResponse);
        }

        return chatResponse.substring(prefixIndex, sufixIndex + sufix.length());
    }
}
