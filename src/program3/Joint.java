package program3;

import processing.core.PApplet;

public class Joint {
	

	
	private int LINK_COLOR;
	private int JOINT_COLOR;
	private float JOINT_DIAM;

	public Joint(int JOINT_COLOR,int LINK_COLOR, float JOINT_DIAM) {
		this.JOINT_COLOR = JOINT_COLOR;
		this.LINK_COLOR = LINK_COLOR;
		this.JOINT_DIAM = JOINT_DIAM;
	}
	
	public void draw(PApplet app, float theta, float L ) {
		app.rotate(theta);
		
		app.stroke(LINK_COLOR);
		//strokeWeight(5);
		//app.line(0, 0, L, 0);
		app.rect(0, 0, L, 0, 50);
		app.noStroke();
		app.fill(JOINT_COLOR);
		app.ellipse(0, 0, JOINT_DIAM, JOINT_DIAM);
		app.translate(L, 0);
	}
}
