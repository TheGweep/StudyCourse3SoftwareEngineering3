import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server implements Runnable
{
    static private ServerSocket server;
    static private  Socket connection;
    static private ObjectOutputStream output;
    static private ObjectInputStream input;
    public  void run()
    {
        System.out.println("1");
        try
        {
            server = new ServerSocket(80,10);
            while (true)
            {
                connection = server.accept();
                output = new ObjectOutputStream(connection.getOutputStream());
                input = new ObjectInputStream(connection.getInputStream());
                JOptionPane.showMessageDialog(null,(String) input.readObject());
                output.writeObject("Вы прислали: " + (String)input.readObject());
            }
        }
        catch (UnknownHostException e) {}
        catch (IOException e) {}
        catch (ClassNotFoundException e) {}
    }
}
