package course.errorAndExceptions.classes;


import course.errorAndExceptions.enums.GroupName;
import course.errorAndExceptions.exceptions.NoStudentsInTheGroupException;

import java.util.ArrayList;
import java.util.List;


public class Group {
    private GroupName groupName;
    private List<Student> studentList = new ArrayList<>();

    public Group() {
    }

    public Group(GroupName groupName, List<Student> studentList) {
        this.groupName = groupName;
        this.studentList = studentList;
    }

    public void addStudentToGroup(Student student) {
        this.studentList.add(student);
    }

    public GroupName getGroupName() {
        return groupName;
    }

    public void setGroupName(GroupName groupName) {
        this.groupName = groupName;
    }

    public List<Student> getStudentList() throws NoStudentsInTheGroupException {
        if (studentList == null || studentList.isEmpty()) {
            throw new NoStudentsInTheGroupException("check if that group has any students");
        }
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName=" + groupName +
                ", studentList=" + studentList +
                '}';
    }
}
