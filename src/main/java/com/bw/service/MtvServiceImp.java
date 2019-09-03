package com.bw.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.bean.Mtv;
import com.bw.bean.Types;
import com.bw.mapper.MtvMapper;

/**
 * @a作者wb
 *
 * @时间2019年9月3日
 */
@Service
public class MtvServiceImp implements MtvService{
	
	@Resource
	private MtvMapper mapper;

	@Override
	public List<Map<String, Object>> selectMtvList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.selectMtvList(map);
	}

	@Override
	public List<Types> selectType() {
		// TODO Auto-generated method stub
		return mapper.selectType();
	}

	@Override
	public int addMtv(Mtv mtv) {
		// TODO Auto-generated method stub
		return mapper.addMtv(mtv);
	}

	@Override
	public int addMtvTypes(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.addMtvTypes(map);
	}

	@Override
	public int deleteMtv(String[] split) {
		// TODO Auto-generated method stub
		return mapper.deleteMtv(split);
	}

	@Override
	public int deleteMtvType(String[] split) {
		// TODO Auto-generated method stub
		return mapper.deleteMtvType(split);
	}

	@Override
	public Map<String, Object> selectMtvByID(Integer mid) {
		// TODO Auto-generated method stub
		return mapper.selectMtvByID(mid);
	}

	@Override
	public int updateMtv(Mtv mtv) {
		// TODO Auto-generated method stub
		return mapper.updateMtv(mtv);
	}

}
