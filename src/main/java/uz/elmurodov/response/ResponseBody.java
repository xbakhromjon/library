package uz.elmurodov.response;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @param <B> Body
 */
@Setter
@Getter
public class ResponseBody<B> {
    private B body;
    private Integer count;


    public ResponseBody(B body) {
        this.body = body;
        this.count = 1;
    }

    public ResponseBody(B body, Integer count) {
        this.body = body;
        this.count = count;
    }
}
