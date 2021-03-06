package org.liaohailong.entity;

public class VideoInfo {
	private int id;
	private String name;// 视频名称
	private String url;// 视频播放地址
	private String html;
	private int type_id;// 视频类型
	private boolean del;// 是否逻辑删除 0表示没有 1表示有
	private String typeName;// 视频类型名称

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public boolean isDel() {
		return del;
	}

	public void setDel(boolean del) {
		this.del = del;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "VideoInfo [id=" + id + ", name=" + name + ", url=" + url + ", html=" + html + ", typeName=" + typeName
				+ "]";
	}

}
