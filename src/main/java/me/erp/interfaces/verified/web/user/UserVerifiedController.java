package me.erp.interfaces.verified.web.user;

import me.erp.domain.model.verified.user.UserVerified;
import me.erp.domain.service.user.IUserService;
import me.erp.domain.service.verified.user.IUserVerifiedService;
import me.erp.infrastructure.persistence.hibernate.generic.Pagination;
import me.erp.interfaces.shared.web.AlertMessage;
import me.erp.interfaces.shared.web.BaseController;
import me.erp.interfaces.user.web.command.CreateUserCommand;
import me.erp.interfaces.verified.web.user.command.ListCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Locale;

/**
 * Created by ivan_ on 2015/4/10.
 */
@Controller
@RequestMapping("/user/verified")
public class UserVerifiedController extends BaseController {

    @Autowired
    private IUserVerifiedService userVerifiedService;

    @Autowired
    private IUserService userService;

    @RequestMapping("/list")
    public ModelAndView list(ListCommand command) throws Exception {
        Pagination<UserVerified> pagination = userVerifiedService.pagination(command);
        return new ModelAndView("/verified/user/list", "pagination", pagination);
    }

    @RequestMapping("/ok/{id}")
    public ModelAndView list(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) throws Exception {

        AlertMessage alertMessage;

        try {
            UserVerified userVerified = userVerifiedService.findById(id);

            String sex = userVerified.getSex() ? "1" : "0";

            CreateUserCommand command = new CreateUserCommand();
            command.setUsername(userVerified.getUsername());
            command.setRealName(userVerified.getRealName());
            command.setPassword(userVerified.getPassword());
            command.setConfirmPassword(userVerified.getPassword());
            command.setEmail(userVerified.getEmail());
            command.setTelephone(userVerified.getTelephone());
            command.setIdCard(userVerified.getIdCard());
            command.setSex(sex);
            command.setOrganization(userVerified.getOrganization());
            command.setRemark(userVerified.getRemark());

            userService.create(command);

            userVerifiedService.delete(id);

            alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS, this.getMessage("UserVerified.auth.ok",
                    new Object[]{id}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        } catch (Exception e) {
            alertMessage = new AlertMessage(AlertMessage.MessageType.WARNING, this.getMessage("default.noFoundId.message",
                    new Object[]{id}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }

        return new ModelAndView("redirect:/user/verified/list");
    }
}
