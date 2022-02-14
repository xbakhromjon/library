package uz.elmurodov.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@NoArgsConstructor
public class ResponseEntity<D> {
    private HttpStatus status;
    private ResponseBody<D> body;


    public ResponseEntity(ResponseBody<D> body) {
        this.body = body;
        this.status = HttpStatus.OK;
    }

    public ResponseEntity(HttpStatus status, ResponseBody<D> body) {
        this.status = status;
        this.body = body;
    }
}
