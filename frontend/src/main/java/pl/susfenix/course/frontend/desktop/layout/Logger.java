package pl.susfenix.course.frontend.desktop.layout;

import javax.swing.*;

public class Logger {

    public static final Logger INSTANCE = new Logger();

    private final JTextArea logger;

    private Logger() {
        this.logger = createLogger();
    }

    private JTextArea createLogger() {
        JTextArea logger = new JTextArea(5, 50);
        logger.setEditable(false);
        return logger;
    }

    public JTextArea getLogger() {
        return logger;
    }

    public void info(String message) {
        logger.append(message + "\n");

    }
}