package in.zycon.demo.hawks.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ads {
    String title;
    String type;
    String description;
    String content;
    String imagelink;
    Integer height;
}
