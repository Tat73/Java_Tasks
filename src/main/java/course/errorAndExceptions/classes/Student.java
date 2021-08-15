package course.errorAndExceptions.classes;


import course.errorAndExceptions.enums.SubjectName;
import course.errorAndExceptions.exceptions.NoSuchScoreException;
import course.errorAndExceptions.exceptions.NoSuchSubjectException;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentName;
    private List<SubjectAndScore> subjectAndScoreList = new ArrayList<>();

    public Student() {
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<SubjectAndScore> getSubjectAndScoreList() throws NoSuchSubjectException {
        if (subjectAndScoreList == null || subjectAndScoreList.isEmpty()) {
            throw new NoSuchSubjectException("check if student has subjects");
        }
        return subjectAndScoreList;
    }

    public void setSubjectAndScoreList(List<SubjectAndScore> subjectAndScoreList) {
        this.subjectAndScoreList = subjectAndScoreList;
    }

    public void addSubjectAndScore(SubjectName subjectName, int subjectScore) throws NoSuchSubjectException, NoSuchScoreException {
        this.subjectAndScoreList.add(new SubjectAndScore(subjectName, subjectScore));
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", subjectAndScoreList=" + subjectAndScoreList +
                '}';
    }
}
