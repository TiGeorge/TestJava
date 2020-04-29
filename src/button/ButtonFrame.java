package button;

import javax.swing.*;
import java.awt.*;

public class ButtonFrame extends JFrame {
    private JPanel buttonPanel;
    public static final int D_W = 300;
    public static final int D_H = 200;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new ButtonFrame();
            frame.setTitle("Not Hello, Warld!");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    public ButtonFrame() throws HeadlessException {
        buttonPanel = new JPanel();
        makeButton("Yellow", Color.YELLOW);
        makeButton("Blue", Color.BLUE);
        makeButton("Red", Color.RED);
        add(buttonPanel);
    }

    public void makeButton(String name, Color bacgroundColor) {
        var button = new JButton(name);
        buttonPanel.add(button);
        button.addActionListener(event -> buttonPanel.setBackground(bacgroundColor));
    }
}


