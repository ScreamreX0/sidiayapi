package com.example.sidiayapi.controllers.servicerequesttype;

import com.example.sidiayapi.entities.ServiceRequestType;
import com.example.sidiayapi.services.ServiceRequestTypeService;
import com.example.sidiayapi.utils.Logger;
import com.example.sidiayapi.utils.NetworkStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/service-request-type")
public class ServiceRequestTypeController implements IServiceRequestTypeController {
    @Autowired
    ServiceRequestTypeService serviceRequestTypeService;

    private final String logTitle = ServiceRequestTypeController.class.toString();

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
    public ResponseEntity<List<ServiceRequestType>> get(@RequestParam Map<String, Object> params) {
        try {
            return this.serviceRequestTypeService.get(Integer.parseInt(params.get("count").toString()));
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
    public ResponseEntity<List<ServiceRequestType>> get(@PathVariable int count) {
        return this.serviceRequestTypeService.get(count);
    }
}
