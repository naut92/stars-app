package services;

import entities.AstronomersEntity;

import java.util.List;

public interface AstronomersService {
    AstronomersEntity getAstronomerByName(String astronomerName);
    boolean insertAstronomer(AstronomersEntity astronomer);
    boolean updateAstronomer(AstronomersEntity astronomer);
    boolean deleteAstronomer(String astronomerId);
    List<AstronomersEntity> getAstronomers();
}