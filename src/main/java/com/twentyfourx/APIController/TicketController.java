package com.twentyfourx.APIController;


import com.twentyfourx.Repository.ExhibitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Thanawat on 3/23/2017.
 */

@RestController
@Controller
@RequestMapping(path="/tickets") // This means URL's start with /demo (after Application path)
public class TicketController {

    /*@Autowired
    TicketRepository ticketRepository;*/
    @Autowired
    ExhibitionRepository exhibitionRepository;

    //get Ticket
    @RequestMapping(value="/{user_id}",method= RequestMethod.GET)
    public @ResponseBody
    List<GetTicketObject> getTicket(@RequestHeader(value="access_token") String tokenValue, @PathVariable String user_id) throws Exception {
        String url = "jdbc:mysql://localhost:3306/bankza";
        Connection conn = DriverManager.getConnection(url, "root", "password");
        Statement stmt = conn.createStatement();
        ResultSet rs;
        int userId = 0;
        List<Integer> listTickId= new ArrayList<Integer>();


        List<GetTicketObject> listTicket= new ArrayList<GetTicketObject>();
        if(checkToken(tokenValue)==true) {
            try {

                rs = stmt.executeQuery("SELECT * FROM user ");
                while (rs.next()) {
                    if (user_id.equalsIgnoreCase(rs.getString("user_id"))) {
                        userId = rs.getInt("id");
                    }
                }
                //conn.close();
            } catch (Exception e) {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());
            }

            try {

                rs = stmt.executeQuery("SELECT * FROM user_and_ticket WHERE user_id = "+userId+" ");
                while (rs.next()) {
                    int i = rs.getInt("ticket_id");
                    listTickId.add(i);
                }
                //conn.close();
            } catch (Exception e) {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());
            }

            for(int j = 0; j< listTickId.size() ; j++){
                int tickIndex = listTickId.get(j);
                try {
                    rs = stmt.executeQuery("SELECT * FROM ticket WHERE id = "+tickIndex+" "+" ORDER BY end_date ASC");
                    while ( rs.next() ) {
                        //String lastName = rs.getString("name");
                        //System.out.println(lastName);
                        int id = rs.getInt("id");
                        int exhibitionId = rs.getInt("exhibition_id");
                        String exhibitionName = rs.getString("exhibition_name");
                        String holderId = rs.getString("user_id");
                        String startDate = rs.getString( "start_date");
                        String endDate = rs.getString("end_date");
                        String holderName = rs.getString("holder_name");
                        String holderRole = rs.getString("holder_role");
                        String companyName = rs.getString("company_name");
                        boolean isExpired = rs.getBoolean("is_expired");


                        ExhibitionObjectForTicket exhibition = new ExhibitionObjectForTicket(exhibitionId,exhibitionName,startDate,endDate);

                        if(checkDate(endDate)==true){
                            GetTicketObject getTicketObject = new GetTicketObject(id,exhibition,startDate,endDate,holderName,holderRole,companyName,true);
                            listTicket.add(getTicketObject);
                        }
                        else{
                            GetTicketObject getTicketObject = new GetTicketObject(id,exhibition,startDate,endDate,holderName,holderRole,companyName,false);
                            listTicket.add(getTicketObject);
                        }
                        //Ticket ticket = new Ticket(id, exhibitionId,exhibitionName,holderId, startDate, endDate, holderName, holderRole, isExpired, companyName);


                    }
                    //conn.close();
                }
                catch (Exception e) {
                    System.err.println("Got an exception! ");
                    System.err.println(e.getMessage());
                }
            }


            conn.close();
            return listTicket;
        }
        else {
            return listTicket;
        }

    }

    /*//get Ticket
    @RequestMapping(value="/{user_id}",method= RequestMethod.GET)
    public @ResponseBody
    List<Ticket> getTicket(@RequestHeader(value="access_token") String tokenValue, @PathVariable String user_id) throws Exception {
        String url = "jdbc:mysql://localhost:3306/bankza";
        Connection conn = DriverManager.getConnection(url, "root", "password");
        Statement stmt = conn.createStatement();
        ResultSet rs;
        int userId = 0;
        List<Integer> listTickId= new ArrayList<Integer>();


        List<Ticket> listTicket= new ArrayList<Ticket>();
        if(checkToken(tokenValue)==true) {
            try {

                rs = stmt.executeQuery("SELECT * FROM user ");
                while (rs.next()) {
                    if (user_id.equalsIgnoreCase(rs.getString("user_id"))) {
                        userId = rs.getInt("id");
                    }
                }
                //conn.close();
            } catch (Exception e) {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());
            }

            try {

                rs = stmt.executeQuery("SELECT * FROM user_and_ticket WHERE user_id = "+userId+" ");
                while (rs.next()) {
                    int i = rs.getInt("ticket_id");
                    listTickId.add(i);
                }
                //conn.close();
            } catch (Exception e) {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());
            }

            for(int j = 0; j< listTickId.size() ; j++){
                int tickIndex = listTickId.get(j);
                try {
                    rs = stmt.executeQuery("SELECT * FROM ticket WHERE id = "+tickIndex+" "+" ORDER BY start_date ASC");
                    while ( rs.next() ) {
                        //String lastName = rs.getString("name");
                        //System.out.println(lastName);
                        int id = rs.getInt("id");
                        int exhibitionId = rs.getInt("exhibition_id");
                        String exhibitionName = rs.getString("exhibition_name");
                        String holderId = rs.getString("user_id");
                        String startDate = rs.getString( "start_date");
                        String endDate = rs.getString("end_date");
                        String holderName = rs.getString("holder_name");
                        String holderRole = rs.getString("holder_role");
                        String companyName = rs.getString("company_name");
                        boolean isExpired = rs.getBoolean("is_expired");

                        Ticket ticket = new Ticket(id, exhibitionId,exhibitionName,holderId, startDate, endDate, holderName, holderRole, isExpired, companyName);

                        listTicket.add(ticket);
                    }
                    //conn.close();
                }
                catch (Exception e) {
                    System.err.println("Got an exception! ");
                    System.err.println(e.getMessage());
                }
            }


            conn.close();
            return listTicket;
        }
        else {
            return listTicket;
        }

    }*/


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


    public boolean checkDate(String endDate)  {

        String string = endDate;

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LocalDate myLocaldate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        //int i = 0;
        LocalDate localDate = LocalDate.now();
        if (myLocaldate.isBefore(localDate)) {

            return true;
        } else {

            return false;
        }


    }
}
