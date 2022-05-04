package models;

import java.util.Arrays;

public class AdminRegister {

    public int rg_id;
    public String rg_name;
    public Byte[] rg_image;
    public String rg_email;
    public String rg_nrc;
    public String rg_phoneNo;
    public String rg_city;
    public String rg_password;
    public String rg_gender;

//    public AdminRegister(String rg_gender){
//        this.rg_gender= rg_gender;
//    }

    public AdminRegister(int rg_id, String rg_name, Byte[] rg_image, String rg_email, String rg_nrc, String rg_phoneNo, String rg_city, String rg_password, String rg_gender) {
        this.rg_id = rg_id;
        this.rg_name = rg_name;
        this.rg_image = rg_image;
        this.rg_email = rg_email;
        this.rg_nrc = rg_nrc;
        this.rg_phoneNo = rg_phoneNo;
        this.rg_city = rg_city;
        this.rg_password = rg_password;
        this.rg_gender = rg_gender;
    }

    public int getRg_id() {
        return rg_id;
    }

    public void setRg_id(int rg_id) {
        this.rg_id = rg_id;
    }

    public String getRg_name() {
        return rg_name;
    }

    public void setRg_name(String rg_name) {
        this.rg_name = rg_name;
    }

    public Byte[] getRg_image() {
        return rg_image;
    }

    public void setRg_image(Byte[] rg_image) {
        this.rg_image = rg_image;
    }

    public String getRg_email() {
        return rg_email;
    }

    public void setRg_email(String rg_email) {
        this.rg_email = rg_email;
    }

    public String getRg_nrc() {
        return rg_nrc;
    }

    public void setRg_nrc(String rg_nrc) {
        this.rg_nrc = rg_nrc;
    }

    public String getRg_phoneNo() {
        return rg_phoneNo;
    }

    public void setRg_phoneNo(String rg_phoneNo) {
        this.rg_phoneNo = rg_phoneNo;
    }

    public String getRg_city() {
        return rg_city;
    }

    public void setRg_city(String rg_city) {
        this.rg_city = rg_city;
    }

    public String getRg_password() {
        return rg_password;
    }

    public void setRg_password(String rg_password) {
        this.rg_password = rg_password;
    }

    public String getRg_gender() {
        return rg_gender;
    }

    public void setRg_gender(String rg_gender) {
        this.rg_gender = rg_gender;
    }

    @Override
    public String toString() {
        return "AdminRegister{" +
                "rg_id=" + rg_id +
                ", rg_name='" + rg_name + '\'' +
                ", rg_image=" + Arrays.toString(rg_image) +
                ", rg_email='" + rg_email + '\'' +
                ", rg_nrc='" + rg_nrc + '\'' +
                ", rg_phoneNo='" + rg_phoneNo + '\'' +
                ", rg_city='" + rg_city + '\'' +
                ", rg_password='" + rg_password + '\'' +
                ", rg_gender='" + rg_gender + '\'' +
                '}';
    }
}
