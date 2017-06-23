package daidai.lexin.inter;

import daidai.lexin.models.TaskReply;

public interface ITaskReplyFunction {
	public int insertTaskReply(TaskReply tr);
	public int deleteTaskReplyByID(String id);
	public int updateTaskReply(TaskReply tr);
	public TaskReply selectTaskReplyByID(String id);
}
