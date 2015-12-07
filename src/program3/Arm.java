
package program3;


import java.util.ArrayList;

import processing.core.PApplet;


public class Arm {
	
	public final static float	ANGLE_INCR	= 0.1f;
	public int					JOINT_COLOR	= 0xFFFF0000;
	public int					LINK_COLOR	= 0xFF0000FF;
	private final float			JOINT_DIAM	= 0.1f;
	//private float[ ]			theta		= { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	private ArrayList <Float> armThetas = new ArrayList<Float>();
	// Right now I have reduced this because the mathematics of inverse
	// kinematics so far can only handle a 2x2 Jacobian matrix
	private final int			NUM_JOINTS	= 2;
	// Index 0 is for padding
	// Note to self: This is the length.
	private float[ ]			L			= { 0, .5f, .5f, .5f, .5f, 1, 1.f, 1f, 1f, 1f };
	private float				armX		= 0.0f;
	private float				armY		= 1.0f;
											
											
	public Arm(PApplet app, float random, float random2, int JOINT_COLOR, int LINK_COLOR)
		{
			this.JOINT_COLOR = JOINT_COLOR;
			this.LINK_COLOR = LINK_COLOR;
			this.armX = random;
			this.armY = random2;
			
			for(int i = 0; i < NUM_JOINTS; i++) {
				armThetas.add(app.random(-1,1));
			}
		}
		
		
	public void draw(PApplet app)
		{
			// draw the arm
			app.stroke(LINK_COLOR);
			app.strokeWeight(0.1f);
			// app.line(0, 0, 0, armY);
			app.noStroke();
			app.fill(JOINT_COLOR);
			// app.ellipse(0, 0, JOINT_DIAM, JOINT_DIAM);
			app.translate(armX, armY);
			
			for (int k = 1; k <= NUM_JOINTS; k++)
				{
					Joint j = new Joint(JOINT_COLOR, LINK_COLOR, JOINT_DIAM);
					j.draw(app, armThetas.get(k-1), L[k]);
					//j.draw(app, theta[k], L[k]);
				}
		}
}
