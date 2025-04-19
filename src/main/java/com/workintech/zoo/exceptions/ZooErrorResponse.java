package com.workintech.zoo.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZooErrorResponse {
    private Integer status;
    private String message;
    private Long timestamp;

    public ZooErrorResponse(int value, int value1, String message, long l) {
    }
}
