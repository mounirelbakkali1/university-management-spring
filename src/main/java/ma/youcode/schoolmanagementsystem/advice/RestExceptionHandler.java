package ma.youcode.schoolmanagementsystem.advice;


import ma.youcode.schoolmanagementsystem.utils.HttpResponse;
import ma.youcode.schoolmanagementsystem.utils.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {


    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<HttpResponse> handleNotFoundException(NotFoundException exception) {
        HttpResponse response = new HttpResponse(exception.getMessage(), 404);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}
