package program3;

import processing.core.PApplet;

public class CircleWithArms {
	
	private int NUMBER_ARMS = 2;

	public CircleWithArms(){
		
	}
	
	public void draw(PApplet app) {
	//	app.ellipse(0, 0, 10, 10);
		
		for(int i = 0; i < NUMBER_ARMS ; i++) {
			Arm arm = new Arm(app.random(100,200), app.random(100,200));
			arm.draw(app);
		}
	}
}
