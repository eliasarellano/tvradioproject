
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.io.File;
import java.io.IOException;

public class RemoteView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		mainframe marco1 = new mainframe();
//		marco1.setVisible(true);
//		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CenteredFrame mainframe = new CenteredFrame();
		mainframe.setVisible(true);
 		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class CenteredFrame extends JFrame{
	public CenteredFrame() {
		//setSize(500,600);
		Toolkit mainwindow = Toolkit.getDefaultToolkit();
		Dimension sizeWindow = mainwindow.getScreenSize();
		
		int windowHeight = sizeWindow.height;
		int windowWidth = sizeWindow.width;
		
		setSize(windowWidth/2, 800);
		
		setLocation(windowWidth/4,100);
		setTitle("CenteredFrame");

		Sheet mainSheet = new Sheet();
		add(mainSheet);
		
//		SheetConFiguras miSheetconfiguras = new SheetConFiguras();
//		add(miSheetconfiguras);
	}

}

class Sheet extends JPanel implements ActionListener {
	
	private Image TvImageOn;
	private Image TvImageOff;
	private Image RadioImageOn;
	private Image RadioImageOff;
	
	//Set buttons for TV
	
	JButton ButtonTvVolUp = new JButton("▲");
	JButton ButtonTvVolDown = new JButton("▼");
	JButton ButtonTvChUp = new JButton("▲");
	JButton ButtonTvChDown = new JButton("▼");
	
	// Set Buttons for Radio
	
	JButton ButtonRadioVolUp = new JButton("▲");
	JButton ButtonRadioVolDown = new JButton("▼");
	JButton ButtonRadioChUp = new JButton("▲");
	JButton ButtonRadioChDown = new JButton("▼");
	
	//Set Butttons for All /ON OFF/ Undo 
	
	JButton ButtonRadioOn = new JButton("On");
	JButton ButtonRadioOff = new JButton("Off");
	JButton ButtonTvOn = new JButton("On");
	JButton ButtonTvOff = new JButton("Off");
	JButton ButtonAll = new JButton("On/Off");
	JButton ButtonUndo = new JButton("<=");
	
	JLabel textVolTV = new JLabel("0");
	JLabel textChTV = new JLabel("0");
	JLabel textVolRadio = new JLabel("0");
	JLabel textChRadio = new JLabel("0");
	
	int total = 0;
	
	public Sheet() {
		
		
		add(ButtonTvVolUp);
		add(ButtonTvVolDown);
		add(ButtonTvChUp);
		add(ButtonTvChDown);
		add(ButtonRadioVolUp);
		add(ButtonRadioVolDown);
		add(ButtonRadioChUp);
		add(ButtonRadioChDown);
		add(ButtonRadioOn);
		add(ButtonRadioOff);
		add(ButtonTvOn);
		add(ButtonTvOff);
		add(ButtonAll);
		add(ButtonUndo);
		
		ButtonTvVolUp.addActionListener(this);
		ButtonTvVolDown.addActionListener(this);
		ButtonTvChUp.addActionListener(this);
		ButtonTvChDown.addActionListener(this);
		ButtonRadioVolUp.addActionListener(this);
		ButtonRadioVolDown.addActionListener(this);
		ButtonRadioChUp.addActionListener(this);
		ButtonRadioChDown.addActionListener(this);
		ButtonRadioOn.addActionListener(this);
		ButtonRadioOff.addActionListener(this);
		ButtonTvOn.addActionListener(this);
		ButtonTvOff.addActionListener(this);
		ButtonAll.addActionListener(this);
		ButtonUndo.addActionListener(this);
		
		setLayout(null);
		
		add(textVolTV);
		add(textChTV);
		add(textVolRadio);
		add(textChRadio);
		
		textVolTV.setBounds(240, 355,30,30);
		textChTV.setBounds(240, 305,30,30);
		textVolRadio.setBounds(815, 355,30,30);
		textChRadio.setBounds(815, 305,30,30);
		
		textVolTV.setFont(new Font("Courier", Font.ITALIC, 26));
		textChTV.setFont(new Font("Courier", Font.ITALIC, 26));
		textVolRadio.setFont(new Font("Courier", Font.ITALIC, 26));
		textChRadio.setFont(new Font("Courier", Font.ITALIC, 26));
		
		ButtonTvChUp.setBounds(88, 490,50,50);
		ButtonTvChDown.setBounds(88, 560,50,50);
		ButtonTvVolUp.setBounds(215, 490,50,50);
		ButtonTvVolDown.setBounds(215, 560,50,50);
		ButtonRadioChUp.setBounds(665, 490,50,50);
		ButtonRadioChDown.setBounds(665,560,50,50);
		ButtonRadioVolUp.setBounds(792, 490,50,50);
		ButtonRadioVolDown.setBounds(792, 560 ,50,50);
		ButtonRadioOn.setBounds(725, 650,60,60);
//		ButtonRadioOff.setBounds(27, 20,90,90);
		ButtonTvOn.setBounds(145, 650,60,60);
//		ButtonTvOff.setBounds(27, 20,90,90);
		ButtonAll.setBounds(455, 375,80,80);
		ButtonUndo.setBounds(475, 465,60,60);
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object pressedButton = e.getSource();
		
		if(pressedButton == ButtonTvVolUp ) {
			System.out.println("Pressed button");
			total++;
			
			textVolTV.setText(Integer.toString(total));
		}
		if(pressedButton == ButtonTvVolDown ) {
			System.out.println("Pressed button");	
		}
		if(pressedButton == ButtonTvChUp ) {
			System.out.println("Pressed button");
		}
		if(pressedButton == ButtonTvChDown ) {
			System.out.println("Pressed button");
		}
		if(pressedButton == ButtonRadioVolUp ) {
			System.out.println("Pressed button");
		}
		if(pressedButton == ButtonRadioVolDown ) {
			System.out.println("Pressed button");
		}
		if(pressedButton == ButtonRadioChUp ) {
			System.out.println("Pressed button");
		}
		if(pressedButton == ButtonRadioChDown ) {
			System.out.println("Pressed button");
		}
		if(pressedButton == ButtonRadioOn ) {
			System.out.println("Pressed button");
		}
		if(pressedButton == ButtonRadioOff ) {
			System.out.println("Pressed button");
		}
		if(pressedButton == ButtonTvOn ) {
			System.out.println("Pressed button");
		}
		if(pressedButton == ButtonTvOff ) {
			System.out.println("Pressed button");
		}
		if(pressedButton == ButtonAll ) {
			System.out.println("Pressed button");
		}
		if(pressedButton == ButtonUndo ) {
			System.out.println("Pressed button");
		}
	}
	
