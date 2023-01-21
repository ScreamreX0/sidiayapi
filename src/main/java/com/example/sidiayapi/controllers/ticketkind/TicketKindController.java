package com.example.sidiayapi.controllers.ticketkind;

import com.example.sidiayapi.entities.TicketKinds;
import com.example.sidiayapi.services.TicketsKindsService;
import com.example.sidiayapi.utils.Logger;
import com.example.sidiayapi.utils.NetworkStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/tickets-kinds")
public class TicketKindController implements ITicketKindController {
    @Autowired
    TicketsKindsService ticketsKindsService;

    private final String logTitle = TicketKindController.class.toString();

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
    public ResponseEntity<List<TicketKinds>> get(@RequestParam Map<String, Object> params) {
        try {
            return this.ticketsKindsService.get(Integer.parseInt(params.get("count").toString()));
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
    public ResponseEntity<List<TicketKinds>> get(@PathVariable int count) {
        return this.ticketsKindsService.get(count);
    }
}
