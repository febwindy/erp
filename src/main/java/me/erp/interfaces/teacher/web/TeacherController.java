package me.erp.interfaces.teacher.web;

import me.erp.domain.model.teacher.Teacher;
import me.erp.domain.service.NoFoundException;
import me.erp.domain.service.teacher.ITeacherService;
import me.erp.infrastructure.persistence.hibernate.generic.Pagination;
import me.erp.interfaces.shared.web.AlertMessage;
import me.erp.interfaces.shared.web.BaseController;
import me.erp.interfaces.teacher.web.command.CreateTeacherCommand;
import me.erp.interfaces.teacher.web.command.EditTeacherCommand;
import me.erp.interfaces.teacher.web.command.ListCommand;
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
import java.text.ParseException;
import java.util.Locale;

/**
 * Created by ivan_ on 2015/4/22.
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController extends BaseController {

    @Autowired
    private ITeacherService teacherService;

    @RequestMapping("/list")
    public ModelAndView list(@ModelAttribute("teacher")ListCommand command) throws Exception {
        Pagination<Teacher> pagination = teacherService.pagination(command);
        return new ModelAndView("/teacher/list", "pagination", pagination)
                .addObject("teacher", command);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create(@ModelAttribute("teacher")CreateTeacherCommand command) throws Exception{
        return new ModelAndView("/teacher/create", "teacher", command);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@Valid @ModelAttribute("teacher")CreateTeacherCommand command,
                               RedirectAttributes redirectAttributes,
                               BindingResult bindingResult,
                               Locale locale) throws Exception{

        AlertMessage alertMessage;

        Teacher teacher = teacherService.findByTeacherId(command.getTeacherId());

        if (null != teacher) {
            bindingResult.rejectValue("teacherId", "CreateTeacherCommand.teacherId.exist", new Object[]{command.getTeacherId()}, null);
        }

        if (bindingResult.hasErrors()) {
            return new ModelAndView("/teacher/create", "teacher", command);
        }

        try {
            teacherService.create(command);

            alertMessage = new AlertMessage(this.getMessage("default.create.success.message", new Object[]{command.getTeacherId()}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        } catch (ParseException e) {
            alertMessage = new AlertMessage(this.getMessage("default.create.failed.message", new Object[]{command.getTeacherId()}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }

        return new ModelAndView("redirect:/teacher/list");
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) throws Exception{

        AlertMessage alertMessage;
        Teacher teacher;

        try {
            teacher = teacherService.findById(id);
        } catch (NoFoundException e) {
            alertMessage = new AlertMessage(this.getMessage("default.noFoundId.message", new Object[]{id}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

            return new ModelAndView("redirect:/teacher/list");
        }

        return new ModelAndView("/teacher/edit", "teacher", teacher);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView edit(@Valid @ModelAttribute("teacher")EditTeacherCommand command,
                             RedirectAttributes redirectAttributes,
                             BindingResult bindingResult,
                             Locale locale) throws Exception {

        AlertMessage alertMessage;

        Teacher teacher = teacherService.findByTeacherId(command.getTeacherId());

        if (null != teacher && !teacher.getId().equals(command.getId())) {
            bindingResult.rejectValue("teacherId", "EditTeacherCommand.teacherId.exist", new Object[]{command.getTeacherId()}, null);
        }

        if (bindingResult.hasErrors()) {
            return new ModelAndView("/teacher/edit", "teacher", command);
        }

        try {

            teacherService.edit(command);

            alertMessage = new AlertMessage(this.getMessage("default.edit.success.message", new Object[]{command.getId()}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        } catch (NoFoundException e) {
            alertMessage = new AlertMessage(this.getMessage("default.noFoundId.message", new Object[]{command.getId()}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        } catch (ParseException e) {
            alertMessage = new AlertMessage(this.getMessage("default.create.failed.message", new Object[]{command.getTeacherId()}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }

        return new ModelAndView("redirect:/teacher/list");
    }

    @RequestMapping(value = "/view/{id}")
    public ModelAndView view(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) throws Exception {

        AlertMessage alertMessage;
        Teacher teacher;

        try {
            teacher = teacherService.findById(id);
        } catch (NoFoundException e) {
            alertMessage = new AlertMessage(this.getMessage("default.noFoundId.message", new Object[]{id}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

            return new ModelAndView("redirect:/teacher/list");
        }

        return new ModelAndView("/teacher/view", "teacher", teacher);
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) throws Exception {

        AlertMessage alertMessage;

        try {
            teacherService.delete(id);
        } catch (NoFoundException e) {
            alertMessage = new AlertMessage(this.getMessage("default.noFoundId.message", new Object[]{id}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }
        return new ModelAndView("redirect:/teacher/list");
    }

}
