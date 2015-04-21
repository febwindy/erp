package me.erp.interfaces.subject.web;

import me.erp.domain.model.subject.Subject;
import me.erp.domain.service.ExistException;
import me.erp.domain.service.NoFoundException;
import me.erp.domain.service.subject.ISubjectService;
import me.erp.domain.service.user.IUserService;
import me.erp.infrastructure.persistence.hibernate.generic.Pagination;
import me.erp.interfaces.shared.web.AlertMessage;
import me.erp.interfaces.shared.web.BaseController;
import me.erp.interfaces.subject.web.command.CreateSubjectCommand;
import me.erp.interfaces.subject.web.command.EditSubjectCommand;
import me.erp.interfaces.subject.web.command.ListCommand;
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
 * Created by ivan_ on 2015/4/20.
 */
@Controller
@RequestMapping("/subject")
public class SubjectController extends BaseController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ISubjectService subjectService;

    @RequestMapping("/list")
    public ModelAndView list(@ModelAttribute("subject")ListCommand command) throws Exception {
        Pagination<Subject> pagination = subjectService.pagination(command);
        return new ModelAndView("/subject/list", "pagination", pagination).addObject("subject", command);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create(@ModelAttribute("subject")CreateSubjectCommand command) throws Exception{
        return new ModelAndView("/subject/create", "subject", command);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@Valid @ModelAttribute("subject")CreateSubjectCommand command,
                               RedirectAttributes redirectAttributes,
                               BindingResult bindingResult,
                               Locale locale) throws Exception{

        int count = subjectService.countBySubjectId(command.getSubjectId());

        if (count >= 1) {
            bindingResult.rejectValue("subjectId", "CreateSubjectCommand.subjectId.exist", new Object[]{command.getSubjectId()}, null);
        }

        if (bindingResult.hasErrors()) {
            return new ModelAndView("/subject/create", "subject", command);
        }

        subjectService.create(command);

        AlertMessage alertMessage = new AlertMessage(this.getMessage("default.create.success.message", new Object[]{command.getSubjectId()}, locale));
        redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        return new ModelAndView("redirect:/subject/list");
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) throws ExistException {

        AlertMessage alertMessage;
        Subject subject;

        try {
            subject = subjectService.findById(id);
        } catch (NoFoundException e) {
            alertMessage = new AlertMessage(this.getMessage("default.noFoundId.message", new Object[]{id}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

            return new ModelAndView("redirect:/subject/list");
        }

        return new ModelAndView("/subject/edit", "subject", subject);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView edit(@Valid @ModelAttribute("subject")EditSubjectCommand command,
                             RedirectAttributes redirectAttributes,
                             BindingResult bindingResult,
                             Locale locale) throws ExistException {

        AlertMessage alertMessage;

        Subject subject = subjectService.findBySubjectId(command.getSubjectId());

        if (null != subject && !subject.getId().equals(command.getId())) {
            bindingResult.rejectValue("subjectId", "CreateSubjectCommand.subjectId.exist", new Object[]{command.getSubjectId()}, null);
        }

        if (bindingResult.hasErrors()) {
            return new ModelAndView("/subject/edit", "subject", command);
        }

        try {

            subjectService.edit(command);

            alertMessage = new AlertMessage(this.getMessage("default.edit.success.message", new Object[]{command.getId()}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        } catch (NoFoundException e) {
            alertMessage = new AlertMessage(this.getMessage("default.noFoundId.message", new Object[]{command.getId()}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }

        return new ModelAndView("redirect:/subject/list");
    }

    @RequestMapping(value = "/view/{id}")
    public ModelAndView view(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) throws ExistException {

        AlertMessage alertMessage;
        Subject subject;

        try {
            subject = subjectService.findById(id);
        } catch (NoFoundException e) {
            alertMessage = new AlertMessage(this.getMessage("default.noFoundId.message", new Object[]{id}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

            return new ModelAndView("redirect:/subject/list");
        }

        return new ModelAndView("/subject/view", "subject", subject);
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) throws ExistException {

        AlertMessage alertMessage;

        try {
            subjectService.delete(id);
        } catch (NoFoundException e) {
            alertMessage = new AlertMessage(this.getMessage("default.noFoundId.message", new Object[]{id}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }
        return new ModelAndView("redirect:/subject/list");
    }
}
