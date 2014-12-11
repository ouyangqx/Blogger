package com.oyou.example;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EqualsBuilderDemo {
	protected static final Log logger = LogFactory.getLog(EqualsBuilderDemo.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = null;
		String b = "";
		
		boolean rtn = new EqualsBuilder().append(a, b).isEquals();
		logger.debug("space with null:" + rtn + "\n");

		rtn = new EqualsBuilder().append(a == null? "" : a, b == null? "" : b).isEquals();
		logger.debug("space with space:" + rtn + "\n");
		
		

	}

}
