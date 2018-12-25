package services;

import entities.StarsEntity;

import java.util.List;

public interface StarsService {
    StarsEntity getStarById(Long id);
    boolean insertStar(StarsEntity star);
    boolean updateStar(StarsEntity star);
    boolean deleteStar(Long id);
    List<StarsEntity> getStars();
    List <StarsEntity> getStarsByAstronomerId(Long astronomerId);
}