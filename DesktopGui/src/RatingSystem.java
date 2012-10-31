
import processing.core.PApplet;
import processing.core.PConstants;

public class RatingSystem {
	
	int rateX = 250;
	int rateY = 100;
	int rateLength = 210;
	int rateWidth = 50;
	int rateSpacingX = 35;
	int rateSpaceY = 25;
	int rateClickArea = 20;
	int rateClick = rateClickArea/2;
	
	PApplet pcode;
	Storage store;
	
	
	RatingSystem(PApplet p, Storage storage) {
		pcode = p;
		store = storage;
	}
	
	void createStar() {
		pcode.stroke(255);
		pcode.strokeWeight(2);
		pcode.beginShape();
		pcode.vertex(0, -12);
		pcode.vertex(3, -5);
		pcode.vertex(12, -4);
		pcode.vertex(6, 2);
		pcode.vertex(7, 10);
		pcode.vertex(0, 6);
		pcode.vertex(-7, 10);
		pcode.vertex(-6, 2);
		pcode.vertex(-12, -4);
		pcode.vertex(-3, -5);
		pcode.endShape(PConstants.CLOSE);
	}
	
	void bar() {
		//rateX = pcode.width/4;
		
		if(pcode.mouseX > rateX && pcode.mouseX < (rateX+rateLength)) {
			if(pcode.mouseY > rateY && pcode.mouseY < (rateY+rateWidth)) {
				
				pcode.fill(133,133,133,127);
				pcode.translate(rateX,rateY);
				pcode.rect(0, 0, rateLength, rateWidth, 0, 0, 18, 18);
				
				if(store.getRank() == 1) { // 1 star
					pcode.translate(35,25);
					pcode.fill(245,15,15,255);
					createStar();
					pcode.fill(245,15,15,127);
					pcode.translate(35,0);
					createStar();
					pcode.translate(35,0);
					createStar();
					pcode.translate(35,0);
					createStar();
					pcode.translate(35,0);
					createStar();
				}
				else if(store.getRank() == 2) { // 2 stars
					pcode.translate(35,25);
					pcode.fill(245,15,15,255);
					createStar();
					pcode.translate(35,0);
					createStar();
					pcode.fill(245,15,15,127);
					pcode.translate(35,0);
					createStar();
					pcode.translate(35,0);
					createStar();
					pcode.translate(35,0);
					createStar();
				}
				else if(store.getRank() == 3) { // 3 stars
					pcode.translate(35,25);
					pcode.fill(245,15,15,255);
					createStar();
					pcode.translate(35,0);
					createStar();
					pcode.translate(35,0);
					createStar();
					pcode.fill(245,15,15,127);
					pcode.translate(35,0);
					createStar();
					pcode.translate(35,0);
					createStar();
				}
				else if(store.getRank() == 4) { // 4 stars
					pcode.translate(35,25);
					pcode.fill(245,15,15,255);
					createStar();
					pcode.translate(35,0);
					createStar();
					pcode.translate(35,0);
					createStar();
					pcode.translate(35,0);
					createStar();
					pcode.fill(245,15,15,127);
					pcode.translate(35,0);
					createStar();
				}
				else if(store.getRank() == 5) { // 5 stars
					pcode.translate(35,25);
					pcode.fill(245,15,15,255);
					createStar();
					pcode.translate(35,0);
					createStar();
					pcode.translate(35,0);
					createStar();
					pcode.translate(35,0);
					createStar();
					pcode.translate(35,0);
					createStar();
				}
				else  { // 0 stars
					pcode.translate(35,25);
					pcode.fill(245,15,15,127);
					createStar();
					pcode.translate(35,0);
					createStar();
					pcode.translate(35,0);
					createStar();
					pcode.translate(35,0);
					createStar();
					pcode.translate(35,0);
					createStar();
				} 
			}
		}
		pcode.translate(0,0);
	}
	
	void clickingBar(){
	
		int leftX1 = rateX+rateSpacingX-rateClick;
		int rightX1 = rateX+rateSpacingX+rateClick;
		int topY1 = rateY+rateSpaceY-rateClick;
		int bottomY1 = rateY+rateSpaceY+rateClick;
		
		int leftX2 = rateX+(2*rateSpacingX)-rateClick;
		int rightX2 = rateX+(2*rateSpacingX)+rateClick;
		int topY2 = rateY+rateSpaceY-rateClick;
		int bottomY2 = rateY+rateSpaceY+rateClick;
		
		int leftX3 = rateX+(3*rateSpacingX)-rateClick;
		int rightX3 = rateX+(3*rateSpacingX)+rateClick;
		int topY3 = rateY+rateSpaceY-rateClick;
		int bottomY3 = rateY+rateSpaceY+rateClick;
		
		int leftX4 = rateX+(4*rateSpacingX)-rateClick;
		int rightX4 = rateX+(4*rateSpacingX)+rateClick;
		int topY4 = rateY+rateSpaceY-rateClick;
		int bottomY4 = rateY+rateSpaceY+rateClick;
		
		int leftX5 = rateX+(5*rateSpacingX)-rateClick;
		int rightX5 = rateX+(5*rateSpacingX)+rateClick;
		int topY5 = rateY+rateSpaceY-rateClick;
		int bottomY5 = rateY+rateSpaceY+rateClick;
		
		if(pcode.mouseX > leftX1 && pcode.mouseX < rightX1) {
			if(pcode.mouseY > topY1 && pcode.mouseY < bottomY1) {
				store.setRank(1);
			}
		}
		
		else if(pcode.mouseX > leftX2 && pcode.mouseX < rightX2) {
			if(pcode.mouseY > topY2 && pcode.mouseY < bottomY2) {
				store.setRank(2);
			}
		}
		
		else if(pcode.mouseX > leftX3 && pcode.mouseX < rightX3) {
			if(pcode.mouseY > topY3 && pcode.mouseY < bottomY3) {
				store.setRank(3);
			}
		}
		
		if(pcode.mouseX > leftX4 && pcode.mouseX < rightX4) {
			if(pcode.mouseY > topY4 && pcode.mouseY < bottomY4) {
				store.setRank(4);
			}
		}
		
		else if(pcode.mouseX > leftX5 && pcode.mouseX < rightX5) {
			if(pcode.mouseY > topY5 && pcode.mouseY < bottomY5) {
				store.setRank(5);
			}
		}
		if(pcode.mouseX > rateX && pcode.mouseX < leftX1) {
			if(pcode.mouseY > rateY && pcode.mouseY < (rateY+rateWidth)) {
				store.setRank(0);
			}
		}
		
	}
	
}