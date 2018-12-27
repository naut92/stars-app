package naut92.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@Entity
public class StarsEntity {
    @NonNull
    Long id, astronomer_id;
    @NonNull
    String star_name, longitude, latitude, color;

    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "astronomer_id", referencedColumnName = "id", insertable = false, updatable = false)
    AstronomersEntity astronomersEntity;
}