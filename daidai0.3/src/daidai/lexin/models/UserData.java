package daidai.lexin.models;

public class UserData {
private Integer user_data_accept;
private Integer user_data_relay;
private Integer user_data_finish;
private Integer user_data_unfinish;
private Integer user_data_publish;
private Integer user_data_accepted;
private Integer user_data_cost;
private Integer user_data_earm;
private Integer user_data_relayed;
private Integer user_data_overdue;
private Integer user_data_punishment;
private Integer user_data_good;
private Integer user_data_gooded;
private Integer user_data_bad;
private Integer user_data_baded;
private Integer user_data_comment;
private Integer user_data_reply;
private String user_id;
public UserData(String user_id,Integer user_data_accept, Integer user_data_relay, Integer user_data_finish,
		Integer user_data_unfinish, Integer user_data_publish, Integer user_data_accepted, Integer user_data_cost,
		Integer user_data_earm, Integer user_data_relayed, Integer user_data_overdue, Integer user_data_punishment,
		Integer user_data_good, Integer user_data_gooded, Integer user_data_bad, Integer user_data_baded,
		Integer user_data_comment, Integer user_data_reply) {
	super();
	this.user_data_accept = user_data_accept;
	this.user_data_relay = user_data_relay;
	this.user_data_finish = user_data_finish;
	this.user_data_unfinish = user_data_unfinish;
	this.user_data_publish = user_data_publish;
	this.user_data_accepted = user_data_accepted;
	this.user_data_cost = user_data_cost;
	this.user_data_earm = user_data_earm;
	this.user_data_relayed = user_data_relayed;
	this.user_data_overdue = user_data_overdue;
	this.user_data_punishment = user_data_punishment;
	this.user_data_good = user_data_good;
	this.user_data_gooded = user_data_gooded;
	this.user_data_bad = user_data_bad;
	this.user_data_baded = user_data_baded;
	this.user_data_comment = user_data_comment;
	this.user_data_reply = user_data_reply;
	this.user_id = user_id;
}
public Integer getUser_data_accept() {
	return user_data_accept;
}
public void setUser_data_accept(Integer user_data_accept) {
	this.user_data_accept = user_data_accept;
}
public Integer getUser_data_relay() {
	return user_data_relay;
}
public void setUser_data_relay(Integer user_data_relay) {
	this.user_data_relay = user_data_relay;
}
public Integer getUser_data_finish() {
	return user_data_finish;
}
public void setUser_data_finish(Integer user_data_finish) {
	this.user_data_finish = user_data_finish;
}
public Integer getUser_data_unfinish() {
	return user_data_unfinish;
}
public void setUser_data_unfinish(Integer user_data_unfinish) {
	this.user_data_unfinish = user_data_unfinish;
}
public Integer getUser_data_publish() {
	return user_data_publish;
}
public void setUser_data_publish(Integer user_data_publish) {
	this.user_data_publish = user_data_publish;
}
public Integer getUser_data_accepted() {
	return user_data_accepted;
}
public void setUser_data_accepted(Integer user_data_accepted) {
	this.user_data_accepted = user_data_accepted;
}
public Integer getUser_data_cost() {
	return user_data_cost;
}
public void setUser_data_cost(Integer user_data_cost) {
	this.user_data_cost = user_data_cost;
}
public Integer getUser_data_earm() {
	return user_data_earm;
}
public void setUser_data_earm(Integer user_data_earm) {
	this.user_data_earm = user_data_earm;
}
public Integer getUser_data_relayed() {
	return user_data_relayed;
}
public void setUser_data_relayed(Integer user_data_relayed) {
	this.user_data_relayed = user_data_relayed;
}
public Integer getUser_data_overdue() {
	return user_data_overdue;
}
public void setUser_data_overdue(Integer user_data_overdue) {
	this.user_data_overdue = user_data_overdue;
}
public Integer getUser_data_punishment() {
	return user_data_punishment;
}
public void setUser_data_punishment(Integer user_data_punishment) {
	this.user_data_punishment = user_data_punishment;
}
public Integer getUser_data_good() {
	return user_data_good;
}
public void setUser_data_good(Integer user_data_good) {
	this.user_data_good = user_data_good;
}
public Integer getUser_data_gooded() {
	return user_data_gooded;
}
public void setUser_data_gooded(Integer user_data_gooded) {
	this.user_data_gooded = user_data_gooded;
}
public Integer getUser_data_bad() {
	return user_data_bad;
}
public void setUser_data_bad(Integer user_data_bad) {
	this.user_data_bad = user_data_bad;
}
public Integer getUser_data_baded() {
	return user_data_baded;
}
public void setUser_data_baded(Integer user_data_baded) {
	this.user_data_baded = user_data_baded;
}
public Integer getUser_data_comment() {
	return user_data_comment;
}
public void setUser_data_comment(Integer user_data_comment) {
	this.user_data_comment = user_data_comment;
}
public Integer getUser_data_reply() {
	return user_data_reply;
}
public void setUser_data_reply(Integer user_data_reply) {
	this.user_data_reply = user_data_reply;
}
public String getUser_id() {
	return user_id;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}
@Override
public String toString() {
	return "�û����� [������������=" + user_data_accept + ", ת����������="
			+ user_data_relay + ", �����������=" + user_data_finish + ", δ�����������=" + user_data_unfinish
			+ ", ������������=" + user_data_publish + ", ���񱻽�������=" + user_data_accepted
			+ ", ���ѻ�������=" + user_data_cost + ", ׬ȡ��������=" + user_data_earm + ", ����ת������="
			+ user_data_relayed + ", ������������=" + user_data_overdue + ", ���ͷ�����="
			+ user_data_punishment + ", ����������=" + user_data_good + ", ����������=" + user_data_gooded
			+ ", ����������=" + user_data_bad + ", ���񱻲�����=" + user_data_baded + ", ������������="
			+ user_data_comment + ", ����ظ�����=" + user_data_reply + ", �û�ID=" + user_id + "]";
}


}
