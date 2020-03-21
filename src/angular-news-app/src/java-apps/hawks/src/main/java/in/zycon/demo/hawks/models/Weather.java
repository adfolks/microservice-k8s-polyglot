package in.zycon.demo.hawks.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather {
    String code;
    String cityName;
    String countryName;
    String weatherMain;
    Double feelsLike;
    Double temp;
}
