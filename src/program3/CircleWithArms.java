package program3;

import java.util.ArrayList;

import com.sun.prism.paint.Color;

import processing.core.PApplet;

public class CircleWithArms {
	
	private int NUMBER_ARMS = 6;
	
	private float armX, armY; 
	private Arm arm;
	
	private ArrayList <Arm> arms = new ArrayList<Arm>();
	
	public CircleWithArms(PApplet app){
		
		for(int i = 0; i < NUMBER_ARMS ; i++) {
			armX = app.random(-1,1);
			armY = app.random(0,1);
			arm = new Arm(armX, armY, app.color(app.random(0, 255), app.random(0, 255), app.random(0, 255)), app.color(app.random(0, 255), app.random(0, 255), app.random(0, 255)));
			arms.add(arm);
		}
		
	}
	
	public void draw(PApplet app) {
		app.noStroke();
		app.ellipse(0, 1.5f, 1.5f, 1.5f);
		
		for(int i = 0; i < arms.size(); i++) {
			arms.get(i).draw(app);
		}
		
	}
}
