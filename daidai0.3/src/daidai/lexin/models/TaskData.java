package daidai.lexin.models;

public class TaskData {
	private String task_data_id;
	private Integer task_data_bad;
	private Integer task_data_good;
	private Integer task_data_comment;
	private Integer task_data_reply;
	private String task_id;
	public TaskData(String task_data_id, Integer task_data_bad, Integer task_data_good, Integer task_data_comment,
			Integer task_data_reply, String task_id) {
		super();
		this.task_data_id = task_data_id;
		this.task_data_bad = task_data_bad;
		this.task_data_good = task_data_good;
		this.task_data_comment = task_data_comment;
		this.task_data_reply = task_data_reply;
		this.task_id = task_id;
	}
	public String getTask_data_id() {
		return task_data_id;
	}
	public void setTask_data_id(String task_data_id) {
		this.task_data_id = task_data_id;
	}
	public Integer getTask_data_bad() {
		return task_data_bad;
	}
	public void setTask_data_bad(Integer task_data_bad) {
		this.task_data_bad = task_data_bad;
	}
	public Integer getTask_data_good() {
		return task_data_good;
	}
	public void setTask_data_good(Integer task_data_good) {
		this.task_data_good = task_data_good;
	}
	public Integer getTask_data_comment() {
		return task_data_comment;
	}
	public void setTask_data_comment(Integer task_data_comment) {
		this.task_data_comment = task_data_comment;
	}
	public Integer getTask_data_reply() {
		return task_data_reply;
	}
	public void setTask_data_reply(Integer task_data_reply) {
		this.task_data_reply = task_data_reply;
	}
	public String getTask_id() {
		return task_id;
	}
	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}
	@Override
	public String toString() {
		return "任务数据 [ID=" + task_data_id + ", 踩=" + task_data_bad + ", 赞="
				+ task_data_good + ", 评论数=" + task_data_comment + ", 回复数=" + task_data_reply
				+ ", 任务ID=" + task_id + "]";
	}
	
	
}
