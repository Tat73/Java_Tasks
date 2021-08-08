/*
1. Student: id, Фамилия, Имя, Отчество, Дата рождения, Адрес, Телефон, Факультет, Курс, Группа.

Создать массив объектов. Вывести:

a) список студентов заданного факультета;

b) списки студентов для каждого факультета и курса;

c) список студентов, родившихся после заданного года;

d) список учебной группы.
 */

package course.classes;

import course.classes.information.Student;

import java.util.Arrays;
import java.util.List;


public class MainTask {
    public static void main(String[] args) {

        List<Student> studentsList = createStudents();

        filterStudentsByFaculty(studentsList, "Исторический");
        filterStudentsByFacultyAndCourse(studentsList, "Экономический", 4);
        filterStudentsWereBornAfterCurrentYear(studentsList, 2000);
        filterStudentsByGroup(studentsList, "Э2017");

    }

    public static List<Student> createStudents() {

        return Arrays.asList(
                new Student(1, "Иванов", "Иван", "Иванович", 2000,
                        "Беларусь, Минск", "375291111111", "Исторический", 2, "И2019"),
                new Student(2, "Васильев", "Василий", "Васильевич",
                        1982, "Беларусь, Гомель", "375291112211",
                        "Архитектурный", 4, "А2017"),
                new Student(3, "Борисов", "Борис", "Борисович",
                        2003, "Беларусь, Минск", "375291111122",
                        "Биологический", 1, "Б2020"),
                new Student(4, "Семенов", "Семен", "Семенович",
                        1999, "Беларусь, Минск", "375178888888",
                        "Филологический", 4, "Ф2017"),
                new Student(5, "Александров", "Александр", "Александрович",
                        1999, "Беларусь, Минск", "375291111122",
                        "Биологический", 3, "Б2018"),
                new Student(6, "Валенинова", "Валентина", "Валентиновна",
                        1999, "Беларусь, Гродно", "375331111133",
                        "Экономический", 4, "Э2017"),
                new Student(7, "Васильева", "Анастасия", "Васильевна",
                        2000, "Беларусь, Минск", "375291113355",
                        "Филологический", 1, "Ф2020"),
                new Student(8, "Борисова", "Анжела", "Борисовна",
                        2005, "Беларусь, Минск", "375291114466",
                        "Архитектурный", 1, "Б2020"),
                new Student(9, "Сергеенко", "Сергей", "Сергеевич",
                        2005, "Беларусь, Мозырь", "375291115577",
                        "Математический", 3, "Б2018"),
                new Student(10, "Иванова", "Мальвина", "Ивановна",
                        2000, "Беларусь, Минск", "375291152122",
                        "Экономический", 4, "Б2017"),
                new Student(11, "Степанов", "Степан", "Степанович",
                        2000, "Беларусь, Минск", "375292252122",
                        "Экономический", 2, "Б2016"),
                new Student(12, "Иваненко", "Иван", "Иванович", 2004,
                        "Беларусь, Минск", "375295551111", "Исторический", 2, "И2019"),
                new Student(13, "Василенко", "Василий", "Васильевич",
                        1983, "Беларусь, Гомель", "375297782211",
                        "Архитектурный", 4, "А2017")
        );
    }

    public static void filterStudentsByFaculty(List<Student> studentsList, String faculty) {
        System.out.println("Filter students by faculty: ");
        for (Student student : studentsList) {
            if (student.getFaculty().equals(faculty)) {
                System.out.println(student);
            }
        }
        System.out.println();
    }

    public static void filterStudentsByFacultyAndCourse(List<Student> studentsList, String faculty, int course) {
        System.out.println("Filter students by faculty and course: ");
        for (Student student : studentsList) {
            if (student.getFaculty().equals(faculty) && (student.getCourse() == course)) {
                System.out.println(student);
            }
        }
        System.out.println();
    }

    public static void filterStudentsWereBornAfterCurrentYear(List<Student> studentsList, int yearOfBirth) {
        System.out.println("Filter students by year of birth: ");
        for (Student student : studentsList) {
            if (student.getYearOfBirthday() > yearOfBirth) {
                System.out.println(student);
            }
        }
        System.out.println();
    }

    public static void filterStudentsByGroup(List<Student> studentsList, String group) {
        System.out.println("Filter students by group: ");
        for (Student student : studentsList) {
            if (student.getGroup().equals(group)) {
                System.out.println(student);
            }
        }
    }

}









