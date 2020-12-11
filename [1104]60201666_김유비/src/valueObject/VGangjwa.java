package valueObject;

public class VGangjwa {
	private String id;
	private String name;
	private String lecturer;
	private String credit;
	private String time;
	
	public VGangjwa(String id, String name, String lecturer, String credit, String time) {
		this.id = id;
		this.name = name;
		this.lecturer = lecturer;
		this.credit = credit;
		this.time = time;

	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLecturer() {
		return lecturer;
	}

	public String getCredit() {
		return credit;
	}

	public String getTime() {
		return time;
	}
}
