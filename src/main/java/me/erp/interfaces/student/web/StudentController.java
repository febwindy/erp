package me.erp.interfaces.student.web;

import me.erp.domain.model.student.Student;
import me.erp.domain.service.ExistException;
import me.erp.domain.service.NoFoundException;
import me.erp.domain.service.student.IStudentService;
import me.erp.infrastructure.persistence.hibernate.generic.Pagination;
import me.erp.interfaces.shared.web.AlertMessage;
import me.erp.interfaces.shared.web.BaseController;
import me.erp.interfaces.student.web.command.CreateStudentCommand;
import me.erp.interfaces.student.web.command.EditStudentCommand;
import me.erp.interfaces.student.web.command.ListCommand;
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
 * Created by ivan_ on 2015/4/21.
 */
@Controller
@RequestMapping("/student")
public class StudentController extends BaseController {

    @Autowired
    private IStudentService studentService;

    @RequestMapping("/list")
    public ModelAndView list(@ModelAttribute("student")ListCommand command) throws ExistException {
        Pagination<Student> pagination = studentService.pagination(command);
        return new ModelAndView("/student/list", "pagination", pagination)
                .addObject("student", command);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create(@ModelAttribute("student")CreateStudentCommand command) throws Exception{
        return new ModelAndView("/student/create", "student", command);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@Valid @ModelAttribute("student")CreateStudentCommand command,
                               RedirectAttributes redirectAttributes,
                               BindingResult bindingResult,
                               Locale locale) throws Exception{

        AlertMessage alertMessage;

        Student student = studentService.findByStudentId(command.getStudentId());

        if (null != student) {
            bindingResult.rejectValue("studentId", "CreateStudentCommand.studentId.exist", new Object[]{command.getStudentId()}, null);
        }

        if (bindingResult.hasErrors()) {
            return new ModelAndView("/student/create", "student", command);
        }

        try {
            studentService.create(command);

            alertMessage = new AlertMessage(this.getMessage("default.create.success.message", new Object[]{command.getStudentId()}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        } catch (ParseException e) {
            alertMessage = new AlertMessage(this.getMessage("default.create.failed.message", new Object[]{command.getStudentId()}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }

        return new ModelAndView("redirect:/student/list");
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) throws Exception{

        AlertMessage alertMessage;
        Student student;

        try {
            student = studentService.findById(id);
        } catch (NoFoundException e) {
            alertMessage = new AlertMessage(this.getMessage("default.noFoundId.message", new Object[]{id}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

            return new ModelAndView("redirect:/student/list");
        }

        return new ModelAndView("/student/edit", "student", student);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ModelAndView edit(@Valid @ModelAttribute("student")EditStudentCommand command,
                             RedirectAttributes redirectAttributes,
                             BindingResult bindingResult,
                             Locale locale) throws ExistException {

        AlertMessage alertMessage;

        Student student = studentService.findByStudentId(command.getStudentId());

        if (null != student && !student.getId().equals(command.getId())) {
            bindingResult.rejectValue("studentId", "EditStudentCommand.studentId.exist", new Object[]{command.getStudentId()}, null);
        }

        if (bindingResult.hasErrors()) {
            return new ModelAndView("/student/edit", "student", command);
        }

        try {

            studentService.edit(command);

            alertMessage = new AlertMessage(this.getMessage("default.edit.success.message", new Object[]{command.getId()}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

        } catch (NoFoundException e) {
            alertMessage = new AlertMessage(this.getMessage("default.noFoundId.message", new Object[]{command.getId()}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        } catch (ParseException e) {
            alertMessage = new AlertMessage(this.getMessage("default.create.failed.message", new Object[]{command.getStudentId()}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }

        return new ModelAndView("redirect:/student/list");
    }

    @RequestMapping(value = "/view/{id}")
    public ModelAndView view(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) throws ExistException {

        AlertMessage alertMessage;
        Student student;

        try {
            student = studentService.findById(id);
        } catch (NoFoundException e) {
            alertMessage = new AlertMessage(this.getMessage("default.noFoundId.message", new Object[]{id}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);

            return new ModelAndView("redirect:/student/list");
        }

        return new ModelAndView("/student/view", "student", student);
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable String id, RedirectAttributes redirectAttributes, Locale locale) throws ExistException {

        AlertMessage alertMessage;

        try {
            studentService.delete(id);
        } catch (NoFoundException e) {
            alertMessage = new AlertMessage(this.getMessage("default.noFoundId.message", new Object[]{id}, locale));
            redirectAttributes.addFlashAttribute(AlertMessage.MODEL_ATTRIBUTE_KEY, alertMessage);
        }
        return new ModelAndView("redirect:/student/list");
    }
}
