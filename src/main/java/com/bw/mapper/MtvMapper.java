package com.bw.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bw.bean.Mtv;
import com.bw.bean.Types;

/**
 * @a作者wb
 *
 * @时间2019年9月3日
 */
public interface MtvMapper {
	
	
	//显示所有
	List<Map<String, Object>> selectMtvList(Map<String, Object> map);

	List<Types> selectType();

	int addMtv(Mtv mtv);

	int addMtvTypes(Map<String, Object> map);

	int deleteMtv(@Param("split") String[] split);

	int deleteMtvType(@Param("split")String[] split);

	Map<String, Object> selectMtvByID(Integer mid);

	int updateMtv(Mtv mtv);

}
