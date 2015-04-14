package me.erp.interfaces.role.web;

import me.erp.application.security.CustomInvocationSecurityMetadataSource;
import me.erp.domain.model.permission.Permission;
import me.erp.domain.model.role.Role;
import me.erp.domain.service.NoFoundException;
import me.erp.domain.service.permission.IPermissionService;
import me.erp.domain.service.role.IRoleService;
import me.erp.infrastructure.persistence.hibernate.generic.Pagination;
import me.erp.interfaces.role.web.command.AuthorizationPermissionCommand;
import me.erp.interfaces.role.web.command.CreateRoleCommand;
import me.erp.interfaces.role.web.command.EditRoleCommand;
import me.erp.interfaces.role.web.command.ListCommand;
import me.erp.interfaces.shared.web.AlertMessage;
import me.erp.interfaces.shared.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

/**
 * Created by ivan_ on 2015/3/31.
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IPermissionService permissionService;

    @Autowired
    private CustomInvocationSecurityMetadataSource securityMetadataSource;

    @RequestMapping(value = "/list")
    public ModelAndView list(ListCommand command) throws Exception {
        Pagination<Role> pagination = roleService.pagination(command);
        return new ModelAndView("/role/list", "pagination", pagination);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() throws Exception {
        return new ModelAndView("/role/create");
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@Valid @ModelAttribute("role")CreateRoleCommand command,
                               RedirectAttributes redirectAttributes,
                               BindingResult bindingResult,
                               Locale locale) throws Exception {

        Role role = roleService.findByName(command.getRole());
        if (null != role) {
            bindingResult.rejectValue("role", "CreateRoleCommand.role.found", new Object[]{command.getRole()}, null);
        }
        if (bindingResult.hasErrors()) {
            return new ModelAndView("/role/create", "role", command);
        }

        roleService.create(command);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS,
                this.getMessage("default.create.success.message", new Object[]{command.getRole()}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/role/list");

    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) throws Exception {

        Role role;
        try {
            role = roleService.findById(id);
        } catch (NoFoundException e) {
            AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER, this.getMessage("default.noFoundId.message",
                    new Object[]{id}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            return new ModelAndView("redirect:/role/list");
        }

        return new ModelAndView("/role/edit", "role", role);

    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView edit(@Valid @ModelAttribute("role")EditRoleCommand command,
                               RedirectAttributes redirectAttributes,
                               BindingResult bindingResult,
                               Locale locale) throws Exception {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("/role/edit", "role", command);
        }

        AlertMessage alertMessage;
        try {
            roleService.edit(command);
            alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS, this.getMessage("default.edit.success.message",
                    new Object[]{command.getRole()}, locale));
        } catch (NoFoundException e) {
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER, this.getMessage("default.noFound.message",
                    new Object[]{command.getRole()}, locale));
        }

        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        return new ModelAndView("redirect:/role/list");

    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) throws Exception {

        AlertMessage alertMessage;
        try {
            roleService.delete(id);
            alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS, this.getMessage("default.delete.success.message",
                    new Object[]{id}, locale));
        } catch (NoFoundException e) {
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER, this.getMessage("default.noFoundId.message",
                    new Object[]{id}, locale));
        }

        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        return new ModelAndView("redirect:/role/list");

    }

    @RequestMapping(value = "/view/{id}")
    public ModelAndView view(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) throws Exception {

        Role role;
        try {
            role = roleService.findById(id, false, true);
        } catch (NoFoundException e) {
            AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER, this.getMessage("default.noFoundId.message",
                    new Object[]{id}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            return new ModelAndView("redirect:/role/list");
        }

        return new ModelAndView("/role/view", "role", role);

    }

    @RequestMapping(value = "/authorization/{id}", method = RequestMethod.GET)
    public ModelAndView authorization(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) throws Exception {

        List<Permission> permissions = permissionService.findAll();
        Role role;
        try {
            role = roleService.findById(id, false, true);
        } catch (NoFoundException e) {
            AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER, this.getMessage("default.noFoundId.message",
                    new Object[]{id}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            return new ModelAndView("redirect:/role/list");
        }

        return new ModelAndView("role/authorization", "permissions", permissions)
                .addObject("role", role);

    }

    @RequestMapping(value = "/authorization/{id}", method = RequestMethod.POST)
    public ModelAndView authorization(@ModelAttribute("role")AuthorizationPermissionCommand command,
                                   RedirectAttributes redirectAttributes,
                                   Locale locale) throws Exception {
        try {
            roleService.authorization(command);
        } catch (NoFoundException e) {
            AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER, this.getMessage("AuthorizationPermissionCommand.failed.message",
                    new Object[]{command.getRole()}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS, this.getMessage("AuthorizationPermissionCommand.success.message",
                new Object[]{command.getRole()}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        securityMetadataSource.flush();

        return new ModelAndView("redirect:/role/list");
    }

}
