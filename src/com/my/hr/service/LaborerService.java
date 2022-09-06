package com.my.hr.service;

import java.time.LocalDate;
import java.util.List;

import com.my.hr.domain.Laborer;

public interface LaborerService {
	List<Laborer> getLaborers(); //List ���, �뵿�ڵ�
	Laborer getLaborer(int laborerId); //Ư�� �뵿��
	void addLaborer(String laborerName, LocalDate hireDate);
	void fixLaborer(Laborer laborer);
	void delLaborer(int laborerId); 
}
/*
������ Dao�� ���
naming rule = coding style Ʋ,��Ģ�� ������ ( ���ڼ� ���߱� �� )

*/ 