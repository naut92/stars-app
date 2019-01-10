package naut92.mappers;

import naut92.entities.AstronomersEntity;
import naut92.util.MyBatisUtil;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AstronomersEntityMapper {
    //String SELECT_ALL = "SELECT * FROM astronomers";
    String SELECT_BY_ID = "SELECT * FROM astronomers WHERE id = #{id}";
    String SELECT_BY_NAME = "SELECT * FROM astronomers WHERE astronomer_name = #{astronomer_name}";
    String INSERT = "INSERT into astronomers(astronomer_name) VALUES(#{astronomer_name})";
    String UPDATE = "UPDATE astronomers SET astronomer_name = #{astronomer_name} WHERE id = #{id}";
    String UPDATE_NAME = "UPDATE astronomers SET astronomer_name = #{astronomer_name} WHERE id = #{id}";
    String DELETE = "DELETE FROM astronomers WHERE id = #{id}";

    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "astronomer_name", column = "astronomer_name")
    })

    /**
     * Returns the list of all Astronomers instances from the database.
     * @return the list of all Astronomers instances from the database.
     */
    @SelectProvider(type = MyBatisUtil.class, method="getAstronomers")
    List<AstronomersEntity> getAstronomers();

    /**
     * Returns a Astronomer instance from the database.
     * @param id primary key value used for lookup.
     * @return A AstronomersEntity instance with a primary key value equals to pk. null if there is no matching row.
     */
    /*@Select(SELECT_BY_ID)
    AstronomersEntity getById(Long id);*/

    /**
     * Returns a Astronom instance from the database.
     * @param astronomerName value used for lookup.
     * @return A AstronomersEntity instance with a primary key value equals to pk. null if there is no matching row.
     */
    @Select(SELECT_BY_NAME)
    AstronomersEntity getAstronomerByName(String astronomerName);

    /**
     * Insert an instance of AstronomersEntity into the database.
     * @param astronomer the instance to be persisted.
     * @return true if transaction successful.
     */
    @Insert(INSERT)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertAstronomer(AstronomersEntity astronomer);

    /**
     * Updates an instance of AstronomersEntity in the database.
     * @param astronomer the instance to be updated.
     * @return true if transaction successful.
     */
    @Update(UPDATE)
    void updateAstronomer(AstronomersEntity astronomer);

    /**
     * Updates an instance of AstronomersEntity in the database.
     * @param astronomerName name value to be updated.
     * @param id primary key value used for lookup.
     * @return true if transaction successful.
     */
    @Update(UPDATE_NAME)
    void updateAstronomerName(@Param("astronomer_name") String astronomerName, @Param("id") Long id);

    /**
     * Delete an instance of Astronomer from the database.
     * @param id primary key value of the instance to be deleted.
     * @return true if transaction successful.
     */
    //@Delete("DELETE FROM astronomers WHERE astronomer_name = #{astronomer_name}")
    @Delete(DELETE)
    void deleteAstronomer(Long id);
}
