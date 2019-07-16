package blogs.beans;

public class Blogs {
	private String title = null;
	private String description = null;
	private String author = null;
	private String date = null;
	private int id = 0;
	
	public void setId(int id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public int getId() {
		return this.id;
	}
	public String getTitle() {
		return this.title;
	}
	public String getDescription() {
		return this.description;
	}
	public String getAuthor() {
		return this.author;
	}
	public String getDate() {
		return this.date;
	}

}
