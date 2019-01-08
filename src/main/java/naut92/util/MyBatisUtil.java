package naut92.util;

import org.apache.ibatis.jdbc.SQL;

public class MyBatisUtil {
    public String getStarsWithAstronomerName(){
        return new SQL() {{
            SELECT("s.id, s.star_name, s.longitude, s.latitude, s.color, s.astronomer_id, a.astronomer_name");
            FROM("stars s");
            INNER_JOIN("astronomers a");
            WHERE("s.astronomer_id = a.id");
        }}.toString();
    }
}
