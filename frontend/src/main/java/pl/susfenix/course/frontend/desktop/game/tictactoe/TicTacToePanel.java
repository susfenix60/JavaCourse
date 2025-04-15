package pl.susfenix.course.frontend.desktop.game.tictactoe;

import pl.susfenix.course.backend.game.tictactoe.logic.TicTacToeApi;
import pl.susfenix.course.backend.game.tictactoe.model.GameStatus;
import pl.susfenix.course.backend.game.tictactoe.model.TicTacToeGameState;
import pl.susfenix.course.backend.game.tictactoe.model.Player;
import pl.susfenix.course.frontend.desktop.layout.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToePanel extends JPanel {
    private static final Logger log = Logger.INSTANCE;

    private static final int BOARD_SIZE = 3;
    private final JButton[][] buttons;

    private TicTacToeApi ticTacToeApi = new TicTacToeApi();
    public TicTacToePanel() {
        super.setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));

        this.buttons = initializeButtons();
        for (int row = 0; row < buttons.length; row++) {
            for (int column = 0; column < buttons.length; column++) {
                super.add(buttons[row][column]);
            }
        }

        log.info(ticTacToeApi.getGameState().getGameResult().getMessage());
    }

    private JButton[][] initializeButtons() {
        final JButton[][] buttons = new JButton[BOARD_SIZE][BOARD_SIZE];
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                final JButton currentButton = new JButton(" ");
                currentButton.setFont(new Font("Arial", Font.BOLD, 40));

                ActionListener onClickButtonListener = onClickAction(currentButton);
                currentButton.addActionListener(onClickButtonListener);
                buttons[row][column] = currentButton;
            }
        }
        return buttons;
    }

    private ActionListener onClickAction(JButton currentButton) {
        final ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!currentButton.getText().equals(" ")) {
                    log.info("Ruch niedozwolony");
                    return;
                }
                final int[] buttonIndexes = findButtonIndex(currentButton);
                final Player currentPlayer = ticTacToeApi.getGameState().getCurrentPlayer();

                final TicTacToeGameState newGameState = ticTacToeApi.makeMove(buttonIndexes[0], buttonIndexes[1]);

                currentButton.setText(String.valueOf(currentPlayer.getSymbol()));
                currentButton.setEnabled(false);

                log.info(newGameState.getGameResult().getMessage());
                if (newGameState.getGameResult().getStatus() == GameStatus.WINNER || newGameState.getGameResult().getStatus() == GameStatus.DRAW){
                    for (int row = 0; row < buttons.length; row++) {
                        for (int col = 0; col < buttons.length; col++) {
                            buttons[row][col].setEnabled(false);
                        }
                    }
                }
            }
        };
        return actionListener;
    }
    private int[] findButtonIndex(JButton currentButton) {
        for (int row = 0; row < buttons.length; row++) {
            for (int col = 0; col < buttons.length; col++) {
                if (buttons[row][col] == currentButton) {
                    return new int[] {row, col};
                }
            }
        }
        throw new IllegalStateException("Should never happen");
    }
}