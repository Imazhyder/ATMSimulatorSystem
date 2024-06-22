package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton fiveHundred, oneThousand, twoThousand, fiveThousand, tenThousand, twentyThousand, back;
    String pinnumber;

    FastCash(String pinnumber) {

        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(210, 230, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        fiveHundred = new JButton("Rs 500");
        fiveHundred.setBounds(170, 300, 150, 30);
        fiveHundred.addActionListener(this);
        image.add(fiveHundred);

        oneThousand = new JButton("Rs 1000");
        oneThousand.setBounds(355, 300, 150, 30);
        oneThousand.addActionListener(this);
        image.add(oneThousand);

        twoThousand = new JButton("Rs 2000");
        twoThousand.setBounds(170, 340, 150, 30);
        twoThousand.addActionListener(this);
        image.add(twoThousand);

        fiveThousand = new JButton("Rs 5000");
        fiveThousand.setBounds(355, 340, 150, 30);
        fiveThousand.addActionListener(this);
        image.add(fiveThousand);

        tenThousand = new JButton("Rs 10000");
        tenThousand.setBounds(170, 380, 150, 30);
        tenThousand.addActionListener(this);
        image.add(tenThousand);

        twentyThousand = new JButton("Rs 20000");
        twentyThousand.setBounds(355, 380, 150, 30);
        twentyThousand.addActionListener(this);
        image.add(twentyThousand);

        back = new JButton("BACK");
        back.setBounds(355, 420, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton) ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else if (rs.getString("type").equals("Withdrawal")) {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if (balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values('" + pinnumber + "', '" + date + "', 'Withdrawal', '" + amount + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String args[]) {
        new FastCash("");
    }
}
