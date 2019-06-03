package bean;

public class User {
	private Integer Uid;
	private String Uname;
	private String Upwd;
	private String Urole;
	private String Ustate;
	private String Uphoto;
	public String getUphoto() {
		return Uphoto;
	}
	public void setUphoto(String uphoto) {
		Uphoto = uphoto;
	}
	public Integer getUid() {
		return Uid;
	}
	public User() {
		super();
	}
	public String getUname() {
		return Uname;
	}
	public void setUname(String uname) {
		this.Uname = uname;
	}
	public String getUpwd() {
		return Upwd;
	}
	public void setUpwd(String upwd) {
		this.Upwd = upwd;
	}
	public String getUrole() {
		return Urole;
	}
	public void setUrole(String urole) {
		this.Urole = urole;
	}
	public String getUstate() {
		return Ustate;
	}
	public void setUstate(String ustate) {
		this.Ustate = ustate;
	}
	public void setUid(Integer uid) {
		this.Uid = uid;
	}
	public User(Integer uid, String uname, String upwd, String urole, String ustate, String uphoto) {
		super();
		Uid = uid;
		Uname = uname;
		Upwd = upwd;
		Urole = urole;
		Ustate = ustate;
		Uphoto = uphoto;
	}
	
	
	
	
}