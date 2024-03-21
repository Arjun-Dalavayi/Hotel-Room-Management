package DataBase;

import Bakend.UserData;
import Bakend.UserPaymentData;
import GUI.First_Frame;

import java.sql.*;
import java.time.LocalDateTime;

public class Restaurant_Database {
    int city_no;
    public Restaurant_Database()  {
        UserData.local_Time[UserData.city-1][UserData.Room_No]= LocalDateTime.now().plusSeconds(UserData.time);
        First_Frame.button[UserData.city-1][UserData.Room_No]="1";
        city_no=UserData.city+1;
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("Database-url\",\"username\",\"Password");
            PreparedStatement st= con.prepareStatement("insert into restaurant_data(city_id,First_name,last_name,gender,Entry_date,End_date,Room_No)" +
                    " value (?,?,?,?,?,?,?)");
            st.setInt(1,city_no);
            st.setString(2,UserData.name);
            st.setString(3,UserData.last_name);
            st.setString(4,UserData.gender);
            st.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
            st.setTimestamp(6,Timestamp.valueOf(UserData.local_Time[UserData.city-1][UserData.Room_No]));
            st.setInt(7,(UserData.Room_No+1));
            int i=st.executeUpdate();
            con.close();
        }catch (Exception e){
           e.printStackTrace();
        }
    }

    public void paymentDetails(UserPaymentData userPaymentData) {
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("Database-url","username","Password");
            Statement sta=con.createStatement();
            ResultSet resultSet=sta.executeQuery("SELECT BookingId FROM restaurant_data ORDER BY BookingId DESC LIMIT 1");
            int primaryKey=0;
            while (resultSet.next()){
                primaryKey=resultSet.getInt("bookingId");
            }
            PreparedStatement statement= con.prepareStatement("insert into paymentDetails(paymentMethode,Bill,nameOnCard,cardNo," +
                    "cardExspireMonth,cardExpireYear,paymentId,PhoneNumber)" +
                    " value (?,?,?,?,?,?,?,?)");
            statement.setString(1,userPaymentData.paymentMethode);
            statement.setFloat(2,userPaymentData.bill);
            statement.setString(3,userPaymentData.nameOnCard);
            statement.setString(4,userPaymentData.CardNo);
            statement.setString(5,userPaymentData.ex_month);
            statement.setString(6,userPaymentData.ex_year);
            statement.setInt(7,primaryKey);
            statement.setString(8,userPaymentData.PhoneNumber);
            int i=statement.executeUpdate();
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
