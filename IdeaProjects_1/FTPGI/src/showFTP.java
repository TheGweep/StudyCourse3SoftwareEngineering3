import javax.swing.*;
import java.awt.*;

public class showFTP extends JFrame
{
    public  showFTP()
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("icon.jpg");
        setIconImage(img);
        setBounds(750,325,330,300);
        setTitle("Клиент-Сервер");
        setResizable(true);
        Container content = getContentPane();
        containerFTP contenier = new containerFTP();
        content.add(contenier);
    }
}
