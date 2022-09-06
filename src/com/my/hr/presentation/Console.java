package com.my.hr.presentation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public interface Console { 		// Console�� ���ϱ� All 'static'��
	Scanner sc = new Scanner(System.in);
	
	static void info(Object obj) {
		System.out.println(obj);
	}
	
	static void err(String msg) {
		System.out.println("ERROR] " + msg);
	}
	
	// interface������ private ��밡��
	private static void in(String msg) {
		System.out.print(msg + "\n> ");
	}
										//len - ���� �� ����
	static String inStr(String msg, int len) {	// laborerName, �̸��� �Է��� Console���� �̸��Է¿��ܱ��������.
		boolean isGood = false;
		String line = "";
		
		do {
			in(msg);
			line = sc.nextLine().trim();
			
			int length = line.length();
			
			isGood = 0 < length && length <= len; // ���϶� isGood = true;
			if(!isGood) err("1�� �̻� " + len + "�� ���ϸ� �Է��ϼ���.");
		} while(!isGood);
		
		return line;
		// �� ����ó���� Console���� ��
	}
	
	static int inNum(String msg) {	// laborerId, Menu  , �뵿��ID, �޴���ȣ�� ���� ����ó���� Console���� �����Ѵ�. 
		boolean isGood = false;
		String line = "";
		int num = 0;
		
		do {
			in(msg);
			line = sc.nextLine().trim();
			 						  // matches() - �Ķ���Ͱ��� �񱳹��ڿ�(line)�� ��Ȯ�� ��ġ�ϸ� true
									  // contains() - �񱳹��ڿ�(line)�� ���ԵǸ� true
			if(line.length() > 0 && line.matches("[0-9]*")) {
				try {
					num = Integer.parseInt(line);
					isGood = true; 		 // �� try �Ⱦ��� if������ �ذ��ϴ°� ������ �� 
				} catch(NumberFormatException e) {}
			} 		
			
			if(!isGood) err("0 �̻��� �Է��ϼ���.");
		} while(!isGood);

		return num;
	}
	
	static LocalDate inDate(String msg) {
		String line = "";
		LocalDate date = null;	// ���� ��¥���� Console���� �𸣴�, date�� ���� + ��¥������ �Է� ���ܵ� Console���� ���̸���
		
		do {
			in(msg);
			line = sc.nextLine();
			
			if(line.length() > 0) {
				try {							//YYYY-MM-DD �������� ������ enum
					date = LocalDate.parse(line, DateTimeFormatter.ISO_DATE);
				} catch(DateTimeParseException e) {}
			}
				
			//try ���Ѱ�� date = null��. �� ���ܻ���
			if(date == null) err("���� ��¥�� YYYY-MM-DD �������� �Է��ϼ���");
		} while(date == null);
		
		return date;
	}
	
	
	
	//��� �߰� ���� ���� - 4�� �迭 
	//���� - 1�� ����
	/* ���� menu
	static String menu(List<String> menuItems) {
		String menu = "";
		int i = 0;
		
		for(String menuItem: menuItems)
			menu += ++i + "." + menuItem + ", ";
		menu += "0. ����";

		return menu;
	}*/
}
/*
Console�� ������ ���������� ���õȰ� ����� �ȵȴ�.


*/