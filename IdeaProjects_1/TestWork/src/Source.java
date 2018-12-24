import jdk.nashorn.internal.scripts.JD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;


public class Source extends JFrame
{

    public static void main(String[] args)
    {
        new Source();
    }

    Source()
    {
        super("DataBase");
        setLayout(new FlowLayout());
        setSize(285,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        show();
        setVisible(true);
        setResizable(false);
        //workUser();
        JLabel l1 = new JLabel("Enter user: ");
        JTextField t1 = new JTextField(10);
        JTextArea t2 = new JTextArea(20,20);
        t2.setLineWrap(true);
        getContentPane().add(new JScrollPane(t2));
        JButton b1 = new JButton("Create");
        JButton b3 = new JButton("Delete");
        JButton b4 = new JButton("View");
        ArrayList al = new ArrayList();
        String str;

        b1.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                String str = t1.getText();
                al.add(str + " " + al.size() + "; ");
                t2.setText(str);
                t1.setText("");
            }
        });

        b3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String number = JOptionPane.showInputDialog("Enter number delete");
                int index = new Integer(number);
                //t1.setText(number);
                al.remove(index);
            }
        });
        b4.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                t2.setText(al + "\n" + al.size());
            }
        });
        add(l1);
        add(t1);
        add(t2);
        add(b1);
        add(b3);
        add(b4);

    }

    ArrayList al = new ArrayList();

    public void workUser()
    {
        Scanner scn = new Scanner(System.in);
        String s;
        String str;
        int index = 0;
        int col = 0;
        System.out.print("Ваш выбор y/n: ");
        s = scn.next();
        if(s.equals("y"))
        {
            System.out.println("Начальный размер al: " + al.size());
            System.out.print("Введите логин: ");
            str = scn.next();
            al.add(str);
            col++;
            System.out.println("Начальный размер al: " + al.size());
            System.out.println("Контент al: " + al);
        }
        else if(s.equals("n"))
            System.out.println("Выход.");
        else
        System.out.println("Ошибка!");
        if(s.equals("y"))
        {
            do
            {
                System.out.print("Ваш выбор y/n/d/v: ");
                s = scn.next();
                if (s.equals("y"))
                {
                    System.out.println("Начальный размер al: " + al.size());
                    System.out.print("Введите логин: ");
                    str = scn.next();
                    al.add(str);
                    col++;
                    System.out.println("Начальный размер al: " + al.size());
                    System.out.println("Контент al: " + al);
                }
                else if (s.equals("n"))
                    System.out.println("Выход.");
                else if (s.equals("d"))
                {
                    System.out.println(col);
                    System.out.print("Введите номер эл-та для удаления: ");
                        index = scn.nextInt();
                        if (index <= 0 || index > col)
                        {
                            while (index <= 0) {
                                System.out.print("Введите номер эл-та для удаления: ");
                                index = scn.nextInt();
                            }
                        }
                    al.remove(index - 1);
                    col--;
                }
                else if(s.equals("v"))
                    System.out.println(al);
                else
                    System.out.println("Ошибка!");
            } while (!s.equals("n"));
        }

    }
}
