package org.cc.exp.security.sql.setup;

import java.sql.SQLException;


public interface TasnNBugsRepository {
	
	void createTaskNBug(TasksNBug tasksNBugs) throws SQLException;

	TasksNBug findTasksNBugByUsername(String username);
	
 

}
