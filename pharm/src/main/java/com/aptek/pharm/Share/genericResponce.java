package com.aptek.pharm.Share;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class genericResponce {
    private String message;

    public genericResponce() {
    }

    public genericResponce(String message) {
        this.message = message;
    }


}
