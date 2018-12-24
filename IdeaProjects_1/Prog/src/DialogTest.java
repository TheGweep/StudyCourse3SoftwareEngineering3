import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogTest extends JDialog
{

        JTextField textField = new JTextField(2);
        JTextField textField1 = new JTextField(2);
        JTextField textField2 = new JTextField(4);

        public DialogTest(JFrame owner) {
            super(owner, "Error", true);
            Container container = getContentPane();
            JLabel label = new JLabel("День");
            JLabel label1 = new JLabel("Месяц");
            JLabel label2 = new JLabel("Год");
            JButton button = new JButton("Определить");
            MyAction action = new MyAction();
            button.addActionListener(action);
            JPanel panel = new JPanel();
            panel.add(label);
            panel.add(textField);
            panel.add(label1);
            panel.add(textField1);
            panel.add(label2);
            panel.add(textField2);
            panel.add(button);

            container.add(panel, BorderLayout.SOUTH);
            setBounds(825, 525, 500, 100);

        }

        private class MyAction implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                int day = Integer.parseInt(textField.getText().trim());
                int month = Integer.parseInt(textField1.getText().trim());
                int year = Integer.parseInt(textField2.getText().trim());
                int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
                day = day - 7;
                int x;
                if (year % 4 == 0) {
                    months[1] = 29;
                }
                x = month % 12;
                if (x == 0 && month > 12) {
                    year++;
                } else if (x != 0) {
                    month = x;
                }
                if (day < 0 && month == 1) {
                    day = months[0] + day;
                    month--;
                    if (month == 0) {
                        month = 12;
                    }
                    year--;
                }
                if (day < 0) {
                    day = months[0] + day;
                    month--;
                    if (month == 0) {
                        month = 12;
                    }
                }
                if (day == 0) {
                    day = months[month - 1];
                    month--;
                }
                if (day == 0 && month == 1) {
                    day = months[month - 1];
                    month--;
                    year--;
                }
                int y = day % months[month - 1];
                int z = day % months[x];
                if (day > months[month - 1] && y != 0 || day > months[x] && z != 0)
                {
                    month++;
                    day = y;
                }
                String str = Integer.toString(day);
                String str1 = Integer.toString(month);
                String str2 = Integer.toString(year);
                textField.setText(str);
                textField1.setText(str1);
                textField2.setText(str2);
                setVisible(false);
            }
        }
    }
