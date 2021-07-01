package com.koreait.integration;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class BoardTest {

	@Test
	public void test() {
		
		// 제목에 '공지'가 포함된 게시글 검색하는 테스트
		
		// 다음 주소를 이용해서 테스트를 수행하시오(context-path/mapping값)
		// 검색되지 않는 경우 message를 출력하시오
		try {
			String query = URLEncoder.encode("공지", "utf-8"); // 인코딩
			String apiURL = "http://localhost:9090/integration/selectQuery.do?column=TITLE&query=" + query;
			URL url = new URL(apiURL); // url 접속
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream())); // apiURL의 실행결과를 읽어들인다
			String resultMap = ""; // byte기반이라 문자열 처리한다
			String line = null;
			while((line = br.readLine()) != null) {
				resultMap += line;
			}
			// System.out.println(resultMap);
			
			// 위 결과를 
			// JSON 문자열 -> JSONObject : org.json JSON은 문자열로 받아서 바로 처리한다(string source)
			JSONObject obj = new JSONObject(resultMap);
			
			// 1. list
			JSONArray arr = obj.getJSONArray("list");
			for(int i=0; i<arr.length(); i++) {
				JSONObject board = (JSONObject)arr.get(i);
				System.out.println("번호: " + board.getInt("no"));
				System.out.println("제목: " + board.getString("title"));
				System.out.println("내용: " + board.getString("content"));
				System.out.println("작성자: " + board.getString("writer"));
				System.out.println("작성일: " + new Date((long)board.get("postdate")));
			}
			
			// 2. message
			String message = obj.getString("message");
			System.out.println("메시지: " + message);
			
			// 3. status
			int status = obj.getInt("status");
			System.out.println("상태: " + status);
			
			br.close();
			con.disconnect();
			
		} catch (UnsupportedEncodingException e) { // 인코딩 예외처리
			e.printStackTrace();
		} catch (MalformedURLException e) { // url 예외처리
			e.printStackTrace();
		} catch (IOException e) { // connection 예외처리
			e.printStackTrace();
		}
		
	}

	
}
