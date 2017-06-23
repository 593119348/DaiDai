package daidai.lexin.inter;

import daidai.lexin.models.TaskComment;

public interface ITaskCommentFunction {
	public int insertTaskComment(TaskComment tc);
	public int deleteTaskCommentByID(String id);
	public int updateTaskComment(TaskComment tc);
	public int selectTaskCommentByID(String id);
}
