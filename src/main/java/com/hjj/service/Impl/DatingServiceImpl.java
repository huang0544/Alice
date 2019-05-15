package com.hjj.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hjj.dao.DatingDao;
import com.hjj.pojo.DatingBean;
import com.hjj.service.DatingService;
@Service@Transactional
public class DatingServiceImpl implements DatingService{

	@Autowired
	private DatingDao datingDao;
	@Override
	public int AddDating(DatingBean datingbean) {
		return datingDao.AddDating(datingbean);
	}

	@Override
	public int DeleteDating(int datingId) {
		return datingDao.DeleteDating(datingId);
	}

	@Override
	public int UpdateDating(DatingBean dating) {
		return datingDao.UpdateDating(dating);
	}

	@Override
	public List<DatingBean> GetDatingBySponsorEmail(String sponsorEmail) {
		return datingDao.GetDatingBySponsorEmail(sponsorEmail);
	}

	@Override
	public DatingBean GetDatingByDatingId(int datingId) {
		return datingDao.GetDatingByDatingId(datingId);
	}
	
	@Override
	public List<DatingBean> GetAllDating(){
		return datingDao.GetAllDating();
	}


}
