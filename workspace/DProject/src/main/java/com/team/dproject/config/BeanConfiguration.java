package com.team.dproject.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.team.dproject.command.JoinCommand;
import com.team.dproject.command.LoginCommand;
import com.team.dproject.command.MidCheckCommand;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class BeanConfiguration {
	/* DBCP 처리하는 dataSource */
	@Bean
	public HikariConfig hikariConfig() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("oracle.jdbc.OracleDriver");
		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		hikariConfig.setUsername("soonjo");
		hikariConfig.setPassword("1111");
		return hikariConfig;
	}
	/* HiKari(DBCP) */
	@Bean
	public HikariDataSource hikariDataSource() {
		return new HikariDataSource(hikariConfig());
	}
	/* SqlSessionFactory */
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(hikariDataSource());
		sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/team/dproject/dao/*.xml"));
		return sqlSessionFactory.getObject();
	}
	/* SqlSession */
	@Bean
	public SqlSessionTemplate sqlSession() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}
	
	@Bean
	public LoginCommand loginCommand() {
		return new LoginCommand();
	}
	@Bean
	public MidCheckCommand MidCheckCommand() {
		return new MidCheckCommand();
	}
	@Bean
	public JoinCommand joinCommand() {
		return new JoinCommand();
	}
	
	
	
	
	
	
	
}

