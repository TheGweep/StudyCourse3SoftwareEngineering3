import java.util.Scanner;

/**
 * Created by root on 22.01.2016.
 */
public class MyArray
{
    private static int id = 0;
    private static String login;
    private static String password;
    Scanner scn = new Scanner(System.in);
    protected int Enter()
    {
        System.out.print("Введите login : ");
        login = scn.next();
        System.out.print("Введите password : ");
        password = scn.next();
        return 0;
    }
    protected int Show()
    {
        System.out.println("Ваш id : " + this.id);
        System.out.println("Ваш login : " + this.login);
        System.out.println("Ваш password : " + this.password);
        this.getId();
        return 0;
    }
    protected int getId()
    {
        id++;
        return 0;
    }
    protected int all()
    {
        this.Enter();
        this.Show();
        this.getId();
        return 0;
    }
}
