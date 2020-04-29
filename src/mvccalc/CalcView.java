package mvccalc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalcView extends JFrame {
    private JTextField first = new JTextField(10);
    private JLabel additionalLable = new JLabel("+");
    private JTextField second = new JTextField(10);
    private JButton button = new JButton("Calculate");
    private JTextField result = new JTextField(10);

    public CalcView() throws HeadlessException {

        JPanel panel = new JPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);

        panel.add(first);
        panel.add(additionalLable);
        panel.add(second);
        panel.add(button);
        panel.add(result);

        this.add(panel);
    }

    public int getFirstNumber() {
        return Integer.parseInt(first.getText());
    }

    public int getSecondNumber() {
        return Integer.parseInt(second.getText());
    }

    public int getResult() {
        return Integer.parseInt(result.getText());
    }

    public void setResult(int result) {
        this.result.setText(Integer.toString(result));
    }

    void addCalcListener(ActionListener listener) {
        button.addActionListener(listener);
    }

    void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

}
