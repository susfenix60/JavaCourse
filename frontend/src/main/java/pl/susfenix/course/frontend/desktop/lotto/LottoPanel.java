package pl.susfenix.course.frontend.desktop.lotto;

import javax.swing.*;
import java.awt.*;

public class LottoPanel {

    public static JPanel create() {
        final JPanel numbersPanel = new JPanel(new GridLayout(7, 7));
        final JCheckBox[] checkBoxes = new JCheckBox[49]; // 49 liczb do wyboru
        for (int i = 0; i < checkBoxes.length; i++) {
            checkBoxes[i] = new JCheckBox(String.valueOf(i + 1));
            numbersPanel.add(checkBoxes[i]);
        }

        final JLabel resultLabel = new JLabel("Wynik: ");
        final JLabel drawnNumbersLabel = new JLabel("Wylosowane liczby: ");
        final JButton drawButton = new JButton("Losuj");
        drawButton.addActionListener(action -> handleAction());

        final JPanel controlPanel = new JPanel();
        controlPanel.add(drawButton);
        controlPanel.add(drawnNumbersLabel);
        controlPanel.add(resultLabel);

        final JPanel lottoPanel = new JPanel();
        lottoPanel.add(numbersPanel, BorderLayout.CENTER);
        lottoPanel.add(controlPanel, BorderLayout.SOUTH);

        return lottoPanel;
    }

    private static void handleAction() {

    }
}
