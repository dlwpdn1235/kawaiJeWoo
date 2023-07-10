package com.kawai.service;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.kawai.dao.BookHashTagDao;
import com.kawai.dao.BookImgDao;
import com.kawai.dao.BookStoreDao;
import com.kawai.dto.BookImgVO;
import com.kawai.dto.BookStoreVO;
import com.kawai.dto.BookTagBoxVO;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BookStoreServiceImpl implements BookStoreService{
	@Autowired BookStoreDao dao;
	@Autowired BookImgDao imgdao;
	@Autowired BookHashTagDao tagdao;
	
	@Override
	public int bookstoreinsert(BookStoreVO vo) { 
		return dao.bookstoreinsert(vo); // bookstore 테이블에 데이터 삽입
	}
	@Override
	public int bookstoreupdate(BookStoreVO vo) { return dao.bookstoreupdate(vo); }
	@Override
	public int bookstoredelete(int no) { return dao.bookstoredelete(no); }
	@Override
	public BookStoreVO bookstoreread(int no) { return dao.bookstoreread(no); }
	@Override
	public List<BookStoreVO> bookstorereadAll() { return dao.bookstorereadAll(); }
	@Override
	public Integer findMaxBsNo() {
		Integer maxBsNo = dao.findMaxBsNo();
		return maxBsNo != null ? maxBsNo : 0;
	}
	@Override
	public void addBookTagBox(BookTagBoxVO tagBox) {
		 dao.addBookTagBox(tagBox);
	}
	@Override
	public List<String> getBookStoreTagNames(int no) {
		 return dao.getBookStoreTagNames(no);
	}
	@Override
	public List<BookStoreVO> getBsName(String name) {
		return dao.getBsName(name);
	}
	
	@Override
	public void registerBookStore(BookStoreVO vo) {
		// 최대 bs_no 값을 조회하여 새로운 번호 설정
        int maxBsNo = findMaxBsNo();
        int newBsNo = maxBsNo + 1;
        vo.setBs_no(newBsNo);

        // 서점 등록 메서드 호출
        dao.registerBookStore(vo);
	}
	
	
}