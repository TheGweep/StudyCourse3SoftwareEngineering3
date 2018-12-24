import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class protocolFTP
{

        public static void ftpConn(String hostAddress, String log, String password) throws FileNotFoundException
        {
            FTPClient fClient = new FTPClient();
            FileInputStream fInput = new FileInputStream("message.txt");
            String fs = "/WWW/sm.txt";
            try {
                fClient.connect(hostAddress);
                fClient.enterLocalPassiveMode();
                fClient.login(log, password);
                fClient.storeFile(fs, fInput);
                fClient.logout();
                fClient.disconnect();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }

        public static void main(String[] args) {
            try {
                ftpConn("up7.hut4.ru","ваш_логин","ваш_пароль");
            } catch (FileNotFoundException ex)
            {
                Logger.getLogger(FTPClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}
