package pl.susfenix.course.backend.game.tictactoe.model;

public class GameResult {
    private final GameStatus status;
    private final String message;

    private GameResult(GameStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public GameStatus getStatus(){
        return this.status;
    }
    public String getMessage(){
        return this.message;
    }

    public static GameResult initial(Player currentPlayer){
        return new GameResult(GameStatus.INICIALAZED, "new game started. current player is: " + currentPlayer.getSymbol());
    }

    public static GameResult winner(Player winner){
        return new GameResult(GameStatus.WINNER, "The winner is: " + winner.getSymbol());
    }

    public static GameResult inGame(Player newPlayer){
        return new GameResult(GameStatus.IN_GAME, "Next turn, current player is: " + newPlayer.getSymbol());
    }

    public static GameResult draw(){
        return new GameResult(GameStatus.DRAW, "The game has ended with a draw.");
    }

}
