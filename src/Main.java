import controller.Controller;
import model.Student;
import model.StudyGroup;
import model.Teacher;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();

        // Создаем список студентов с их id
        List<Integer> studentIds = Arrays.asList(1, 2, 3);
        List<Student> students = controller.getStudents(studentIds);

        // Создаем преподавателя
        Teacher teacher = controller.getTeacher("Мария", "Сидорова", "Ивановна", 101);

        // Формируем учебную группу
        StudyGroup studyGroup = controller.formStudyGroup(teacher, students);

        // Выводим информацию о созданной учебной группе
        System.out.println(studyGroup);
    }
}