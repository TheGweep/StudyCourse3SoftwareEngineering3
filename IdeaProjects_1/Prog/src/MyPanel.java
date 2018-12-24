import javax.swing.*;
import java.awt.*;


public class MyPanel extends JPanel
{
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawString("Hello world!",75,100);
    }
}
