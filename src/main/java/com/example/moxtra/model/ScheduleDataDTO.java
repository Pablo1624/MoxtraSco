package com.example.moxtra.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ScheduleDataDTO {

    private String schedule_binder_id;
    private String binder_name;
    private Long created_time;
    private Long updated_time;
    private String revision;
    private String session_key;
    private String startmeet_url;
    private String scheduled_starts;
    private String scheduled_ends;
    private String password_protected;
    private String password;
    private String auto_recording;
    private List<DialinNumberDTO> dialin_numbers;

}
