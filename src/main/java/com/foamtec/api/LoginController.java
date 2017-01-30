package com.foamtec.api;

import com.foamtec.domain.AppUser;
import com.foamtec.service.AppUserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by apichat on 1/19/2017 AD.
 */
@CrossOrigin(origins = "*")
@RestController
public class LoginController {

    @Autowired
    private AppUserService appUserService;

    private String SECRET_KEY = "ASDFZXCVBYUIJHGLOIUTGFEDSWE";

    @RequestMapping(value = "/login", method = RequestMethod.POST, headers = "Content-Type=Application/json")
    public LoginResponse login(@RequestBody final UserLogin login) throws ServletException {

        AppUser user = appUserService.findByUsernameAndPassword(login.username, login.password);

        if (user == null) {
            throw new ServletException("Invalid login");
        }

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, 2);
        Date tokenExpiredDate = c.getTime();

        return new LoginResponse("Bearer " + Jwts.builder()
                .setSubject(login.username)
                .claim("role", user.getRoleName())
                .claim("tokenExpiredDate", tokenExpiredDate)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact(), user.getName(), user.getRoleName());
    }

    @SuppressWarnings("unused")
    private static class UserLogin {
        public String username;
        public String password;
    }

    @SuppressWarnings("unused")
    private static class LoginResponse {
        public String token;
        public String name;
        public String role;
        public LoginResponse(final String token, final String name, final String role) {
            this.token = token;
            this.name = name;
            this.role = role;
        }
    }
}
