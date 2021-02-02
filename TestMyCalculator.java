import javax.swing.*;

public class TestMyCalculator {
	public static void main(String[] args) {
		
		//windows look and feel
		try {
			// Windows LF
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			
		}
		MyCalculator window = new MyCalculator();
		window.setVisible(true);
		window.setSize(380, 620);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Calculator Project");
		window.setLocationRelativeTo(null);
		

	}
}
