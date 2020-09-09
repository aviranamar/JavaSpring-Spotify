package com.listsong.mvc;

public class song {
	private String songName;
	private String songArtist;
	private int songActive;
	private String songEmbed;
	private String songTime;
	public song() {
		super();
	}
	public song(String songName, String songArtist, int songActive, String songEmbed, String songTime) {
		super();
		this.songName = songName;
		this.songArtist = songArtist;
		this.songActive = songActive;
		this.songEmbed = songEmbed;
		this.songTime = songTime;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getSongArtist() {
		return songArtist;
	}
	public void setSongArtist(String songArtist) {
		this.songArtist = songArtist;
	}
	public int getSongActive() {
		return songActive;
	}
	public void setSongActive(int songActive) {
		this.songActive = songActive;
	}
	public String getSongEmbed() {
		return songEmbed;
	}
	public void setSongEmbed(String songEmbed) {
		this.songEmbed = songEmbed;
	}
	public String getSongTime() {
		return songTime;
	}
	public void setSongTime(String songTime) {
		this.songTime = songTime;
	}
	@Override
	public String toString() {
		return "song [songName=" + songName + ", songArtist=" + songArtist + ", songActive=" + songActive
				+ ", songEmbed=" + songEmbed + ", songTime=" + songTime + "]";
	}
}
