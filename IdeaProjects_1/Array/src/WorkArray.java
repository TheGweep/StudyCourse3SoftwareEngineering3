import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by root on 22.01.2016.
 */
public class WorkArray
{
   // MyArray MyArray = new MyArray();
    //ArrayList<MyArray> list = new ArrayList<MyArray>();
    Scanner scn = new Scanner(System.in);
    private int id = 0;
    private String login;
    private String password;
    ArrayList<String> list = new ArrayList<String>();
    ArrayList<String> list_1 = new ArrayList<String>();
    protected int EnterArray()
    {
        System.out.print("Введите login : ");
        this.login = scn.next();
        System.out.print("Введите password : ");
        this.password = scn.next();
        this.View();
        return 0;
    }
    protected int View()
    {
        list.add(id,login);
        list_1.add(id,password);
        list.get(id);
        list_1.get(id);
        return 0;
    }
    protected int Show()
    {
        this.getId();
        System.out.println("Ваш id : " + this.id);
        System.out.println("Ваш login : " + this.login);
        System.out.println("Ваш password : " + this.password);
        return 0;
    }
    protected int getId()
    {
        id++;
        return 0;
    }
    protected int all()
    {
        this.EnterArray();
        this.Show();
        return 0;
    }
}
