package simpleFrame;

import javax.swing.*;
import java.awt.*;

public class SimpleFrameTest {
    public static void main(String[] args) {



        EventQueue.invokeLater(()->{
            var frame = new SimpleFtame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class SimpleFtame extends JFrame {
    public static final int D_W = 300;
    public static final int D_H = 200;

    public SimpleFtame() throws HeadlessException {
        setSize(D_W, D_H);
    }
}
