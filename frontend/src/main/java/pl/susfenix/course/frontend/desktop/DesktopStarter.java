package pl.susfenix.course.frontend.desktop;

import pl.susfenix.course.frontend.desktop.layout.MainFrame;

import javax.swing.*;

public class DesktopStarter {

    public static void start() {
        javax.swing.SwingUtilities.invokeLater(() -> {

            final JFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}
