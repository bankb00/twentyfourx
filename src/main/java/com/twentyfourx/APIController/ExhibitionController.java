package com.twentyfourx.APIController;

/**
 * Created by Thanawat on 3/11/2017.
 */

import com.twentyfourx.Entity.Booth;
import com.twentyfourx.Entity.BoothObject;
import com.twentyfourx.Entity.Exhibition;
import com.twentyfourx.Entity.ExhibitionObject;
import com.twentyfourx.Repository.BoothRepository;
import com.twentyfourx.Repository.ExhibitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController //Test
@Controller    // This means that this class is a Controller
@RequestMapping(path="/exhibitions") // This means URL's start with /demo (after Application path)
public class ExhibitionController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private ExhibitionRepository exhibitionRepository;
    @Autowired
    private BoothRepository boothRepository;
    /*@Autowired
    private BoothContactRepository boothContactRepository;*/

    private List<String> categories = new ArrayList<>(Arrays.asList("Food", "Home & Decorate","Technology & Electronics Devices"
            ,"Book Fair","Travel & Tourism","Motor Show","Trade Show","Business","Pet","Cloth & Fashion","Others"));


    //@RequestMapping(value = "/getsize", method = RequestMethod.GET)
    public void checkSize() throws SQLException {
        List<Exhibition> listEx = exhibitionRepository.findAll();

        String url = "jdbc:mysql://localhost:3306/bankza";
        Connection conn = DriverManager.getConnection(url,"root","password");
        boolean status;
        int size = listEx.size();
        int id;
        for(int i = 0 ; i<size ; i++){
            //boolean status = listEx.get(i).checkDate();
            listEx.get(i).setPassed(listEx.get(i).checkDate());
            status = listEx.get(i).checkDate();
            id = listEx.get(i).getId();
            try
        {
            Statement st = conn.createStatement();
            if(status==true) {
                st.executeUpdate("UPDATE exhibition SET is_passed= 1 WHERE id = " + id + "");
            }
            else {
                st.executeUpdate("UPDATE exhibition SET is_passed= 0 WHERE id = " + id + "");
            }


        }
        catch (SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
        }
    }



    //Pageable Exhibition
    @RequestMapping(value = "/", method = RequestMethod.GET)
    Page<Exhibition> exhibitionsPageable(Pageable pageable) {
        return exhibitionRepository.findAll(pageable);

    }

    //list All Exhibition
    @RequestMapping(value="/all",method= RequestMethod.GET)
    public @ResponseBody Iterable<Exhibition> getAllExhibitions() {
        // This returns a JSON or XML with the users
        return exhibitionRepository.findAll();
        //return exhibitionRepository.
    }

    //get exhibition
    @RequestMapping(value = "/{exhibitionId}", method=RequestMethod.GET)
    public Exhibition getExhibition(@PathVariable int exhibitionId){
        return  exhibitionRepository.findById(exhibitionId);

    }

    //save Exhibition fav
    @RequestMapping(value = "/{exhibitionId}/saveFavourited", method=RequestMethod.GET)
    @ResponseBody
    public boolean saveFavExhi(@RequestHeader(value="access_token") String tokenValue,@RequestHeader(value="user_id") String user_id, @PathVariable int exhibitionId) throws SQLException, Exception {
        int id = 0;
        String userId = user_id;
        String url = "jdbc:mysql://localhost:3306/bankza";
        Connection conn = DriverManager.getConnection(url,"root","password");
        Statement stmt = conn.createStatement();
        ResultSet rs;

        if(checkToken(tokenValue)==true) {

            //check user is created?
            try {

                rs = stmt.executeQuery("SELECT * FROM user ");
                while (rs.next()) {
                    if (user_id.equalsIgnoreCase(rs.getString("user_id"))) {
                        id = rs.getInt("id");
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
                    //conn.close();

                } catch (Exception e) {
                    System.err.println("Got an exception! ");
                    System.err.println(e.getMessage());
                }
                rs = stmt.executeQuery("SELECT * FROM user ");
                while (rs.next()) {
                    if (user_id.equalsIgnoreCase(rs.getString("user_id"))) {
                        id = rs.getInt("id");
                        System.out.println(id);
                    }
                }
            }

            if(id!=0){
                System.out.println("Create at user_and_exhibition");
                System.out.println(id);
                String str = "INSERT INTO user_and_exhibition (user_id, exhibition_id)" +
                        "VALUES ('" + id + "', '"+exhibitionId+"')";

                try {
                    stmt.executeUpdate(str);
                    conn.close();

                } catch (Exception e) {
                    System.err.println("Got an exception! ");
                    System.err.println(e.getMessage());
                }
            }
            return true;

        }
        else {
            return false;
        }
    }

    //UnFav Exhibition fav
    @ResponseBody
    @RequestMapping(value = "/{exhibitionId}/unFavourited", method=RequestMethod.GET)
    public boolean unFavExhi(@RequestHeader(value="access_token") String tokenValue,@RequestHeader(value="user_id") String user_id,@PathVariable int exhibitionId) throws SQLException, Exception {

        int id = 0;
        String userId = user_id;
        String url = "jdbc:mysql://localhost:3306/bankza";
        Connection conn = DriverManager.getConnection(url,"root","password");
        Statement stmt = conn.createStatement();
        ResultSet rs;

        if(checkToken(tokenValue)==true) {
            //check user is created?
            try {

                rs = stmt.executeQuery("SELECT * FROM user ");
                while (rs.next()) {
                    if (user_id.equalsIgnoreCase(rs.getString("user_id"))) {
                        id = rs.getInt("id");
                    }
                }
                //conn.close();
            } catch (Exception e) {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());
            }

            //id not then create
            if (id == 0) {
                return false;
            }

            if(id!=0){
                System.out.println("Create at user_and_exhibition");
                System.out.println(id);
                String str = "DELETE FROM user_and_exhibition WHERE user_id = "+id+" AND exhibition_id = "+exhibitionId+"";

                try {
                    stmt.executeUpdate(str);
                    conn.close();

                } catch (Exception e) {
                    System.err.println("Got an exception! ");
                    System.err.println(e.getMessage());
                }
            }
            return true;

        }
        else {
            return false;
        }


        /*if(checkToken(tokenValue)==true){
            exhibitionRepository.findById(exhibitionId).setFavourited(false);
            return true;
        }
        else {
            System.out.println("UnValid");
            return false;
        }*/
    }


    //get fav ex
    @RequestMapping(value="/favEx",method= RequestMethod.GET)
    public @ResponseBody List<Exhibition> getFavExhibitions(@RequestHeader(value="access_token") String tokenValue,@RequestHeader(value="user_id") String user_id) throws Exception {
        String url = "jdbc:mysql://localhost:3306/bankza";
        Connection conn = DriverManager.getConnection(url, "root", "password");
        Statement stmt = conn.createStatement();
        ResultSet rs;
        int userId = 0;
        List<Integer> listExId= new ArrayList<Integer>();


        List<Exhibition> listEx= new ArrayList<Exhibition>();
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

                rs = stmt.executeQuery("SELECT * FROM user_and_exhibition WHERE user_id = "+userId+" ");
                while (rs.next()) {
                    int i = rs.getInt("exhibition_id");
                    listExId.add(i);
                }
                //conn.close();
            } catch (Exception e) {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());
            }

            for(int j = 0; j< listExId.size() ; j++){
                int exIndex = listExId.get(j);
                try {
                    rs = stmt.executeQuery("SELECT * FROM exhibition WHERE id = "+exIndex+" "+" ORDER BY start_date ASC");
                    while ( rs.next() ) {
                        //String lastName = rs.getString("name");
                        //System.out.println(lastName);
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        String description = rs.getString("description");
                        String location = rs.getString("location");
                        String category = rs.getString("category");
                        String startDate = rs.getString("start_date");
                        String endDate = rs.getString("end_date");
                        String posterUrl = rs.getString("poster_url");
                        boolean isFavourited = rs.getBoolean("is_favourited");
                        Double latitude = rs.getDouble("latitude");
                        Double longtitude = rs.getDouble("longtitude");
                        String agendaUrl = rs.getString("agenda_url");
                        String mapUrl = rs.getString("map_url");
                        boolean isPassed = rs.getBoolean("is_passed");

                        Exhibition exhibition = new Exhibition(id,name,description,location,category,startDate,endDate,posterUrl,isFavourited,latitude
                                ,longtitude,agendaUrl,mapUrl,isPassed);

                        listEx.add(exhibition);
                    }
                    //conn.close();
                }
                catch (Exception e) {
                    System.err.println("Got an exception! ");
                    System.err.println(e.getMessage());
                }
            }


            conn.close();
            return listEx;
        }
        else {
            return listEx;
        }

    }


    //get booths
    @RequestMapping(value="/{exhibitionId}/booths",method= RequestMethod.GET)
    public @ResponseBody List<Booth> getAllBooths(@PathVariable int exhibitionId){
    //public void getAllBooths(@PathVariable int exhibitionId){


        return boothRepository.findBoothByExhibitionId(exhibitionId);
    }

    //Filter By category
    @RequestMapping(value="/category/{category}",method = RequestMethod.GET)
    @ResponseBody
    public List<Exhibition> filterByCategory(@PathVariable String category){
        return exhibitionRepository.findByCategory(category);
    }

    //List of Category
    @RequestMapping(value="/categories",method= RequestMethod.GET)
    public @ResponseBody List<String> getAllCategories() {

        return categories;
    }


    //Get booth
    @RequestMapping(value="/{exhibitionId}/booths/{boothId}",method= RequestMethod.GET)
    public @ResponseBody Booth getBooth(@PathVariable int boothId){
        // This returns a JSON or XML with the users
        return boothRepository.findBoothById(boothId);


    }

    //Save e-bro
    @RequestMapping(value="/{exhibitionId}/booths/{boothId}/save",method= RequestMethod.POST)
    public @ResponseBody Booth saveEBro(@PathVariable int boothId, int exhibitionId){
        // This returns a JSON or XML with the users

        String brochureUrl = boothRepository.findBoothById(boothId).getBrochureUrl();
        System.out.println(exhibitionId);
        return boothRepository.findBoothById(boothId);


    }


    //get all latest Exhibition
    @RequestMapping(value="/latest",method = RequestMethod.GET)
    @ResponseBody
    public List<Exhibition> getUnPassExhibition() throws SQLException {
        checkSize();
        List<Exhibition> listEx= new ArrayList<Exhibition>();
        try {
            String url = "jdbc:mysql://localhost:3306/bankza";
            Connection conn = DriverManager.getConnection(url,"root","password");
            Statement stmt = conn.createStatement();
            ResultSet rs;


            rs = stmt.executeQuery("SELECT * FROM exhibition WHERE is_passed = false "+" ORDER BY start_date ASC");
            while ( rs.next() ) {
                //String lastName = rs.getString("name");
                //System.out.println(lastName);
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String location = rs.getString("location");
                String category = rs.getString("category");
                String startDate = rs.getString("start_date");
                String endDate = rs.getString("end_date");
                String posterUrl = rs.getString("poster_url");
                boolean isFavourited = rs.getBoolean("is_favourited");
                Double latitude = rs.getDouble("latitude");
                Double longtitude = rs.getDouble("longtitude");
                String agendaUrl = rs.getString("agenda_url");
                String mapUrl = rs.getString("map_url");
                boolean isPassed = rs.getBoolean("is_passed");

                Exhibition exhibition = new Exhibition(id,name,description,location,category,startDate,endDate,posterUrl,isFavourited,latitude
                ,longtitude,agendaUrl,mapUrl,isPassed);

                listEx.add(exhibition);
            }
            conn.close();
            }
            catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return listEx;


    }


    //add exhibition
    @ResponseBody
    @RequestMapping(value="/add",method= RequestMethod.POST)
    public void addExhibition(@RequestBody ExhibitionObject jason) throws SQLException {
        String name = jason.getName();
        String description = jason.getDescription();
        String location = jason.getLocation();
        String category = jason.getCategory();
        String startDate = jason.getStartDate();
        String endDate = jason.getEndDate();
        String posterUrl = jason.getPosterUrl();
        Double latitude = jason.getLatitude();
        if(latitude==null){
            latitude = 13.764936;
        }
        Double longtitude = jason.getLongtitude();
        if(longtitude==null){
            longtitude = 100.538297;
        }
        String agendaUrl = jason.getAgendaUrl();
        String mapUrl = jason.getMapUrl();

        String url = "jdbc:mysql://localhost:3306/bankza";
        Connection conn = DriverManager.getConnection(url, "root", "password");
        String insertEx = "INSERT INTO exhibition (name, description, location, category, start_date, end_date, poster_url, latitude, longtitude, agenda_url, map_url)" +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(insertEx);
            ps.setString(1,name);
            ps.setString(2,description);
            ps.setString(3,location);
            ps.setString(4,category);
            ps.setString(5,startDate);
            ps.setString(6,endDate);
            ps.setString(7,posterUrl);
            ps.setDouble(8,latitude);
            ps.setDouble(9,longtitude);
            ps.setString(10,agendaUrl);
            ps.setString(11,mapUrl);
            ps.executeUpdate();
            conn.close();

        }
        catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    //add booth
    @ResponseBody
    @RequestMapping(value="/{exId}/booths/add",method= RequestMethod.POST)
    public void addBooth(@RequestBody BoothObject jason, @PathVariable int exId) throws SQLException {
        String name = jason.getName();
        String boothCode = jason.getBoothCode();
        String description = jason.getDescription();
        int exhibitionId = exId;
        String logoUrl = jason.getLogoUrl();
        String brochureUrl = jason.getBrochureUrl();

        String url = "jdbc:mysql://localhost:3306/bankza";
        Connection conn = DriverManager.getConnection(url, "root", "password");
        /*String str = "INSERT INTO booth (name, booth_code, description, exhibition_id, logo_url, brochure_url)" +
                "VALUES ('"+name+"', '"+boothCode+"', '"+description+"', '"+exhibitionId+"', '"+logoUrl+"', '"+brochureUrl+"')";*/

        String insertBooth = "INSERT INTO booth"
                + "(name, booth_code, description, exhibition_id, logo_url, brochure_url) VALUES"
                + "(?,?,?,?,?,?)";

        try {
            /*Statement stmt = conn.createStatement();
            stmt.executeUpdate(str);*/
            PreparedStatement ps = conn.prepareStatement(insertBooth);
            ps.setString(1,name);
            ps.setString(2,boothCode);
            ps.setString(3,description);
            ps.setInt(4,exhibitionId);
            ps.setString(5,logoUrl);
            ps.setString(6,brochureUrl);
            ps.executeUpdate();
            conn.close();

        }
        catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    //Update exhibiiton
    @ResponseBody
    @RequestMapping(value="/{exhibitionId}/update",method= RequestMethod.POST)
    public void saveData(@RequestBody ExhibitionObject jason, @PathVariable int exhibitionId) throws SQLException {
        int id = exhibitionId;
        String name = jason.getName();
        String description = jason.getDescription();
        String location = jason.getLocation();
        String category = jason.getCategory();
        String startDate = jason.getStartDate();
        String endDate = jason.getEndDate();
        String posterUrl = jason.getPosterUrl();
        Double latitude = jason.getLatitude();
        Double longtitude = jason.getLongtitude();
        String agendaUrl = jason.getAgendaUrl();
        String mapUrl = jason.getMapUrl();

        String url = "jdbc:mysql://localhost:3306/bankza";
        Connection conn = DriverManager.getConnection(url,"root","password");
        if(name!=null){
            try
            {
                PreparedStatement ps = conn.prepareStatement(
                        "UPDATE exhibition SET name = ? WHERE id = ? ");
                ps.setString(1,name);
                ps.setInt(2,id);
                ps.executeUpdate();
            }
            catch (SQLException ex)
            {
                System.err.println(ex.getMessage());
            }
        }
        if(location!=null){
            try
            {
                PreparedStatement ps = conn.prepareStatement(
                        "UPDATE exhibition SET location = ? WHERE id = ? ");
                ps.setString(1,location);
                ps.setInt(2,id);
                ps.executeUpdate();
            }
            catch (SQLException ex)
            {
                System.err.println(ex.getMessage());
            }
        }
        if(category!=null){
            try
            {
                PreparedStatement ps = conn.prepareStatement(
                        "UPDATE exhibition SET category = ? WHERE id = ? ");
                ps.setString(1,category);
                ps.setInt(2,id);
                ps.executeUpdate();
            }
            catch (SQLException ex)
            {
                System.err.println(ex.getMessage());
            }
        }
        if(startDate!=null){
            try
            {
                PreparedStatement ps = conn.prepareStatement(
                        "UPDATE exhibition SET start_date = ? WHERE id = ? ");
                ps.setString(1,startDate);
                ps.setInt(2,id);
                ps.executeUpdate();
            }
            catch (SQLException ex)
            {
                System.err.println(ex.getMessage());
            }
        }
        if(endDate!=null){
            try
            {
                PreparedStatement ps = conn.prepareStatement(
                        "UPDATE exhibition SET end_date = ? WHERE id = ? ");
                ps.setString(1,endDate);
                ps.setInt(2,id);
                ps.executeUpdate();
            }
            catch (SQLException ex)
            {
                System.err.println(ex.getMessage());
            }
        }
        if(posterUrl!=null){
            try
            {
                PreparedStatement ps = conn.prepareStatement(
                        "UPDATE exhibition SET poster_url = ? WHERE id = ? ");
                ps.setString(1,posterUrl);
                ps.setInt(2,id);
                ps.executeUpdate();
            }
            catch (SQLException ex)
            {
                System.err.println(ex.getMessage());
            }
        }
        if(description!=null){
            try
            {
                PreparedStatement ps = conn.prepareStatement(
                        "UPDATE exhibition SET description = ? WHERE id = ? ");
                ps.setString(1,description);
                ps.setInt(2,id);
                ps.executeUpdate();
            }
            catch (SQLException ex)
            {
                System.err.println(ex.getMessage());
            }
        }
        if(latitude!=null){
            try
            {
                PreparedStatement ps = conn.prepareStatement(
                        "UPDATE exhibition SET latitude = ? WHERE id = ? ");
                ps.setDouble(1,latitude);
                ps.setInt(2,id);
                ps.executeUpdate();
            }
            catch (SQLException ex)
            {
                System.err.println(ex.getMessage());
            }
        }
        if(longtitude!=null){
            try
            {
                PreparedStatement ps = conn.prepareStatement(
                        "UPDATE exhibition SET longtitude = ? WHERE id = ? ");
                ps.setDouble(1,longtitude);
                ps.setInt(2,id);
                ps.executeUpdate();
            }
            catch (SQLException ex)
            {
                System.err.println(ex.getMessage());
            }
        }
        if(agendaUrl!=null){
            try
            {
                PreparedStatement ps = conn.prepareStatement(
                        "UPDATE exhibition SET agenda_url = ? WHERE id = ? ");
                ps.setString(1,agendaUrl);
                ps.setInt(2,id);
                ps.executeUpdate();
            }
            catch (SQLException ex)
            {
                System.err.println(ex.getMessage());
            }
        }
        if(mapUrl!=null){
            try
            {
                PreparedStatement ps = conn.prepareStatement(
                        "UPDATE exhibition SET map_url = ? WHERE id = ? ");
                ps.setString(1,mapUrl);
                ps.setInt(2,id);
                ps.executeUpdate();
            }
            catch (SQLException ex)
            {
                System.err.println(ex.getMessage());
            }
        }
    }

    //Update booth
    @ResponseBody
    @RequestMapping(value="/{exhibiitonId}/booths/{boothId}/update",method= RequestMethod.POST)
    public void updateBooth(@RequestBody BoothObject jason, @PathVariable int boothId) throws SQLException {
        int id = boothId;
        String name = jason.getName();
        String boothCode = jason.getBoothCode();
        String description = jason.getDescription();
        int exhibitionId = jason.getExhibitionId();
        String logoUrl = jason.getLogoUrl();
        String brochureUrl = jason.getBrochureUrl();

        String url = "jdbc:mysql://localhost:3306/bankza";
        Connection conn = DriverManager.getConnection(url,"root","password");
        if(name!=null){
            try
            {
                PreparedStatement ps = conn.prepareStatement(
                        "UPDATE booth SET name = ? WHERE id = ? ");
                ps.setString(1,name);
                ps.setInt(2,id);
                ps.executeUpdate();
            }
            catch (SQLException ex)
            {
                System.err.println(ex.getMessage());
            }
        }
        if(boothCode!=null){
            try
            {
                PreparedStatement ps = conn.prepareStatement(
                        "UPDATE booth SET booth_code = ? WHERE id = ? ");
                ps.setString(1,boothCode);
                ps.setInt(2,id);
                ps.executeUpdate();
            }
            catch (SQLException ex)
            {
                System.err.println(ex.getMessage());
            }
        }
        if(description!=null){
            try
            {
                PreparedStatement ps = conn.prepareStatement(
                        "UPDATE booth SET description = ? WHERE id = ? ");
                ps.setString(1,description);
                ps.setInt(2,id);
                ps.executeUpdate();
            }
            catch (SQLException ex)
            {
                System.err.println(ex.getMessage());
            }
        }
        if(exhibitionId!=0){
            try
            {
                PreparedStatement ps = conn.prepareStatement(
                        "UPDATE booth SET exhibition_id = ? WHERE id = ? ");
                ps.setInt(1,exhibitionId);
                ps.setInt(2,id);
                ps.executeUpdate();
            }
            catch (SQLException ex)
            {
                System.err.println(ex.getMessage());
            }
        }
        if(logoUrl!=null){
            try
            {
                PreparedStatement ps = conn.prepareStatement(
                        "UPDATE booth SET logo_url = ? WHERE id = ? ");
                ps.setString(1,logoUrl);
                ps.setInt(2,id);
                ps.executeUpdate();
            }
            catch (SQLException ex)
            {
                System.err.println(ex.getMessage());
            }
        }
        if(brochureUrl!=null){
            try
            {
                PreparedStatement ps = conn.prepareStatement(
                        "UPDATE booth SET brochure_url = ? WHERE id = ? ");
                ps.setString(1,brochureUrl);
                ps.setInt(2,id);
                ps.executeUpdate();
            }
            catch (SQLException ex)
            {
                System.err.println(ex.getMessage());
            }
        }
    }


    //Register with header for user
    @RequestMapping(value="/{exhibitionId}/register",method= RequestMethod.POST)
    public @ResponseBody
    void registerExhibition (@RequestHeader(value="token") String tokenValue,@PathVariable int exhibitionId) {

        int exhibition_id = exhibitionId;
        int user_id = 1; //userid

        String token = tokenValue;
        System.out.println(token);

        String  str = "INSERT INTO ticket (exhibition_id, user_id, start_date, end_date, holder_name, holder_role, is_expired, can_register)" +
                "VALUES ("+exhibition_id+","+user_id+", '2017-02-5', '2017-02-7', 'bankbank', 'visitor', 0, 0)";

        try {
            String url = "jdbc:mysql://localhost:3306/bankza";
            Connection conn = DriverManager.getConnection(url,"root","password");
            Statement stmt = conn.createStatement();

            stmt.executeUpdate(str);

            conn.close();
        }
        catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
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

    @RequestMapping(value = "/getUserId", method=RequestMethod.GET)
    public int getUserId(){
        int id = getUserIdna("138236010038864");

        return id;

    }

    //get user id
    public int getUserIdna(String userId){
        int id = 0;
        String check = userId;
        try {
            String url = "jdbc:mysql://localhost:3306/bankza";
            Connection conn = DriverManager.getConnection(url,"root","password");
            Statement stmt = conn.createStatement();
            ResultSet rs;


            rs = stmt.executeQuery("SELECT * FROM user ");
            while ( rs.next() ) {
                if(rs.getString("userId").equalsIgnoreCase(check)){
                    id = rs.getInt("id");
                }
            }
            conn.close();
        }
        catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return id;
    }


    //search exhibition by name
    @RequestMapping(value = "/search", method=RequestMethod.GET)
    public @ResponseBody List<Exhibition> search(@RequestParam("key") String text) throws SQLException {
        String search = text;
        List<Integer> listExId = new ArrayList<Integer>();
        List<Exhibition> listEx = new ArrayList<Exhibition>();

        String url = "jdbc:mysql://localhost:3306/bankza";
        Connection conn = DriverManager.getConnection(url,"root","password");
        Statement stmt = conn.createStatement();
        ResultSet rs;
        try {
            rs = stmt.executeQuery("SELECT * FROM exhibition ");
            while (rs.next()) {
                //if (search.equalsIgnoreCase(rs.getString("name"))) {
                if (rs.getString("name").toLowerCase().indexOf(search.toLowerCase())!=-1) {
                    System.out.println("1");
                    listExId.add(rs.getInt("id"));
                }
            }
            //conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        // i มันไม่ใช่
        for(int i = 0 ; i<listExId.size() ; i++){
            int exId = listExId.get(i);
            rs = stmt.executeQuery("SELECT * FROM exhibition WHERE id = "+exId+"");
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String location = rs.getString("location");
                String category = rs.getString("category");
                String startDate = rs.getString("start_date");
                String endDate = rs.getString("end_date");
                String posterUrl = rs.getString("poster_url");
                boolean isFavourited = rs.getBoolean("is_favourited");
                Double latitude = rs.getDouble("latitude");
                Double longtitude = rs.getDouble("longtitude");
                String agendaUrl = rs.getString("agenda_url");
                String mapUrl = rs.getString("map_url");
                boolean isPassed = rs.getBoolean("is_passed");

                Exhibition exhibition = new Exhibition(id, name, description, location, category, startDate, endDate, posterUrl, isFavourited, latitude
                        , longtitude, agendaUrl, mapUrl, isPassed);

                listEx.add(exhibition);
            }

        }

        return listEx;

    }
}









