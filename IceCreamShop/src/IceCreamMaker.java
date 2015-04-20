import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class IceCreamMaker extends JPanel implements ActionListener
{
	private IceCreamCone iceCreamCone;
	
	private JButton vanilla;
	private JButton greenTea;
	private JButton peach;
	private JButton mint;
	private JButton trashScoop; 
	
	public IceCreamMaker()
	{
		// initialize cone class
		iceCreamCone = new IceCreamCone();
		
		// set layout
		setLayout(new BorderLayout());
		
		// add button panel to south
		add(createButtonPanel(), BorderLayout.NORTH);
		// add cone to the panel
		add(iceCreamCone, BorderLayout.CENTER);
		
		refreshDisplay();
	}
	
	public JPanel createButtonPanel()
	{
		// new panel with border layout
		JPanel buttonPanel = new JPanel( new BorderLayout() );
		
		// panel with grid layout for flavor-choosing buttons
		JPanel flavorPanel = new JPanel( new GridLayout(1,4) );
		
		// initialize buttons
		vanilla = new JButton("Vanilla");
		vanilla.setBackground(Color.YELLOW);
		vanilla.setOpaque(true);
		
		greenTea = new JButton("Green tea");
		greenTea.setBackground(new Color(102, 255, 102));
		greenTea.setOpaque(true);
		
		peach = new JButton("Peach");
		peach.setBackground(Color.PINK);
		peach.setOpaque(true);
		
		mint = new JButton("Mint");
		mint.setBackground(new Color(153, 255, 255));
		mint.setOpaque(true);
		
		trashScoop = new JButton("Trash the top scoop!");
		
		// add action listeners
		vanilla.addActionListener(this);
		greenTea.addActionListener(this);
		peach.addActionListener(this);
		mint.addActionListener(this);
		trashScoop.addActionListener(this);
		
		// add them to the grid layout panel
		flavorPanel.add(vanilla);
		flavorPanel.add(greenTea);
		flavorPanel.add(peach);
		flavorPanel.add(mint);
		
		// set flavor panel to center
		buttonPanel.add(flavorPanel, BorderLayout.CENTER);
		
		// set trash scoop button to south
		buttonPanel.add(trashScoop, BorderLayout.SOUTH);
		
		return buttonPanel;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		JButton buttonPressed = (JButton)e.getSource();
		if (buttonPressed.equals(vanilla))
		{
			iceCreamCone.addScoop("Vanilla");
		}
		else if (buttonPressed.equals(greenTea))
		{
			iceCreamCone.addScoop("Green tea");
		}
		else if (buttonPressed.equals(peach))
		{
			iceCreamCone.addScoop("Peach");
		}
		else if (buttonPressed.equals(mint))
		{
			iceCreamCone.addScoop("Mint");
		}
		else
		{
			iceCreamCone.removeScoop();
		}
		refreshDisplay();
	}
	public void refreshDisplay()
	{
		repaint();
	}
	
	public IceCreamCone getCone()
	{
		return iceCreamCone;
	}
}
