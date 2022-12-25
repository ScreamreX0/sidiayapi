package com.example.sidiayapi.controllers.servicerequestfacility;

import com.example.sidiayapi.entities.ServiceRequestFacility;
import com.example.sidiayapi.services.ServiceRequestFacilityService;
import com.example.sidiayapi.utils.Logger;
import com.example.sidiayapi.utils.NetworkStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/service-request-facility")
public class ServiceRequestFacilityController implements IServiceRequestFacilityController {
    @Autowired
    ServiceRequestFacilityService serviceRequestFacilityService;

    private final String logTitle = ServiceRequestFacilityController.class.toString();

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
    public ResponseEntity<List<ServiceRequestFacility>> get(@RequestParam Map<String, Object> params) {
        try {
            return this.serviceRequestFacilityService.get(Integer.parseInt(params.get("count").toString()));
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
    public ResponseEntity<List<ServiceRequestFacility>> get(@PathVariable int count) {
        return this.serviceRequestFacilityService.get(count);
    }
}
