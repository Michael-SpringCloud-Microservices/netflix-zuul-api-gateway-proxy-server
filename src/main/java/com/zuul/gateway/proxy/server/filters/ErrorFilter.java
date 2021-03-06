/**
 * 
 */
package com.zuul.gateway.proxy.server.filters;

import com.netflix.zuul.ZuulFilter;

/**
 * @author 109726
 *
 */
public class ErrorFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return "error";
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
		System.out.println("Inside Error/Route Filter");
		return null;
	}
}