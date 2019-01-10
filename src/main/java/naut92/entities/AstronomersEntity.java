package naut92.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class AstronomersEntity {
    @NonNull
    Integer id;
    @NonNull
    String astronomer_name;

    List<StarsEntity> stars = new ArrayList<>();
}
