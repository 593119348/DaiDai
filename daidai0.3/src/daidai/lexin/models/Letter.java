package daidai.lexin.models;

import java.sql.Timestamp;

public class Letter {
	private String letter_id;
	private String letter_mes;
	private Integer letter_send;
	private String letter_fromuserid;
	private String letter_touserid;
	private Timestamp letter_date;
	public Letter(String letter_id, String letter_mes, Integer letter_send, String letter_fromuserid,
			String letter_touserid, Timestamp letter_date) {
		super();
		this.letter_id = letter_id;
		this.letter_mes = letter_mes;
		this.letter_send = letter_send;
		this.letter_fromuserid = letter_fromuserid;
		this.letter_touserid = letter_touserid;
		this.letter_date = letter_date;
	}
	public String getLetter_id() {
		return letter_id;
	}
	public void setLetter_id(String letter_id) {
		this.letter_id = letter_id;
	}
	public String getLetter_mes() {
		return letter_mes;
	}
	public void setLetter_mes(String letter_mes) {
		this.letter_mes = letter_mes;
	}
	public Integer getLetter_send() {
		return letter_send;
	}
	public void setLetter_send(Integer letter_send) {
		this.letter_send = letter_send;
	}
	public String getLetter_fromuserid() {
		return letter_fromuserid;
	}
	public void setLetter_fromuserid(String letter_fromuserid) {
		this.letter_fromuserid = letter_fromuserid;
	}
	public String getLetter_touserid() {
		return letter_touserid;
	}
	public void setLetter_touserid(String letter_touserid) {
		this.letter_touserid = letter_touserid;
	}
	public Timestamp getLetter_date() {
		return letter_date;
	}
	public void setLetter_date(Timestamp letter_date) {
		this.letter_date = letter_date;
	}
	@Override
	public String toString() {
		return "私信 [ID=" + letter_id + ", 信息=" + letter_mes + ", 发送状态=" + letter_send
				+ ", 发送用户ID=" + letter_fromuserid + ", 接收用户ID=" + letter_touserid + ", 日期="
				+ letter_date + "]";
	}
	
	
}
