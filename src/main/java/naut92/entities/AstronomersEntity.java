package naut92.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class AstronomersEntity {
    @NonNull
    Integer id;
    @NonNull
    String astronomer_name;

    //@Select("SELECT * FROM stars WHERE astronomers_id = #{id}")
    List<StarsEntity> stars = new ArrayList<>();
}
