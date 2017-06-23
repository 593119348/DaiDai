package daidai.lexin.models;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

public class Operation {
	private String operation_id;
	private String operation_mes;
	private String operation_result;
	private Timestamp operation_date;
	private String user_id;
	public Operation(String operation_id, String operation_mes, String operation_result, Timestamp operation_date,
			String user_id) {
		super();
		this.operation_id = operation_id;
		this.operation_mes = operation_mes;
		this.operation_result = operation_result;
		this.operation_date = operation_date;
		this.user_id = user_id;
	}
	public String getOperation_id() {
		return operation_id;
	}
	public void setOperation_id(String operation_id) {
		this.operation_id = operation_id;
	}
	public String getOperation_mes() {
		return operation_mes;
	}
	public void setOperation_mes(String operation_mes) {
		this.operation_mes = operation_mes;
	}
	public String getOperation_result() {
		return operation_result;
	}
	public void setOperation_result(String operation_result) {
		this.operation_result = operation_result;
	}
	public Timestamp getOperation_date() {
		return operation_date;
	}
	public void setOperation_date(Timestamp operation_date) {
		this.operation_date = operation_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "操作记录 [ID=" + operation_id + ", 信息=" + operation_mes + ", 结果="
				+ operation_result + ", 日期=" + operation_date + ", 用户ID=" + user_id + "]";
	}
	
	/***
	 * ID生成
	 * @param phone
	 * @return
	 */
	public static String markID(String phone) {
		Long time = new Date().getTime();
		int ran = new Random().nextInt(900)+100;
		return phone+time+ran;
	}
	
}
