package controller;

import View.StudentView;
import model.*;
import service.DataService;
import service.StudyGroupService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Controller {

    private final DataService service = new DataService();

    private final StudentView view = new StudentView();

    private StudyGroupService studyGroupService = new StudyGroupService();

    public void createStudent(String firstName, String lastName, String middleName) {
        service.create(firstName, lastName, middleName, Type.STUDENT);
    }

    public void getAllStudent(){
        List<User> userList = service.getAllStudent();
        for (User user : userList) {
            Student student = (Student) user;
            view.printOnConsole(student);
        }
    }

    public StudyGroup formStudyGroup(Teacher teacher, List<Student> students) {
        return studyGroupService.createStudyGroup(teacher, students);
    }

    public List<Student> getStudents(List<Integer> studentIds) {
        return IntStream.range(0, studentIds.size())
                .mapToObj(i -> new Student(studentIds.get(i)))
                .collect(Collectors.toList());
    }

    public Teacher getTeacher(String firstName, String lastName, String middleName, int teacherId) {
        return new Teacher(firstName, lastName, middleName, teacherId);
    }
}
