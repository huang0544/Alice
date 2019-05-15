package com.hjj.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hjj.dao.JoinDatingDao;
import com.hjj.pojo.JoinDatingBean;
import com.hjj.service.JoinDatingService;

@Service
@Transactional
public class JoinDatingServiceImpl implements JoinDatingService {

	@Autowired
	private JoinDatingDao joinDatingDao;

	@Override
	public int addJoinDating(JoinDatingBean joinDatingbean) {
		System.out.println(joinDatingbean.toString());
		return joinDatingDao.addJoinDating(joinDatingbean);
	}

	@Override
	public int deleteJoinDating(int joinId) {
		return joinDatingDao.deleteJoinDating(joinId);
	}

	@Override
	public List<JoinDatingBean> getJoinDatingByUserEamil(String joinDatingUserEmail) {
		return joinDatingDao.getJoinDatingByUserEamil(joinDatingUserEmail);
	}

	@Override
	public List<JoinDatingBean> getJoinDatingByDatingId(int datingId) {
		return joinDatingDao.getJoinDatingByDatingId(datingId);
	}

	@Override
	public JoinDatingBean getJoinDatingByJoinId(int joinId) {
		return joinDatingDao.getJoinDatingByJoinId(joinId);
	}

}
