import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Source
{
    public static void main(String[] args)
    {
        Frame frame = new Frame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.show();
    }
}
class Frame extends JFrame
{
    private String PATH = "/cmd.png";
    private String TITLE = "Data";

    Frame()
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage(PATH);
        setIconImage(img);
        setBounds(750,325,525,200);
        setTitle(TITLE);
        setResizable(false);
        PanelButton panel = new PanelButton();
        add(panel);
    }
}
class PanelButton extends JPanel
{
    JTextField textField = new JTextField(2);
    JTextField textField1 = new JTextField(2);
    JTextField textField2 = new JTextField(4);
    JTextField textField3 = new JTextField(2);
    JTextField textField4 = new JTextField(2);
    JTextField textField5 = new JTextField(4);
    PanelButton()
    {
        JLabel label = new JLabel("День");
        JLabel label1 = new JLabel("Месяц");
        JLabel label2 = new JLabel("Год");
        JLabel  label3 = new JLabel("День");
        JLabel  label4 = new JLabel("Месяц");
        JLabel  label5 = new JLabel("Год");
        JButton button = new JButton("Определить");
        setLayout(new FlowLayout(FlowLayout.CENTER,50,20));
        add(label);
        add(textField);
        add(label1);
        add(textField1);
        add(label2);
        add(textField2);
        add(label3);
        add(textField3);
        add(label4);
        add(textField4);
        add(label5);
        add(textField5);
        add(button);
        MyEvent event = new MyEvent();
        button.addActionListener(event);
        textField3.setEditable(false);
        textField4.setEditable(false);
        textField5.setEditable(false);
    }
}
class DialogTest
{
    JTextField textField = new JTextField(2);
    JTextField textField1 = new JTextField(2);
    JTextField textField2 = new JTextField(4);
    public DialogTest()
    {
        JLabel label = new JLabel("День");
        JLabel label1 = new JLabel("Месяц");
        JLabel label2 = new JLabel("Год");
        JButton button = new JButton("Определить");
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(textField);
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(button);

    }
}
class MyEvent implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {

    }
}