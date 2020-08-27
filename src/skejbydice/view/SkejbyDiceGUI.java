package skejbydice.view;

import skejbydice.domain.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SkejbyDiceGUI {
    private Game game;

    public static void main(String[] args) {
        new SkejbyDiceGUI();
    }

    public SkejbyDiceGUI() {
        game = new Game(new ChosePlayerWithClickStrategy(),new RegularRerollOrAttackStrategy(), new RegularDecideNumberOfTurnsStrategy(), new RegularDie(new RandomRollStrategy()),new RegularDie(new RandomRollStrategy()),new RegularDie(new RandomRollStrategy()));


        JFrame frame = new JFrame("Skejby Dice");
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(createButtonPanel(), BorderLayout.SOUTH);

        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new GridLayout(4, 1));
        statusPanel.add(new JLabel("Søren"));
        statusPanel.add(new JLabel("Beers: "));
        statusPanel.add(new JLabel("Sips: "));
        statusPanel.add(new JLabel("Lucky Die: "));
        contentPane.add(statusPanel, BorderLayout.EAST);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        String text = "Test";
        textPanel.add(new JLabel(text), BorderLayout.CENTER);
        contentPane.add(textPanel, BorderLayout.CENTER);


        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem newGame = new JMenuItem("New Game");
        file.add(newGame);

        menuBar.add(file);
        frame.setJMenuBar(menuBar);
        frame.pack();
        frame.setVisible(true);
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
