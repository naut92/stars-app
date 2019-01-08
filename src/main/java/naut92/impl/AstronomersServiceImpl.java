package naut92.impl;

import naut92.entities.AstronomersEntity;
import naut92.mappers.AstronomersEntityMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class AstronomersServiceImpl implements AstronomersEntityMapper {

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession session;
    private AstronomersEntityMapper mapper;

    public AstronomersServiceImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }

    public List<AstronomersEntity> getAstronomers() {
        session = sqlSessionFactory.openSession();
        try {
            mapper = session.getMapper(AstronomersEntityMapper.class);
            return mapper.getAstronomers();
        } finally {
            session.close();
        }
    }

    /*public AstronomersEntity getById(Long id) {
        session = sqlSessionFactory.openSession();
        try {
            mapper = session.getMapper(AstronomersEntityMapper.class);
            return mapper.getById(id);
        } finally {
            session.close();
        }
    }*/

    public AstronomersEntity getAstronomerByName(String astronomerName) {
        session = sqlSessionFactory.openSession();
        try {
            AstronomersEntityMapper mapper = session.getMapper(AstronomersEntityMapper.class);
            return mapper.getAstronomerByName(astronomerName);
        } finally {
            session.close();
        }
    }

    public void insertAstronomer(AstronomersEntity astronomer) {
        session = sqlSessionFactory.openSession();
        try {
            mapper = session.getMapper(AstronomersEntityMapper.class);
            mapper.insertAstronomer(astronomer);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void updateAstronomer(AstronomersEntity astronomer) {
        session = sqlSessionFactory.openSession();
        try {
            mapper = session.getMapper(AstronomersEntityMapper.class);
            mapper.updateAstronomer(astronomer);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void updateAstronomerName(String astronomerName, Long id) {
        session = sqlSessionFactory.openSession();
        try {
            mapper = session.getMapper(AstronomersEntityMapper.class);
            mapper.updateAstronomerName(astronomerName, id);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void deleteAstronomer(Long id) {
        session = sqlSessionFactory.openSession();
        try {
            mapper = session.getMapper(AstronomersEntityMapper.class);
            mapper.deleteAstronomer(id);
            session.commit();
        } finally {
            session.close();
        }
    }
}