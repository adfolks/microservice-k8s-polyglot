package in.zycon.demo.news.exception;

public class NewsNotFound extends RuntimeException {

    public NewsNotFound(String message) {
        super(message);
    }
}
