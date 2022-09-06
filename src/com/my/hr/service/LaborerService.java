package com.my.hr.service;

import java.time.LocalDate;
import java.util.List;

import com.my.hr.domain.Laborer;

public interface LaborerService {
	List<Laborer> getLaborers(); //List 목록, 노동자들
	Laborer getLaborer(int laborerId); //특정 노동자
	void addLaborer(String laborerName, LocalDate hireDate);
	void fixLaborer(Laborer laborer);
	void delLaborer(int laborerId); 
}
/*
지금은 Dao랑 비슷
naming rule = coding style 틀,규칙을 맞추자 ( 글자수 맞추기 등 )

*/ 