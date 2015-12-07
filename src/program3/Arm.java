package program3;

import processing.core.PApplet;

public class Arm {
	
	public final static float ANGLE_INCR = 0.1f;
	public int JOINT_COLOR = 0xFFFF0000;
	public int LINK_COLOR = 0xFF0000FF;
	private final float JOINT_DIAM = 0.1f;
	private float[] theta = {0, 0.1f, -0.3f, 0.2f, -0.2f, 0, 0.1f, -0.3f, 0.2f, -0.2f};
	//	Right now I have reduced this because the mathematics of inverse
	//	kinematics so far can only handle a 2x2 Jacobian matrix
	private final int NUM_JOINTS = 1;
	//				index 0 is for padding
	private float[] L = {0, 1.f, 0.5f, 0.70f, 0.60f, 0, 1.f, 0.5f, 0.70f, 0.60f};
	private float armX = 0.0f;
	private float armY = 1.0f;

	
	public Arm(float random, float random2, int JOINT_COLOR, int LINK_COLOR)
		{
			this.JOINT_COLOR = JOINT_COLOR;
			this.LINK_COLOR = LINK_COLOR;
			this.armX = random;
			this.armY = random2;
		}


	public void draw(PApplet app) {
		// draw the arm		
		app.stroke(LINK_COLOR);
		app.strokeWeight(0.1f);
//    	app.line(0, 0, 0, armY);
		app.noStroke();
		app.fill(JOINT_COLOR);
//		app.ellipse(0, 0, JOINT_DIAM, JOINT_DIAM);
		app.translate(armX, armY);
		
		for (int k=1; k<=NUM_JOINTS; k++) 
		{
			Joint j = new Joint(JOINT_COLOR,LINK_COLOR,JOINT_DIAM);
			j.draw(app, theta[k], L[k]);
		}
	}
}
