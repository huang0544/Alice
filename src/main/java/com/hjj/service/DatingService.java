package com.hjj.service;

import java.util.List;

import com.hjj.pojo.DatingBean;

public interface DatingService {
	// 户外活动发帖
	public int AddDating(DatingBean datingbean);

	// 删除活动
	public int DeleteDating(int datingId);

	// 更新活动
	public int UpdateDating(DatingBean dating);

	// 根据发起者获取活动
	public List<DatingBean> GetDatingBySponsorEmail(String sponsorEmail);

	// 根据活动id查询活动
	public DatingBean GetDatingByDatingId(int datingId);

	// 查询所有活动
	public List<DatingBean> GetAllDating();

}
