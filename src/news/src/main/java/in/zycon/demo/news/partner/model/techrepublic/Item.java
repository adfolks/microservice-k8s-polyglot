package in.zycon.demo.news.partner.model.techrepublic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    String title;
    String description;
    String pubDate;
    String link;
}
