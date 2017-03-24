package com.twentyfourx.APIController;

import com.twentyfourx.Repository.ExhibitionRepository;
import com.twentyfourx.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Thanawat on 3/23/2017.
 */

@RestController
@Controller
@RequestMapping(path="/ticket") // This means URL's start with /demo (after Application path)
public class TicketController {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    ExhibitionRepository exhibitionRepository;

    /*@RequestMapping(value = "/addTicket", method = RequestMethod.POST)
    public @ResponseBody
    void addTicket (@RequestParam int id) {
        int exhibitionId = id;
        try {
            String url = "jdbc:mysql://localhost:3306/bankza";
            Connection conn = DriverManager.getConnection(url,"root","password");
            Statement stmt = conn.createStatement();
            String str = "INSERT INTO customer " +
                    "(id,Name,Email,CountryCode,Budget,Used) " +
                    "VALUES ('C005','Chai Surachai','chai.surachai@thaicreate.com'" +
                    ",'TH','1000000','0') ";

            stmt.executeUpdate("INSERT INTO ticket" + "VALUES (1, 1, '2017-12-12', '2017-12-17', 'Bankza', 'Visitor',0,0)");

            conn.close();
        }
        catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        //return ticket;
    }*/


}
