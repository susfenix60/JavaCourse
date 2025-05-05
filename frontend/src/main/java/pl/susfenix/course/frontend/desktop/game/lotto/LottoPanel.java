package pl.susfenix.course.frontend.desktop.game.lotto;

import pl.susfenix.course.backend.game.lotto.Lotto;
import pl.susfenix.course.frontend.desktop.layout.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.TreeSet;

public class LottoPanel extends JPanel {
    private final Logger logger = Logger.INSTANCE;

    private final JCheckBox[] checkBoxes;
    private final JLabel userNumbersLabel;
    private final JLabel resultLabel;
    private final JLabel winnerNumbersLabel;
    private final JButton randomActionButton;
    private final JLabel wonMoneyLabel;

    public LottoPanel() {
        this.userNumbersLabel = new JLabel("Liczby użytkownika: ");
        this.resultLabel = new JLabel("Trafiłeś: ");
        this.winnerNumbersLabel = new JLabel("Wylosowane liczby: ");
        this.randomActionButton = new JButton("Losuj");
        this.wonMoneyLabel = new JLabel("Wygrałeś: ");


        this.checkBoxes = new JCheckBox[49]; // 49 liczb do wyboru
        for (int i = 0; i < checkBoxes.length; i++) {
            checkBoxes[i] = new JCheckBox(String.valueOf(i + 1));
        }

        initialize();
        this.logger.clear();
    }

    private void initialize() {
        final JPanel numbersPanel = new JPanel(new GridLayout(7, 7,2,2));
        for (JCheckBox checkBox : checkBoxes) {
            numbersPanel.add(checkBox);
        }


        final ActionListener actionListener = onClickAction();
        randomActionButton.addActionListener(actionListener);

        JPanel actionPanel = new JPanel();
        actionPanel.add(randomActionButton);

        JPanel userDataPanel = new JPanel();
        userDataPanel.add(userNumbersLabel);

        JPanel winnerDataPanel = new JPanel();
        winnerDataPanel.add(winnerNumbersLabel);

        JPanel resultDataPanel = new JPanel();
        resultDataPanel.add(resultLabel);

        JPanel wonMoneyPanel = new JPanel();
        wonMoneyPanel.add(wonMoneyLabel);

        final JPanel controlPanel = new JPanel(new GridLayout(5, 1,2,2));
        controlPanel.add(actionPanel);
        controlPanel.add(userDataPanel);
        controlPanel.add(winnerDataPanel);
        controlPanel.add(resultDataPanel);
        controlPanel.add(wonMoneyPanel);


        super.setLayout(new GridLayout(2, 1,2,2));
        super.add(numbersPanel, BorderLayout.CENTER);
        super.add(controlPanel, BorderLayout.SOUTH);
    }

    private ActionListener onClickAction() {
        final ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                final Set<Integer> selectedNumbers = new TreeSet<>();

                for (JCheckBox checkBox : checkBoxes) {
                    if (checkBox.isSelected()) {
                        selectedNumbers.add(Integer.valueOf(checkBox.getText()));
                    }
                }
                if (selectedNumbers.size() < 6) {
                    JOptionPane.showMessageDialog(null, "Podales mniej niz 6 liczb!");
                    return;
                }
                else if (selectedNumbers.size() > 6) {
                    JOptionPane.showMessageDialog(null, "Podales wiecej niz 6 liczb!");
                    return;
                }

                userNumbersLabel.setText("Liczby użytkownika: " + selectedNumbers);
                logger.info("Liczby użytkownika: " + selectedNumbers);

                Set<Integer> computerNumbers = Lotto.retrieveComputerNumbers();
                winnerNumbersLabel.setText("Wylosowane liczby: " + computerNumbers);
                logger.info("Wylosowane liczby: " + computerNumbers);

                int countedHits = Lotto.countHits(computerNumbers, selectedNumbers);
                resultLabel.setText("Liczba trafień wynosi: " + countedHits);
                logger.info("Liczba trafień wynosi: " + countedHits);

                double winMoney = Lotto.determineWinMoney(countedHits);
                wonMoneyLabel.setText("Wygrałeś " + winMoney + " zł.");
                logger.info("Wygrałeś " + winMoney + " zł.");

                //Lotto.startGame(selectedNumbers);

            }
        };
        return actionListener;
    }

}