package program3;

import java.util.ArrayList;

import processing.core.PApplet;

public class CircleWithArms {
	
	private int NUMBER_ARMS = 2;
	
	private float armX, armY; 
	private Arm arm;
	
	private ArrayList <Arm> arms = new ArrayList<Arm>();
	
	public CircleWithArms(PApplet app){
		
		for(int i = 0; i < NUMBER_ARMS ; i++) {
			armX = 1;//app.random(1.5,1);
			armY = 0;//app.random(0,1);
			arm = new Arm(app, armX, armY, app.color(app.random(0, 255), app.random(0, 255), app.random(0, 255)), app.color(app.random(0, 255), app.random(0, 255), app.random(0, 255)));
			arms.add(arm);
		}
		
	}
	
	public void draw(PApplet app) {
		app.noStroke();
		
		app.ellipse(0, 0, 2f, 2f);
		
		for(int i = 0; i < arms.size(); i++) {
			arms.get(i).draw(app);
		}
		
	}
}
