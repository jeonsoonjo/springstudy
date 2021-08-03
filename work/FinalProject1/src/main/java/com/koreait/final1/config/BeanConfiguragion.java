package com.koreait.final1.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.koreait.final1.command.DeleteBoardCommand;
import com.koreait.final1.command.InsertBoardCommand;
import com.koreait.final1.command.SelectBoardListCommand;
import com.koreait.final1.command.SelectBoardViewCommand;
import com.koreait.final1.command.UpdateBoardCommand;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class BeanConfiguragion {

	@Bean
	public HikariConfig hikariConfig() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("oracle.jdbc.OracleDriver");
		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		hikariConfig.setUsername("spring");
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
		sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/koreait/final1/dao/*.xml"));
		return sqlSessionFactory.getObject();
	}
	/* SqlSession */
	@Bean
	public SqlSessionTemplate sqlSession() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}
	
	@Bean
	public SelectBoardListCommand selectBoardListCommand() {
		return new SelectBoardListCommand();
	}
	@Bean
	public SelectBoardViewCommand selectBoardViewCommand() {
		return new SelectBoardViewCommand();
	}
	@Bean
	public InsertBoardCommand insertBoardCommand() {
		return new InsertBoardCommand();
	}
	@Bean
	public UpdateBoardCommand updateBoardCommand() {
		return new UpdateBoardCommand();
	}
	@Bean
	public DeleteBoardCommand deleteBoardCommand() {
		return new DeleteBoardCommand();
	}
	
}
