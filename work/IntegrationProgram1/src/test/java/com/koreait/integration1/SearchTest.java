package com.koreait.integration1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class SearchTest {

	@Test
	public void test() {
				// 제목에 '영화'가 포함된 게시글 검색하는 테스트
				try {
					String query = URLEncoder.encode("영화", "utf-8"); // 인코딩
					String apiURL = "http://localhost:9090/integration1/selectQuery.do?column=TITLE&query=" + query;
					URL url = new URL(apiURL); // url 접속
					HttpURLConnection con = (HttpURLConnection)url.openConnection();
					BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream())); 
					String resultMap = ""; // byte기반이라 문자열 처리한다
					String line = null;
					while((line = br.readLine()) != null) {
						resultMap += line;
					}
					System.out.println(resultMap);
					
					// 위 결과를 
					// JSON 문자열 -> JSONObject : org.json JSON은 문자열로 받아서 바로 처리한다(string source)
					JSONObject obj = new JSONObject(resultMap);
					
					// 1. list
					JSONArray arr = obj.getJSONArray("list");
					for(int i=0; i<arr.length(); i++) {
						JSONObject searchBoard = (JSONObject)arr.get(i);
						System.out.println("번호: " + searchBoard.getLong("no"));
						System.out.println("제목: " + searchBoard.getString("title"));
						System.out.println("내용: " + searchBoard.getString("content"));
						System.out.println("작성일: " + new Date((long)searchBoard.get("regdate")));
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

