package com.example.sidiayapi.controllers.ticketfacility;

import com.example.sidiayapi.entities.TicketsFacilities;
import com.example.sidiayapi.services.TicketFacilityService;
import com.example.sidiayapi.utils.Logger;
import com.example.sidiayapi.utils.NetworkStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ticket-facility")
public class TicketFacilityController implements ITicketFacilityController {
    @Autowired
    TicketFacilityService ticketFacilityService;

    private final String logTitle = TicketFacilityController.class.toString();

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
    public ResponseEntity<List<TicketsFacilities>> get(@RequestParam Map<String, Object> params) {
        try {
            return this.ticketFacilityService.get(Integer.parseInt(params.get("count").toString()));
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
    public ResponseEntity<List<TicketsFacilities>> get(@PathVariable int count) {
        return this.ticketFacilityService.get(count);
    }
}
