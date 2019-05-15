package com.hjj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hjj.pojo.DatingBean;

@Repository
public interface DatingDao {
	// 户外活动发帖
	public int AddDating(DatingBean datingbean);

	// 删除活动
	public int DeleteDating(@Param("datingId") int datingId);

	// 更新活动
	public int UpdateDating(DatingBean dating);

	// 根据发起者获取活动
	public List<DatingBean> GetDatingBySponsorEmail(@Param("sponsorEmail") String sponsorEmail);

	// 根据活动id查询活动
	public DatingBean GetDatingByDatingId(@Param("datingId") int datingId);

	// 获取所有活动
	public List<DatingBean> GetAllDating();

}
