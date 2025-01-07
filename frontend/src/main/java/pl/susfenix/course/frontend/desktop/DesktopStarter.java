package pl.susfenix.course.frontend.desktop;

import pl.susfenix.course.frontend.console.ConsoleStarter;

import javax.swing.*;

public class DesktopStarter {

    public static void start() {
        javax.swing.SwingUtilities.invokeLater(() -> {
            final JFrame mainFrame = MainFrame.create();
            mainFrame.setVisible(true);
        });
    }
}
