package naut92.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class AstronomersEntity {
    @NonNull
    Integer id;
    @NonNull
    String astronomer_name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "astronomersEntity", cascade = CascadeType.ALL)
    Set<StarsEntity> stars = new HashSet<>();
}
