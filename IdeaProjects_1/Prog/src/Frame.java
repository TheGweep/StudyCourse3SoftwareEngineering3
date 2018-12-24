import javax.swing.*;
import java.awt.*;
public class Frame extends JFrame
{
    public Frame()
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("123.jpg");
        setIconImage(img);
        setBounds(750, 325, 525, 200);
        setTitle("Определяет дату дня, отстоящего от заданного на 1 неделю");
        setResizable(false);
        Container contentPain = getContentPane();
        //MyPanel panel = new MyPanel();
        //DrawPanel panel1 = new DrawPanel();
        //ButtonPanel panel2 = new ButtonPanel();
        // contentPain.add(panel);
        //contentPain.add(panel1);
        //contentPain.add(panel2);
        //JDialog dialog = new DialogTest(this);
        //dialog.show();
        PanelButton panel3 = new PanelButton();
        contentPain.add(panel3);
    }
}
