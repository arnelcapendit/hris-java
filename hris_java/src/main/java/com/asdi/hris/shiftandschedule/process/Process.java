package com.asdi.hris.shiftandschedule.process;

public class Process {
	
	
	public String value(String arr[], int index, int index2, String delimeter){
		String val = "";
		for(int i=0; i<arr.length; i++){
			String s1[] = arr[index2].split(delimeter);
			if(index==0) val = s1[index].trim().replace("[", "").replace("]", "").replace("\"", "");
			else val = s1[index].trim().replace("[", "").replace("]", "").replace("\"", "");
		}
		return val;
	}
	
	public String dayValue(String sDays){
		sDays = sDays.trim().replace("[\"", "").replace("\"]", "").replace(",", "").replace(" ", "").replace("\"", " ");
		System.out.println("keme " + sDays);
		StringBuffer sf = new StringBuffer();
		if(sDays.contains("mon")) sf.append("1");
		if(sDays.contains("tue")) sf.append("2");
		if(sDays.contains("wed")) sf.append("3");
		if(sDays.contains("thu")) sf.append("4");
		if(sDays.contains("fri")) sf.append("5");
		if(sDays.contains("sat")) sf.append("6");
		if(sDays.contains("sun")) sf.append("7");
		
		return sf.toString();
	}
}
