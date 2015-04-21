package me.erp.interfaces.subject.web.command;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by ivan_ on 2015/4/21.
 */
public class EditSubjectCommand {

    private String id;

    @NotEmpty(message = "{EditSubjectCommand.subjectId.NotEmpty}")
    private String subjectId;

    @NotEmpty(message = "{EditSubjectCommand.subjectName.NotEmpty}")
    private String subjectName;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
