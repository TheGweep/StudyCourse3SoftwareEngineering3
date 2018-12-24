import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class ButtonPanel extends JPanel
{
    public ButtonPanel()
    {
        JButton yellowButton = new JButton("Yellow");
        JButton blueButton = new JButton("Blue");
        JButton redButton = new JButton("Red");
        add(yellowButton);
        add(blueButton);
        add(redButton);
        MyColor yellowAction = new MyColor(Color.yellow);
        MyColor blueAction = new MyColor(Color.blue);
        MyColor redAction = new MyColor(Color.red);
        yellowButton.addActionListener(yellowAction);
        blueButton.addActionListener(blueAction);
        redButton.addActionListener(redAction);
    }
    private class MyColor implements ActionListener
    {
        private Color backgroundColor;
        public MyColor(Color c)
        {
            backgroundColor = c;
        }
        public void actionPerformed(ActionEvent event)
        {
            setBackground(backgroundColor);
        }
    }
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
        g2.drawString("Hello world!",55,80);
    }
}
