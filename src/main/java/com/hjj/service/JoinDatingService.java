package com.hjj.service;

import java.util.List;

import com.hjj.pojo.JoinDatingBean;

public interface JoinDatingService {
	//��ӲμӼ�¼
	public int addJoinDating(JoinDatingBean joinDatingbean);
	//ɾ���μӼ�¼
	public int deleteJoinDating(int joinId);
	//�����û�email��ѯ�μӼ�¼
	public List<JoinDatingBean> getJoinDatingByUserEamil(String joinDatingUserEmail);
	//���ݻid��ѯ�μӼ�¼
	public List<JoinDatingBean> getJoinDatingByDatingId(int datingId);
	//���ݻid��ѯ�����
	public JoinDatingBean getJoinDatingByJoinId(int joinId);
}
