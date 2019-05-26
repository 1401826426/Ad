package com.fei.adsponsor.service.impl;

import com.fei.adsponsor.constants.Constants;
import com.fei.adsponsor.entity.AdUser;
import com.fei.adsponsor.repository.AdUserRepository;
import com.fei.adsponsor.service.IUserService;
import com.fei.adsponsor.util.DigestUtil;
import com.fei.adsponsor.vo.UserDto;
import com.fei.common.CodeMsg;
import com.fei.common.exception.GlobalException;
import com.fei.common.redis.RedisService;
import com.fei.common.redis.prefix.UserPrefix;
import com.fei.common.util.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

@Service
public class UserService implements IUserService {

    @Autowired
    private AdUserRepository userRepository ;

    @Autowired
    private RedisService redisService ;

    @Override
    @Transactional
    public UserDto createUser(String username) {
        if (StringUtils.isBlank(username)) {
            throw new GlobalException(CodeMsg.NO_USER_NAME) ;
        }
        AdUser oldUser = userRepository.findByUsername(username) ;
        if(oldUser != null){
            throw new GlobalException(CodeMsg.USER_HAS_CREATED) ;
        }
        AdUser user = new AdUser(username,username) ;
        userRepository.save(user) ;
        UserDto userDto = new UserDto() ;
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    @Override
    @Transactional
    public UserDto login(HttpServletResponse response,String username) {
        if (StringUtils.isBlank(username)) {
            throw new GlobalException(CodeMsg.NO_USER_NAME) ;
        }
        AdUser user = userRepository.findByUsername(username) ;
        UserDto userDto = null ;
        if(user == null){
            userDto = createUser(username) ;
        }else{
            userDto = new UserDto() ;
            BeanUtils.copyProperties(user, userDto);
        }
        String token = DigestUtil.generateUserToken(String.valueOf(userDto.getId())) ;
        redisService.set(UserPrefix.getByToken,token,userDto) ;
        Cookie cookie = new Cookie(Constants.USER_TOKEN_HEADER,token) ;
        response.addCookie(cookie);
        return userDto;
    }


}

















