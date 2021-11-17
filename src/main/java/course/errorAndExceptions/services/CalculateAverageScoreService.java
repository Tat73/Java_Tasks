package course.errorAndExceptions.services;

import course.errorAndExceptions.exceptions.*;
import course.errorAndExceptions.models.*;

import java.util.List;

public class CalculateAverageScoreService {

    public double getAverageScoreOfOneStudent(List<Student> studentList, String studentName) throws NoSuchSubjectException, NoSuchScoreException {
        double averageOfStudentScores = 0;

        for (Student student : studentList) {
            if (student.getStudentName().equalsIgnoreCase(studentName)) {
                averageOfStudentScores = student.getSubjectAndScoreList().stream().mapToDouble(SubjectAndScore::getSubjectScore)
                        .average()
                        .orElse(0);
            }
        }
        return Math.floor(averageOfStudentScores);
    }

    public double getAverageScoreOnCurrentSubjectGroupFaculty(List<Faculty> facultyList,
                                                                     SubjectName subjectName, GroupName groupName,
                                                                     FacultyName facultyName) throws NoSuchSubjectException, NoSuchFacultyInUniversityException, NoSuchGroupsOnThatFacultyException, NoStudentsInTheGroupException, NoSuchScoreException {
        double sumOfScore = 0;
        long scoreQuantity = 0;
        double averageScore = 0;

        for (Faculty faculty : facultyList) {
            if (faculty.getFacultyName().equals(facultyName)) {
                for (Group group : faculty.getGroupList()) {
                    if (group.getGroupName().equals(groupName)) {
                        for (Student student : group.getStudentList()) {
                            sumOfScore += student.getSubjectAndScoreList().stream()
                                    .filter(subjectAndScore -> subjectAndScore.getSubjectName().equals(subjectName))
                                    .mapToDouble(SubjectAndScore::getSubjectScore)
                                    .sum();
                            scoreQuantity += student.getSubjectAndScoreList().stream()
                                    .filter(subjectAndScore -> subjectAndScore.getSubjectName().equals(subjectName))
                                    .mapToDouble(SubjectAndScore::getSubjectScore)
                                    .count();
                        }
                        averageScore = sumOfScore / scoreQuantity;
                    }

                }
            }
        }
        return Math.floor(averageScore);
    }

    public double getAverageScoreOnCurrentSubjectForWholeUniversity(List<Faculty> facultyList, SubjectName subjectName) throws NoSuchSubjectException, NoSuchFacultyInUniversityException, NoSuchGroupsOnThatFacultyException, NoStudentsInTheGroupException, NoSuchScoreException {
        double sumOfScore = 0;
        long scoreQuantity = 0;
        double averageScore = 0;
        for (Faculty faculty : facultyList) {
            for (Group group : faculty.getGroupList()) {
                for (Student student : group.getStudentList()) {
                    sumOfScore = sumOfScore + student.getSubjectAndScoreList().stream()
                            .filter(subjectAndScore -> subjectAndScore.getSubjectName().equals(subjectName))
                            .mapToDouble(SubjectAndScore::getSubjectScore)
                            .sum();
                    scoreQuantity += student.getSubjectAndScoreList().stream()
                            .filter(subjectAndScore -> subjectAndScore.getSubjectName().equals(subjectName))
                            .mapToDouble(SubjectAndScore::getSubjectScore)
                            .count();
                }
                averageScore = sumOfScore / scoreQuantity;
            }

        }
        return Math.floor(averageScore);
    }
}
