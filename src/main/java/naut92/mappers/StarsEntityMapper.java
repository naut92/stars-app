package naut92.mappers;

import naut92.entities.StarsEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StarsEntityMapper {

    String GET_ALL_STARS = "SELECT * FROM stars";
    String GET_ALL_STARS_BY_ASTRONOMER_ID = "SELECT * FROM stars INNER JOIN astronomers ON astronomers.id = stars.astronomer_id";
    String GET_STAR_BY_ID = "SELECT * FROM stars WHERE id = #{id}";
    String INSERT_STAR = "INSERT into stars(star_name, longitude, latitude, color, astronomer_id) VALUES(#{star_name}, #{longitude}, #{latitude}, #{color}, #{astronomer_id})";
    String UPDATE_STAR = "UPDATE stars SET star_name=#{star_name}, longitude=#{longitude}, latitude=#{latitude}, color=#{color}, astronomer_id=#{astronomer_id} WHERE id = #{id}";
    String DELETE_STAR = "DELETE FROM stars WHERE id = #{id}";

    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "star_name", column = "star_name"),
            @Result(property = "longitude", column = "longitude"),
            @Result(property = "latitude", column = "latitude"),
            @Result(property = "color", column = "color"),
            @Result(property = "astronomer_id", column = "astronomer_id")
    })

    /**
     * Returns the list of all Stars instances from the database.
     * @return the list of all StarsEntity instances from the database.
     */
    @Select(GET_ALL_STARS)
    List <StarsEntity> getStars();

    /**
     * Returns a Stars instance from the database by astronomerId.
     * @param astronomerId foreign key value used for lookup.
     * @return A StarsEntity instance with a foreign key value equals to fk. null if there is no matching row.
     */
    @Select(GET_ALL_STARS_BY_ASTRONOMER_ID)
    List <StarsEntity> getStarsByAstronomerId(Long astronomerId);

    /**
     * Returns a Star instance from the database.
     * @param id primary key value used for lookup.
     * @return A StarsEntity instance with a primary key value equals to pk. null if there is no matching row.
     */
    @Select(GET_STAR_BY_ID)
    StarsEntity getStarById(Long id);

    /**
     * Insert an instance of StarsEntity into the database.
     * @param star the instance to be persisted.
     * @return true if transaction successful.
     */
    @Insert(INSERT_STAR)
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn="id")
    boolean insertStar(StarsEntity star);

    /**
     * Updates an instance of StarsEntity in the database.
     * @param star the instance to be updated.
     * @return true if transaction successful.
     */
    @Update(UPDATE_STAR)
    boolean updateStar(StarsEntity star);

    /**
     * Delete an instance of Star from the database.
     * @param id primary key value of the instance to be deleted.
     * @return true if transaction successful.
     */
    @Delete(DELETE_STAR)
    boolean deleteStar(Long id);
}