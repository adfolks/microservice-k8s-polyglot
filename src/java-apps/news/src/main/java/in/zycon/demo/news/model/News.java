package in.zycon.demo.news.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class News {
    @ApiModelProperty(notes = "Unique News Reference Id")
    Integer id;
    @ApiModelProperty(notes = "News Title")
    String title;
    @ApiModelProperty(notes = "News Description")
    String desc;
    @ApiModelProperty(notes = "Image resource url")
    String imageUrl;
    @ApiModelProperty(notes = "News Link")
    String url;
    @ApiModelProperty(notes = "Publication Date")
    String pubDate;

    public enum newsType {
        SPORTS, WORLD, TECHNOLOGY
    }
    @ApiModelProperty(notes = "News Category")
    newsType newsType;
}
