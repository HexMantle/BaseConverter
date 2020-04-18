/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseconverter;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author sehga
 */
public class Converter implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Converter");
        frame.setPreferredSize(new Dimension(500, 200));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container c) {
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

        JTextField input = new JTextField("");
        JLabel output = new JLabel("");
        

        c.add(input);
        c.add(createPanel(input, output));
        c.add(output);
    }

    private JPanel createPanel(JTextField input, JLabel output) {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JButton convert = new JButton("convert");

        JTextField base1 = new JTextField();
        JTextField base2 = new JTextField();
        convert.addActionListener(new baseListener(input, output, base1, base2));
        c.weightx = 1.;
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0;
        c.gridy = 0;
        panel.add(new JLabel("From:"), c);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(base1, c);
        c.gridx = 1;
        c.gridy = 0;
        panel.add(new JLabel("To:"), c);
        c.gridx = 1;
        c.gridy = 1;
        panel.add(base2, c);
        c.gridx = 2;
        c.gridy = 1;
        panel.add(convert, c);
        
        return panel;
    }

}
