package com.example.moxtra.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ScheduleResponseDTO {

    private String code;

    private ScheduleDataDTO data;
}
