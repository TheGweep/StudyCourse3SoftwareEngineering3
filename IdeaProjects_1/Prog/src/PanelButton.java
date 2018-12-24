import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelButton extends JPanel
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

    private class MyEvent implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            int day = Integer.parseInt(textField.getText().trim());;
            int month = Integer.parseInt(textField1.getText().trim());
            int year = Integer.parseInt(textField2.getText().trim());
            int dayNext;
            int newDayNext;
            int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            String str3;
            String str4;
            String str5;
            while (year <= 0)
            {
                str5 = JOptionPane.showInputDialog("Введите год > 0!");
                textField2.setText(str5);
                year = Integer.parseInt(textField2.getText().trim());
            }
            while (month <= 0 || month > 12)
            {
                str4 = JOptionPane.showInputDialog("Введите месяц > 0 и < 12!");
                textField1.setText(str4);
                month = Integer.parseInt(textField1.getText().trim());
            }
            while (day <= 0 || day > months[month-1])
            {
                str3 = JOptionPane.showInputDialog("Введите день > 0 и < дней в месяце!");
                textField.setText(str3);
                day = Integer.parseInt(textField.getText().trim());
            }
            if (year % 4 == 0)
                    months[1] = 29;
               dayNext = day - 7;
                if (day == 7)
                {
                    if (month == 1)
                    {
                        month = 12;
                        dayNext = months[month - 1];
                        year--;
                    } else
                    {
                        dayNext = months[month - 2];
                        month--;
                    }
                }
                else if (day < 7)
                {
                    if (month == 1)
                    {
                        month = 12;
                        newDayNext = months[month - 1] + dayNext;
                        dayNext = newDayNext;
                        year--;
                    } else
                    {
                        newDayNext = months[month - 2] + dayNext;
                        dayNext = newDayNext;
                        month--;
                    }
                }
            String str1 = Integer.toString(month);
            String str2 = Integer.toString(year);
            String str = Integer.toString(dayNext);
            textField3.setText(str);
            textField4.setText(str1);
            textField5.setText(str2);
            }

        }

    }