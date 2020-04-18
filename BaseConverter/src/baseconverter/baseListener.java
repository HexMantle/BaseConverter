/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseconverter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author sehga
 */
public class baseListener implements ActionListener {

    private JTextField input;
    private JLabel output;
    private JTextField base1;
    private JTextField base2;

    public baseListener(JTextField input, JLabel output, JTextField base1, JTextField base2) {
        this.input = input;
        this.output = output;
        this.base1 = base1;
        this.base2 = base2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int X = 0;
        int Y = 0;
        int Val = 0;
        String[] a = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        ArrayList<String> letters = new ArrayList<String>(Arrays.asList(a));
        try {
            X = Integer.parseInt(base1.getText());
            Y = Integer.parseInt(base2.getText());

        } catch (NumberFormatException nfe) {
            this.input.setText("");
            this.base1.setText("");
            this.base2.setText("");

        }
        String[] arr = this.input.getText().split("");
        ArrayList<Integer> ints = new ArrayList<>();

        for (String string : arr) {
            if (letters.contains(string)) {
                ints.add(letters.indexOf(string));
            } else {
                ints.add(Integer.parseInt(string));
            }
        }

        //Convert value to decimal
        int sum = 0;

        for (int i = 0; i < ints.size(); i++) {
            sum += ints.get(i) * Math.pow(X, ints.size() - i - 1);
        }
        Val = sum;

        //convert decimal to base Y
        String str = "";
        while (true) {

            int quotient = Math.floorDiv(Val, Y);
            int remainder = Val % Y;

            str += "" + letters.get(remainder);
            Val = quotient;
            if (quotient == 0) {
                break;
            }
        }

        this.output.setText(new StringBuilder(str).reverse().toString());
    }

    public int getDigits(int num) {
        return String.valueOf(num).length();
    }

}
