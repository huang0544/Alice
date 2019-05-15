package com.hjj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hjj.pojo.DatingBean;

@Repository
public interface DatingDao {
	// ��������
	public int AddDating(DatingBean datingbean);

	// ɾ���
	public int DeleteDating(@Param("datingId") int datingId);

	// ���»
	public int UpdateDating(DatingBean dating);

	// ���ݷ����߻�ȡ�
	public List<DatingBean> GetDatingBySponsorEmail(@Param("sponsorEmail") String sponsorEmail);

	// ���ݻid��ѯ�
	public DatingBean GetDatingByDatingId(@Param("datingId") int datingId);

	// ��ȡ���л
	public List<DatingBean> GetAllDating();

}
