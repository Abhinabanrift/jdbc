package jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

public class JDBCSELECT {
    public static void main(String[] args) {
        String user = "sys as sysdba";
        String pass = "Welcome1.123";
        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcle", user, pass);
            ResultSet rs = con.createStatement().executeQuery("select * from employee");
            while(rs.next()) {
                int eid = rs.getInt(1);
                String ename = rs.getString(2);
                String elname =  rs.getString(3);
                String edid = rs.getString(4);
                Double  esal = rs.getDouble(5);
                System.out.println(eid + " " + ename + " " + elname + " " + esal);
            }
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
