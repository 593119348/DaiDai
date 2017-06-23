package daidai.lexin.models;

public class UserVInformation {
	private String user_vinformation_value;
	private Integer user_vinformation_level;
	private String user_vinformation_specialty;
	private String user_vinformation_good;
	private Integer user_vinformation_blacked;
	private Integer user_vinformation_black;
	private Integer user_vinformation_follow;
	private Integer user_vinformation_followed; 
	private String user_id;
	
	
	
	public UserVInformation(String user_id,String user_vinformation_value, Integer user_vinformation_level,
			String user_vinformation_specialty, String user_vinformation_good, Integer user_vinformation_blacked,
			Integer user_vinformation_black, Integer user_vinformation_follow, Integer user_vinformation_followed) {
		this.user_vinformation_value = user_vinformation_value;
		this.user_vinformation_level = user_vinformation_level;
		this.user_vinformation_specialty = user_vinformation_specialty;
		this.user_vinformation_good = user_vinformation_good;
		this.user_vinformation_blacked = user_vinformation_blacked;
		this.user_vinformation_black = user_vinformation_black;
		this.user_vinformation_follow = user_vinformation_follow;
		this.user_vinformation_followed = user_vinformation_followed;
		this.user_id = user_id;
	}
	
	public String getUser_vinformation_value() {
		return user_vinformation_value;
	}
	public void setUser_vinformation_value(String user_vinformation_value) {
		this.user_vinformation_value = user_vinformation_value;
	}
	public Integer getUser_vinformation_level() {
		return user_vinformation_level;
	}
	public void setUser_vinformation_level(Integer user_vinformation_level) {
		this.user_vinformation_level = user_vinformation_level;
	}
	public String getUser_vinformation_specialty() {
		return user_vinformation_specialty;
	}
	public void setUser_vinformation_specialty(String user_vinformation_specialty) {
		this.user_vinformation_specialty = user_vinformation_specialty;
	}
	public String getUser_vinformation_good() {
		return user_vinformation_good;
	}
	public void setUser_vinformation_good(String user_vinformation_good) {
		this.user_vinformation_good = user_vinformation_good;
	}
	public Integer getUser_vinformation_blacked() {
		return user_vinformation_blacked;
	}
	public void setUser_vinformation_blacked(Integer user_vinformation_blacked) {
		this.user_vinformation_blacked = user_vinformation_blacked;
	}
	public Integer getUser_vinformation_black() {
		return user_vinformation_black;
	}
	public void setUser_vinformation_black(Integer user_vinformation_black) {
		this.user_vinformation_black = user_vinformation_black;
	}
	public Integer getUser_vinformation_follow() {
		return user_vinformation_follow;
	}
	public void setUser_vinformation_follow(Integer user_vinformation_follow) {
		this.user_vinformation_follow = user_vinformation_follow;
	}
	public Integer getUser_vinformation_followed() {
		return user_vinformation_followed;
	}
	public void setUser_vinformation_followed(Integer user_vinformation_followed) {
		this.user_vinformation_followed = user_vinformation_followed;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "用户虚拟信息 [积分="
				+ user_vinformation_value + ", 等级=" + user_vinformation_level
				+ ", 擅长=" + user_vinformation_specialty + ", 赞="
				+ user_vinformation_good + ", 被拉黑次数=" + user_vinformation_blacked
				+ ", 拉黑次数=" + user_vinformation_black + ", 关注数="
				+ user_vinformation_follow + ", 被关注数=" + user_vinformation_followed + ", 用户ID="
				+ user_id + "]";
	}
	
	
}
