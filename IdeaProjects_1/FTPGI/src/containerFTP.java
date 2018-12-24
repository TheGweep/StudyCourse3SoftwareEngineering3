import org.apache.commons.net.ftp.FTPClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;

public class containerFTP extends JPanel
{
    JTextField textField = new JTextField(15);
    JTextField textField1 = new JTextField(15);
    JTextField textField2 = new JTextField(15);
    JTextField textField3 = new JTextField(15);
    JTextField textField4 = new JTextField(15);
    containerFTP()
    {
        JLabel label = new JLabel("Строка");
        JLabel label1 = new JLabel("Файл");
        JLabel label2 = new JLabel("Сайт");
        JLabel  label3 = new JLabel("Логин");
        JLabel  label4 = new JLabel("Пароль");
        JButton button = new JButton("Потвердить");
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
        add(button);
        codeFTP event = new codeFTP();
        button.addActionListener(event);
    }
}
public class codeFTP implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
        String hostAddress;
        String log;
        String password;
        FTPClient fClient = new FTPClient();
        FileInputStream fInput = new FileInputStream();
        String fs;
        try
        {
            fClient.connect(hostAddress);
            fClient.enterLocalPassiveMode();
            fClient.login(log, password);
            fClient.storeFile(fs, fInput);
            fClient.logout();
            fClient.disconnect();
        } catch (IOException ex)
        {
            System.err.println(ex);
        }
    }
}
