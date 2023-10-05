package com.example.telcosystemservice.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AnyResponse {
    private String message;

    private Object data;
}
