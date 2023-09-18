package ma.youcode.schoolmanagementsystem.utils;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class HttpResponse {
    private final String message;
    private final int status;

}
