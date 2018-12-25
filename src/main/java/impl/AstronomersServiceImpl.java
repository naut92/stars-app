package impl;

import entities.AstronomersEntity;
import mappers.AstronomersEntityMapper;
import services.AstronomersService;
//import org.mybatis.spring.annotation.MapperScan;
import javax.annotation.ManagedBean;
import javax.inject.Inject;

import java.util.List;

//@MapperScan(basePackages = "com.github.naut92.starsappsb.mappers")
@ManagedBean
public class AstronomersServiceImpl implements AstronomersService {

    @Inject
    private AstronomersEntityMapper astronomersMapper;

    public AstronomersEntity getAstronomerByName(String astronomerName) {
        AstronomersEntity astronomer = astronomersMapper.getAstronomerByName(astronomerName);
        return astronomer;
    }

    public boolean insertAstronomer(AstronomersEntity astronomer) {
        return astronomersMapper.insertAstronomer(astronomer);
    }


    public boolean updateAstronomer(AstronomersEntity astronomer) {
        return astronomersMapper.updateAstronomer(astronomer);
    }

    public boolean deleteAstronomer(String astronomerName) {
        return false;
    }


    public boolean deleteAstronomer(Long astronomerId) {
        return astronomersMapper.deleteAstronomer(astronomerId);
    }


    public List<AstronomersEntity> getAstronomers() {
        List<AstronomersEntity> astronomers = astronomersMapper.getAstronomers();
        return astronomers;
    }
}