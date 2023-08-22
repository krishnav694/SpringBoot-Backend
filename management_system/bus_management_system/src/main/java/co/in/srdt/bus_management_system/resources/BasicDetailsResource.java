package co.in.srdt.bus_management_system.resources;

import co.in.srdt.bus_management_system.models.BasicDetailsModel;
import co.in.srdt.bus_management_system.services.BasicDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus")
public class BasicDetailsResource {

    @Autowired
    BasicDetailsService basicDetailsService;

    @PostMapping("/saveBasicDetails")
    public ResponseEntity saveBasicDetails(@RequestBody BasicDetailsModel basicDetailsModel) {
        System.out.println("basicDetailsModel=>"+basicDetailsModel);
        return basicDetailsService.saveBasicDetails(basicDetailsModel);
    }

    @GetMapping("/getAllBasicDetails")
    public List<BasicDetailsModel> getAllBasicDetails(){
        return basicDetailsService.getAllBasicDetails();
    }

    @GetMapping("/getBasicDetailsById/{id}")
    public BasicDetailsModel getBasicDetailsById(@PathVariable Long id){
        return basicDetailsService.getBasicDetailsById(id);
    }

    @DeleteMapping("/deleteBasicDetailsById/{id}")
    public ResponseEntity deleteBasicDetailsById(@PathVariable Long id){
        return basicDetailsService.deleteBasicDetailsById(id);
    }
}
