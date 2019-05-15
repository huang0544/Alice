package com.hjj.service;

import java.util.List;

import com.hjj.pojo.JoinDatingBean;

public interface JoinDatingService {
	//添加参加记录
	public int addJoinDating(JoinDatingBean joinDatingbean);
	//删除参加记录
	public int deleteJoinDating(int joinId);
	//根据用户email查询参加记录
	public List<JoinDatingBean> getJoinDatingByUserEamil(String joinDatingUserEmail);
	//根据活动id查询参加记录
	public List<JoinDatingBean> getJoinDatingByDatingId(int datingId);
	//根据活动id查询活动详情
	public JoinDatingBean getJoinDatingByJoinId(int joinId);
}
