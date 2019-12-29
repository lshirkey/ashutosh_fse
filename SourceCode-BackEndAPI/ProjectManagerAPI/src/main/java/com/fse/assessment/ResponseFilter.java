/**
 * 
 */
package com.fse.assessment;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



/**
 * @author Pratik Das
 *
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ResponseFilter implements Filter {

	private final static String KEY_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
	private final static String VALUE_ALLOW_ORIGIN = "*";

	private final static String KEY_ALLOW_HEADERS = "Access-Control-Allow-Headers";		
	private final static String VALUE_ALLOW_HEADERS = "origin,accept,content-type,op,rc,Authorization,dv,d,X-Forwarded-For,browser,Locale,country,timezone";		

	private final static String KEY_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";
	private final static String VALUE_ALLOW_CREDENTIALS = "true";

	private final static String KEY_ALLOW_METHODS = "Access-Control-Allow-Methods";
	private final static String VALUE_ALLOW_TEST_METHODS = "GET,POST,PUT,DELETE,OPTIONS,HEAD";
	private final static String KEY_EXPOSE_HEADERS = "Access-Control-Expose-Headers";
	private final static String VALUE_EXPOSE_HEADERS = "Content-Disposition,Cache-Control,Content-Length,PSTAT,csStatus,csErrorCode,csErrorDesc";
	
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;

		response.addHeader(KEY_ALLOW_ORIGIN, VALUE_ALLOW_ORIGIN);
		response.addHeader(KEY_ALLOW_HEADERS, VALUE_ALLOW_HEADERS);		
		response.addHeader(KEY_ALLOW_CREDENTIALS, VALUE_ALLOW_CREDENTIALS);
		response.addHeader(KEY_ALLOW_METHODS, VALUE_ALLOW_TEST_METHODS);
		response.addHeader(KEY_EXPOSE_HEADERS, VALUE_EXPOSE_HEADERS);
		
		try {
			chain.doFilter(req, res);
		} finally {
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}
}
