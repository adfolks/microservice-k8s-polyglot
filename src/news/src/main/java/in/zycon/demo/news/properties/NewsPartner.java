package in.zycon.demo.news.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsPartner {
    Integer id;
    String name;
    String url;
    String type;
    Boolean enabled;

}
