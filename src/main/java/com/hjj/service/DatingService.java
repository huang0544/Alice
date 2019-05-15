package com.hjj.service;

import java.util.List;

import com.hjj.pojo.DatingBean;

public interface DatingService {
	// ��������
	public int AddDating(DatingBean datingbean);

	// ɾ���
	public int DeleteDating(int datingId);

	// ���»
	public int UpdateDating(DatingBean dating);

	// ���ݷ����߻�ȡ�
	public List<DatingBean> GetDatingBySponsorEmail(String sponsorEmail);

	// ���ݻid��ѯ�
	public DatingBean GetDatingByDatingId(int datingId);

	// ��ѯ���л
	public List<DatingBean> GetAllDating();

}
