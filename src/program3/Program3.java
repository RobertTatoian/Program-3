package program3;

import java.awt.geom.Point2D;

import processing.core.PApplet;


public class Program3 extends PApplet {
	

	


	// dimensions of the world in world units
	private static float WORLD_WIDTH = 4, WORLD_HEIGHT = 2;
	private static float pixelToWorld, worldToPixel;
	// screen coordinates of the world's origin
	private static int worldX, worldY;
	
	float[] toolMatrix = {1, 0, 0, 0, 1, 0};
	
	private float toolX, toolY; 
	private static CircleWithArms cwa;
	
	public void settings() {
		size(1024, 1024);
	}

	
	public void setup() {
		 cwa = new CircleWithArms(this);
		
		pixelToWorld = WORLD_WIDTH/width;
		worldToPixel = width/WORLD_WIDTH;
		
		worldX = width/2;
		worldY = 7*height/8;
	}

	private Point2D.Float pixelToWorld(int ix, int iy) {
		return new Point2D.Float((ix-worldX)*pixelToWorld, -(iy-worldY)*pixelToWorld);
	}
	
	public void draw() {
		
	background(167);
		
		pushMatrix();
		
		// change to world coordinates
		translate(worldX, worldY);
		scale(worldToPixel, -worldToPixel);
	
		//	from now on we are in world units, relative to the 
		// origin of the world
		stroke(0);
		
		
		// draw the ground plane		
//		line(-WORLD_WIDTH/2, 0, +WORLD_WIDTH/2, 0);
		
		drawArm();
		
		popMatrix();
		
	}
	
	private void drawArm() {
		pushMatrix();

//		Arm arm = new Arm();
//		arm.draw(this);
		
		
		cwa.draw(this);
		
		// When we leave the loop, and before the pop the matrix, the current
		// reference frame is the one we find ourselves at following the final translate
		//	statement, which put us at the end of the very last link, that is, at
		//	the tip of the manipulator, and with a local x direction aligned with the
		//	last link
		
		// update values of toolX, toolY
		// Changes to the code we did in class:

		//  2. I don't use the PMatrix object for anything other than extracting its array
		//	of float values, so no need to create a variable for that.
		toolMatrix = getMatrix().get(toolMatrix);
		
		// Explanation of what just happened:  The matrix that we get here is the global transformation
		//	matrix between the window reference frame and the reference frame at the tip of the arm.
		//      ( m11  m12  m13 )
		//	M = ( m21  m22  m23 )
		//      (  0    0    1  )
		// the rightmost column of M gives us the coordinates of the tip of the arm in window (pixel coordinates)
		// the array toolMatrix that we extracted is the "flattened" version of the first 2 rows of M:
		// toolMatrix = {m11, m12, m13, m21, m22, m23}.  The elements we want are at indices 2 and 5
		// We convert the coordinates into world coordinates using the finction we coded earlier.
		Point2D.Float tool = pixelToWorld((int) toolMatrix[2], (int) toolMatrix[5]);
		toolX = tool.x;
		toolY = tool.y;
		
		//	So now toolX and toolY store the cooordinates of the tip of the arm in world coordinate system.
		
		popMatrix();
	}
	public static void main(String _args[]) {
		PApplet.main(new String[] { program3.Program3.class.getName() });
	}
}
