package me.erp.interfaces.student.web.command;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by ivan_ on 2015/4/21.
 */
public class EditStudentCommand {

    private String id;

    @NotEmpty(message = "{EditStudentCommand.studentId.NotEmpty}")
    private String studentId;

    @NotEmpty(message = "{EditStudentCommand.studentName.NotEmpty}")
    private String studentName;

    @NotEmpty(message = "{EditStudentCommand.sex.NotEmpty}")
    private String sex;

    @NotEmpty(message = "{EditStudentCommand.birthDate.NotEmpty}")
    private String birthDate;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
