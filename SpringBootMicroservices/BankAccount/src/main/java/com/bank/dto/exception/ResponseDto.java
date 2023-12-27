package com.bank.dto.exception;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    private Integer statusCode;
    private String responseMessage;
    private LocalDateTime timestamp;

}
