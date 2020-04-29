package draw;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{

        });
    }
}

class DrawFrame extends JFrame {
    public DrawFrame() throws HeadlessException {
        var list = new ArrayList<Object>();


    }
}

class DrawComponent extends JComponent {
    public static final int D_W = 400;
    public static final int D_H = 400;

    @Override
    protected void paintComponent(Graphics g) {
        var g2 = (Graphics2D) g;
    }
}