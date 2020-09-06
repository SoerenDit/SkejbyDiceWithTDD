package skejbydice.view;

import skejbydice.domain.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class SkejbyDiceGUI {
    private Game game;
    private JLabel textLabel;
    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;

    public SkejbyDiceGUI(Game game) throws InterruptedException {
        this.game = game;
        JFrame frame = new JFrame("Skejby Dice");
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(createButtonPanel(), BorderLayout.SOUTH);

        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new GridLayout(4, 1));
        l1 = new JLabel();
        l2 = new JLabel();
        l3 = new JLabel();
        l4 = new JLabel();
        statusPanel.add(l1);
        statusPanel.add(l2);
        statusPanel.add(l3);
        statusPanel.add(l4);
        updatePlayerStatus();

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        textLabel = new JLabel();
        textPanel.add(textLabel, BorderLayout.CENTER);
        updateTextPanel();

        contentPane.add(statusPanel, BorderLayout.EAST);
        contentPane.add(textPanel, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem newGame = new JMenuItem("New Game");
        file.add(newGame);

        menuBar.add(file);
        frame.setJMenuBar(menuBar);
        frame.pack();
        frame.setVisible(true);
        TimeUnit.MINUTES.sleep(1);
    }

    private void updateTextPanel() {
        textLabel.setText(game.getStatusText());
    }

    private void updatePlayerStatus() {
        l1.setText(game.getNameOfActivePlayer());
        l2.setText("Beers: " + game.getBeerFromActivePlayer());
        l3.setText("Sips: " + game.getSipsFromActivePlayer());
        l4.setText("Lucky Die: " + game.getLuckyDieNumberFromActivePlayer());
    }

    private JComponent createButtonPanel() {
        Box panel = new Box(BoxLayout.X_AXIS);

        JButton okButton = new JButton("Ok");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (game.getCurrentState()) {
                    case start:
                        game.onGameStarted();
                        updatePlayerStatus();
                        updateTextPanel();
                        break;
                }
            }
        });
        panel.add(okButton);

        JButton rollButton = new JButton("Roll");
        rollButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (game.getCurrentState()) {
                    case aboutToRollAttackingDice:
                        game.onRollAttackingDice();
                        updatePlayerStatus();
                        updateTextPanel();
                        break;
                }
            }
        });
        panel.add(rollButton);

        JButton drinkButton = new JButton("Drink");
        rollButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel.add(drinkButton);

        JButton nextButton = new JButton("Next");
        rollButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.gameFlow();
            }
        });
        panel.add(nextButton);
        return panel;
    }
}
