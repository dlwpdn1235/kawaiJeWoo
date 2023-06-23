package kawai_project;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kawai.dao.CommDao;
import com.kawai.dao.CommDaoAnswer;
import com.kawai.dao.CommDaoBookinfo;
import com.kawai.dao.CommDaoInquiry;
import com.kawai.dao.CommDaoLike;
import com.kawai.dto.CommDto;
import com.kawai.dto.CommDtoAnswer;
import com.kawai.dto.CommDtoBookinfo;
import com.kawai.dto.CommDtoCategory;
import com.kawai.dto.CommDtoCommunityLike;
import com.kawai.dto.CommDtoInquiry;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/*-context.xml")
public class commTest {
	@Autowired
	CommDao dao;
	@Autowired
	CommDaoBookinfo dao2;
	@Autowired
	CommDaoLike like;
	@Autowired
	CommDaoInquiry inquiry;
	@Autowired
	CommDaoAnswer answerdao;
	
	@Test @Ignore
	public void bookinfoInsert() {
		CommDtoBookinfo info = new CommDtoBookinfo();
		info.setBook_title("승재형은 왜그럴까?");
		info.setBook_description("일부로 그러는걸까?");
		info.setBook_author("제우리");
		info.setBook_publisher("그린아카데미");
		info.setBook_image("no.jpg");
		info.setBook_pubdate("2023-01-20");
		System.out.println(dao2.commBookinfoInsert(info));
	}
	
	@Test @Ignore
	public void communityInsert() {
		CommDto info = new CommDto();
		info.setCommunity_title("승재형은 왜그럴까?라는 책의 리뷰입니다.");
		info.setCommunity_content("이책은 진짜 승재형이 왜그럴까에대해 잘설명되어있습니다.");
		info.setCommunity_ip("111-222-111");
		info.setUser_id("user001");
//		info.setCommunity_id(2);
		CommDtoBookinfo info2 = new CommDtoBookinfo();
		info2.setBookinfo_id(1);
		info.setBookinfo(info2);
		CommDtoCategory info3 = new CommDtoCategory();
		info3.setCategory_id(2);
		info.setCommcategory(info3);
		dao.commCommunityInsert(info);
//		dao.commCommunityUpdate(info);
		System.out.println(dao.commCommunityAllRead());
	}
	@Test @Ignore
	public void communityHit() {
		System.out.println(dao.commCommunityHit(2));
	}
	@Test @Ignore
	public void communityRead() {
		System.out.println(dao.commCommunityRead(3));
	}
	@Test @Ignore
	public void communityDelete() {
		System.out.println(dao.commCommunityDelete(2));
	}
	@Test @Ignore
	public void insertlike() {
		CommDtoCommunityLike communityLike = new CommDtoCommunityLike();
		communityLike.setCommunity_id(3);
		communityLike.setUser_id("user001");
		like.communityLikeInsert(communityLike);
	}
	@Test @Ignore
	public void deletelike() {
		CommDtoCommunityLike communityLike = new CommDtoCommunityLike();
		communityLike.setCommunity_id(3);
		communityLike.setUser_id("user001");
		like.communityLikeDelete(communityLike);
	}
	@Test @Ignore
	public void commlikeAllRead() {
		like.communityLikeAllRead("user001");
	}
	@Test @Ignore
	public void commInquiryInsert() {
		CommDtoInquiry dto = new CommDtoInquiry();
		dto.setInquiry_category_id(1);
		dto.setInquiry_title("승재형이 왜그럴까? 라는 책이 이상합니다.");
		dto.setInquiry_content("진짜 왜그럴까요");
		dto.setInquiry_ip("111-111-111");
		dto.setMarket_id(1);
		dto.setUser_id("user001");
//		dto.setInquiry_id(1);
		System.out.println(inquiry.commInquiryInsert(dto));
//		System.out.println(inquiry.commInquiryUpdate(dto));
	}
	@Test @Ignore
	public void commInquiryRead() {
		System.out.println(inquiry.commInquiryRead(1));
	}
	@Test @Ignore
	public void commInquiryAllRead() {
		System.out.println(inquiry.commInquiryAllRead("user001"));
	}
	@Test @Ignore
	public void commInquiryDelete() {
		System.out.println(inquiry.commInquiryDelete(1));
	}
	@Test @Ignore
	public void commAnswerInsert() {
		CommDtoAnswer answer = new CommDtoAnswer();
		answer.setAnswer("진짜 이상하지 말입니다??");
		answer.setInquiry_id(2);
		answer.setAnswer_ip("111-111-111");
//		answer.setUser_id("admin");
//		System.out.println(answerdao.commAnswerInsert(answer));
		System.out.println(answerdao.commAnswerUpdate(answer));
	}
	@Test @Ignore
	public void commAnswerRead() {
		System.out.println(answerdao.commAnswerRead(2));
	}
	@Test @Ignore
	public void commAnswerIs() {
		System.out.println(answerdao.commAnswerIs(1));
	}
	@Test @Ignore
	public void commAnswerDelete() {
		System.out.println(answerdao.commAnswerDelete(1));
	}
	
}