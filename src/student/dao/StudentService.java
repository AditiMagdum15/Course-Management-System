package student.dao;

import java.util.List;

import student.model.Student;

public interface StudentService {
	String createStudent(List<Student>lst);
	Student retriveStudent(int stud_id);
	int deleteStudent(int stud_id);
	List<Student>getAllStudent();
	

}
