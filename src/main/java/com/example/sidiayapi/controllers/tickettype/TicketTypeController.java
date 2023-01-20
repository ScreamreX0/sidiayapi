package com.example.sidiayapi.controllers.tickettype;

import com.example.sidiayapi.entities.TicketTypes;
import com.example.sidiayapi.services.TicketTypeService;
import com.example.sidiayapi.utils.Logger;
import com.example.sidiayapi.utils.NetworkStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ticket-type")
public class TicketTypeController implements ITicketTypeController {
    @Autowired
    TicketTypeService ticketTypeService;

    private final String logTitle = TicketTypeController.class.toString();

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
    public ResponseEntity<List<TicketTypes>> get(@RequestParam Map<String, Object> params) {
        try {
            return this.ticketTypeService.get(Integer.parseInt(params.get("count").toString()));
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
    public ResponseEntity<List<TicketTypes>> get(@PathVariable int count) {
        return this.ticketTypeService.get(count);
    }
}
