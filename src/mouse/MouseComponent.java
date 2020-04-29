package mouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class MouseComponent extends JComponent {
    private static final int D_W = 300;
    private static final int D_H = 200;
    private static final int SIDELENGTH = 10;

    private ArrayList<Rectangle2D> squares;
    private Rectangle2D current;

    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            var frame = new MouseFrame();
            frame.setTitle("Мой редактор");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
    public MouseComponent() {
        squares = new ArrayList<>();
        current = null;

        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());
    }

    public Dimension getPreferredSize() {
        return new Dimension(D_W, D_H);
    }

    public void paintComponent(Graphics graphics) {
        var g2 = (Graphics2D) graphics;
        for(Rectangle2D r:squares) g2.draw(r);
    }

    public Rectangle2D find(Point2D p) {
        for (Rectangle2D r : squares) {
            if(r.contains(p)) return r;
        }
        return null;
    }

    public void add(Point2D p) {
        double x = p.getX();
        double y = p.getY();

        current = new Rectangle2D.Double(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
        squares.add(current);
        repaint();
    }

    public void remove(Rectangle2D s) {
        if(s==null) return;
        if(s==current) current = null;
        squares.remove(s);
        repaint();
    }

    private class MouseHandler extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent event) {
            current = find(event.getPoint());
            if(current!=null && event.getClickCount()>=2) remove(current);
        }

        @Override
        public void mousePressed(MouseEvent event) {
            current = find(event.getPoint());
            if(current==null) add(event.getPoint());
        }
    }

    private class MouseMotionHandler implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent event) {
            if (current != null) {
                int x = event.getX();
                int y = event.getY();

                current.setFrame(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
                repaint();
            }
        }

        @Override
        public void mouseMoved(MouseEvent event) {

            if (find(event.getPoint()) == null) setCursor(Cursor.getDefaultCursor());
            else setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }
    }
}

class MouseFrame extends JFrame {
    public MouseFrame() throws HeadlessException {
        add(new MouseComponent());
        pack();
    }
}