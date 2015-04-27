package me.erp.interfaces.student.web.command;

/**
 * Created by ivan_ on 2015/4/27.
 */
public class SelectSubjectCommand {

    private String id;
    private String studentName;
    private String teachers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getTeachers() {
        return teachers;
    }

    public void setTeachers(String teachers) {
        this.teachers = teachers;
    }
}
