package course.errorAndExceptions.classes;

import course.errorAndExceptions.enums.SubjectName;
import course.errorAndExceptions.exceptions.NoSuchScoreException;


public class SubjectAndScore {
    private SubjectName subjectName;
    private int subjectScore;

    public SubjectAndScore(SubjectName subjectName, int subjectScore) throws NoSuchScoreException {
        this.subjectName = subjectName;
        if (subjectScore > 10 || subjectScore < 0) {
            throw new NoSuchScoreException("check student`s score");
        }
        this.subjectScore = subjectScore;
    }

    public SubjectName getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(SubjectName subjectName) {
        this.subjectName = subjectName;
    }

    public int getSubjectScore() {
        return subjectScore;
    }

    public void setSubjectScore(int subjectScore) {
        this.subjectScore = subjectScore;
    }

    @Override
    public String toString() {
        return "SubjectAndScore{" +
                "subjectName=" + subjectName +
                ", subjectScore=" + subjectScore +
                '}';
    }
}
