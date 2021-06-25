package com.koreait.member.command;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

public class Encript {

	public static String sha256(String str) {
		// java : java.security
		// MessageDigest 사용하기
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(str.getBytes());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// md.digest() 암호화된 byte배열
		StringBuilder sb = new StringBuilder(); // String으로 변환
		for(byte b : md.digest()) {
			sb.append(String.format("%02x", b)); // 16진수 표기법으로 변환
		}
		return sb.toString();
		
	}
	
	public static String base64(String str) {
		// commons-codec
		// Base64 사용하기
		// Base64.encodeBase64(pw.getBytes() 암호화된 byte배열
		StringBuilder sb = new StringBuilder(); // String으로 변환
		for(byte b : Base64.encodeBase64(str.getBytes())) {
			sb.append(String.format("%02x", b)); // 16진수 표기법으로 변환
		}
		return sb.toString();
		
	}
	
}

