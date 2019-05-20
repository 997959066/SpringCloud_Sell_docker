package com.imooc.apigateway;

import com.google.common.util.concurrent.RateLimiter;
import com.imooc.apigateway.exception.RateLimitException;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

/**
 * @ClassName AuthFilter$
 * @Description TODO
 * @Author ZSH9440$
 * @Date 2019/5/20$ 14:44$
 * @Version 1.1
 **/
@Component
public class AuthFilter extends ZuulFilter {



    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return SERVLET_DETECTION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext= RequestContext.getCurrentContext();
        HttpServletRequest request =requestContext.getRequest();
        /**
         /order/create 只能买家访问
         /order/finish只能卖家访问
         /product/list 都可以访问
         */
        return null;
    }


}
