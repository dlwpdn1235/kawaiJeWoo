package com.kawai.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.kawai.dto.AccountUserVO;

public interface AccountUserService {
	// 회원가입 accountUserInsert
	public int accountUserInsert(HttpServletRequest request , AccountUserVO user);
	
	// 아이디 중복체크 accountIdCheck
	public Map<String,String> accountIdCheck(String id);
	
	
	// 로그인 accointLogin
	public AccountUserVO accountLogin(HttpServletRequest request , AccountUserVO user);
	
	// 회원정보 상세보기 accountUserRead
	public AccountUserVO accountUserRead(AccountUserVO userVO);
	public AccountUserVO accountUserRead2(String userId);
	
	// 회원목록 리스트 accountUserList
	public List<AccountUserVO> accountUserList();
	
	// 회원정보 수정 accountUserUpdate
	public int accountUserUpdate(HttpServletRequest request , AccountUserVO user);
	
	// 회원탈퇴 accountUserDelete
	public int accountUserDelete(AccountUserVO user);
	
}