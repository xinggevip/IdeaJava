package com.gaoxing.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Category {
	private Integer cid;
	private String cname;
	@Override
	public String toString() {
		return "Categary [cid=" + cid + ", cname=" + cname + "]";
	}
	
}
