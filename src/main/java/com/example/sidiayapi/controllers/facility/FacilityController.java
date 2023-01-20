package com.example.sidiayapi.controllers.facility;

import com.example.sidiayapi.entities.Facilities;
import com.example.sidiayapi.services.FacilityService;
import com.example.sidiayapi.utils.Logger;
import com.example.sidiayapi.utils.NetworkStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/facility")
public class FacilityController implements IFacilityController {
    @Autowired
    FacilityService facilityService;

    private final String logTitle = FacilityController.class.toString();

    @Override
    @GetMapping
    public ResponseEntity<String> test() {
        try {
            return ResponseEntity.ok(null);
        } catch (Exception exception) {
            Logger.log(logTitle, exception.getStackTrace());
            return new ResponseEntity<>("", NetworkStates.BadRequest.getCode());
        }
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<List<Facilities>> get(@RequestParam Map<String, Object> params) {
        try {
            return this.facilityService.get(Integer.parseInt(params.get("count").toString()));
        } catch (NumberFormatException | NullPointerException exception) {
            Logger.log(logTitle, exception.getStackTrace());
            return new ResponseEntity<>(NetworkStates.Unauthorized.getCode());
        } catch (Exception exception) {
            Logger.log(logTitle, exception.getStackTrace());
            return new ResponseEntity<>(NetworkStates.BadRequest.getCode());
        }
    }

    @Override
    @GetMapping("/{count}")
    public ResponseEntity<List<Facilities>> get(@PathVariable int count) {
        return this.facilityService.get(count);
    }
}
