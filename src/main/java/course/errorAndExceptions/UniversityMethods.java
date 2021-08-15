package course.errorAndExceptions;

import course.errorAndExceptions.classes.*;
import course.errorAndExceptions.enums.FacultyName;
import course.errorAndExceptions.enums.GroupName;
import course.errorAndExceptions.enums.SubjectName;
import course.errorAndExceptions.exceptions.*;


import java.util.Arrays;
import java.util.List;


public class UniversityMethods {

    public UniversityMethods() throws NoSuchSubjectException, NoSuchScoreException {
    }

    public static List<Student> createStudents() throws NoSuchScoreException, NoSuchSubjectException {

        Student student1 = new Student();
        student1.setStudentName("Cole");
        student1.addSubjectAndScore(SubjectName.ECONOMY, 5);
        student1.addSubjectAndScore(SubjectName.HISTORY, 9);


        Student student2 = new Student();
        student2.setStudentName("Ola");
        student2.addSubjectAndScore(SubjectName.ECONOMY, 10);
        student2.addSubjectAndScore(SubjectName.MATHS, 8);

        Student student3 = new Student();
        student3.setStudentName("Mary");
        student3.addSubjectAndScore(SubjectName.ECONOMY, 7);

        List<Student> studentList;
        studentList = Arrays.asList(student1, student2, student3);

        return studentList;
    }

    public static List<Group> createStudentGroup() throws NoSuchSubjectException, NoSuchScoreException {
        Group group1 = new Group();
        group1.setGroupName(GroupName.FIN);
        group1.addStudentToGroup(createStudents().get(0));
        group1.addStudentToGroup(createStudents().get(1));

        Group group2 = new Group();
        group2.setGroupName(GroupName.HIS);
        group2.addStudentToGroup(createStudents().get(2));

        List<Group> groupList;
        groupList = Arrays.asList(group1, group2);

        return groupList;
    }

    public static List<Faculty> createFacultiesWithGroups() throws NoSuchSubjectException, NoSuchScoreException {
        Faculty faculty1 = new Faculty();
        faculty1.setFacultyName(FacultyName.FINANCIAL);
        faculty1.addGroupToFaculty(createStudentGroup().get(0));

        Faculty faculty2 = new Faculty();
        faculty2.setFacultyName(FacultyName.HISTORICAL);
        faculty2.addGroupToFaculty(createStudentGroup().get(1));

        List<Faculty> facultyList;
        facultyList = Arrays.asList(faculty1, faculty2);

        return facultyList;
    }

    public static double getAverageScoreOfOneStudent(List<Student> studentList, String studentName) throws NoSuchSubjectException {
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

    public static double getAverageScoreOnCurrentSubjectGroupFaculty(University university,
                                                                     SubjectName subjectName, GroupName groupName,
                                                                     FacultyName facultyName) throws NoSuchSubjectException, NoSuchFacultyInUniversityException, NoSuchGroupsOnThatFaculty, NoStudentsInTheGroupException {
        double sumOfScore = 0;
        long scoreQuantity = 0;
        double averageScore = 0;

        for (Faculty faculty : university.getFacultyList()) {
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
                        averageScore = (double) (sumOfScore / scoreQuantity);
                    }

                }
            }
        }
        return Math.floor(averageScore);
    }

    public static double getAverageScoreOnCurrentSubjectForWholeUniversity(University university, SubjectName subjectName) throws NoSuchSubjectException, NoSuchFacultyInUniversityException, NoSuchGroupsOnThatFaculty, NoStudentsInTheGroupException {
        double sumOfScore = 0;
        long scoreQuantity = 0;
        double averageScore = 0;
        for (Faculty faculty : university.getFacultyList()) {
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
                averageScore = (double) (sumOfScore / scoreQuantity);
            }

        }
        return Math.floor(averageScore);
    }

}



