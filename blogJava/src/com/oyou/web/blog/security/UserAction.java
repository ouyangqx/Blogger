package com.oyou.web.blog.security;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.WebApplicationContext;

import com.oyou.common.spring.SpringService;
import com.oyou.domain.blog.UserService;
import com.oyou.web.struts.StrutsAction;

public abstract class UserAction extends StrutsAction {
	private static final Log log = LogFactory.getLog(UserAction.class);
	protected static final String FORWARD_GROUP = "group";
	protected static final String FORWARD_SEARCH = "blogSearch";
	private UserService userService;

	public UserService getUserService() {
		if (userService == null) {
			log.debug(">>BEAN userService is null");
			try {
				WebApplicationContext ctx = getWebApplicationContext();
				if (ctx != null)
					if (ctx.containsBean(SpringService.USER_SERVICE)) {
						Object obj = ctx.getBean(SpringService.USER_SERVICE);
						if (obj != null)
						userService = (UserService)obj;
					}
				if (userService == null) {
					log.fatal(">>Can't get userService from Application Context");
				} 
			} catch (Exception e) {
				e.printStackTrace();
				log.debug("Exception on get context " + e.getMessage());
			}
		}
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	protected Map getKeyMethodMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("button.login", "login");
		map.put("button.password", "changePassword");
		map.put("button.register", "register");
		map.put("button.profile", "updateProfile");
		map.put("button.search", "forgotPassword");
		return map;
	}


}
