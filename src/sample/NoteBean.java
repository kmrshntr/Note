package sample;

public class NoteBean {

	protected String title;
	protected String body;
	
	public NoteBean(){
		title = "";
		body = "";
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	
}