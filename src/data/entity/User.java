package data.entity;

import java.awt.image.BufferedImage;

public class User {
	
	private String nickname;
	private String password;
	private String status;
	private BufferedImage avatar;
	
	public User(String nickname, String password, String status, BufferedImage avatar) {
		this.nickname = nickname;
		this.password = password;
		this.status = status;
		this.avatar = avatar;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BufferedImage getAvatar() {
		return avatar;
	}

	public void setAvatar(BufferedImage avatar) {
		this.avatar = avatar;
	}
	
}