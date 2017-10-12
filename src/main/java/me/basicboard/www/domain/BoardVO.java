package me.basicboard.www.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private Integer bno;
	private String title;
	private String writer;
	private Date regdate;
	private Integer reviewcnt;
	private String content;
	
}
