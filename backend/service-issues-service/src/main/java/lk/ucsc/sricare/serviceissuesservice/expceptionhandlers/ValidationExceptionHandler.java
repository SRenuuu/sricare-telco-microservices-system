package lk.ucsc.sricare.serviceissuesservice.expceptionhandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ValidationExceptionHandler {
    /*
     * Custom exception handler to handle invalid input
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> notValidInput(MethodArgumentNotValidException ex){
        Map<String, String> errorMap = ex.getAllErrors()
                .stream()
                .collect(Collectors.toMap(x -> ((FieldError)x).getField(),
                        b -> b.getDefaultMessage(), (p, q) -> p, LinkedHashMap::new));

        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }
}
