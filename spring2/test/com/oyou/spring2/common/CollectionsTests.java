package com.oyou.spring2.common;

import com.oyou.spring2.common.CollectionsUtil;
import com.oyou.spring2.common.CollectionsHelper;

import junit.framework.TestCase;


public class CollectionsTests extends TestCase {

	public void ntestProcess() {
		CollectionsHelper oo = new CollectionsHelper();
		oo.process();
	}
	
	
	public void testDups() {
		CollectionsUtil ooc = new CollectionsUtil();
		ooc.findDups(new String[]{"a","b","c","a"});
	}
}