package course.errorAndExceptions;

import course.errorAndExceptions.exceptions.NoSuchScoreException;
import course.errorAndExceptions.exceptions.NoSuchSubjectException;
import course.errorAndExceptions.models.Faculty;
import course.errorAndExceptions.models.FacultyName;
import course.errorAndExceptions.models.FacultyName;
import course.errorAndExceptions.models.Group;
import course.errorAndExceptions.models.GroupName;
import course.errorAndExceptions.models.GroupName;
import course.errorAndExceptions.models.Student;
import course.errorAndExceptions.models.SubjectName;
import course.errorAndExceptions.models.SubjectName;


import java.util.Arrays;
import java.util.List;


public class UniversityMethods {

    public static List<Student> createStudents() throws NoSuchScoreException, NoSuchSubjectException {

        Student student1 = new Student();
        student1.setStudentName("Cole");
        student1.addSubjectAndScore(SubjectName.ECONOMY, -5);
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


}



