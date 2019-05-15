package com.hjj.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hjj.pojo.JoinDatingBean;
@Repository
public interface JoinDatingDao {
	//��ӲμӼ�¼
	public int addJoinDating(JoinDatingBean joinDatingbean);
	//ɾ���μӼ�¼
	public int deleteJoinDating(int joinId);
	//�����û�email��ѯ�μӼ�¼
	public List<JoinDatingBean> getJoinDatingByUserEamil(String joinDatingUserEmail);
	//���ݻid��ѯ�μӼ�¼
	public List<JoinDatingBean> getJoinDatingByDatingId(int joinId);
	//���ݻid��ѯ�����
	public JoinDatingBean getJoinDatingByJoinId(int joinId);
}
