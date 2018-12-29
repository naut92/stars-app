package naut92.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class StarsEntity {
    @NonNull
    Long id, astronomer_id;
    @NonNull
    String star_name, longitude, latitude, color;

    AstronomersEntity astronomersEntity;
}