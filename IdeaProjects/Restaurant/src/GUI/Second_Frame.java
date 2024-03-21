package GUI;


import Bakend.UserData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Second_Frame extends Text_box_Labels implements ActionListener{
    static JFrame frame2;
    public static boolean second_frame_on;
    int height=850,width=1550;
    String gender,name,last_name;
    int Room_No,time,city_no,temp;
    public Second_Frame(int i,int j){
        super(i);
        //for check second frame is on
        second_frame_on=true;

        Room_No =i;
        city_no=j;

        frame2=new JFrame();
        frame2.add(l1);
        frame2.add(p1);
        frame2.add(Button_panel);
        frame2.add(p2);
        frame2.setTitle("BookMyRoom");
        frame2.setSize(width,height);
        frame2.setResizable(true);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setLayout(null);
        frame2.setVisible(true);
        b1.addActionListener(this);
        submitButton.addActionListener(this);
        Read_more.addActionListener(this);
        jr_button_1.addActionListener(this);
        jr_button_2.addActionListener(this);
        jr_button_3.addActionListener(this);
        jr_button_4.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==jr_button_1){
            gender=jr_button_1.getText();
        }else if (e.getSource()==jr_button_2){
            gender=jr_button_2.getText();
        } else if (e.getSource()==jr_button_3) {
            gender=jr_button_3.getText();
        }
        if(e.getSource()==b1){
            frame2.dispose();
            new First_Frame();
        }
        if(e.getSource()== submitButton) {
            if (text.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter Name", "title", JOptionPane.ERROR_MESSAGE);
                text.requestFocusInWindow();
            } else if (text1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter Last name", "title", JOptionPane.ERROR_MESSAGE);
                text1.requestFocusInWindow();
            } else if (text2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter how many Hours You want to stay", "title", JOptionPane.ERROR_MESSAGE);
                text2.requestFocusInWindow();
            } else if (jr_button_1.isSelected() || jr_button_2.isSelected() || jr_button_3.isSelected()) {
                if (jr_button_4.isSelected()) {
                    try {
                        temp = 1;
                        name = text.getText();
                        last_name = text1.getText();
                        time = Integer.parseInt(text2.getText());

                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null, "Invalid Input", "title", JOptionPane.ERROR_MESSAGE);
                        temp = JOptionPane.ERROR_MESSAGE;
                        text2.requestFocusInWindow();
                    }
                    if (temp != 0) {
                        UserData.name=name;UserData.last_name=last_name;UserData.time=time;UserData.Room_No=Room_No;
                        UserData.city=city_no+1;UserData.gender=gender;
                        frame2.dispose();
                        new Already_Booked_Rooms(time);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Accept terms And Conditions", "title", JOptionPane.INFORMATION_MESSAGE);
                }
            }else {
                JOptionPane.showMessageDialog(null, "Select Gender", "title", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getSource()==Read_more){
          new Terms_And_Conditions();
        }
    }
}

 class Text_box_Labels extends panel_second_frame{
    JTextField text,text1,text2;
    JLabel l1,l2,l3,l4,l5;
    JRadioButton jr_button_1,jr_button_2,jr_button_3,jr_button_4;
    Font myFont=new Font("Italic",Font.BOLD,25);

    public Font myFont2=new Font("Italic",Font.BOLD,20);
    Font myFont3=new Font("Italic",Font.BOLD,15);
 ButtonGroup bg=new ButtonGroup();

    public Text_box_Labels(int i){
        b1.setFont(myFont2);
        b1.setForeground(Color.RED);
        submitButton.setFont(myFont2);
        submitButton.setForeground(Color.BLACK);



        text=new JTextField();
         l1=new JLabel("Selected Room No is "+(i+1));
        l1.setFont(myFont);
        l1.setForeground(Color.white);
        l1.setBounds( 600,100,880,50);


         l2=new JLabel("  Your First Name :-");
        l2.setFont(myFont2);
        l2.setForeground(Color.BLACK);
        l2.setBounds( 50,40,200,50);
        p1.add(l2);
        text.setBounds(250,45,300,40);
        text.setFont(myFont);
        text.setBackground(Color.CYAN);
        text.setForeground(Color.BLACK);
        text.setEditable(true);
        p1.add(text);


        l3=new JLabel("  Your Last Name :-");
        text1=new JTextField();
        l3.setFont(myFont2);
        l3.setForeground(Color.BLACK);
        l3.setBounds( 50,130,200,50);
        p1.add(l3);
        text1.setBounds(250,135,300,40);
        text1.setFont(myFont);
        text1.setBackground(Color.CYAN);
        text1.setForeground(Color.BLACK);
        text1.setEditable(true);
        p1.add(text1);

        l4=new JLabel("Time (in seconds) :-");
        text2=new JTextField();
        l4.setFont(myFont2);
        l4.setForeground(Color.BLACK);
        l4.setBounds( 50,225,200,50);
        p1.add(l4);
        text2.setBounds(250,230,300,40);
        text2.setFont(myFont);
        text2.setBackground(Color.CYAN);
        text2.setForeground(Color.BLACK);
        text2.setEditable(true);
        p1.add(text2);

        l5=new JLabel("  Select Gender:-");
        l5.setFont(myFont2);
        l5.setForeground(Color.BLACK);
        l5.setBounds(50,285,200,50);
        p1.add(l5);

        jr_button_1=new JRadioButton("Male");
        jr_button_1.setBounds(250,290,90,40);
        jr_button_1.setFocusable(false);
        jr_button_1.setForeground(Color.BLACK);
        jr_button_1.setBackground(Color.CYAN);
        jr_button_1.setFont(myFont3);
        //jr_button_1.setOpaque(false);
        p1.add(jr_button_1);


        jr_button_2=new JRadioButton("Female");
        jr_button_2.setBounds(350,290,90,40);
        jr_button_2.setFocusable(false);
        jr_button_2.setBackground(Color.CYAN);
        jr_button_2.setForeground(Color.BLACK);
        jr_button_2.setFont(myFont3);
       // jr_button_2.setOpaque(false);
        p1.add(jr_button_2);

        jr_button_3=new JRadioButton("other");
        jr_button_3.setBounds(450,290,100,40);
        jr_button_3.setFocusable(false);
        jr_button_3.setBackground(Color.CYAN);
        jr_button_3.setForeground(Color.BLACK);
        jr_button_3.setFont(myFont3);
        // jr_button_2.setOpaque(false);
        p1.add(jr_button_3);
        bg.add(jr_button_1);bg.add(jr_button_2);bg.add(jr_button_3);

        jr_button_4=new JRadioButton("<html>By booking a hotel room with us you agree <br> to the following terms and conditions. </html>");
        jr_button_4.setOpaque(false);
        jr_button_4.setBounds(235,350,400,40);
        jr_button_4.setBorderPainted(false);
        jr_button_4.setForeground(Color.RED);
        jr_button_4.setFont(new Font("Italic",Font.BOLD,15));

        Read_more =new JButton("Read more");
        Read_more.setBounds(518,366,100,30);
        Read_more.setFocusable(false);
        Read_more.setBorderPainted(false);
        Read_more.setContentAreaFilled(false);
        p1.add(Read_more);
        p1.add(jr_button_4);
    }
}


class panel_second_frame {
    JPanel p1,p2,Button_panel;
    JButton b1, submitButton, Read_more;

    panel_second_frame(){
        p1=new JPanel();


        p1.setBounds(400,170,650,400);
        p1.setBackground(Color.pink);
//        p1.setOpaque(false);
        p1.setLayout(null);


        ImageIcon image=new ImageIcon("src/GUI/SecondFrame.jpg");
        p2=new JPanel();
        p2.setBounds(0,0,1550,850);
        p2.add(new JLabel(image));

        b1=new JButton("Back");
        b1.setFocusable(false);
        b1.setBorderPainted(true);
        b1.setContentAreaFilled(false);

        submitButton =new JButton("Submit");
        submitButton.setFocusable(false);
        submitButton.setBorderPainted(true);
        submitButton.setContentAreaFilled(false);

        Button_panel=new JPanel();
        Button_panel.setBounds(450,600,500,75);
        Button_panel.add(b1);
        Button_panel.add(submitButton);
        Button_panel.setOpaque(false);
        Button_panel.setLayout(new GridLayout(1,2,250,300));
    }
}