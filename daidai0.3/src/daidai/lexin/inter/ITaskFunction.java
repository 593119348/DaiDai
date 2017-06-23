package daidai.lexin.inter;

import daidai.lexin.models.Task;

public interface ITaskFunction {
	public int insertTask(Task t);
	public int deleteTaskByID(String id);
	public int updateTask(Task t);
	public Task selectTaskByID(String id);
}
