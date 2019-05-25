package com.fei.adsponsor.service.impl;

import com.fei.adsponsor.entity.AdUser;
import com.fei.adsponsor.repository.AdUserRepository;
import com.fei.adsponsor.service.IUserService;
import com.fei.adsponsor.vo.UserDto;
import com.fei.common.CodeMsg;
import com.fei.common.exception.GlobalException;
import com.fei.common.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private AdUserRepository userRepository ;

    @Override
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


}

















