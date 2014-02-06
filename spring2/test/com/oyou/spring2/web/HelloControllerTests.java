package com.oyou.spring2.web;

import org.springframework.web.servlet.ModelAndView;

import com.oyou.spring2.web.HelloController;

import junit.framework.TestCase;


public class HelloControllerTests extends TestCase {

    public void testHandleRequestView() throws Exception{		
        HelloController controller = new HelloController();
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        assertEquals("hello", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        String nowValue = (String) modelAndView.getModel().get("now");
        assertNotNull(nowValue);
    }
}