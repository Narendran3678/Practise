package com.bank.dto.exception;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseDto {
    private Integer errorCode;
    private String apiPath;
    private String errorMessage;
    private LocalDateTime timestamp;
}
