package GUI;


import Bakend.Thread_Start;
import Bakend.UserData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDateTime;

public class First_Frame extends Panel implements ActionListener{
    public static JFrame frame;
    int height=850,width=1550;
    Font myFont=new Font("Italic",Font.ROMAN_BASELINE,25);

    public static String [][] button=new String[10][10];
    public static int city;
    public First_Frame(){

         Second_Frame.second_frame_on=false;
        frame =new JFrame();

        //calling Thread start
        new Thread_Start();

        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(panel3);
        frame.add(panel1);
        frame.add(panel2);


       // frame.add(comboBox);
        comboBox.addActionListener(this);
        button();

        frame.setTitle("BookMyRoom");
        frame.setSize(width,height);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void button(){
        for (int i=0;i<button.length;i++){
            if(button[city][i]==null) {
                numButton[i] = new JButton("Room " + (i + 1));
                panel1.add(numButton[i]);
                numButton[i].setFont(myFont);
                numButton[i].setForeground(Color.BLACK);
                numButton[i].setFocusable(false);
                //numButton[i].setOpaque(false);
                numButton[i].setContentAreaFilled(true);
                numButton[i].setBorderPainted(true);
                numButton[i].addActionListener(this);
            }
        }

        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==comboBox){
               city=comboBox.getSelectedIndex();
            System.out.println(city);
               frame.dispose();
               new First_Frame();

        }

        for(int i=0;i<button.length;i++){
            if(e.getSource()==numButton[i]){
                new Second_Frame(i,city);
                frame.dispose();
            }
        }
    }


    public static void CheckDatabase(){
        Connection con= null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","7022349334");
            PreparedStatement statement=con.prepareStatement("select * from `restaurant_data` where `End_date` > ?");
            statement.setTimestamp(1,Timestamp.valueOf(LocalDateTime.now()));
            ResultSet rs=statement.executeQuery();
            while (rs.next()){
                        button[rs.getInt("city_id")-1][rs.getInt("Room_No")-1]="1";
                        UserData.local_Time[rs.getInt("city_id")-1][rs.getInt("Room_No")-1]
                                =rs.getTimestamp("End_date").toLocalDateTime();
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}


class Panel extends Labels{
    String [] city={"Bengaluru", "Chennai", "Kolkata", "Mumbai", "Pune", "Belagavi", "Delhi", "Bhopal", "Jaipur", "Ahmedabad"};
    static JComboBox comboBox;
    JPanel panel1,panel2,panel3;
    JButton [] numButton=new JButton[10];
    public Panel(){
        panel1=new JPanel();
        panel1.setBounds(200,450,1150,200);
        panel1.setOpaque(false);
        panel1.setLayout(new GridLayout(2,5,10,10));

        comboBox = new JComboBox(city);
        panel2=new JPanel();
        panel2.setBounds(0,0,1550,850);
        ImageIcon image=new ImageIcon("src/GUI/FirstFrame.jpg" );
        comboBox.setSelectedIndex(First_Frame.city);
        panel2.add(new JLabel(image));

        panel3=new JPanel();
        panel3.setBounds(750, 258, 500, 50);
        panel3.setOpaque(false);
        panel3.add(comboBox);
        panel3.setLayout(null);

        //combBox

        comboBox.setBounds(0, 0, 180, 30);
        comboBox.setOpaque(false);
        comboBox.setFont(new Font("Italic",Font.BOLD,20));

    }


}

class Labels{
    JLabel label1,label2,label3;
    public Labels(){
        label1=new JLabel("Welcome To BookMyHotel.");
        label1.setFont(new Font("My Bola",Font.BOLD,60));
        label1.setBounds(400,100,1350,70);
        label1.setForeground(Color.BLACK );


        label2=new JLabel("Select City:-");
        label2.setFont(new Font("My Boli",Font.BOLD,30));
        label2.setBounds( 570,250,180,40);
        label2.setForeground(Color.black);

        label3=new JLabel("Available Rooms :");
        label3.setFont(new Font("My Bold", Font.BOLD,40));
        label3.setBounds(590,390,400,60);
        label3.setForeground(Color.BLACK);

    }
}

