import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class DrawPanel extends JPanel
{
    public void paintComponent(Graphics q)
    {
        super.paintComponent(q);
        Graphics2D g2 = (Graphics2D)q;
        Rectangle2D.Float rect = new Rectangle.Float(100.0f,100.0f,200.0f,200.0f);
        g2.draw(rect);
        Rectangle2D.Float rect1 = new Rectangle.Float(150.0f,150.0f,200.0f,200.0f);
        g2.draw(rect1);
        g2.draw(new Line2D.Float(100.0f,100.0f,150.0f,150.0f));
        g2.draw(new Line2D.Float(300.0f,100.0f,350.0f,150.0f));
        g2.draw(new Line2D.Float(300.0f,300.0f,350.0f,350.0f));
        g2.draw(new Line2D.Float(150.0f,350.0f,100.0f,300.0f));
    }
}
