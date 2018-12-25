package naut92.impl;

import naut92.entities.StarsEntity;
import naut92.mappers.StarsEntityMapper;

import javax.annotation.ManagedBean;
import java.util.List;

@ManagedBean
public class StarsServiceImpl implements StarsEntityMapper {


    @Override
    public List<StarsEntity> getStars() {
        return null;
    }

    @Override
    public List<StarsEntity> getStarsByAstronomerId(Long astronomerId) {
        return null;
    }

    @Override
    public StarsEntity getStarById(Long id) {
        return null;
    }

    @Override
    public boolean insertStar(StarsEntity star) {
        return false;
    }

    @Override
    public boolean updateStar(StarsEntity star) {
        return false;
    }

    @Override
    public boolean deleteStar(Long id) {
        return false;
    }
}