package me.erp.interfaces;

import me.erp.application.security.SaltUser;
import me.erp.domain.model.user.User;
import me.erp.domain.service.user.IUserService;
import me.erp.domain.service.verified.user.IUserVerifiedService;
import me.erp.interfaces.verified.web.user.command.CreateUserCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by _liwenhe on 2015/3/3.
 */
@Controller
public class IndexController {

    @Autowired
    private IUserVerifiedService userVerifiedService;

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/")
    public ModelAndView login() throws Exception {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (obj instanceof SaltUser) {
            return new ModelAndView("redirect:/index");
        }

        return new ModelAndView("/login");
    }

    @RequestMapping(value = "/index")
    public ModelAndView index() throws Exception {
        return new ModelAndView("/index");
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView signUp(@ModelAttribute("user")CreateUserCommand command) throws Exception {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (obj instanceof SaltUser) {
            return new ModelAndView("redirect:/index");
        }

        return new ModelAndView("/register", "user", command);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView signUp(@Valid @ModelAttribute("user")CreateUserCommand command,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) throws Exception {

        User repeatUser = userService.findByUsername(command.getUsername());
        if (null != repeatUser) {
            bindingResult.rejectValue("username", "CreateUserCommand.username.found",  new Object[]{command.getUsername()}, null);
        }

        if (!command.getPassword().equals(command.getConfirmPassword())) {
            bindingResult.rejectValue("confirmPassword", "CreateUserCommand.confirmPasswordAndPassword.NotEquals");
        }

        if (bindingResult.hasErrors()) {
            return new ModelAndView("/register", "user", command);
        }

        try {
            userVerifiedService.create(command);
        } catch (Exception e) {
            return new ModelAndView("/register", "user", command)
                    .addObject("message", "该用户名[" + command.getUsername() + "]已存在");
        }

        redirectAttributes.addFlashAttribute("success", "用户注册成功");

        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/about")
    public ModelAndView about() throws Exception {
        return new ModelAndView("/about");
    }

}
