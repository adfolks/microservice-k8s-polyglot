package in.zycon.demo.pa.exception;

public class NewsNotFound extends RuntimeException {

    public NewsNotFound(String message) {
        super(message);
    }
}
