package Bakend;

import DataBase.Restaurant_Database;
import GUI.Already_Booked_Rooms;
import GUI.First_Frame;
import javax.swing.*;

public class Pay_button {
    int CardNo,temp=0;
    public void credit_button(){

      if(Already_Booked_Rooms.credit_card_name.getText().isEmpty() || Already_Booked_Rooms.credit_card_name.getText().length()<3){
          JOptionPane.showMessageDialog(null,"Enter Your Name","error",JOptionPane.ERROR_MESSAGE);
          Already_Booked_Rooms.credit_card_name.requestFocusInWindow();
      }else if(Already_Booked_Rooms.credit_card_no.getText().length()==14){
            for(int i=0;i<Already_Booked_Rooms.credit_card_no.getText().length();i++) {
                try {
                    CardNo =Integer.parseInt(String.valueOf(Already_Booked_Rooms.credit_card_no.getText().charAt(i)));
                    temp++;
                }catch(Exception e) {
                    JOptionPane.showMessageDialog(null,"Invalid Character","error",JOptionPane.ERROR_MESSAGE);
                    Already_Booked_Rooms.debit_card_no.requestFocusInWindow();
                }
            }

                JOptionPane.showMessageDialog(null, "Payment successful", "done", JOptionPane.INFORMATION_MESSAGE);
                UserPaymentData userPaymentData=new UserPaymentData("Credit Card",Already_Booked_Rooms.bill,
                        Already_Booked_Rooms.credit_card_name.getText(),
                        Already_Booked_Rooms.credit_card_no.getText(),
                        Already_Booked_Rooms.ex_month[Already_Booked_Rooms.expiry_month.getSelectedIndex()],
                        Already_Booked_Rooms.ex_year[Already_Booked_Rooms.expiry_year.getSelectedIndex()],null);
                Restaurant_Database restaurantDatabase=new Restaurant_Database();
                restaurantDatabase.paymentDetails(userPaymentData);
                JOptionPane.showMessageDialog(null, "Your Room is Booked", "title", JOptionPane.INFORMATION_MESSAGE);
                 Already_Booked_Rooms.frame.dispose();
                new First_Frame();

        }else {
            JOptionPane.showMessageDialog(null,"Invalid card no","error",JOptionPane.ERROR_MESSAGE);
        }
    }






    public void debit_button(){

        //CHECK NAME IS VALID OR NOT
        if(Already_Booked_Rooms.Debit_card_name.getText().isEmpty() || Already_Booked_Rooms.Debit_card_name.getText().length()<3){
            JOptionPane.showMessageDialog(null,"Enter Your Name","error",JOptionPane.ERROR_MESSAGE);
            Already_Booked_Rooms.Debit_card_name.requestFocusInWindow();
        }else if(Already_Booked_Rooms.debit_card_no.getText().length()==14){
            for(int i=0;i<Already_Booked_Rooms.debit_card_no.getText().length();i++) {
                try {
                   CardNo =Integer.parseInt(String.valueOf(Already_Booked_Rooms.debit_card_no.getText().charAt(i)));
                   temp++;
                }catch(Exception e) {
                    JOptionPane.showMessageDialog(null,"Invalid Character","error",JOptionPane.ERROR_MESSAGE);
                    Already_Booked_Rooms.debit_card_no.requestFocusInWindow();
                }
            }
                JOptionPane.showMessageDialog(null, "Payment successful", "done", JOptionPane.INFORMATION_MESSAGE);
                UserPaymentData userPaymentData=new UserPaymentData("Debit Card",Already_Booked_Rooms.bill,
                        Already_Booked_Rooms.debit_card_no.getText(),
                        Already_Booked_Rooms.Debit_card_name.getText(),
                        Already_Booked_Rooms.ex_month[Already_Booked_Rooms.expiry_month.getSelectedIndex()],
                        Already_Booked_Rooms.ex_year[Already_Booked_Rooms.expiry_year.getSelectedIndex()],null);
                Restaurant_Database restaurantDatabase=new Restaurant_Database();
                restaurantDatabase.paymentDetails(userPaymentData);
                JOptionPane.showMessageDialog(null, "Your Room is Booked", "title", JOptionPane.INFORMATION_MESSAGE);
                Already_Booked_Rooms.frame.dispose();
                new First_Frame();
        }else {
            JOptionPane.showMessageDialog(null,"Invalid card no","error",JOptionPane.ERROR_MESSAGE);
            new Already_Booked_Rooms();
        }
    }
    public void upi_button(){
        if(Already_Booked_Rooms.upi_no.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Enter Phone Number","error",JOptionPane.ERROR_MESSAGE);
            Already_Booked_Rooms.upi_no.requestFocusInWindow();
        }else if(Already_Booked_Rooms.upi_no.getText().length()==10){
            for(int i=0;i<Already_Booked_Rooms.upi_no.getText().length();i++) {
                try {
                    CardNo =Integer.parseInt(String.valueOf(Already_Booked_Rooms.upi_no.getText().charAt(i)));
                    temp++;
                }catch(Exception e) {
                    JOptionPane.showMessageDialog(null,"Enter Correct Phone Number","error",JOptionPane.ERROR_MESSAGE);
                    Already_Booked_Rooms.upi_no.requestFocusInWindow();
                }
            }
                JOptionPane.showMessageDialog(null, "Payment successful", "done", JOptionPane.INFORMATION_MESSAGE);
                UserPaymentData userPaymentData=new UserPaymentData("UPI",Already_Booked_Rooms.bill,
                        null,
                       null,
                        null,
                       null,Already_Booked_Rooms.upi_no.getText());
                Restaurant_Database restaurantDatabase=new Restaurant_Database();
                restaurantDatabase.paymentDetails(userPaymentData);
                JOptionPane.showMessageDialog(null, "Your Room is Booked", "title", JOptionPane.INFORMATION_MESSAGE);
                Already_Booked_Rooms.frame.dispose();
                new First_Frame();
        }else {
            JOptionPane.showMessageDialog(null,"Enter Correct Phone Number","error",JOptionPane.ERROR_MESSAGE);
            Already_Booked_Rooms.upi_no.requestFocusInWindow();
        }
    }


}
