package me.erp.interfaces.teacher.web.command;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by ivan_ on 2015/4/21.
 */
public class CreateTeacherCommand {

    private String id;

    @NotEmpty(message = "{CreateTeacherCommand.teacherId.NotEmpty}")
    private String teacherId;

    @NotEmpty(message = "{CreateTeacherCommand.teacherName.NotEmpty}")
    private String teacherName;

    @NotEmpty(message = "{CreateTeacherCommand.sex.NotEmpty}")
    private String sex;

    @NotEmpty(message = "{CreateTeacherCommand.birthDate.NotEmpty}")
    private String birthDate;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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
