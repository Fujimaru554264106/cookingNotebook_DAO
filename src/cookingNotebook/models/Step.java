package cookingNotebook.models;

public class Step {
	private static int idDB = 0;
	private int numStep;
	private String content;
	private String linkImg;

	public Step() {
		this.numStep = idDB++;
	}

	public Step(String content, String linkImg) {
		this();
		this.content = content;
		this.linkImg = linkImg;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLinkImg() {
		return linkImg;
	}

	public void setLinkImg(String linkImg) {
		this.linkImg = linkImg;
	}

	public int getNumStep() {
		return numStep;
	}

	public void setNumStep(int numStep) {
		this.numStep = numStep;
	}
}