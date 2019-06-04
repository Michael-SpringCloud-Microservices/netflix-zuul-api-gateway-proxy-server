/**
 * 
 */
package com.zuul.gateway.proxy.server.filters;


import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * @author 109726
 *
 */
public class PreFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		System.out.println("Inside Pre Filter");

		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		System.out.println("Pre Filter -> Request Method : " + request.getMethod() + " " + "Pre Filter ->  Request URL : " + request.getRequestURL().toString());
		return null;
	}
}