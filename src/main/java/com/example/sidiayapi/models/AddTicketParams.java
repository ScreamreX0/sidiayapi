package com.example.sidiayapi.models;

import com.example.sidiayapi.entities.Facilities;
import com.example.sidiayapi.entities.TicketKinds;
import com.example.sidiayapi.entities.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class AddTicketParams {
//    private List<Facilities> facilities;
//    private Users author;
    //    private Users executor;
    @Builder.Default
    private Long priority = 1L;
    @Builder.Default
    private TicketKinds kind = new TicketKinds(1L, "");
    @Builder.Default
    private String plane_date = "";
    @Builder.Default
    private String expiration_date = "";
    @Builder.Default
    private String creation_date = "";
    @Builder.Default
    private String completed_work = "";
    @Builder.Default
    private String description = "";
    @Builder.Default
    private String name = "";
    @Builder.Default
    private String status = "";
    @Builder.Default
    private String service = "";
}