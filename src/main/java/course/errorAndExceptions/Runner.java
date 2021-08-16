package course.errorAndExceptions;

import course.errorAndExceptions.classes.University;
import course.errorAndExceptions.enums.FacultyName;
import course.errorAndExceptions.enums.GroupName;
import course.errorAndExceptions.enums.SubjectName;
import course.errorAndExceptions.exceptions.*;


import static course.errorAndExceptions.UniversityMethods.*;

public class Runner {
    public static void main(String[] args) {
        try {
            University university = new University(createFacultiesWithGroups());
            System.out.println("Average score for on student: " + getAverageScoreOfOneStudent(createStudents(),
                    "Cole"));
            System.out.println("Average score for current faculty, group and subject: " +
                    getAverageScoreOnCurrentSubjectGroupFaculty(university, SubjectName.HISTORY, GroupName.FIN, FacultyName.FINANCIAL));
            System.out.println("Average score for current subject at whole university: " +
                    getAverageScoreOnCurrentSubjectForWholeUniversity(university, SubjectName.ENGLISH));
        } catch (NoSuchScoreException | NoSuchSubjectException | NoStudentsInTheGroupException |
                NoSuchGroupsOnThatFaculty | NoSuchFacultyInUniversityException e) {
            e.printStackTrace();
        }
    }

}
