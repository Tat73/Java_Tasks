package course.errorAndExceptions.classes;

import course.errorAndExceptions.exceptions.NoSuchFacultyInUniversityException;

import java.util.List;

public class University {
    private List<Faculty> facultyList;

    public University(List<Faculty> facultyList) {
        this.facultyList = facultyList;
    }

    public List<Faculty> getFacultyList() throws NoSuchFacultyInUniversityException {
        if (facultyList == null || facultyList.isEmpty()) {
            throw new NoSuchFacultyInUniversityException("check university faculties");
        }
        return facultyList;
    }

    public void setFacultyList(List<Faculty> facultyList) {
        this.facultyList = facultyList;
    }

    @Override
    public String toString() {
        return "University{" +
                "facultyList=" + facultyList +
                '}';
    }
}
