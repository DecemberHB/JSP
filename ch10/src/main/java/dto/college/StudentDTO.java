package dto.college;

public class StudentDTO {
	
	private String stdNO;
	private String name;
	private String birth;
	private String major;
	private String enr_date;
	public String getStdNO() {
		return stdNO;
	}
	public void setStdNO(String stdNO) {
		this.stdNO = stdNO;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getEnr_date() {
		return enr_date;
	}
	public void setEnr_date(String enr_date) {
		this.enr_date = enr_date;
	}
	@Override
	public String toString() {
		return "StudentDTO [stdNO=" + stdNO + ", name=" + name + ", birth=" + birth + ", major=" + major + ", enr_date="
				+ enr_date + "]";
	}
	
	
	

}
