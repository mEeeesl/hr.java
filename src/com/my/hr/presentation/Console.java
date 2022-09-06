package com.my.hr.presentation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public interface Console { 		// Console은 보니까 All 'static'임
	Scanner sc = new Scanner(System.in);
	
	static void info(Object obj) {
		System.out.println(obj);
	}
	
	static void err(String msg) {
		System.out.println("ERROR] " + msg);
	}
	
	// interface에서도 private 사용가능
	private static void in(String msg) {
		System.out.print(msg + "\n> ");
	}
										//len - 글자 수 제한
	static String inStr(String msg, int len) {	// laborerName, 이름을 입력할 Console에서 이름입력예외까지만든다.
		boolean isGood = false;
		String line = "";
		
		do {
			in(msg);
			line = sc.nextLine().trim();
			
			int length = line.length();
			
			isGood = 0 < length && length <= len; // 참일때 isGood = true;
			if(!isGood) err("1자 이상 " + len + "자 이하를 입력하세요.");
		} while(!isGood);
		
		return line;
		// ★ 예외처리는 Console에서 ★
	}
	
	static int inNum(String msg) {	// laborerId, Menu  , 노동자ID, 메뉴번호에 대한 예외처리도 Console에서 진행한다. 
		boolean isGood = false;
		String line = "";
		int num = 0;
		
		do {
			in(msg);
			line = sc.nextLine().trim();
			 						  // matches() - 파라미터값과 비교문자열(line)이 정확히 일치하면 true
									  // contains() - 비교문자열(line)이 포함되면 true
			if(line.length() > 0 && line.matches("[0-9]*")) {
				try {
					num = Integer.parseInt(line);
					isGood = true; 		 // ★ try 안쓰고 if문으로 해결하는게 좋은거 ★ 
				} catch(NumberFormatException e) {}
			} 		
			
			if(!isGood) err("0 이상을 입력하세요.");
		} while(!isGood);

		return num;
	}
	
	static LocalDate inDate(String msg) {
		String line = "";
		LocalDate date = null;	// 무슨 날짜인지 Console에선 모르니, date로 적음 + 날짜에대한 입력 예외도 Console에서 같이만듬
		
		do {
			in(msg);
			line = sc.nextLine();
			
			if(line.length() > 0) {
				try {							//YYYY-MM-DD 형식으로 나오는 enum
					date = LocalDate.parse(line, DateTimeFormatter.ISO_DATE);
				} catch(DateTimeParseException e) {}
			}
				
			//try 못한경우 date = null임. 그 예외사항
			if(date == null) err("실제 날짜를 YYYY-MM-DD 형식으로 입력하세요");
		} while(date == null);
		
		return date;
	}
	
	
	
	//목록 추가 수정 삭제 - 4개 배열 
	//종료 - 1개 원소
	/* 기존 menu
	static String menu(List<String> menuItems) {
		String menu = "";
		int i = 0;
		
		for(String menuItem: menuItems)
			menu += ++i + "." + menuItem + ", ";
		menu += "0. 종료";

		return menu;
	}*/
}
/*
Console은 업무와 직접적으로 관련된건 만들면 안된다.


*/