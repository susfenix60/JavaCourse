package pl.susfenix.course.frontend.desktop.game.tictactoe;

import javax.swing.*;
import java.awt.*;

class TicTacToeAiConfigurationDialog {
    private static final String DEFAULT_ENDPOINT = "https://api.deepseek.com/chat/completions";

    public static String[] show() {
        JTextField tokenField = new JTextField(20);
        JTextField endpointField = new JTextField(DEFAULT_ENDPOINT, 20);

        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
        panel.add(new JLabel("API Token:"));
        panel.add(tokenField);
        panel.add(new JLabel("Endpoint:"));
        panel.add(endpointField);


        int result = JOptionPane.showConfirmDialog(
                null,
                panel,
                "Konfiguracja API",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {
            String token = new String(tokenField.getText()).trim();
            String endpoint = endpointField.getText().trim();

            return new String[] {token, endpoint};
        }

        return new String[0];
    }
}