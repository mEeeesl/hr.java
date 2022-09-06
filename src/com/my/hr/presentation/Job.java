package com.my.hr.presentation;

public enum Job {
	EXIT("����"), LIST("���"), ADD("�߰�"), FIX("����"), DEL("����");
	
	private String label;
	
	private Job(String label) {
		this.label = label;
	}
	
	public static int length() {
		return values().length;
	}
	
	public static Job toJob(int ordinal) {
		return values()[ordinal];
	}
	
	public static String labels() {
		Job[] jobs = values();
		String line = "";
		String last = "";
		
		for(Job job: jobs) {
			if(job.ordinal() == 0) last += job.ordinal() + "." + job.label;
			else line += job.ordinal() + "." + job.label + ", ";
		}
		line += last;
		
		return line;
	}
}
/*
	���� Job.values() = EXIT LIST ADD FIX DEL
	  values().length(); = 5�� ����
 
	�迭���� index���� ����
	  ex) values()[0] = EXIT
	  ex) values()[1] = LIST

	EXIT -> job.ordinal() = 0�϶�
	LIST -> job.ordinal() = 1�϶�
	
*/