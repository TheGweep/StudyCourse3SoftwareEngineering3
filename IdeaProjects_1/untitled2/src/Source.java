import com.sun.javaws.Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
public class Source extends JFrame implements Runnable
{
    static private  Socket connection;
    static private ObjectOutputStream output;
    static private ObjectInputStream input;
    public static void main(String[] args)
    {
        new Thread(new Source("Test")).start();
        new Thread(new Server()).start();
    }
     Source(String name)
    {
        super(name);
        setLayout(new FlowLayout());
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        final JTextField t1 = new JTextField(10);
        final JButton b1 = new JButton("Send");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
             if(e.getSource() == b1)
             {
                 sendData(t1.getText());
             }
            }
        });
        add(t1);
        add(b1);
    }

    public void run()
    {
        System.out.println("1");
        try
        {
            while (true)
            {
                connection = new Socket(InetAddress.getByName("127.0.0.1"), 80);
                output = new ObjectOutputStream(connection.getOutputStream());
                input = new ObjectInputStream(connection.getInputStream());
                JOptionPane.showMessageDialog(null,(String) input.readObject());
            }
        }
        catch (UnknownHostException e) {}
        catch (IOException e) {}
        catch (ClassNotFoundException e) {}
    }
    private static void sendData(Object obj)
    {
        try
        {
            output.flush();
            output.writeObject(obj);
        } catch (IOException e) {}
    }
}