	public void paintComponent (Graphics g) {

		super.paintComponent(g);
	//	g.drawRect(50,50,200,200);
		
		Graphics2D g2 = (Graphics2D) g;
		
		Rectangle2D ChanelVolTV = new Rectangle2D.Double(75,300,200,100);
		Rectangle2D ChanelVolRadio = new Rectangle2D.Double(650,300,200,100);
		Rectangle2D ChanelTV = new Rectangle2D.Double(88,475,50,150);
		Rectangle2D ChanelRadio = new Rectangle2D.Double(665,475,50,150);
		Rectangle2D VolTV = new Rectangle2D.Double(215,475,50,150);
		Rectangle2D VolRadio = new Rectangle2D.Double(792,475,50,150);
		Rectangle2D AllUndo = new Rectangle2D.Double(385,375,150,150);
		
		g2.draw(ChanelVolTV);
		g2.draw(ChanelVolRadio);
		g2.draw(ChanelTV);
		g2.draw(VolTV);
		g2.draw(ChanelRadio);
		g2.draw(VolRadio);
		g2.draw(AllUndo);
		
		g2.setPaint(Color.WHITE);
		g2.fill(ChanelVolTV);
		g2.fill(ChanelVolRadio);
		g2.fill(ChanelTV);
		g2.fill(ChanelRadio);
		g2.fill(VolTV);
		g2.fill(VolRadio);
		g2.fill(AllUndo);
		
		
		//Titles TV and Radio
		Font TvFont = new Font("Courier",Font.BOLD,56);
		g2.setFont(TvFont);
		g2.setColor(Color.BLUE);
		g2.drawString("TV", 140, 120);
		
		Font RadioFont = new Font("Courier",Font.BOLD,56);
		g2.setFont(RadioFont);
		g2.setColor(Color.ORANGE);
		g2.drawString("Radio", 660, 120);
		
		
		//Chanel and Vol of TV next to values
		Font ChanelTvVar = new Font("Courier",Font.BOLD,30);
		g2.setFont(ChanelTvVar);
		g2.setColor(Color.BLACK);
		g2.drawString("Chanel", 85, 330);
		
		Font VolTvVar = new Font("Courier",Font.BOLD,30);
		g2.setFont(VolTvVar);
		g2.setColor(Color.BLACK);
		g2.drawString("Volume",85, 380);
		
		//Chanel and Vol of Radio next to values
		Font ChanelRadioVar = new Font("Courier",Font.BOLD,30);
		g2.setFont(ChanelRadioVar);
		g2.setColor(Color.BLACK);
		g2.drawString("Chanel", 660, 330);
		
		Font VolRadioVar = new Font("Courier",Font.BOLD,30);
		g2.setFont(VolRadioVar);
		g2.setColor(Color.BLACK);
		g2.drawString("Volume", 660, 380);
		
		//Title Buttons TV
		
		Font ChTv = new Font("Courier",Font.BOLD,30);
		g2.setFont(ChTv);
		g2.setColor(Color.BLACK);
		g2.drawString("CH", 95, 460);
		
		Font VolTv = new Font("Courier",Font.BOLD,30);
		g2.setFont(VolTv);
		g2.setColor(Color.BLACK);
		g2.drawString("VOL", 210, 460);
		
		//Title Buttons Radio
		
		Font ChRad = new Font("Courier",Font.BOLD,30);
		g2.setFont(ChRad);
		g2.setColor(Color.BLACK);
		g2.drawString("CH", 670, 460);
				
		Font VolRad = new Font("Courier",Font.BOLD,30);
		g2.setFont(VolRad);
		g2.setColor(Color.BLACK);
		g2.drawString("VOL", 790, 460);
		
		//Title Buttons All OF/ON and Undo
		
		Font AllTitle = new Font("Courier",Font.BOLD,30);
		g2.setFont(AllTitle);
		g2.setColor(Color.BLACK);
		g2.drawString("ALL", 395, 420);
				
		Font UndoTitle = new Font("Courier",Font.BOLD,30);
		g2.setFont(UndoTitle);
		g2.setColor(Color.BLACK);
		g2.drawString("Undo", 395, 500);
		
		//Set Image TV On
		File ImageTVOn = new File("src/Images/TvOn.png");
		try {
		TvImageOn = ImageIO.read(ImageTVOn);		
		}
		catch(IOException e) {
			System.out.println("Image Not Found");
		}
		
		g.drawImage(TvImageOn,100,130,150,150,null,null);
		
		//Set Image Radio On
		File ImageRadioOn = new File("src/Images/RadioOn.png");
		try {
			RadioImageOn = ImageIO.read(ImageRadioOn);		
		}
		catch(IOException e) {
			System.out.println("Image Not Found");
		}
		
		g.drawImage(RadioImageOn,670,130,180,150,null,null);
		

		
		}

}
	



