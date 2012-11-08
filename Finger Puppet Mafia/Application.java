import java.awt.EventQueue;

import Controllers.ContainerController;
import DesktopViews.ContainerView;

public class Application {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContainerView containerView = new ContainerView();
					ContainerController containerController = new ContainerController(containerView);
					containerView.setVisible(true);
					containerController.go();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
