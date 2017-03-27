package com.twentyfourx.APIController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;

/**
 * Created by Thanawat on 3/26/2017.
 */
@RestController //Test
@Controller    // This means that this class is a Controller
@RequestMapping(path="/user") // This means URL's start with /demo (after Application path)
public class UserController {


    @RequestMapping(value="/add",method= RequestMethod.GET)
    public boolean addUser(@RequestHeader(value="access_token") String tokenValue,@RequestHeader(value="user_id") String user_id) throws Exception {
        String url = "jdbc:mysql://localhost:3306/bankza";
        Connection conn = DriverManager.getConnection(url,"root","password");
        Statement stmt = conn.createStatement();
        ResultSet rs;
        int id = 0;
        String userId = user_id;

        if(checkToken(tokenValue)==true) {

            //check user is created?
            try {

                rs = stmt.executeQuery("SELECT * FROM user ");
                while (rs.next()) {
                    if (user_id.equalsIgnoreCase(rs.getString("user_id"))) {
                        id = rs.getInt("id");
                        return false;
                    }
                }
                //conn.close();
            } catch (Exception e) {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());
            }

            //id not then create
            if (id == 0) {
                String str = "INSERT INTO user (user_id)" +
                        "VALUES ('" + userId + "')";

                try {
                    stmt.executeUpdate(str);
                    return true;
                    //conn.close();

                } catch (Exception e) {
                    System.err.println("Got an exception! ");
                    System.err.println(e.getMessage());
                }

            }
        }



        return false;

    }

    public boolean checkToken(String token) throws  Exception{
        String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:53.0) Gecko/20100101 Firefox/53.0";
        //String userToken = "EAADnEZCfV0nwBAO4HYFGrnJdjIrlVV66whWgKe80UUCZCsH15B4sM55Ob3dH3ThwMv3BsZC6635c3LYPdbx9yIX3ooXmZBDa5ZBW0X9ZA0mqCWQsc36XYZBpG2uUWYa20U96ns8zvOJGIjGZBM7msrGocMQKoMjauK8I0kj0C9hCnObl22tUz4xSIuZBSfaE9k3gZD";
        String userToken = token;
        String url = "https://graph.facebook.com/debug_token?input_token="+userToken+"&access_token=254072948380284|53koftZWubLWVXH3nzUZyFbboVw";
        //"http://www.google.com/search?q=mkyong";
        //"https://graph.facebook.com/oauth/access_token?client_id=254072948380284&client_secret=d82a08cc6c73d5948212516c12671e42&grant_type=client_credentials";

        boolean isValid = false;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        //System.out.println("\nSending 'GET' request to URL : " + url);
        //System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        StringBuilder sb = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
            sb.append(inputLine+"\n");
            //////////////////////////////////////////
            String sentence = inputLine;
            String search  = "true";

            if ( sentence.toLowerCase().indexOf(search.toLowerCase()) != -1&&responseCode==200 ) {

                isValid = true;
            }
            /////////////////////////////////////////
        }
        String str =sb.toString();
        in.close();

        //print result
        //System.out.println(isValid);
        //return str;
        return isValid;

    }
}
