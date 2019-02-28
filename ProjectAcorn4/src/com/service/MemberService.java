package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.MemberDao;
import com.dto.ChoolCheckDTO;
import com.dto.MemberDTO;

public class MemberService {

	
	
	public List<MemberDTO> memberSelect (){
		SqlSession session = MySqlSessionFactory.getSession();
		MemberDao dao = new MemberDao();
		List<MemberDTO> list = null;
		try {
			list = dao.memberSelect(session);
		}finally {
			session.close();
		}
		return list;
	}
	
	public int MemberJoin(HashMap<String, String> map) {
		SqlSession session = MySqlSessionFactory.getSession();	
		MemberDao dao = new MemberDao();
		int n = 0;
		try {
			n=dao.MemberJoin(session, map);
			session.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return n;
	}
	
	public int idCheck (String userid) {
		SqlSession session = MySqlSessionFactory.getSession();
		MemberDao dao = new MemberDao();
		int check = 0;
		try {
			check=dao.idCheck(session, userid);
/*		}catch (Exception e) {
			e.printStackTrace();*/
		}finally {
			session.close();
		}
		return check;
	}
	
	public MemberDTO login (HashMap<String, String> map) {
		SqlSession session = MySqlSessionFactory.getSession();
		MemberDao dao = new MemberDao();
		MemberDTO dto = null;
		try {
			dto=dao.login(session, map);
/*		}catch (Exception e) {
			e.printStackTrace();*/
		}finally {
			session.close();
		}
		return dto;
	}
	
	public ChoolCheckDTO choolCheck (String check) {
		SqlSession session = MySqlSessionFactory.getSession();		
		MemberDao dao = new MemberDao();
		ChoolCheckDTO dto = null;
		try {
			dto=dao.choolCheck(session, check);
		} finally {
			session.close();
		}
		
		return dto;
	}
	
	public int choolInsert (HashMap<String, String> map) {
		SqlSession session = MySqlSessionFactory.getSession();		
		MemberDao dao = new MemberDao();
		int n = 0;
		try {
			n=dao.choolInsert(session,map);
			session.commit();
		} finally {
			session.close();
		}
		
		return n;
	}
	
	public int choolUpdate (HashMap<String, String> map) {
		SqlSession session = MySqlSessionFactory.getSession();		
		MemberDao dao = new MemberDao();
		int n = 0;
		try {
			n=dao.choolUpdate(session,map);
			session.commit();
		} finally {
			session.close();
		}
		
		return n;
	}
	
	public int choolClear (String check) {
		SqlSession session = MySqlSessionFactory.getSession();		
		MemberDao dao = new MemberDao();
		int n = 0;
		try {
			n=dao.choolClear(session, check);
			session.commit();
		} finally {
			session.close();
		}
		
		return n;
	}
	
	
}
