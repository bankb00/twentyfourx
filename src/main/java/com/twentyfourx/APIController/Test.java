package com.twentyfourx.APIController;

/**
 * Created by Thanawat on 3/21/2017.
 */
//  Query1.java:  Query an mSQL database using JDBC.

/**
 * A JDBC SELECT (JDBC query) example program.
 */
/*public class Test {

    public static void main (String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/bankza";
            Connection conn = DriverManager.getConnection(url,"root","password");
            Statement stmt = conn.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery("SELECT * FROM Exhibition WHERE isPassed = FALSE ");
            while ( rs.next() ) {
                String lastName = rs.getString("name");
                System.out.println(lastName);
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}*/