package entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class AstronomersEntity {
    @NonNull
    Integer id;
    @NonNull
    String astronomer_name;

    //OneToMany
    Set<StarsEntity> stars = new HashSet<StarsEntity>();
}
