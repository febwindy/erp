package me.erp.interfaces.permission.web;

import me.erp.domain.model.permission.Permission;
import me.erp.domain.service.NoFoundException;
import me.erp.domain.service.permission.IPermissionService;
import me.erp.infrastructure.persistence.hibernate.generic.Pagination;
import me.erp.interfaces.permission.web.command.CreatePermissionCommand;
import me.erp.interfaces.permission.web.command.EditPermissionCommand;
import me.erp.interfaces.permission.web.command.ListCommand;
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
import java.util.Locale;

/**
 * Created by ivan_ on 2015/3/31.
 */
@Controller
@RequestMapping("/permission")
public class PermissionController extends BaseController {

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping(value = "/list")
    public ModelAndView list(ListCommand command) throws Exception {
        Pagination<Permission> pagination = permissionService.pagination(command);
        return new ModelAndView("/permission/list", "pagination", pagination);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() throws Exception {
        return new ModelAndView("/permission/create");
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@Valid @ModelAttribute("permission")CreatePermissionCommand command,
                               RedirectAttributes redirectAttributes,
                               BindingResult bindingResult,
                               Locale locale) throws Exception {

        Permission permission = permissionService.findByName(command.getResource());
        if (null != permission) {
            bindingResult.rejectValue("resource", "CreatePermissionCommand.resource.found", new Object[]{command.getResource()}, null);
        }
        if (bindingResult.hasErrors()) {
            return new ModelAndView("/permission/create", "permission", command);
        }

        permissionService.create(command);

        AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS,
                this.getMessage("default.create.success.message", new Object[]{command.getResource()}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/permission/list");

    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) throws Exception {

        Permission permission;
        try {
            permission = permissionService.findById(id);
        } catch (NoFoundException e) {
            AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER, this.getMessage("default.noFoundId.message",
                    new Object[]{id}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            return new ModelAndView("redirect:/permission/list");
        }

        return new ModelAndView("/permission/edit", "permission", permission);

    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView edit(@Valid @ModelAttribute("permission")EditPermissionCommand command,
                             RedirectAttributes redirectAttributes,
                             BindingResult bindingResult,
                             Locale locale) throws Exception {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("/permission/edit", "permission", command);
        }

        AlertMessage alertMessage;
        try {
            permissionService.edit(command);
            alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS, this.getMessage("default.edit.success.message",
                    new Object[]{command.getResource()}, locale));
        } catch (NoFoundException e) {
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER, this.getMessage("default.noFound.message",
                    new Object[]{command.getResource()}, locale));
        }

        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        return new ModelAndView("redirect:/permission/list");

    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) throws Exception {

        AlertMessage alertMessage;
        try {
            permissionService.delete(id);
            alertMessage = new AlertMessage(AlertMessage.MessageType.SUCCESS, this.getMessage("default.delete.success.message",
                    new Object[]{id}, locale));
        } catch (NoFoundException e) {
            alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER, this.getMessage("default.noFoundId.message",
                    new Object[]{id}, locale));
        }

        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        return new ModelAndView("redirect:/permission/list");

    }

    @RequestMapping(value = "/view/{id}")
    public ModelAndView view(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) throws Exception {

        Permission permission;
        try {
            permission = permissionService.findById(id);
        } catch (NoFoundException e) {
            AlertMessage alertMessage = new AlertMessage(AlertMessage.MessageType.DANGER, this.getMessage("default.noFoundId.message",
                    new Object[]{id}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
            return new ModelAndView("redirect:/permission/list");
        }

        return new ModelAndView("/permission/view", "permission", permission);

    }

}
