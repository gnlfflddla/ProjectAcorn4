package com.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.MemberDAO;
import com.dto.MemberDTO;

public class MemberService {

	public int memberAdd(MemberDTO dto) {
		SqlSession session=MySqlSessionFactory.getSession();
		int n=0;
		try {
			
			MemberDAO dao=new MemberDAO();
			n=dao.memberAdd(session, dto);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return n;
	}
	
	public MemberDTO login(HashMap<String, String> map) {
		
		SqlSession session=MySqlSessionFactory.getSession();
		MemberDTO dto=null;
		try {
			MemberDAO dao=new MemberDAO();
			dto=dao.login(session, map);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return dto;
	}
	
	public HashMap<String, String> idSearch(MemberDTO dto) {
		SqlSession session=MySqlSessionFactory.getSession();
		HashMap<String, String> map=null;
		try {
			MemberDAO dao=new MemberDAO();
			map=dao.idSearch(session, dto);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return map;
	}
	
	public int idCheck(String userid) {
		SqlSession session=MySqlSessionFactory.getSession();
		int count=0;
		try {
			MemberDAO dao=new MemberDAO();
			count=dao.idCheck(session, userid);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return count;
	
	}
	
	public int update(MemberDTO dto) {
		SqlSession session=MySqlSessionFactory.getSession();
		int n=0;
		try {
			MemberDAO dao=new MemberDAO();
			n=dao.update(session, dto);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return n;
	}
	
	public int withdrawal(HashMap<String, String> map) {
		SqlSession session=MySqlSessionFactory.getSession();
		int n=0;
		try {
			MemberDAO dao=new MemberDAO();
			n=dao.withdrawal(session, map);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return n;
	}
	
	public int pwSearch_phone(HashMap<String, String> map) {
		SqlSession session=MySqlSessionFactory.getSession();
		int n=0;
		try {
			MemberDAO dao=new MemberDAO();
			n=dao.pwSearch_phone(session, map);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return n;
	}
	
	public int pwSearch_email(HashMap<String, String> map) {
		SqlSession session=MySqlSessionFactory.getSession();
		int n=0;
		try {
			MemberDAO dao=new MemberDAO();
			n=dao.pwSearch_email(session, map);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return n;
	}
	
	public int passwdUpdate(HashMap<String, String> map2) {
		SqlSession session=MySqlSessionFactory.getSession();
		int n=0;
		try {
			MemberDAO dao=new MemberDAO();
			n=dao.passwdUpdate(session, map2);
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return n;
	}
}
