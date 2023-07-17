package student.dao;
import java.util.List;

import student.model.*;
public interface course_service {
	String createCourse(List<product> lst);
	List<product> editcourse(int course_id);
	int deletecourse(int course_id);
	List<product> getAllcourse();
	int addcourse(product p);

}
