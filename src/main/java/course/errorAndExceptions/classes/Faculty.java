package course.errorAndExceptions.classes;

import course.errorAndExceptions.enums.FacultyName;
import course.errorAndExceptions.exceptions.NoSuchGroupsOnThatFaculty;

import java.util.ArrayList;
import java.util.List;


public class Faculty {
    private FacultyName facultyName;
    private List<Group> groupList = new ArrayList<>();

    public Faculty() {
    }

    public Faculty(FacultyName facultyName, List<Group> groupList) {
        this.facultyName = facultyName;
        this.groupList = groupList;
    }

    public void addGroupToFaculty(Group group) {
        this.groupList.add(group);
    }

    public FacultyName getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(FacultyName facultyName) {
        this.facultyName = facultyName;
    }

    public List<Group> getGroupList() throws NoSuchGroupsOnThatFaculty {
        if (groupList == null || groupList.isEmpty()) {
            throw new NoSuchGroupsOnThatFaculty("check if faculty has any group");
        }
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyName=" + facultyName +
                ", groupList=" + groupList +
                '}';
    }
}
