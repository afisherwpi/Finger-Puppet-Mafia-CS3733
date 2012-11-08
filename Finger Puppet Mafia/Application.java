import java.awt.EventQueue;

import Controllers.ContainerController;
import Database.Database;
import DesktopViews.ContainerView;

public class Application {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Database db = new Database("SoftwareEngineering.db4o");
					ContainerView containerView = new ContainerView();
					ContainerController containerController = new ContainerController(containerView, db);
					containerView.setVisible(true);
					containerController.go();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
