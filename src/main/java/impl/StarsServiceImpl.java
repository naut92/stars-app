package impl;

import entities.StarsEntity;
import mappers.StarsEntityMapper;
import services.StarsService;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
public class StarsServiceImpl implements StarsService {

    @Inject
    private StarsEntityMapper starsMapper;

    public StarsEntity getStarById(Long id) {
        return starsMapper.getStarById(id);
    }

    public boolean insertStar(StarsEntity star) {
        return starsMapper.insertStar(star);
    }


    public boolean updateStar(StarsEntity star) {
        return starsMapper.updateStar(star);
    }


    public boolean deleteStar(Long id) {
        return starsMapper.deleteStar(id);
    }


    public List<StarsEntity> getStars() {
        List<StarsEntity> stars = starsMapper.getStars();
        return stars;
    }


    public List<StarsEntity> getStarsByAstronomerId(Long astronomerId) {
        List<StarsEntity> stars = starsMapper.getStarsByAstronomerId(astronomerId);
        return stars;
    }
}