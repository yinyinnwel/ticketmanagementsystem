package models;

public class SellerRegister {

    public int seller_id;
    public String seller_name;
    public String seller_image;
    public String seller_email;
    public String seller_nrc;
    public String seller_phoneNo;
    public String seller_city;
    public String seller_password;
    public String seller_gender;

    public SellerRegister(int seller_id,String seller_name,String seller_image,String seller_email,String seller_nrc,
                          String seller_phoneNo,String seller_city,String seller_password,String seller_gender){
        this.seller_id = seller_id;
        this.seller_name = seller_name;
        this.seller_image = seller_image;
        this.seller_email = seller_email;
        this.seller_nrc = seller_nrc;
        this.seller_phoneNo = seller_phoneNo;
        this.seller_city = seller_city;
        this.seller_password = seller_password;
        this.seller_gender = seller_gender;
    }

    public int getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }

    public String getSeller_name() {
        return seller_name;
    }

    public void setSeller_name(String seller_name) {
        this.seller_name = seller_name;
    }

    public String getSeller_image() {
        return seller_image;
    }

    public void setSeller_image(String seller_image) {
        this.seller_image = seller_image;
    }

    public String getSeller_email() {
        return seller_email;
    }

    public void setSeller_email(String seller_email) {
        this.seller_email = seller_email;
    }

    public String getSeller_nrc() {
        return seller_nrc;
    }

    public void setSeller_nrc(String seller_nrc) {
        this.seller_nrc = seller_nrc;
    }

    public String getSeller_phoneNo() {
        return seller_phoneNo;
    }

    public void setSeller_phoneNo(String seller_phoneNo) {
        this.seller_phoneNo = seller_phoneNo;
    }

    public String getSeller_city() {
        return seller_city;
    }

    public void setSeller_city(String seller_city) {
        this.seller_city = seller_city;
    }

    public String getSeller_password() {
        return seller_password;
    }

    public void setSeller_password(String seller_password) {
        this.seller_password = seller_password;
    }

    public String getSeller_gender() {
        return seller_gender;
    }

    public void setSeller_gender(String seller_gender) {
        this.seller_gender = seller_gender;
    }
}
