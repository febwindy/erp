package me.erp.interfaces.subject.web.command;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by ivan_ on 2015/4/21.
 */
public class CreateSubjectCommand {

    @NotEmpty(message = "{CreateSubjectCommand.subjectId.NotEmpty}")
    private String subjectId;

    @NotEmpty(message = "{CreateSubjectCommand.subjectName.NotEmpty}")
    private String subjectName;

    private String remark;

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
