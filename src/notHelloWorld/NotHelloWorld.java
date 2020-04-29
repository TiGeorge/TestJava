package notHelloWorld;

import javax.swing.*;
import java.awt.*;

public class NotHelloWorld {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            var frame = new NotHelloWorldFrame();
            frame.setTitle("Not Hello, Warld!");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class NotHelloWorldFrame extends JFrame {
    public NotHelloWorldFrame() throws HeadlessException {
        add(new NotHelloWorldFrameComponent());
        pack();
    }
}

class NotHelloWorldFrameComponent extends JComponent {
    public static final int M_X = 75;
    public static final int M_Y = 100;

    public static final int D_W = 300;
    public static final int D_H = 200;

    @Override
    protected void paintComponent(Graphics g) {
        g.drawString("Non a Hello, Warld proramm", M_X, M_Y);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(D_W, D_H);
    }
}