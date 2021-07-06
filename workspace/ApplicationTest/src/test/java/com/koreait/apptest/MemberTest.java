package com.koreait.apptest;



import static org.junit.Assert.assertEquals;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.koreait.apptest.config.BeanConfiguration;
import com.koreait.apptest.dao.MemberDAO;
import com.koreait.apptest.dto.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {BeanConfiguration.class})
public class MemberTest {

	// field
	@Autowired
	private SqlSession sqlSession; // DAO에 있는 값과 비교하려면 sqlSession에서 꺼내야 하기에 필드 선언 해준다
	
	@Test
	public void joinTest() { // 애너테이션과 메소드명은 같지 않아도 된다
		// MemberDAO에 join을 test하는 것이기 때문에
		// join할 때에 필요한 값을 직접 적어 DAO에 전달해 있는지 없는지 확인 후 가입 시킨다
		Member member = new Member();
		member.setId("test");
		member.setPw("1111");
		member.setName("테스트");
		member.setEmail("test@web.com");
		
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		int count = memberDAO.join(member); // 가입 성공: 1, 가입 실패: 0
		
		// assertEquals("message: 아닐 때 메시지", "기대한 값", "실제 값")
		assertEquals("가입 실패", 1, count);
		// 1과 count가 같으면 검사 통과
		// 1과 count가 다르면 검사 실패(가입 실패 메시지 출력)
		
		// 여기까지 상태로 junit test를 하면 NullPointerException 발생..
		// 위에서 new Member()로 생성했음에도(new는 무조건 생성) null이 발생했다
		// 즉, sqlSession에 값이 없다는 것이다
		
		// junit 테스트는 스프링을 모두 돌리지 않고 눈에 보이는 것만 돌린다(@AutoWired 했음에도 그렇다.. 동작 안 함)
		// oracle jdbc도 tomcat에 넣어 두면 동작하지 않는다
		
		// 현재 프로젝트에 포함되어 있어야만 테스트 진행한다(pom.xml에 추가해야 함)
		// spring-test 디펜던시를 추가한다(스프링 프레임워크와 버전 맞춰야 한다, 현재는 5.1.4버전)
		
		// spring-test 디펜던시가 지원하는 애너테이션 2개를 추가해야 한다!!
		// @RunWith(SpringJUnit4ClassRunner.class) : 이 테스트는 스프링을 함께 돌려달라
		// @ContextConfiguration(classes= {BeanConfiguration.class}) : Bean을 여기서 찾아달라

	}
	
	// 문제: 아이디 중복 점검 테스트(이미 가입이 되어있다는 가정 하에)
	// admin 아이디를 가진 아이디가 없으면 중복 체크 통과, 있으면 중복 체크 실패
	@Test
	public void idCheckTest() {
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		int count = memberDAO.idCheck("admin"); // DAO에 "admin" 아이디가 있는지 idCheck
		assertEquals("중복 체크 실패", 1, count);
	}
	
	

}

