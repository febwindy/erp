package me.erp.interfaces.teacher.web.command;

/**
 * Created by ivan_ on 2015/4/27.
 */
public class SelectSubjectCommand {

    private String id;
    private String teacherName;
    private String subjects;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }
}
