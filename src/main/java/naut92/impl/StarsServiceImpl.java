package naut92.impl;


import naut92.entities.AstronomersEntity;
import naut92.entities.StarsEntity;
import naut92.mappers.AstronomersEntityMapper;
import naut92.mappers.StarsEntityMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class StarsServiceImpl implements StarsEntityMapper {

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession session;
    private StarsEntityMapper mapper;

    public StarsServiceImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }

    @Override
    public List<StarsEntity> getStars() {
        session = sqlSessionFactory.openSession();
        try {
            mapper = session.getMapper(StarsEntityMapper.class);
            return mapper.getStars();
        } finally {
            session.close();
        }
    }

    @Override
    public List<StarsEntity> getStarsByAstronomerId(Long astronomerId) {
        session = sqlSessionFactory.openSession();
        try {
            mapper = session.getMapper(StarsEntityMapper.class);
            return mapper.getStarsByAstronomerId(astronomerId);
        } finally {
            session.close();
        }
    }

    @Override
    public List<StarsEntity> getStarsWithAstronomerName() {
        session = sqlSessionFactory.openSession();
        try {
            mapper = session.getMapper(StarsEntityMapper.class);
            return mapper.getStarsWithAstronomerName();
        } finally {
            session.close();
        }
    }
/*
    @Override
    public AstronomersEntity getById(Long id) {
        session = sqlSessionFactory.openSession();
        try {
            mapper = session.getMapper(StarsEntityMapper.class);
            return mapper.getById(id);
        } finally {
            session.close();
        }
    }//*/

    @Override
    public StarsEntity getStarById(Long id) {
        session = sqlSessionFactory.openSession();
        try {
            mapper = session.getMapper(StarsEntityMapper.class);
            return mapper.getStarById(id);
        } finally {
            session.close();
        }
    }

    @Override
    public void insertStar(StarsEntity star) {
        session = sqlSessionFactory.openSession();
        try {
            mapper = session.getMapper(StarsEntityMapper.class);
            mapper.insertStar(star);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void updateStar(StarsEntity star) {
        session = sqlSessionFactory.openSession();
        try {
            mapper = session.getMapper(StarsEntityMapper.class);
            mapper.updateStar(star);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteStar(Long id) {
        session = sqlSessionFactory.openSession();
        try {
            mapper = session.getMapper(StarsEntityMapper.class);
            mapper.deleteStar(id);
            session.commit();
        } finally {
            session.close();
        }
    }
}