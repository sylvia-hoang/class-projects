import javax.swing.JFrame;


public class IceCreamShopApplication extends JFrame
{
	public static void main(String[] args) 
	{
		// create a JFrame
		JFrame iceCreamFrame = new JFrame("We're serving ice cream");
		
		// set size
		iceCreamFrame.setSize(900,900);
		
		// set normal exiting upon closing the window
		iceCreamFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// add sorting panel to frame
		IceCreamShopPanel iceCreamShopPanel = new IceCreamShopPanel();
		
		iceCreamFrame.add(iceCreamShopPanel);
		
		// set visible
		iceCreamFrame.setVisible(true);
	}
}
