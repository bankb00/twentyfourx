package com.twentyfourx.APIController;

/**
 * Created by Thanawat on 3/11/2017.
 */

import com.twentyfourx.Entity.Booth;
import com.twentyfourx.Entity.Exhibition;
import com.twentyfourx.Repository.BoothContactRepository;
import com.twentyfourx.Repository.BoothRepository;
import com.twentyfourx.Repository.ExhibitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Test
@Controller    // This means that this class is a Controller
@RequestMapping(path="/exhibition") // This means URL's start with /demo (after Application path)
public class ExhibitionController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private ExhibitionRepository exhibitionRepository;
    @Autowired
    private BoothRepository boothRepository;
    @Autowired
    private BoothContactRepository boothContactRepository;



    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody String addExhibition (@RequestParam String name) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Exhibition exhibition = new Exhibition();
        exhibition.setExhibitionName(name);
        exhibitionRepository.save(exhibition);

        return "Saved";
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

    //get booths
    @RequestMapping(value="/{exhibitionId}/booths",method= RequestMethod.GET)
    public @ResponseBody List<Booth> getAllBooths(@PathVariable int exhibitionId){
        // This returns a JSON or XML with the users
        return boothRepository.findBoothByExhibitionId(exhibitionId);


    }

}









//import com.twentyfourx.Entity.Exhibition;
//import com.twentyfourx.Repository.ExhibitionRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Isolation;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.*;
//@RestController
//@RequestMapping("/api")
//@Transactional(readOnly = false, rollbackFor = Exception.class,
//        isolation = Isolation.READ_COMMITTED)
//public class ExhibitionController {
//    private ExhibitionRepository exhibitionRepository;
//    @Autowired
//    public ExhibitionController(ExhibitionRepository exhibitionRepository) {
//        this.exhibitionRepository = exhibitionRepository;
//    }
//    @RequestMapping(value = "", method = RequestMethod.POST)
//    public int addExhibition(@RequestBody Exhibition exhibition) {
//        exhibitionRepository.add(exhibition);
//        return exhibition.getExhibitionId();
//    }
///*    @RequestMapping(value = "", method = RequestMethod.GET)
//    public List<Patient> getAllPatients() {
//        return patientRepository.getAll();
//    }*/
//
//    /*@RequestMapping(value = "/{exhibitionId}", method = RequestMethod.GET)
//    public Exhibition getExhibition(@PathVariable int exhibitionId) {
//        return exhibitionRepository.get(exhibitionId);
//    }*/
//    @RequestMapping(value = "/1", method = RequestMethod.GET)
//    public Exhibition getExhibition() {
//        return exhibitionRepository.get(1);
//    }
//
//    /*@RequestMapping(value = "/get", method = RequestMethod.GET)
//    public int getExhibition() {
//        return 123;
//    }*/
//
//    @RequestMapping(value = "/{exhibitionId}", method = RequestMethod.PUT)
//    public void updateExhibition(@PathVariable int exhibitionId,
//                              @RequestBody Exhibition exhibitionRequest) {
//        Exhibition exhibition = exhibitionRepository.get(exhibitionId);
//        exhibition.setExhibitionName(exhibitionRequest.getExhibitionName());
//    }
//    @RequestMapping(value = "/{exhibitionId}", method = RequestMethod.DELETE)
//    public void removeExhibition(@PathVariable int exhibitionId) {
//        Exhibition exhibition = exhibitionRepository.get(exhibitionId);
//        exhibitionRepository.remove(exhibition);
//    }
//}