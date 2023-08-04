package springbootdemo.springbootdemo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import springbootdemo.springbootdemo.service.DataService;

@Controller
public class RestController {

    @Autowired
    DataService dataService;

    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> getTeams() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(dataService.getTeams());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server Internal Error");
        }
    }

    @PutMapping(value = "/teams/{id}")
    public ResponseEntity<Object> updateTeam() {
        try {
            dataService.updateTeam();
            return ResponseEntity.status(HttpStatus.OK).body(dataService.getTeams());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server Internal Error");
        }
    }

    @DeleteMapping(value = "/teams/{id}")
    public ResponseEntity<Object> deleteTeam() {
        try {
            dataService.deleteTeam();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}