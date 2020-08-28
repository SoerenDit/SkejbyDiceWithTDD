package skejbydice.view;

import skejbydice.domain.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class SkejbyDiceGUI {
    private Game game;

    public SkejbyDiceGUI(Game game) throws InterruptedException {
        this.game = game;
        JFrame frame = new JFrame("Skejby Dice");
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(createButtonPanel(), BorderLayout.SOUTH);

        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new GridLayout(4, 1));
        JLabel l1 = new JLabel();
        JLabel l2 = new JLabel();
        JLabel l3 = new JLabel();
        JLabel l4 = new JLabel();
        statusPanel.add(l1);
        statusPanel.add(l2);
        statusPanel.add(l3);
        statusPanel.add(l4);
        updatePlayerStatus(l1,l2,l3,l4);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        JLabel textLabel = new JLabel();
        textPanel.add(textLabel, BorderLayout.CENTER);
        updateTextPanel(textLabel);

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

    private void updateTextPanel(JLabel textLabel) {
        game.getStatusText();
    }

    private void updatePlayerStatus(JLabel l1, JLabel l2, JLabel l3, JLabel l4) {
        l1.setText(game.getNameOfActivePlayer());
        l2.setText("Beers: " + game.getBeerFromActivePlayer());
        l3.setText("Sips: " + game.getSipsFromActivePlayer());
        l4.setText("Lucky Die: " + game.getLuckyDieNumberFromActivePlayer());
    }

    private JComponent createButtonPanel() {
        Box panel = new Box(BoxLayout.X_AXIS);

        JButton rollButton = new JButton("Roll");
        rollButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel.add(rollButton);

        JButton drinkButton = new JButton("Drink");
        rollButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel.add(drinkButton);
        return panel;
    }
}
