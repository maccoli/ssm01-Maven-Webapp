package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.pojo.CountryComment;
import com.cn.hnust.pojo.CountryWithBLOBs;

public interface CountryCommentService {
	/**
	 * ��ȡ����һ��������������
	 * @return
	 */
	public List<CountryComment> getCountryComments(CountryWithBLOBs countryWithBLOBs);
	
	public String newCountryComment(CountryComment comment);
	
}
