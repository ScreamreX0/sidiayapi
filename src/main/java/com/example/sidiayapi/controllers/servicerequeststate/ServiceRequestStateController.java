package com.example.sidiayapi.controllers.servicerequeststate;

import com.example.sidiayapi.entities.ServiceRequestState;
import com.example.sidiayapi.services.ServiceRequestStateService;
import com.example.sidiayapi.utils.Logger;
import com.example.sidiayapi.utils.NetworkStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/service-request-state")
public class ServiceRequestStateController implements IServiceRequestStateController {
    @Autowired
    ServiceRequestStateService serviceRequestStateService;

    private final String logTitle = ServiceRequestStateController.class.toString();

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
    public ResponseEntity<List<ServiceRequestState>> get(@RequestParam Map<String, Object> params) {
        try {
            return this.serviceRequestStateService.get(Integer.parseInt(params.get("count").toString()));
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
    public ResponseEntity<List<ServiceRequestState>> get(@PathVariable int count) {
        return this.serviceRequestStateService.get(count);
    }
}
