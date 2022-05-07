package database;

import models.AdminBusLine;
import models.AdminRegister;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

//public class AdminBusLine_DB {
//
//
//    public static AdminBusLine getBusLine(int bus_id) {
//
//        AdminBusLine adminBusLine = null;
//        try {
//            Connection con = DB_Connection.getConnection();
//            String sql = "select * from admin_busline where bus_id=?";
//            PreparedStatement getstatement = con.prepareStatement(sql);
//            getstatement.setInt(1, bus_id);
//            ResultSet rs = getstatement.executeQuery();
//
//            while (rs.next())  {
//
//                Blob blob = rs.getBlob(4);
////                ByteArrayInputStream is = new ByteArrayInputStream(blob);
////                BufferedImage newBi = blob.read(is);
//
//                        adminBusLine = new AdminBusLine(rs.getInt(1), rs.getString(2),rs.getString(3), blob.length()+" ",rs.getString(5), rs.getString(6),
//                                LocalDate.parse(rs.getString(7)), LocalTime.parse(rs.getString(8)), rs.getInt(9),rs.getInt(10),rs.getDouble(11));
//
//
//
//            }
//            con.close();
//        } catch (SQLException e) {
//
//            e.printStackTrace();
//        }
//        return adminBusLine;
//
//    }
//
//    public static List<AdminBusLine> getAdminBusLists() {
//
//        List<AdminBusLine> list = new ArrayList<AdminBusLine>();
//
//        try {
//            Connection con = DB_Connection.getConnection();
//            String sql = "select * from admin_busline ";
//
//            PreparedStatement getstatement = con.prepareStatement(sql);
//
//            ResultSet rs = getstatement.executeQuery();
//            while (rs.next()) {
//
//                Blob blob = rs.getBlob(4);
//
//                AdminBusLine adminBusLine = new AdminBusLine(rs.getInt(1), rs.getString(2),rs.getString(3), blob.length()+" ",rs.getString(5), rs.getString(6),
//                        LocalDate.parse(rs.getString(7)),LocalTime.parse(rs.getString(8)), rs.getInt(9),rs.getInt(10),rs.getDouble(11));
//
//                list.add(adminBusLine);
//            }
//            con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public static void addBusLine(AdminBusLine bus) {
//        try {
//            Connection con = DB_Connection.getConnection();
//            PreparedStatement ps = con.prepareStatement(
//                    "insert into admin_busline (bus_id,bus_name,bus_no,bus_image,loc_from,loc_to,date,time,seat_qty,seat_col,price) values (?,?,?,?,?,?,?,?,?,?,?)");
//
//            ps.setInt(1, bus.getBus_id());
//            ps.setString(2, bus.getBus_name());
//            ps.setString(3, bus.getBus_no());
//        //    ps.setBlob(4);
//            ps.setString(5, bus.getLoc_from());
//            ps.setString(6, bus.getLoc_to());
//            ps.setString(7,bus.getDate().toString());
//            ps.setString(8,bus.getTime().toString());
//            ps.setInt(9, bus.getSeat_qty());
//            ps.setInt(10, bus.getSeat_col());
//            ps.setDouble(11, bus.getPrice());
//
//            ps.executeUpdate();
//
//            con.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//
//    }
//
//    public static void delete_BusLine(int bus_id) {
//
//        try {
//            Connection con = DB_Connection.getConnection();
//            String sql = "DELETE FROM admin_busline WHERE bus_id=?";
//            PreparedStatement getstatement = con.prepareStatement(sql);
//            getstatement.setInt(1, bus_id);
//            getstatement.executeUpdate();
//            con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//        }
//
//    }
//
//    public static void updateBusLine(AdminBusLine bus) {
//
//        try {
//            Connection con = DB_Connection.getConnection();
//
//            String sql = "UPDATE admin_busline SET  bus_name=?,bus_no=?,bus_image=?,loc_from=?,loc_to=?,date=?,time=?,seat_qty=?,seat_col=?,price=?  where bus_id=?";
//            PreparedStatement statement = con.prepareStatement(sql);
//
//            statement.setString(1, bus.getBus_name());
//            statement.setString(2, bus.getBus_no());
//          //  statement.setBlob(3);
//            statement.setString(4, bus.getLoc_from());
//            statement.setString(5, bus.getLoc_to());
//            statement.setString(6, bus.getDate().toString());
//            statement.setString(7, bus.getTime().toString());
//            statement.setInt(8, bus.getSeat_qty());
//            statement.setInt(9, bus.getSeat_col());
//            statement.setDouble(10, bus.getPrice());
//            statement.setInt(11, bus.getBus_id());
//
//            statement.executeUpdate();
//            con.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
