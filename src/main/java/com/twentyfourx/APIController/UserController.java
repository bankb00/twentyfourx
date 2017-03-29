package com.twentyfourx.APIController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping(path="/users") // This means URL's start with /demo (after Application path)
public class UserController {


    /*@RequestMapping(value="/add",method= RequestMethod.GET)
    public boolean addUser(@RequestHeader(value="access_token") String tokenValue,@RequestHeader(value="user_id") String user_id) throws Exception {
        String url = "jdbc:mysql://localhost:3306/bankza";
        Connection conn = DriverManager.getConnection(url,"root","password");
        Statement stmt = conn.createStatement();
        ResultSet rs;
        int id = 0;
        String userId = user_id;


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


        return false;

    }*/

    @RequestMapping(value="/login",method= RequestMethod.GET)
    public @ResponseBody LoginObject userLogin(@RequestHeader(value="access_token") String tokenValue, @RequestHeader(value="user_id") String user_id) throws Exception {
        String url = "jdbc:mysql://localhost:3306/bankza";
        Connection conn = DriverManager.getConnection(url,"root","password");
        Statement stmt = conn.createStatement();
        ResultSet rs;
        LoginObject login = new LoginObject(false,false);
        int id = 0;
        String userId = user_id;
        String name;
        String email;
        String mobileNo;


        //ObjectMapper mapper = new ObjectMapper();
        //String jsonInString = null;

        //check user is created?
        try {
            rs = stmt.executeQuery("SELECT * FROM user ");
            while (rs.next()) {
                if (userId.equalsIgnoreCase(rs.getString("user_id"))) {
                    id = rs.getInt("id");
                    name = rs.getString("name");
                    email = rs.getString("email");
                    mobileNo = rs.getString("mobile_no");

                    login.setLoginSuccess(true);

                    UserObject user = new UserObject(name,email,mobileNo,tokenValue,userId);
                    //String jsonInString = mapper.writeValueAsString(user);
                    login.setUser(user);
                     //jsonInString = mapper.writeValueAsString(user);
                }
            }
            //conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        //id not then create
        if (id == 0) {
            return login;
        }
        else {
            login.setIsRegister(true);

            //UserObject user =mapper.readValue(jsonInString, UserObject.class);

            return login;
        }
    }

    @RequestMapping(value="/register",method= RequestMethod.POST)
    public @ResponseBody LoginObject userRegister(@RequestHeader(value="access_token") String tokenValue, @RequestHeader(value="user_id") String user_id, @RequestBody UserObject user) throws Exception {
        String url = "jdbc:mysql://localhost:3306/bankza";
        Connection conn = DriverManager.getConnection(url,"root","password");
        Statement stmt = conn.createStatement();
        ResultSet rs;
        String name = user.getName();
        String email = user.getEmail();
        String mobileNo = user.getMobileNo();
        String userId = user_id;



        String insertEx = "INSERT INTO user (name, user_id, email, mobile_no)" +
                "VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(insertEx);
            ps.setString(1,name);
            ps.setString(2,userId);
            ps.setString(3,email);
            ps.setString(4,mobileNo);
            ps.executeUpdate();
            conn.close();

        }
        catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        return(userLogin(tokenValue,user_id));

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

    /*@RequestMapping(value="/testest",method= RequestMethod.GET)
    public String eiei() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        UserObject user = new UserObject("bankza","bankstch@gmail.com","156165156","15611651");

        //Object to JSON in String
        String jsonInString = mapper.writeValueAsString(user);
        return jsonInString;
    }*/

}
