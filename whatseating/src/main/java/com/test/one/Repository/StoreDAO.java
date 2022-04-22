package com.test.one.Repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.one.Vo.StoreDTO;

@Repository("storeDAO")
public class StoreDAO {

	@Autowired
	private SqlSession session;
	
	//���� ������ �ҷ���
	public StoreDTO storeInfo(int ST_CODE) {
		StoreDTO storeDTO = session.selectOne("mappers.storeMapper.storeInfo",ST_CODE);
		return storeDTO;
	}
	//���� ����
	public int storeModify(StoreDTO storeDTO) {
		int updateResult = session.update("mappers.storeMapper.storeModify",storeDTO);
		return updateResult;
	}
	//���� ���
	public int storeRegister (StoreDTO storeDTO) {
		int insertResult = session.insert("mappers.storeMapper.storeRegister",storeDTO);
		return insertResult;
	}
	
	//���� ����Ʈ
	public List<StoreDTO> storeList(String ST_MANAGER) {
		List<StoreDTO> storeList = session.selectList("mappers.storeMapper.storeList",ST_MANAGER);
		return storeList;
	}
	
	//���� ī��Ʈ 
	public int storeCount (String ST_MANAGER) {
		int storeCount = session.selectOne("mappers.storeMapper.storeCount",ST_MANAGER);
		return storeCount;
	}
	
	//���� ����
	public int storeDelete (int ST_CODE) {
		int deleteResult = session.delete("mappers.storeMapper.storeDelete",ST_CODE);
		return deleteResult;
	}
	
	
	
}