package com.my.hr.dao;

import java.time.LocalDate;
import java.util.List;

import com.my.hr.domain.Laborer;
											
public class LaborerDaoImpl implements LaborerDao {
	private List<Laborer> laborers;
	private int laborerIdSeq; // 1,2,3,4~ 순차 - 시퀀스
	
	public LaborerDaoImpl(List<Laborer> laborers) {
		this.laborers = laborers;
		this.laborerIdSeq = 1;	// 노동자수 초기값 '1'로 둠
	}
	
	@Override
	public List<Laborer> selectLaborers() { 
		return laborers;	// List<> laborers 를 나타내면됨
	}
	
	@Override
	public Laborer selectLaborer(int laborerId) {  
	 	//iterating 으로 특정 노동자를 찾아서 검사해야함
		Laborer laborer = null; // 찾았을때 담을 변수
		
		for(Laborer laborerTmp: laborers) { 
			if(laborerTmp.getLaborerId() == laborerId) {
				laborer = laborerTmp; 
				break;	// 찾으면 for 블럭에서 빠져나오기 
			}
		}
		
		return laborer; 
	}
	
	@Override
	public void insertLaborer(String laborerName, LocalDate hireDate) {
		laborers.add(new Laborer(laborerIdSeq++, laborerName, hireDate));
		//laboers는 Laborer타입의 배열이기에 파라미터도 똑같이 객체로
	}
	
	@Override
	public void updateLaborer(Laborer laborerTmp) {
		laborers.forEach(laborer -> { // 포이치 파라미터 람다
			if(laborer.getLaborerId() == laborerTmp.getLaborerId()) {
				//노동자를 찾았을때 수정작업
				laborer.setName(laborerTmp.getName());
				laborer.setHireDate(laborerTmp.getHireDate());
			}
		}); 
	}
	
	@Override
	public void deleteLaborer(int laborerId) {
		Laborer laborer = null;
		//노동자 찾는 로직은 구현해놓음, insertLaborer로
		laborer = selectLaborer(laborerId);
		if(laborer != null) laborers.remove(laborer); // 찾았으면 remove
	}
}
/*
id 생성을 데이터처리로 생각하면 dao
머시기면 service로


*/