package com.imooc.apigateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpServerConnection;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @ClassName TokenFilter$
 * @Description TODO
 * @Author ZSH9440$
 * @Date 2019/5/20$ 14:13$
 * @Version 1.1
 **/
@Component
public class TokenFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER -1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext= RequestContext.getCurrentContext();
        HttpServletRequest request =requestContext.getRequest();
        //url参数中获得
       String token= request.getParameter("token");
       if (StringUtils.isEmpty(token)){
           requestContext.setSendZuulResponse(false);
           requestContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
       }
        return null;
    }
}
