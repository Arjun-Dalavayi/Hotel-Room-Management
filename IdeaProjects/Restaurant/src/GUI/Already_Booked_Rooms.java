package GUI;



import Bakend.Pay_button;
import Bakend.UserData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class Already_Booked_Rooms implements ActionListener {
   public static JFrame frame;
    JButton credit_button,debit_button,upi_button,credit_payButton,debit_payButton,upi_payButton,Cancel;

    //class of second_frame
    Pay_button payButton=new Pay_button();
   public static JTextField Debit_card_name;
    public static JTextField credit_card_name;
    public static JTextField credit_card_no;
    public static JTextField debit_card_no;
    public static JTextField upi_no;
    public static JComboBox expiry_year;
    public static JComboBox expiry_month;
   public static String [] ex_year={"2023","2024","2025","2026","2027","2028","2029","2030"};
    public static String [] ex_month={"01","02","03","04","05","06","07","08","09","10","11","12"};
    JLabel label_1,label_2,label_3,bill_label;
    CardLayout card=new CardLayout();
   // Image image;
    Container main_panel;
    JPanel panel,panel_2,panel_3;
    public static float bill;
    public Already_Booked_Rooms(){
//       this.dispose();
    }
    public Already_Booked_Rooms(int time){
        frame=new JFrame();
        bill=10*time;
        main_panel=new Container();
        panel=new JPanel();
        panel_2=new JPanel();
        panel_3=new JPanel();
        main_panel.setBounds(400,170,750,400);
        main_panel.setLayout(card);

        main_panel.add(panel,"1");
        main_panel.add(panel_2,"2");
        main_panel.add(panel_3,"3");

        credit_button=new JButton("Credit Card");
        credit_button.setBounds(500,10,170,150);
        credit_button.setFocusable(false);
        debit_button=new JButton("Debit Card");
        debit_button.setBounds(680,10,170,150);
        debit_button.setFocusable(false);
        upi_button=new JButton("UPI");
        upi_button.setBounds(860,10,170,150);
        upi_button.setFocusable(false);
        frame.add(credit_button);frame.add(debit_button);frame.add(upi_button);
        card.show(main_panel,"1");

        credit_payButton=new JButton("PAY");
        debit_payButton=new JButton("PAY");
        upi_payButton=new JButton("PAY");
        Cancel=new JButton("Cancel Payment");
        Cancel.setBounds(710,600,150,70);
        Cancel.setFocusable(false);
        frame.add(Cancel);
        debit_card();
        upi();
        credit_card();

       credit_button.addActionListener(this);
       debit_button.addActionListener(this);
       upi_button.addActionListener(this);
       credit_payButton.addActionListener(this);
       debit_payButton.addActionListener(this);
       upi_payButton.addActionListener(this);
       Cancel.addActionListener(this);

        frame.setSize(1550,850);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.add(main_panel);
        frame.setResizable(false);
       //pack();
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==credit_button){
           // panel.add(credit_button);panel.add(debit_button);panel.add(upi_button);
            credit_button.setEnabled(false);
            debit_button.setEnabled(true);
            upi_button.setEnabled(true);
            credit_payButton.setVisible(true);
            card.show(main_panel,"1");

        }
        if (e.getSource()==debit_button){
           // panel_2.add(credit_button);panel_2.add(debit_button);panel_2.add(upi_button);

            credit_button.setEnabled(true);
            debit_button.setEnabled(false);
            upi_button.setEnabled(true);

            card.show(main_panel,"2");

        }
        if(e.getSource()==upi_button){
           // panel_3.add(credit_button);panel_3.add(debit_button);panel_3.add(upi_button);
            credit_button.setEnabled(true);
            debit_button.setEnabled(true);
            upi_button.setEnabled(false);

            card.show(main_panel,"3");
        }
        if(e.getSource()==credit_payButton){
            payButton.credit_button();
        }
        if(e.getSource()==debit_payButton){
             payButton.debit_button();
        }
        if(e.getSource()==upi_payButton){
            payButton.upi_button();
        }
        if(e.getSource()==Cancel){
            First_Frame.button[UserData.city][UserData.Room_No]=null;
            frame.dispose();
            new First_Frame();
        }
    }



    public void credit_card(){
        bill_label=new JLabel("Bill  $"+bill);
        bill_label.setFont(new Font("Italic",Font.BOLD,40));
        bill_label.setBounds(305,5,900,50);
        panel.add(bill_label);
        panel.setBackground(Color.cyan);


        label_1=new JLabel("Name On Card :");
        label_1.setBounds( 95,65,880,50);
        label_1.setFont(new Font("Italic",Font.BOLD,20));
        credit_card_name =new JTextField();
        credit_card_name.setBounds(250,70,300,40);
        panel.add(label_1);
        panel.add(credit_card_name);

        label_2=new JLabel("Card No :");
        label_2.setFont(new Font("Italic",Font.BOLD,20));
        label_2.setBounds( 155,150,200,50);
        credit_card_no =new JTextField();
        credit_card_no.setBounds(250,155,300,40);
        panel.add(label_2);
        panel.add(credit_card_no);

        label_3=new JLabel("Expiry Date :");
        label_3.setFont(new Font("Italic",Font.BOLD,20));
        label_3.setBounds( 125,225,200,50);
        expiry_year=new JComboBox(ex_year);
        expiry_year.setBounds(250,230,150,40);
        expiry_month=new JComboBox(ex_month);
        expiry_month.setBounds(410,230,150,40);
        panel.add(label_3);
        panel.add(expiry_year);
        panel.add(expiry_month);

        credit_payButton.setBounds(320,320,130,70);
        credit_payButton.setFocusable(false);
        panel.add(credit_payButton);

        panel.setLayout(null);
    }

    public void debit_card(){
        bill_label=new JLabel("Bill  $"+bill);
        bill_label.setFont(new Font("Italic",Font.BOLD,40));
        bill_label.setBounds(305,5,900,50);
        panel_2.add(bill_label);

        panel_2.setBackground(Color.cyan);
        label_1=new JLabel("Name On Card :");
        label_1.setBounds( 95,65,880,50);
        label_1.setFont(new Font("Italic",Font.BOLD,20));
        Debit_card_name =new JTextField();
        Debit_card_name.setBounds(250,70,300,40);
        panel_2.add(label_1);
        panel_2.add(Debit_card_name);

        label_2=new JLabel("Card No :");
        label_2.setFont(new Font("Italic",Font.BOLD,20));
        label_2.setBounds( 155,150,200,50);
        debit_card_no =new JTextField();
        debit_card_no.setBounds(250,155,300,40);
        panel_2.add(label_2);
        panel_2.add(debit_card_no);

        label_3=new JLabel("Expiry Date :");
        label_3.setFont(new Font("Italic",Font.BOLD,20));
        label_3.setBounds( 125,225,200,50);
        expiry_year=new JComboBox(ex_year);
        expiry_year.setBounds(250,230,150,40);
        expiry_month=new JComboBox(ex_month);
        expiry_month.setBounds(410,230,150,40);
        panel_2.add(label_3);
        panel_2.add(expiry_year);
        panel_2.add(expiry_month);
        debit_payButton.setBounds(320,320,130,70);
        debit_payButton.setFocusable(false);
        panel_2.add(debit_payButton);

        panel_2.setLayout(null);
        //panel.setLayout(new GridLayout(3,2));
        //panel.pack();
    }

    public void upi(){
        bill_label=new JLabel("Bill  $"+bill);
        bill_label.setFont(new Font("Italic",Font.BOLD,40));
        bill_label.setBounds(305,5,900,50);
        panel_3.add(bill_label);
        panel_3.setBackground(Color.cyan);


        label_2=new JLabel("Phone No :");
        label_2.setFont(new Font("Italic",Font.BOLD,20));
        label_2.setBounds( 140,130,200,50);
        upi_no=new JTextField();
       upi_no.setBounds(250,135,300,40);
        panel_3.add(label_2);
        panel_3.add(upi_no);


        upi_payButton.setBounds(320,320,130,70);
        upi_payButton.setFocusable(false);
        panel_3.add(upi_payButton);
        panel_3.setLayout(null);
    }

}
