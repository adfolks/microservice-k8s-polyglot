package in.zycon.demo.news.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class News {
    Integer id;
    String name;
    String desc;

    public enum newsType {
        SPORTS, WORLD, TECHNOLOGY
    }

    Integer basePrice;
    newsType newsType;
}
