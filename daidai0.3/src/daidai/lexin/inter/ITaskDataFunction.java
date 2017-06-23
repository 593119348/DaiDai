package daidai.lexin.inter;

import daidai.lexin.models.TaskData;

public interface ITaskDataFunction {
	public int insertTaskData(TaskData td);
	public int deleteTaskDataByID(String id);
	public int updateTaskData(TaskData td);
	public TaskData selectTaskDataByTaskID(String id);
}
