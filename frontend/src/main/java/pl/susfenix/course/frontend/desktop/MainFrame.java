package pl.susfenix.course.frontend.desktop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class MainFrame {

    private static final List<JButton> GAME_BUTTONS = Arrays.asList(
            createGameButton("Lotto", actionEvent -> openLottoGame())
    );

    public static JFrame create(){
       final JFrame mainFrame = new JFrame();
       mainFrame.setLayout(new FlowLayout());
       mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       mainFrame.setTitle("Wybierz grę");

        for (JButton gameButton : GAME_BUTTONS) {
            mainFrame.add(gameButton);
        }

        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);

        return mainFrame;
    }

    private static JButton createGameButton(String name, ActionListener listener) {
        final JButton gameButton = new JButton(name);
        gameButton.addActionListener(listener);
        return gameButton;
    }

    private static void openLottoGame() {
      /*  LottoGame lottoGame = new LottoGame();
        lottoGame.setVisible(true);*/
    }
}