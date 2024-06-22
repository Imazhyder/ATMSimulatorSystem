package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupTwo extends JFrame implements ActionListener {
    String formno;
    JTextField cnicTextField;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, occupation, income, education;

    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(100, 140, 100, 30);
        add(name);

        String valReligion[] = {"Islam", "Hinduism", "Christianity", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 22));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        String valcategory[] = {"Current Account", "Saving Account", "Loan Account"};
        category = new JComboBox(valcategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel gender = new JLabel("Income:");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(100, 240, 200, 30);
        add(gender);

        String incomecategory[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel email = new JLabel("Educational");
        email.setFont(new Font("Raleway", Font.BOLD, 22));
        email.setBounds(100, 290, 200, 30);
        add(email);

        JLabel marital = new JLabel("Qualification:");
        marital.setFont(new Font("Raleway", Font.BOLD, 22));
        marital.setBounds(100, 315, 200, 30);
        add(marital);

        String educationValues[] = {"Matric", "Intermediate", "Graduation", "Post Graduation", "Doctrate"};
        education = new JComboBox(educationValues);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel address = new JLabel("Occupation:");
        address.setFont(new Font("Raleway", Font.BOLD, 22));
        address.setBounds(100, 390, 200, 30);
        add(address);

        String OccupationValues[] = {"Salaried Individual", "Self-Employed", "Businessman", "Student", "Retired", "Others"};
        occupation = new JComboBox(OccupationValues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel cnic = new JLabel("CNIC Number:");
        cnic.setFont(new Font("Raleway", Font.BOLD, 22));
        cnic.setBounds(100, 440, 200, 30);
        add(cnic);

        cnicTextField = new JTextField();
        cnicTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cnicTextField.setBounds(300, 440, 400, 30);
        add(cnicTextField);

        JLabel sc = new JLabel("Senior Citizen:");
        sc.setFont(new Font("Raleway", Font.BOLD, 22));
        sc.setBounds(100, 490, 200, 30);
        add(sc);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 490, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(400, 490, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup scgroup = new ButtonGroup();
        scgroup.add(syes);
        scgroup.add(sno);

        JLabel pincode = new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 22));
        pincode.setBounds(100, 540, 200, 30);
        add(pincode);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 540, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(400, 540, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup ecgroup = new ButtonGroup();
        ecgroup.add(eyes);
        ecgroup.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 590, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = null;
        if (syes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }

        String existingaccount = null;
        if (eyes.isSelected()) {
            existingaccount = "Yes";
        } else if (eno.isSelected()) {
            existingaccount = "No";
        }

        String scnic = cnicTextField.getText();

        try {
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+scnic+"', '"+seniorcitizen+"', '"+existingaccount+"')";            c.s.executeUpdate(query);

            //Signup 3 Object
            setVisible(false);
            new SignupThree(formno).setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new SignupTwo("");
    }
}