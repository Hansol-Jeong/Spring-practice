package com.rubypaper.tv;

import org.springframework.beans.factory.annotation.Autowired;

public class SamsungTV {
	@Autowired
	private AppleSpeaker speaker;
	
	public void powerOn() {
		System.out.println("on");
	}
	public void poweroff() {
		System.out.println("off");
	}
	public void volumUp() {
		speaker.volumUp();
	}
	public void volumDown() {
		speaker.volumDown();
	}
//	public void setSpeaker(AppleSpeaker speaker) {
//		this.speaker = speaker;
//	}
	
}
