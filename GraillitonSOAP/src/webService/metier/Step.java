package webService.metier;

public class Step {
	private int id;
	private String content;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Step(String content) {
		super();
		this.content = content;
	}
	public Step() {
		super();
	}
	
	
}
