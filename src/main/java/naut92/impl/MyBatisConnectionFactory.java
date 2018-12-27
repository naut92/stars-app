package naut92.impl;

import naut92.mappers.AstronomersEntityMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * MyBatis Connection Factory, which reads the configuration data from a XML file.
 * 
 * @author naut
 *
 */
public class MyBatisConnectionFactory {
	private static SqlSessionFactory sqlSessionFactory;

	static {
		try {
			String resource = System.getProperty("user.dir") + "/src/main/resources/mybatis-config.xml";

			Reader reader = new FileReader(resource);
			if (sqlSessionFactory == null) {
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

				sqlSessionFactory.getConfiguration().addMapper(AstronomersEntityMapper.class);
				//sqlSessionFactory.getConfiguration().addMapper(StarsEntityMapper.class);
			}
		} catch (IOException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		}
	}

	static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
