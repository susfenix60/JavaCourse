package pl.susfenix.course.frontend.desktop.layout;

import pl.susfenix.course.frontend.desktop.game.tictactoe.TicTacToePanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private final JMenuBar menu;
    private final JTextArea logger;

    private JPanel currentGamePanel;

    //private GameFrontendApi gameFrontendApi;

    public MainFrame() {
        this.menu = createMenu();
        this.logger = Logger.INSTANCE.getLogger();
        // gameFrontendApi = new GameFrontendApi(this);

        super.setTitle("Game Menu");
        super.setSize(1366, 768);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(new BorderLayout());
        super.add(this.menu, BorderLayout.NORTH);

        final JScrollPane loggerInScrollPane = new JScrollPane(this.logger);
        loggerInScrollPane.setMinimumSize(new Dimension(450,768));
        super.add(loggerInScrollPane, BorderLayout.EAST);
    }



    private JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("Gry");

        JMenuItem lottoItem = new JMenuItem("Lotto");
       /* lottoItem.addActionListener(e -> {
            gameFrontendApi.startLotto()
        });*/

        JMenuItem ticTacToeItem = new JMenuItem("Kółko i Krzyżyk");
        ticTacToeItem.addActionListener(e -> refreshGamePanel(new TicTacToePanel()));

        JMenuItem checkersItem = new JMenuItem("Warcaby");
        //checkersItem.addActionListener(e -> gameFrontendApi.startCheckers());

        gameMenu.add(lottoItem);
        gameMenu.add(ticTacToeItem);
        gameMenu.add(checkersItem);

        menuBar.add(gameMenu);
        return menuBar;
    }


    public void refreshGamePanel(JPanel panel) {
        if (currentGamePanel != null) {
            remove(currentGamePanel);
        }
        this.currentGamePanel = panel;
        add(currentGamePanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }


}