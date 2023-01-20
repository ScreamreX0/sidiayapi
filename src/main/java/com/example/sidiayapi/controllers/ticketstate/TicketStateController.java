package com.example.sidiayapi.controllers.ticketstate;

import com.example.sidiayapi.entities.TicketStates;
import com.example.sidiayapi.services.TicketStateService;
import com.example.sidiayapi.utils.Logger;
import com.example.sidiayapi.utils.NetworkStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ticket-state")
public class TicketStateController implements ITicketStateController {
    @Autowired
    TicketStateService ticketStateService;

    private final String logTitle = TicketStateController.class.toString();

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
    public ResponseEntity<List<TicketStates>> get(@RequestParam Map<String, Object> params) {
        try {
            return this.ticketStateService.get(Integer.parseInt(params.get("count").toString()));
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
    public ResponseEntity<List<TicketStates>> get(@PathVariable int count) {
        return this.ticketStateService.get(count);
    }
}
