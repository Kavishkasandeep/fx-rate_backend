package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MsgResponse {
    @JsonProperty("MESSAGE")
    private String MESSAGE;

    @JsonProperty("STATUS")
    private String STATUS;

    @JsonProperty("DATA")
    private Data data;

}
