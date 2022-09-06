package com.my.hr.dao;

import java.time.LocalDate;
import java.util.List;

import com.my.hr.domain.Laborer;

public interface LaborerDao {
	List<Laborer> selectLaborers(); //List (�뵿�� ���) �б�
	Laborer selectLaborer(int laborerId); //Ư�� �뵿�� �б�
	void insertLaborer(String laborerName, LocalDate hireDate);
	void updateLaborer(Laborer laborer);
	void deleteLaborer(int laborerId); 
}
/*
1.	List<Laborer> select~() ȣ��� �ƹ��͵� ������ - �ƹ��͵� ���� list�� ���
	Laborer select~(id) ȣ��� �ƹ��͵� ������ - null ���

2.	String laborerName �̶�� �� ����
	Laborer Ŭ������ name = LaborerName
	Dao interface�� name = ?? laborerName�̶� ���ؾ���

3.	(�̸�, ���̵�, ��¥) 3�� �̻� �Ķ���� �������� domain�� �ִ� Ŭ������ ����ִ°� ����
	( dto��,  ����Ÿ�� Laborer, = �Ķ���� Laberer �϶��� �̷��� �϶�¸�)

4. 	Ư�� �༮ ã���� key �صθ� ����������.

*/