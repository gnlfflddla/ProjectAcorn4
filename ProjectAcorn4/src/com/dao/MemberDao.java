package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.ChoolCheckDTO;
import com.dto.MemberDTO;

public class MemberDao {
	public List<MemberDTO> memberSelect (SqlSession session){
		return session.selectList("MemberMapper.memberSelect");
	}
	public int MemberJoin (SqlSession session, HashMap<String, String> map) {
		return session.insert("MemberMapper.MemberJoin", map);
	}
	
	public int idCheck (SqlSession session, String userid) {
		return session.selectOne("MemberMapper.idCheck", userid);
	}
	
	public MemberDTO login (SqlSession session, HashMap<String, String> map) {
		return session.selectOne("MemberMapper.login", map);
	}
	
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
	
}
