package Bakend;

public class UserPaymentData {
    public String paymentMethode;
    public float bill;
    public String nameOnCard;
    public String CardNo;
    public String PhoneNumber;
    public String ex_month;
    public String ex_year;

    public UserPaymentData(String paymentMethode, float bill, String nameOnCard, String cardNo, String ex_month, String ex_year,String PhoneNumber) {
        this.paymentMethode = paymentMethode;
        this.bill = bill;
        this.nameOnCard = nameOnCard;
        CardNo = cardNo;
        this.ex_month = ex_month;
        this.ex_year = ex_year;
        this.PhoneNumber=PhoneNumber;
    }


}
