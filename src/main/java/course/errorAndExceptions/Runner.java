package course.errorAndExceptions;

import course.errorAndExceptions.models.FacultyName;
import course.errorAndExceptions.models.GroupName;
import course.errorAndExceptions.models.SubjectName;
import course.errorAndExceptions.exceptions.NoStudentsInTheGroupException;
import course.errorAndExceptions.exceptions.NoSuchFacultyInUniversityException;
import course.errorAndExceptions.exceptions.NoSuchGroupsOnThatFacultyException;
import course.errorAndExceptions.exceptions.NoSuchScoreException;
import course.errorAndExceptions.exceptions.NoSuchSubjectException;
import course.errorAndExceptions.services.CalculateAverageScoreService;

public class Runner {
    public static void main(String[] args) {
        try {
            CalculateAverageScoreService service = new CalculateAverageScoreService();
            System.out.println("Average score for on student: " + service.getAverageScoreOfOneStudent(UniversityMethods.
                            createStudents(),
                    "Mary"));
            System.out.println("Average score for current faculty, group and subject: " +
                    service.getAverageScoreOnCurrentSubjectGroupFaculty(UniversityMethods.createFacultiesWithGroups(),
                            SubjectName.HISTORY, GroupName.FIN, FacultyName.FINANCIAL));
            System.out.println("Average score for current subject at whole university: " +
                    service.getAverageScoreOnCurrentSubjectForWholeUniversity(UniversityMethods.createFacultiesWithGroups(),
                            SubjectName.ECONOMY));
        } catch (NoSuchScoreException | NoSuchSubjectException | NoStudentsInTheGroupException |
                NoSuchGroupsOnThatFacultyException | NoSuchFacultyInUniversityException e) {
            e.printStackTrace();
        }
    }

}
