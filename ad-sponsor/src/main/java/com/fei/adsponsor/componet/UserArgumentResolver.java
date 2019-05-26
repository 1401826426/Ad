package com.fei.adsponsor.componet;

import com.fei.adsponsor.constants.Constants;
import com.fei.adsponsor.vo.UserDto;
import com.fei.common.redis.RedisService;
import com.fei.common.redis.prefix.UserPrefix;
import com.fei.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Component
public class UserArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private RedisService redisService ;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().isAssignableFrom(UserDto.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest httpServletRequest = nativeWebRequest.getNativeRequest(HttpServletRequest.class) ;
        String token = httpServletRequest.getParameter(Constants.USER_TOKEN_HEADER) ;
        if(StringUtils.isBlank(token)){
            token = httpServletRequest.getHeader(Constants.USER_TOKEN_HEADER) ;
        }
        if(StringUtils.isBlank(token)){
            Cookie[] cookies = httpServletRequest.getCookies() ;
            if(cookies != null){
                for(Cookie cookie:cookies){
                    if(Constants.USER_TOKEN_HEADER.equals(cookie.getName())){
                        token = cookie.getValue() ;
                        break ;
                    }
                }
            }
        }
        if(StringUtils.isBlank(token)){
            return null ;
        }
        UserDto userDto = redisService.get(UserPrefix.getByToken,token,UserDto.class);
        if(userDto != null){
            redisService.set(UserPrefix.getByToken,token,userDto) ;
        }
        return userDto ;
    }
}










