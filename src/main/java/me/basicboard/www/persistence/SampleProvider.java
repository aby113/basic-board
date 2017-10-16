package me.basicboard.www.persistence;

import org.springframework.util.StringUtils;

import lombok.extern.java.Log;
import me.basicboard.www.domain.Criteria;

@Log
public class SampleProvider {

	public static String search(Criteria cri){
		String searchFront = 
				"SELECT * FROM basicboard ";

		if(!StringUtils.isEmpty(cri.getSearchType())){
				searchFront += "WHERE ";
				log.warning(cri.getSearchType());
				log.warning("t".equals(cri.getSearchType()) + "");
				
			if("t".equals(cri.getSearchType())){
				searchFront += "title like '%"+cri.getKeyword() + "%'";
				log.warning(searchFront);
			}else if("c".equals(cri.getSearchType())){
				searchFront += "content like '%" + cri.getKeyword() + "%'";
			}else if("tc".equals(cri.getSearchType())){
				searchFront += "title like '%"+cri.getKeyword() + "%'"
				+ "OR content like '%" + cri.getKeyword() + "%'";
			}
		}
		searchFront += "ORDER BY bno desc limit "
					+ cri.getPageStart() + ", " + cri.getPerPageNum(); 
		return searchFront;
	}
	
	public static String searchCount(Criteria cri){
		String searchFront = 
				"SELECT COUNT(*) FROM basicboard ";
		if(!StringUtils.isEmpty(cri.getSearchType())){
			// 공백문자가 아니면
			searchFront += "WHERE ";
			if("t".equals(cri.getSearchType())){
				searchFront += "title like '%"+cri.getKeyword() + "%'";
			}else if("c".equals(cri.getSearchType())){
				searchFront += "content like '%" + cri.getKeyword() + "%'";
			}else if("tc".equals(cri.getSearchType())){
				searchFront += "title like '%"+cri.getKeyword() + "%'"
				+ "OR content like '%" + cri.getKeyword() + "%'";
			}
			
		}
		return searchFront;
	}
}
