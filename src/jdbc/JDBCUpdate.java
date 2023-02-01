package jdbc;

import java.io.BufferedReader;
import java.sql.*;

public class JDBCUpdate {
    public static void main(String[] args) {
        try {
            // Class.forName("oracle.jdbc.driver.OracleDriver");
            String user = "sys as sysdba";
            String pass = "Welcome1.123";
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcle", user, pass);
            Statement st = con.createStatement(); // statemenr is a interface

            BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
            System.out.println("Enter id");
            System.out.println("Enter the id to update");
            int id = Integer.parseInt(br.readLine());
            System.out.println("Enter the name");
            String name = br.readLine();
            // UPDATE
            int count = st.executeUpdate("update employee set firstname='" + name + "' where eid=" + id);
            if(count>0){
                System.out.println(count);
            }else{
                System.out.println("NEI KICHU");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
