package com.cso.jsf2spring3.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@ManagedBean
@RequestScoped
public class AutocompleteBean {
	private static final Log log = LogFactory.getLog(AutocompleteBean.class);

	
	private List<String> nameList = new ArrayList<String>();

	public List<String> getNameList() {
		log.debug("nameList>>");
		nameList.clear();
		nameList.add("abc");
		nameList.add("abcd");
		nameList.add("abcde");
		nameList.add("bcd");
		nameList.add("bcde");
		nameList.add("bcdef");
		log.debug("nameList>>");
		return nameList;
	}

	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}


	public List<String> autocompleteList(String search) {
		log.debug("autocompleteList>>");
		this.getNameList();
		log.debug("autocompleteList>>");
		return nameList;
	}


}

