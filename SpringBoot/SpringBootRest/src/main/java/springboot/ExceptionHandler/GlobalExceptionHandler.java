package springboot.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.sql.Timestamp;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<GenErrorResponse> handleEmpleNotFoundException(Exception exception) {
        System.out.println("Global Exception Handler");
        GenErrorResponse response = new GenErrorResponse(500,exception.getMessage(), new Timestamp(System.currentTimeMillis()));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
