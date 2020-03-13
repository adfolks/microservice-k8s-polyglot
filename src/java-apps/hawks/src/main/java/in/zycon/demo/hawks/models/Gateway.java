package in.zycon.demo.hawks.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gateway {
    Set<News> news;
    Weather weather;
    Set<Ads>ads;
}
