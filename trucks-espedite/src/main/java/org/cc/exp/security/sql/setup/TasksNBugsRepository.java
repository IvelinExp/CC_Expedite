package org.cc.exp.security.sql.setup;

import java.sql.SQLException;
import java.util.List;



public interface TasksNBugsRepository {
	
	void createTaskNBug(TasksNBug tasksNBugs) throws SQLException;

	TasksNBug findTasksNBugByUsername(String username);
	
	List <TasksNBug> returnAlltaskNBugs();
	
 

}
