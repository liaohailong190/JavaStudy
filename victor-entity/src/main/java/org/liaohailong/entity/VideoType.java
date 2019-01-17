package org.liaohailong.entity;

public class VideoType {
	private int id;
	private String name;// 视频类型

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

	@Override
	public String toString() {
		return "VideoType [id=" + id + ", name=" + name + "]";
	}
}
