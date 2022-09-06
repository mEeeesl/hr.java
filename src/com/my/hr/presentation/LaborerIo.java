package com.my.hr.presentation;

import java.time.LocalDate;
import java.util.List;

import com.my.hr.domain.Laborer;
import com.my.hr.service.LaborerService;

public class LaborerIo {
	private LaborerService laborerService;
	private String menu;
	
	public LaborerIo(LaborerService laborerService) {
		this.laborerService = laborerService;
		this.menu = Job.labels();
	}
	
	public void play() {
		Job job = null;	
		while( (job = choose(menu)) != Job.EXIT) {//종료 목록 추가 수정 삭제
			switch(job) {
			case LIST: listLaborers(); break;
			case ADD: addLaborer(); break;
			case FIX: fixLaborer(); break;
			case DEL: delLaborer();
			}
		}
	}
	
	private Job choose(String menu) {
		boolean isGood = false;
		int choice = 0;
		
		do {
			choice = Console.inNum(menu);	//엔터만누르는예외는 Console에서
			if(choice < 0 || choice >= Job.length())
				Console.err("메뉴 번호를 재입력 하세요.");
			else isGood = true;
		} while(!isGood);
		
		return Job.toJob(choice);
	}
	
	private void listLaborers() {
		List<Laborer> laborers = laborerService.getLaborers();
		
		if(laborers.size() > 0) {
			
			System.out.println(" ID  이름      입사일");
			System.out.println("---------------------");
		
			laborers.forEach(laborer -> Console.info(laborer));
			
		} else Console.info("노동자가 없습니다.");
	}
	
	private void addLaborer() {
		String laborerName = Console.inStr("노동자명을 입력하세요", 5);
		
		if(!laborerName.equals("0")) {
			LocalDate hireDate = Console.inDate("입사일을 입력하세요.");
			laborerService.addLaborer(laborerName, hireDate);
			Console.info("노동자를 추가했습니다.");
		} else Console.info("추가를 취소합니다.");
	}
	
	private void fixLaborer() {
		if(laborerService.getLaborers().size() > 0) {
			// addLaborer()와 중복된 메소드를 별도의 메소드로 뽑아냄.
			int laborerId = getLaborer("수정");
			if(laborerId > 0) {
				String laborerName = Console.inStr("수정할 노동자명을 입력하세요.", 5);
				LocalDate hireDate = Console.inDate("수정할 입사일을 입력하세요.");
				
				laborerService.fixLaborer(new Laborer(laborerId, laborerName, hireDate));
				Console.info("노동자를 수정했습니다.");
			}
			
		} else Console.info("노동자가 없습니다.");
	}
	
	private int getLaborer(String job) {// 무슨작업을 취소하는지
						// 노동자가 있는데 번호 잘못입력해서 못찾은경우
		Laborer laborer = null;
		int laborerId = 0;
		
		do { // 강제종료, 작업취소
			laborerId = Console.inNum("노동자ID를 입력하세요");
			if(laborerId == 0) {
				Console.info(job + "을/를 취소합니다. ");
				return 0; // 강제종료, 작업취소
			}
				
			// 노동자 찾기
			laborer = laborerService.getLaborer(laborerId);
			 // 노동자 찾을 수 없을때
			if(laborer == null) Console.err("해당 ID의 노동자가 없습니다.");
		} while(laborer == null);
		
		// 노동자 찾았을때 , 수정과 삭제에서 ID를 key로 받을거임.
		return laborerId;
		
	}
	
	private void delLaborer() {
		if(laborerService.getLaborers().size() > 0) { //노동자 1명이상
			int laborerId = getLaborer("삭제");
			if(laborerId > 0) {	// 우리가 0 안누르면
				laborerService.delLaborer(laborerId);
				Console.info("노동자를 삭제했습니다.");
			} 
			
		} else Console.info("노동자가 없습니다.");
	}
}
/*
공유하는거 - 멤버데이터로
자기만쓰는거 - 메소드의 지역변수로


*/