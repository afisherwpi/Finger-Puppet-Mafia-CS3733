import processing.core.PApplet;

public class TextField {

	PApplet pcode;

	
	TextField(PApplet p) {
		pcode = p;
	}
	
	void searchBar() {
		int scaledX = pcode.width*11/16;
		int scaledLength = pcode.width - pcode.width*11/16 - (pcode.width - pcode.width*23/32 - 200);
		pcode.fill(255);
		pcode.stroke(0);
		pcode.rect(scaledX, 20, scaledLength, 20, 18, 18, 18, 18);
		pcode.fill(102);
		pcode.text("Search...", scaledX+10, 35);
	}
	
	void TitleBar() {
		int scaledX = 200;//pcode.width*11/16;
		int scaledLength = pcode.width*23/32;
		int controlledY = 50;
		pcode.fill(255);
		pcode.stroke(0);
		pcode.rect(scaledX, controlledY, scaledLength, 20);
		pcode.fill(102);
		pcode.text("Title", scaledX+10, controlledY+15);
	}
	
	void CodeBox() {
		int scaledX = 200;//pcode.width*11/16;
		int controlledY = 100;
		int sidebar_controlledY = 50;
		int scaledLength = pcode.width*23/32;
		int scaledHeight = pcode.height-sidebar_controlledY-controlledY; //pcode.width/4;
		pcode.fill(255);
		pcode.stroke(0);
		pcode.rect(scaledX, controlledY, scaledLength, scaledHeight);
		pcode.fill(102);
		pcode.text("Enter Code here", scaledX+10, controlledY+15);
	}
	
	
	void SideBar() {
		int scaledX = 20;//pcode.width*11/16;
		int controlledY = 50;
		int scaledLength = 150; //pcode.width/4;
		int scaledHeight = pcode.height-(2*controlledY);
		pcode.fill(255);
		pcode.stroke(0);
		pcode.rect(scaledX, controlledY, scaledLength, scaledHeight);
		pcode.fill(102);
		pcode.text("SideBar", scaledX+10, controlledY+15);
	}
	
	
}
