package database;

import models.AdminRegister;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminRegister_DB {

    static File path;

    public static AdminRegister getRegister(int rg_id) {

        AdminRegister adminRegister = null;
        try {
            Connection con = DB_Connection.getConnection();
            String sql = "select * from admin_register where rg_id=?";
            PreparedStatement getstatement = con.prepareStatement(sql);
            getstatement.setInt(1, rg_id);
            ResultSet rs = getstatement.executeQuery();
            while (rs.next()) {

                Blob blob = rs.getBlob(3);

                adminRegister = new AdminRegister(rs.getInt(1), rs.getString(2), blob.length() + "",rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7),rs.getString(8),rs.getString(9));

            }
            con.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return adminRegister;

    }

    public static List<AdminRegister> getRegisterLists() {

        List<AdminRegister> list = new ArrayList<AdminRegister>();

        try {
            Connection con = DB_Connection.getConnection();
            String sql = "select * from admin_register ";

            PreparedStatement getstatement = con.prepareStatement(sql);

            ResultSet rs = getstatement.executeQuery();
            while (rs.next()) {

                Blob blob = rs.getBlob(3);

                AdminRegister register = new AdminRegister(rs.getInt(1), rs.getString(2), blob.length() + "",rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7),rs.getString(8),rs.getString(9));

               list.add(register);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void addRegister(AdminRegister register) {

        try {
            Connection con = DB_Connection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into admin_register (rg_id,rg_name,rg_image,rg_email,rg_nrc,rg_phoneNo,rg_city,rg_password,rg_gender) values (?,?,?,?,?,?,?,?,?)");

            ps.setInt(1, register.getRg_id());
            ps.setString(2, register.getRg_name());
            ps.setString(4,register.getRg_email());
            ps.setString(5, register.getRg_nrc());
            ps.setString(6, register.getRg_phoneNo());
            ps.setString(7, register.getRg_city());
            ps.setString(8, register.getRg_password());
            ps.setString(9, register.getRg_gender());
            if (path != null) {
                ps.setBlob(3, new FileInputStream(path));
            } else
                ps.setBlob(3, new FileInputStream(new File("D:\\Jetbrain Projects\\TicketManagementSystem_V2\\src\\images\\user.png")));

            ps.executeUpdate();

            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public static void delete_Register(int rg_id) {

        try {
            Connection con = DB_Connection.getConnection();
            String sql = "DELETE FROM admin_register WHERE rg_id=?";
            PreparedStatement getstatement = con.prepareStatement(sql);
            getstatement.setInt(1, rg_id);
            getstatement.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    public static void updateRegister(AdminRegister register) throws FileNotFoundException {

        try {
            Connection con = DB_Connection.getConnection();

            String sql = "UPDATE admin_register SET  rg_name,rg_image,rg_email,rg_nrc,rg_phoneNo,rg_city,rg_password,rg_gender where rg_id=?";
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, register.getRg_name());
            statement.setString(3,register.getRg_email());
            statement.setString(4, register.getRg_nrc());
            statement.setString(5, register.getRg_phoneNo());
            statement.setString(6, register.getRg_city());
            statement.setString(7, register.getRg_password());
            statement.setString(8,register.getRg_gender());
            if (path != null) {
                statement.setBlob(2, new FileInputStream(path));
            } else
                statement.setBlob(2, new FileInputStream(new File("D:\\Jetbrain Projects\\TicketManagementSystem_V2\\src\\images\\user.png")));
            statement.setInt(9, register.getRg_id());
            statement.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws FileNotFoundException {

		ArrayList<AdminRegister> registers=(ArrayList<AdminRegister>) getRegisterLists();
		for(AdminRegister rg:registers) {
			System.out.println(rg.getRg_id());
			System.out.println(rg.getRg_name());
		}

//		AdminRegister newrg=new AdminRegister("Male");
//		System.out.println(newrg.getRg_gender());

//		delete_Register(2);

//		updateRegister(new Register(1, "Admin","D:\\Java_Project\\Photos\\name.png", "1I-2090","09123456", "MDY", "123"));
//		addRegister(new AdminRegister(1, "Admin", "D:\\Jetbrain Projects\\TicketManagementSystem_V2\\src\\images\\user.png","admin@gmail.com","9/MaHaMa(N)123456","09123456789","mdy","admin123","Male"));

    }

}
