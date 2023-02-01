package jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class JDBCInsert {
    public static void main(String[] args) {
        String user = "sys as sysdba";
        String pass = "Welcome1.123";
        try  {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcle", user, pass);
            PreparedStatement psmt = con.prepareStatement("insert into employee values(?,?,?,?,?)");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while(true){
                System.out.println("EID FIRSTNAME lastname did salary");
                int eid = Integer.parseInt(br.readLine());
                String fname = br.readLine();
                String lname = br.readLine();
                int did = Integer.parseInt(br.readLine());
                double salary = Double.parseDouble(br.readLine());

                psmt.setInt(1, eid);
                psmt.setString(2, fname);
                psmt.setString(3, lname);
                psmt.setInt(4, did);
                psmt.setDouble(5, salary);
                int n = psmt.executeUpdate();
                System.out.println(n + " rows inserted");
                System.out.println("Do you want to continue (y/n)");
                String ch = br.readLine();
                if(ch.equalsIgnoreCase("n"))
                    break;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
