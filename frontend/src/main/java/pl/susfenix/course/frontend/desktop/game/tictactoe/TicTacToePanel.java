package pl.susfenix.course.frontend.desktop.game.tictactoe;

import pl.susfenix.course.backend.game.tictactoe.TicTacToeGameState;
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

    private TicTacToeGameState gameState = new TicTacToeGameState();
    public TicTacToePanel() {
        super.setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));

        this.buttons = initializeButtons();
        for (int row = 0; row < buttons.length; row++) {
            for (int column = 0; column < buttons.length; column++) {
                super.add(buttons[row][column]);
            }
        }

        log.info("START NEW GAME. CURRENT PLAYER IS: " + gameState.getCurrentPlayer());
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
                currentButton.setText(gameState.getCurrentPlayer().name());
                currentButton.setEnabled(false);

                final Player nextPlayer = gameState.nextPlayer();

                log.info("CURRENT PLAYER IS: " + nextPlayer);
            }
        };
        return actionListener;
    }
}