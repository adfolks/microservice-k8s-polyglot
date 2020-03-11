package in.zycon.demo.hawks.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class News {

    Integer id;

    String title;

    String desc;

    String imageUrl;

    String url;

    String pubDate;

    public enum newsType {
        SPORTS, WORLD, TECHNOLOGY
    }

    newsType newsType;
}
