package me.erp.interfaces.auth.web;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by _liwenhe on 2015/3/4.
 */
@Controller
@RequestMapping(value = "/auth")
public class AuthorizationController {

    @RequestMapping(value = "/login")
    public ModelAndView login() throws Exception {
        return new ModelAndView("redirect:/index");
    }

    @RequestMapping(value = "/failed")
    public ModelAndView failed(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        String message = null;

        Object obj = request.getSession(false).getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        if (obj instanceof UsernameNotFoundException) {
            message = ((UsernameNotFoundException) obj).getMessage();
        }

        if (obj instanceof BadCredentialsException) {
            message = ((BadCredentialsException) obj).getMessage();
        }

        redirectAttributes.addFlashAttribute("error", message);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/denied")
    public ModelAndView denied() throws Exception {
        return new ModelAndView("redirect:/");
    }

}
