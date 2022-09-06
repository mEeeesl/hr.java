package com.my.hr.dao;

import java.time.LocalDate;
import java.util.List;

import com.my.hr.domain.Laborer;

public interface LaborerDao {
	List<Laborer> selectLaborers(); //List (노동자 목록) 읽기
	Laborer selectLaborer(int laborerId); //특정 노동자 읽기
	void insertLaborer(String laborerName, LocalDate hireDate);
	void updateLaborer(Laborer laborer);
	void deleteLaborer(int laborerId); 
}
/*
1.	List<Laborer> select~() 호출시 아무것도 없으면 - 아무것도 없는 list가 출력
	Laborer select~(id) 호출시 아무것도 없으면 - null 출력

2.	String laborerName 이라고 쓴 이유
	Laborer 클래스의 name = LaborerName
	Dao interface의 name = ?? laborerName이라 정해야함

3.	(이름, 아이디, 날짜) 3개 이상 파라미터 받을때는 domain에 있는 클래스를 담아주는게 좋음
	( dto가,  리턴타입 Laborer, = 파라미터 Laberer 일때는 이렇게 하라는말)

4. 	특정 녀석 찾을때 key 해두면 좋은이유임.

*/