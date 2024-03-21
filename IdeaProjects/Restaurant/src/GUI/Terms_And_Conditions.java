package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Terms_And_Conditions extends JFrame implements ActionListener {
    JLabel label,label2;
    JButton Ok;
    public Terms_And_Conditions(){
        setTitle("Terms And Conditions");
        label2 =new JLabel("Terms And Conditions.");
        label2.setFont(new Font("My Boli",Font.BOLD,30));
        label2.setForeground(Color.BLACK);
        label2.setBounds(130,20,420,50);

        label=new JLabel("<html>Booking Confirmation:<br>" +
                "All reservations are subject to room availability and will be confirmed upon successful payment.<br>" +
                "<br>" +
                "Cancellation Policy:<br>" +
                "Cancellations made within 24 hours of the scheduled check-in time may be subject to a cancellation fee.<br>" +
                "<br>" +
                "Check-in and Check-out:<br>" +
                "Check-in time is after [specified time], and check-out time is before [specified time].<br>" +
                "<br>" +
                "Damages:<br>" +
                "Guests are responsible for any damages caused to hotel property during their stay. Charges for damages <br>" +
                " will be applied accordingly.<br>" +
                "<br>" +
                "Refusal of Service:<br>" +
                "The hotel reserves the right to refuse service to anyone for any reason.<br>" +
                "<br>" +
                "Pets and Smoking:<br>" +
                "Unless specified otherwise, no pets are allowed. Smoking is strictly prohibited in rooms and designated <br>" +
                " non-smoking areas.<br>" +
                "<br>" +
                "Additional Charges:<br>" +
                "Guests are responsible for any additional charges incurred during their stay.<br>" +
                "<br>" +
                "Adherence to Policies:<br>" +
                "By booking a room, guests acknowledge and agree to abide by these terms and conditions.</html>");
       label.setBounds(10,90,620,400);

        this.setSize(620,620);

        Ok=new JButton("OK");
        Ok.setBounds(250,520,100,50);
        Ok.setFont(new Font("My Boli",Font.BOLD,30));
        Ok.setFocusable(false);
        Ok.addActionListener(this);
        add(Ok);

        add(label);
        add(label2);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        //pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Ok){
            dispose();
        }
    }
}
