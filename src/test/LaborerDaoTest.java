package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.my.hr.dao.LaborerDao;
import com.my.hr.dao.LaborerDaoImpl;
import com.my.hr.domain.Laborer;

public class LaborerDaoTest {
	public static void main(String[] args) {
		List<Laborer> laborers = new ArrayList<>();
		laborers.add(new Laborer(11, "최한석", LocalDate.now()));
		laborers.add(new Laborer(12, "한아름", LocalDate.now()));
		
		LaborerDao laborerDao = new LaborerDaoImpl(laborers);
		System.out.println(laborerDao.selectLaborers());
		System.out.println(laborerDao.selectLaborer(12));
		
		laborerDao.insertLaborer("양승일", LocalDate.now());
		laborerDao.insertLaborer("김필진", LocalDate.now());
		System.out.println(laborerDao.selectLaborers());
		
		laborerDao.updateLaborer(new Laborer(11, "소지섭", LocalDate.of(2025, 5, 5)));
		System.out.println(laborerDao.selectLaborers());
		
		laborerDao.deleteLaborer(11);
		System.out.println(laborerDao.selectLaborers());
	}
}
/*
Test를 실패했는지 성공했는지 내가 판단해야해서 위험할 수 있
그걸 스프링? 에서 알려준다함 


*/