package com.koreait.myproject.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.koreait.myproject.command.imgBoard.InsertImgBoardCommand;
import com.koreait.myproject.command.imgBoard.SelectImgBoardListCommand;
import com.koreait.myproject.command.member.DeleteMemberCommand;
import com.koreait.myproject.command.member.EmailAuthCommand;
import com.koreait.myproject.command.member.EmailCheckCommand;
import com.koreait.myproject.command.member.FindIdCommand;
import com.koreait.myproject.command.member.FindPwCommand;
import com.koreait.myproject.command.member.IdCheckCommand;
import com.koreait.myproject.command.member.JoinCommand;
import com.koreait.myproject.command.member.LoginCommand;
import com.koreait.myproject.command.member.LogoutCommand;
import com.koreait.myproject.command.member.PresentPwCheckCommand;
import com.koreait.myproject.command.member.UpdateMemberCommand;
import com.koreait.myproject.command.member.UpdatePwCommand;
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
		sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/koreait/myproject/dao/*.xml"));
		return sqlSessionFactory.getObject();
	}
	/* SqlSession */
	@Bean
	public SqlSessionTemplate sqlSession() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}
	/* CommonsMultipartResolver(첨부파일 사용 시) */
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setDefaultEncoding("utf-8");
		multipartResolver.setMaxUploadSize(1024 * 1024 * 10); // Byte 단위(10MB)
		return multipartResolver;
	}
	// 회원(member)
	@Bean
	public LoginCommand loginCommand() {
		return new LoginCommand();
	}
	@Bean
	public LogoutCommand logoutCommand() {
		return new LogoutCommand();
	}
	@Bean
	public IdCheckCommand idCheckCommand() {
		return new IdCheckCommand();
	}
	@Bean
	public EmailCheckCommand EmailCheckCommand() {
		return new EmailCheckCommand();
	}
	@Bean
	public EmailAuthCommand emailAuthCommand() {
		return new EmailAuthCommand();
	}
	@Bean
	public JoinCommand joinCommand() {
		return new JoinCommand();
	}
	@Bean
	public PresentPwCheckCommand PresentPwCheckCommand() {
		return new PresentPwCheckCommand();
	}
	@Bean
	public UpdatePwCommand updatePwCommand() {
		return new UpdatePwCommand();
	}
	@Bean
	public UpdateMemberCommand updateMemberCommand() {
		return new UpdateMemberCommand();
	}
	@Bean
	public DeleteMemberCommand deleteMemberCommand() {
		return new DeleteMemberCommand();
	}
	@Bean
	public FindIdCommand findIdCommand() {
		return new FindIdCommand();
	}
	@Bean
	public FindPwCommand findPwCommand() {
		return new FindPwCommand();
	}
	
	// 이미지 게시판(imgBoard)
	@Bean
	public SelectImgBoardListCommand selectImgBoardListCommand() {
		return new SelectImgBoardListCommand();
	}
	@Bean
	public InsertImgBoardCommand insertImgBoardCommand() {
		return new InsertImgBoardCommand();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

