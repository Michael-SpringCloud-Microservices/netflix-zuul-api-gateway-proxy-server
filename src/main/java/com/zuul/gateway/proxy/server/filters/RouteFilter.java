/**
 * 
 */
package com.zuul.gateway.proxy.server.filters;


import com.netflix.zuul.ZuulFilter;

/**
 * @author 109726
 *
 */
public class RouteFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return "route";
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
		System.out.println("Inside Route Filter");
		return null;
	}
}