package com.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.dto.ChoolCheckDTO;
import com.dto.MemberDTO;

public class MemberDAO {
	public ChoolCheckDTO choolCheck (SqlSession session,String check) {
		return session.selectOne("ChoolSeokMapper.choolCheck",check);
	}
	
	public int choolInsert (SqlSession session, HashMap<String, String> map) {
		return session.insert("ChoolSeokMapper.choolInsert", map);
	}
	
	public int choolUpdate (SqlSession session, HashMap<String, String> map) {
		return session.update("ChoolSeokMapper.choolUpdate", map);
	}
	
	public int choolClear (SqlSession session, String check) {

		return session.update("ChoolSeokMapper.choolClear", check);
	}
	
	public int memberAdd(SqlSession session,MemberDTO dto) {
		System.out.println("dao>>>"+dto);
		int n=session.insert("MemberMapper.memberAdd",dto);
		return n;
	}
	public MemberDTO login(SqlSession session,HashMap<String, String> map) {
		MemberDTO dto=session.selectOne("MemberMapper.login",map);
		return dto;
	}
	
	public HashMap<String, String> idSearch(SqlSession session, MemberDTO dto) {
		HashMap<String, String> map=session.selectOne("MemberMapper.idSearch",dto);
		return map;
	}
	
	public int idCheck(SqlSession session, String userid) {
		int n=session.selectOne("MemberMapper.idCheck",userid);
		System.out.println("idcheck DAO = "+n);
		return n;
	}
	
	public int update(SqlSession session, MemberDTO dto) {
		int n=session.update("MemberMapper.memberupdate",dto);
		return n;
	}
	
	public int withdrawal(SqlSession session, HashMap<String, String> map) {
		
		int n=session.delete("MemberMapper.withdrawal",map);
		return n;
	}
	
	public int pwSearch_phone(SqlSession session, HashMap<String, String> map) {
		int n=session.selectOne("MemberMapper.pwSearch_phone",map);
		return n;
	}
	
	public int pwSearch_email(SqlSession session, HashMap<String, String> map) {
		int n=session.selectOne("MemberMapper.pwSearch_email",map);
		return n;
	}
	
	public int passwdUpdate(SqlSession session, HashMap<String, String> map2) {
		System.out.println(map2);
		int n=session.update("MemberMapper.passwdUpdate",map2);
		return n;
	}
}
