import processing.core.*;

@SuppressWarnings("serial")
public class mainCode extends PApplet {
	
	Storage storage = new Storage();
	TextField texts = new TextField(this);
	RatingSystem rates = new RatingSystem(this,storage);

	PImage backImg;
	
	public void setup() {
		size(800,550);
		backImg = loadImage("backgroundPic.jpg");
	}
	
	public void draw() {
		background(0);
		image(backImg,0,0);
		texts.searchBar();
		texts.TitleBar();
		texts.CodeBox();
		texts.SideBar();
		translate(0,0);
		fill(27,224,27);
		text("Welcome: ", 20, 25);
		fill(34,232,242);
		text("John Doe !", 90, 25);
		rates.bar();
		
	}
	
	public void mousePressed() {
		rates.clickingBar();
		print("x:  " + mouseX + "   y:  " + mouseY);
		print("width: " + width + "   height: " + height );
	}
}
