package com.my.hr.dao;

import java.time.LocalDate;
import java.util.List;

import com.my.hr.domain.Laborer;
											
public class LaborerDaoImpl implements LaborerDao {
	private List<Laborer> laborers;
	private int laborerIdSeq; // 1,2,3,4~ ���� - ������
	
	public LaborerDaoImpl(List<Laborer> laborers) {
		this.laborers = laborers;
		this.laborerIdSeq = 1;	// �뵿�ڼ� �ʱⰪ '1'�� ��
	}
	
	@Override
	public List<Laborer> selectLaborers() { 
		return laborers;	// List<> laborers �� ��Ÿ�����
	}
	
	@Override
	public Laborer selectLaborer(int laborerId) {  
	 	//iterating ���� Ư�� �뵿�ڸ� ã�Ƽ� �˻��ؾ���
		Laborer laborer = null; // ã������ ���� ����
		
		for(Laborer laborerTmp: laborers) { 
			if(laborerTmp.getLaborerId() == laborerId) {
				laborer = laborerTmp; 
				break;	// ã���� for ������ ���������� 
			}
		}
		
		return laborer; 
	}
	
	@Override
	public void insertLaborer(String laborerName, LocalDate hireDate) {
		laborers.add(new Laborer(laborerIdSeq++, laborerName, hireDate));
		//laboers�� LaborerŸ���� �迭�̱⿡ �Ķ���͵� �Ȱ��� ��ü��
	}
	
	@Override
	public void updateLaborer(Laborer laborerTmp) {
		laborers.forEach(laborer -> { // ����ġ �Ķ���� ����
			if(laborer.getLaborerId() == laborerTmp.getLaborerId()) {
				//�뵿�ڸ� ã������ �����۾�
				laborer.setName(laborerTmp.getName());
				laborer.setHireDate(laborerTmp.getHireDate());
			}
		}); 
	}
	
	@Override
	public void deleteLaborer(int laborerId) {
		Laborer laborer = null;
		//�뵿�� ã�� ������ �����س���, insertLaborer��
		laborer = selectLaborer(laborerId);
		if(laborer != null) laborers.remove(laborer); // ã������ remove
	}
}
/*
id ������ ������ó���� �����ϸ� dao
�ӽñ�� service��


*/