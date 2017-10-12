package me.basicboard.www.util;

import java.util.Date;

public class JspUtil {

	public String getPatternValue(Date userDate){
		return new Date().equals(userDate)?"HH:mm":"yyyy-MM-dd";
	}
	
}
