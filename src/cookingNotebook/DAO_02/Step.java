package cookingNotebook.DAO_02;

public class Step {

	private Integer fid;
	private Integer sid;
	private String content;
	private String image;
	
	public Step(Integer fid, Integer sid, String content, String image) {
		this.fid = fid;
		this.sid = sid;
		this.content = content;
		this.image = image;
	}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Step [fid=" + fid + ", sid=" + sid + ", content=" + content + ", image=" + image + "]";
	}
	
}
