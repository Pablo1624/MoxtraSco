package com.example.moxtra.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ScheduleRequestDTO {

    private String name;
    private String start_time;
    private String end_time;
    private String agenda;
    private String tags;
}
