package com.test.springcloud.filter;

import java.nio.charset.Charset;
import java.util.Base64;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class AuthorizedRequestFilter extends ZuulFilter{
	@Override
    public String filterType() {
		//这里是做权限验证，所以在调用前进行设置认证
        return FilterConstants.PRE_TYPE;
    }
    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
    	//设置开启此过滤
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext() ; // 获取当前请求的上下文
        // 认证的信息，zuul路由调其他微服务时，需要先经过spring-security的认证
        String auth = "sec-admin:sec-admin"; 
        byte[] encodedAuth = Base64.getEncoder().encode(
        		auth.getBytes(Charset.forName("US-ASCII"))); // 进行一个加密的处理
        String authHeader = "Basic " + new String(encodedAuth);
        currentContext.addZuulRequestHeader("Authorization", authHeader);
        return null;
    }

}
