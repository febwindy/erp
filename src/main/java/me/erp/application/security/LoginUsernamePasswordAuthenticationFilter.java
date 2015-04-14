package me.erp.application.security;

import me.erp.domain.model.user.User;
import me.erp.domain.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by _liwenhe on 2015/3/5.
 */
public class LoginUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private IUserService userService;

    private boolean postOnly = true;

    private Md5PasswordEncoder md5PasswordEncoder;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if(this.postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        } else {
            String username = this.obtainUsername(request);
            String password = this.obtainPassword(request);
            if(null == username) {
                username = "";
            }

            if(null == password) {
                password = "";
            }

            username = username.trim();
            User user = userService.findByUsername(username);
            if (null == user) {
                throw new UsernameNotFoundException("用户名[" + username + "]不存在.");
            } else {
                if (!md5PasswordEncoder.isPasswordValid(user.getPassword(), password, user.getSalt())) {
                    throw new BadCredentialsException("密码不正确.");
                }
            }

            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
            this.setDetails(request, authRequest);
            return this.getAuthenticationManager().authenticate(authRequest);
        }
    }

    public void setMd5PasswordEncoder(Md5PasswordEncoder md5PasswordEncoder) {
        this.md5PasswordEncoder = md5PasswordEncoder;
    }
}
