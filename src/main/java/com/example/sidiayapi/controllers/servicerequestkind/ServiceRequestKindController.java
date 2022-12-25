package com.example.sidiayapi.controllers.servicerequestkind;

import com.example.sidiayapi.entities.ServiceRequestKind;
import com.example.sidiayapi.services.ServiceRequestKindService;
import com.example.sidiayapi.utils.Logger;
import com.example.sidiayapi.utils.NetworkStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/service-request-kind")
public class ServiceRequestKindController implements IServiceRequestKindController {
    @Autowired
    ServiceRequestKindService serviceRequestKindService;

    private final String logTitle = ServiceRequestKindController.class.toString();

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
    public ResponseEntity<List<ServiceRequestKind>> get(@RequestParam Map<String, Object> params) {
        try {
            return this.serviceRequestKindService.get(Integer.parseInt(params.get("count").toString()));
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
    public ResponseEntity<List<ServiceRequestKind>> get(@PathVariable int count) {
        return this.serviceRequestKindService.get(count);
    }
}
