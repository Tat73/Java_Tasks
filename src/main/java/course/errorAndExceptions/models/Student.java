package course.errorAndExceptions.models;


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

    public List<SubjectAndScore> getSubjectAndScoreList() {
        if (subjectAndScoreList == null || subjectAndScoreList.isEmpty()) {
            try {
                throw new NoSuchSubjectException("check if student has subjects");
            } catch (NoSuchSubjectException e) {
                e.printStackTrace();
            }
        }
        for (SubjectAndScore subjectAndScore : subjectAndScoreList) {
            if (subjectAndScore.getSubjectScore() > 10 || subjectAndScore.getSubjectScore() < 0) {
                try {
                    throw new NoSuchScoreException("check student`s score");
                } catch (NoSuchScoreException e) {
                    System.out.println("Unable to get subjectList" + " " + e.getMessage());
                }
            }
        }
        return subjectAndScoreList;
    }

    public void setSubjectAndScoreList(List<SubjectAndScore> subjectAndScoreList) {
        this.subjectAndScoreList = subjectAndScoreList;
    }

    public void addSubjectAndScore(SubjectName subjectName, int subjectScore) {
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
