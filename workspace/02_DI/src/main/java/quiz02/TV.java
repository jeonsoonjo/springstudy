package quiz02;

import org.springframework.beans.factory.annotation.Autowired;

public class TV {

	// field
	private int ch; // 0~100
	private Speaker speaker;
	
	// getter, setter
	public int getCh() {
		return ch;
	}
	public void setCh(int ch) {
		this.ch = ch;
	}
	public Speaker getSpeaker() {
		return speaker;
	}
	@Autowired
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	// method
	public void volUp() {
		speaker.volUp();
	}
	public void volDown() {
		speaker.volDown();
	}
	public void chUp() {
		ch++;
		if(ch > 100) ch = 0;
		System.out.println("현재 채널: " + ch);
	}
	public void chDown() {
		ch--;
		if(ch < 0) ch = 100;
		System.out.println("현재 채널: " + ch);
	}
	
}


