package com.foamtec.service;

import com.foamtec.dao.AppUserDao;
import com.foamtec.domain.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by apichat on 1/19/2017 AD.
 */
@Service
public class AppUserService {

    @Autowired
    private AppUserDao appUserDao;

    public AppUser findByUsernameAndPassword(String username, String password) {
        return appUserDao.findByUsernameAndPassword(username, password);
    }
}
