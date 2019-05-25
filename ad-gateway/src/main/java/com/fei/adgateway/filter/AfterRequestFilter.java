package com.fei.adgateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

@Component
public class AfterRequestFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(AfterRequestFilter.class) ;

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER-1 ;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext() ;
        long startTime = (long) ctx.get(Constants.SYSTEM_TIME);
        long endTime = System.currentTimeMillis() - startTime ;
        logger.info("{}#{}",ctx.getRequest().getRequestURI(),endTime-startTime) ;
        return null;
    }
}
