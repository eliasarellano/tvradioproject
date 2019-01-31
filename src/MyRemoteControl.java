import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import sun.audio.*;
import java.applet.AudioClip;


import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyRemoteControl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File file = new File ("Tiago.mp4");

		CenteredFrame mainframe = new CenteredFrame();
		mainframe.setVisible(true);
 		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		
	}

}

class CenteredFrame extends JFrame{
	public CenteredFrame() {

		Toolkit mainwindow = Toolkit.getDefaultToolkit();
		Dimension sizeWindow = mainwindow.getScreenSize();
		
		int windowHeight = sizeWindow.height;
		int windowWidth = sizeWindow.width;
		
		setSize(windowWidth/2, 800);
		
		setLocation(windowWidth/4,100);
		setTitle("CenteredFrame");

		Sheet mainSheet = new Sheet();
		add(mainSheet);

	}

}

class Sheet extends JPanel implements ActionListener {

	//Declaration of TV and radio 
	radio radio = new radio();
	television television = new television();
	
	public void deviceInit() {
		radio.initDevice();
		television.initDevice();
	}
	
	
	private Image TvImageOn;
	//private Image TvImageOff;
	private Image RadioImageOn;
	private Image RadioImageOff;
	private Image RemoteCtrl;
	
	private Image Imgch1;
	private Image Imgch2;
	private Image Imgch3;
	private Image Imgch4;
	private Image Imgch5;
	private Image Imgch6;
	private Image Imgch7;
	private Image Imgch8;
	private Image Imgch9;
	private Image Imgch10;
	
	//Set buttons for TV
	JButton ButtonTvVolUp = new JButton(new ImageIcon("src/Images/increasevolbutton.png"));
	JButton ButtonTvVolDown = new JButton(new ImageIcon("src/Images/decreasevolbutton.png"));
	JButton ButtonTvChUp = new JButton("▲");
	JButton ButtonTvChDown = new JButton("▼");
	
	// Set Buttons for Radio
	//JButton ButtonRadioVolUp = new JButton("â–²");
	//JButton ButtonRadioVolDown = new JButton("â–¼");
	JButton ButtonRadioVolUp = new JButton(new ImageIcon("src/Images/increasevolbutton.png"));
	JButton ButtonRadioVolDown = new JButton(new ImageIcon("src/Images/decreasevolbutton.png"));
	JButton ButtonRadioChUp = new JButton("▲");
	JButton ButtonRadioChDown = new JButton("▼");
	
	//Set Buttons for All /ON OFF/ Undo 
	JButton ButtonRadioOn = new JButton(new ImageIcon("src/Images/powerbutton.png"));
	JButton ButtonRadioOff = new JButton("Off");
	JButton ButtonTvOn = new JButton(new ImageIcon("src/Images/powerbutton.png"));
	JButton ButtonTvOff = new JButton("Off");
	JButton ButtonAllOn = new JButton("All On");
	JButton ButtonAllOff = new JButton("All Off");
	JButton ButtonUndo = new JButton("Undo");
	
	JLabel textVolTV = new JLabel(String.valueOf(television.getVolume()));
	JLabel textChTV = new JLabel(String.valueOf(television.getChannel()));
	JLabel textVolRadio = new JLabel(String.valueOf(radio.getVolume()));
	JLabel textChRadio = new JLabel(String.valueOf(radio.getChannel()));
	
	JLabel UpdateGraphic = new JLabel("");
	
	public Sheet() {
	//	this.deviceInit();
		
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
		add(ButtonAllOn);
		add(ButtonAllOff);
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
		ButtonAllOn.addActionListener(this);
		ButtonAllOff.addActionListener(this);
		ButtonUndo.addActionListener(this);
		
		setLayout(null);
		
		add(textVolTV);
		add(textChTV);
		add(textVolRadio);
		add(textChRadio);
		add(UpdateGraphic);
		
		textVolTV.setBounds(465, 325,30,30);
		textChTV.setBounds(465, 275,30,30);
		textVolRadio.setBounds(1040, 325,30,30);
		textChRadio.setBounds(1040, 275,30,30);
		UpdateGraphic.setBounds(1,1,1,1);
		
		textVolTV.setFont(new Font("Courier", Font.ITALIC, 26));
		textChTV.setFont(new Font("Courier", Font.ITALIC, 26));
		textVolRadio.setFont(new Font("Courier", Font.ITALIC, 26));
		textChRadio.setFont(new Font("Courier", Font.ITALIC, 26));
		
		textChTV.setText(Integer.toString(television.getTotalChannel()));
		textVolTV.setText(Integer.toString(television.getTotalVolume()));
		textChRadio.setText(Integer.toString(radio.getTotalChannel()));
		textVolRadio.setText(Integer.toString(radio.getTotalVolume()));
		
		UpdateGraphic.setFont(new Font("Courier", Font.ITALIC, 26));
		
		//Tv Buttons
		ButtonTvOn.setBounds(461, 483,50,50);
   //   ButtonTvOff.setBounds(27, 20,90,90);
		ButtonTvChUp.setBounds(517, 540,48,48);
		ButtonTvChDown.setBounds(517, 604,50,50);
		ButtonTvVolUp.setBounds(557,575,40,40);
		ButtonTvVolDown.setBounds(489,575,40,40);
		
		//Radio Buttons
		ButtonRadioOn.setBounds(714, 480,50,50);
//		ButtonRadioOff.setBounds(27, 20,90,90);
		ButtonRadioChUp.setBounds(783, 531,48,48);
		ButtonRadioChDown.setBounds(783,595,50,50);
		ButtonRadioVolUp.setBounds(822,565,40,40);
		ButtonRadioVolDown.setBounds(756,565,40,40);

		ButtonAllOn.setBounds(623, 466,90,90);
		ButtonAllOff.setBounds(623, 598,90,90);
		ButtonUndo.setBounds(624, 533,90,90);
		
	 //Customize buttons (color, forms,...)
		//Tv Buttons
		ButtonTvOn.setOpaque(false);
		ButtonTvOn.setContentAreaFilled(false);
		ButtonTvOn.setBorderPainted(false);
		//ButtonTvOn.setFocusPainted(false);
		
		ButtonTvChUp.setForeground(Color.white);
		ButtonTvChUp.setOpaque(false);
		ButtonTvChUp.setContentAreaFilled(false);
		ButtonTvChUp.setBorderPainted(false);
		
		ButtonTvChDown.setForeground(Color.white);
		ButtonTvChDown.setOpaque(false);
		ButtonTvChDown.setContentAreaFilled(false);
		ButtonTvChDown.setBorderPainted(false);
		
		ButtonTvVolUp.setOpaque(false);
		ButtonTvVolUp.setContentAreaFilled(false);
		ButtonTvVolUp.setBorderPainted(false);
		
		ButtonTvVolDown.setOpaque(false);
		ButtonTvVolDown.setContentAreaFilled(false);
		ButtonTvVolDown.setBorderPainted(false);
		
		
		//Radio Buttons
		ButtonRadioOn.setOpaque(false);
		ButtonRadioOn.setContentAreaFilled(false);
		ButtonRadioOn.setBorderPainted(false);
		
		ButtonRadioChUp.setForeground(Color.WHITE);
		ButtonRadioChUp.setOpaque(false);
		ButtonRadioChUp.setContentAreaFilled(false);
		ButtonRadioChUp.setBorderPainted(false);
		
		ButtonRadioChDown.setForeground(Color.WHITE);
		ButtonRadioChDown.setOpaque(false);
		ButtonRadioChDown.setContentAreaFilled(false);
		ButtonRadioChDown.setBorderPainted(false);
		
		ButtonRadioVolUp.setOpaque(false);
		ButtonRadioVolUp.setContentAreaFilled(false);
		ButtonRadioVolUp.setBorderPainted(false);
		
		ButtonRadioVolDown.setOpaque(false);
		ButtonRadioVolDown.setContentAreaFilled(false);
		ButtonRadioVolDown.setBorderPainted(false);
		
		//All On, All Off, Undo Buttons
		ButtonAllOn.setForeground(Color.BLACK);
		ButtonAllOn.setOpaque(false);
		ButtonAllOn.setContentAreaFilled(false);
		ButtonAllOn.setBorderPainted(false);
		
		ButtonAllOff.setForeground(Color.BLACK);
		ButtonAllOff.setOpaque(false);
		ButtonAllOff.setContentAreaFilled(false);
		ButtonAllOff.setBorderPainted(false);
		
		ButtonUndo.setForeground(Color.BLACK);
		ButtonUndo.setOpaque(false);
		ButtonUndo.setContentAreaFilled(false);
		ButtonUndo.setBorderPainted(false);
	}
		
	

public void actionPerformed(ActionEvent e) {
	Graphics g;
	Object pressedButton = e.getSource();
	
	//Sounds for radio 
	File Chanel1 = new File("0999.wav");
	File Chanel2 = new File("0579.wav");
	
	//Tv Buttons
	

	if(pressedButton == ButtonTvOn ) {

		television.setOnOff(!television.getOnOff());
		
	}
	if (television.getOnOff()) {
		if(pressedButton == ButtonTvChUp) {

			television.setChannel(television.getTotalChannel()+1);
			radio.notUndo();
			textChTV.setText(Integer.toString(television.getTotalChannel()));
		
		}
		if(pressedButton == ButtonTvChDown ) {
		
			television.setChannel(television.getTotalChannel()-1);
			radio.notUndo();
			textChTV.setText(Integer.toString(television.getTotalChannel()));
		}
		if(pressedButton == ButtonTvVolUp ) {

			television.setVolume(television.getTotalVolume()+1);
			radio.notUndo();
			textVolTV.setText(Integer.toString(television.getTotalVolume()));
		}
		if(pressedButton == ButtonTvVolDown ) {

			television.setVolume(television.getTotalVolume()-1);
			radio.notUndo();
			textVolTV.setText(Integer.toString(television.getTotalVolume()));
		}
	} else if (television.getOnOff()==false) {
		/* Do nothing */
	}
	
	if(pressedButton == ButtonRadioOn ) {
	
		radio.setOnOff(!radio.getOnOff());
	}
	
	if(radio.getOnOff()) {
		if(pressedButton == ButtonRadioChUp ) {	
		radio.setChannel(radio.getTotalChannel()+1);
		television.notUndo();
		textChRadio.setText(Integer.toString(radio.getTotalChannel()));
		
		//Trying to play music on the radio 
//		try {
//			Clip clip1 = AudioSystem.getClip();
//			clip1.open(AudioSystem.getAudioInputStream(Chanel1));
//			Clip clip2 = AudioSystem.getClip();
//			clip2.open(AudioSystem.getAudioInputStream(Chanel2));
//				
//		if (radio.getTotalChannel()== 1) {
//
//				clip1.start();
//			} else
//		
//		if (radio.getTotalChannel() == 2) {
//			clip1.stop();
//			clip1.stop();
//				Thread.sleep(2000);
//				clip2.start();
//
//		} else
//		
//		if (radio.getTotalChannel() == 3) {
//			clip2.stop();
//			/*...*/
//		}
//		}  catch(Exception ex) {
//			System.out.println("Error in getting total channel of the radio");
//		} 
	}
	if(pressedButton == ButtonRadioChDown ) {

		radio.setChannel(radio.getTotalChannel()-1);
		television.notUndo();
		textChRadio.setText(Integer.toString(radio.getTotalChannel()));
		
		//Trying to change music un the radio 
//		
//		if (radio.getTotalChannel() == 1) {
//			playSound(Chanel1);
//			
//		}
//		
//		if (radio.getTotalChannel() == 2) {
//			stopSound(Chanel1); //Stop next or previous chanel
//			playSound(Chanel2);
//		}
		
	}
	if(pressedButton == ButtonRadioVolUp ) {

		radio.setVolume(radio.getTotalVolume()+1);
		television.notUndo();
		textVolRadio.setText(Integer.toString(radio.getTotalVolume()));
	}
	if(pressedButton == ButtonRadioVolDown ) {
		radio.setVolume(radio.getTotalVolume()-1);
		television.notUndo();
		textVolRadio.setText(Integer.toString(radio.getTotalVolume()));
	}

	} else if (radio.getOnOff() == false ) {
			/* Do nothing */
		}
	
	//Other Buttons
	if(pressedButton == ButtonAllOn ) {

		television.setOnOff(true);
		radio.setOnOff(true);
	}
	if(pressedButton == ButtonAllOff ) {
		television.setOnOff(false);
		radio.setOnOff(false);
	}
	if(pressedButton == ButtonUndo ) {
		television.undo();
		radio.undo();
		textChRadio.setText(Integer.toString(radio.getTotalChannel()));
		textVolRadio.setText(Integer.toString(radio.getTotalVolume()));
		textChTV.setText(Integer.toString(television.getTotalChannel()));
		textVolTV.setText(Integer.toString(television.getTotalVolume()));
	} 
}

public void playSound (File Sound) {

}

public void stopSound (File Sound) {
	try {
		Clip clip = AudioSystem.getClip();
		clip.stop();

		
	} catch(Exception e) {
		System.out.println("We can't stop the sound");
	} 
}

public void paintComponent (Graphics g) {

	super.paintComponent(g);

	Toolkit mainwindow = Toolkit.getDefaultToolkit();
	Dimension sizeWindow = mainwindow.getScreenSize();
	
	Graphics2D g2 = (Graphics2D) g;
	
	
	Rectangle2D ChanelVolTV = new Rectangle2D.Double(300,270,200,100);
	Rectangle2D ChanelVolRadio = new Rectangle2D.Double(875,270,200,100);
	Rectangle2D AllUndo = new Rectangle2D.Double(385,345,150,150);
	
	Rectangle2D Chanels = new Rectangle2D.Double(314, 111, 176, 108); 

	g2.draw(ChanelVolTV);
	g2.draw(ChanelVolRadio);

	g2.setPaint(Color.WHITE);
	g2.fill(ChanelVolTV);
	g2.fill(ChanelVolRadio);

	//Titles TV and Radio
	Font TvFont = new Font("Courier",Font.BOLD,56);
	g2.setFont(TvFont);
	g2.setColor(Color.BLUE);
	g2.drawString("TV", 365, 70);
	
	Font RadioFont = new Font("Courier",Font.BOLD,56);
	g2.setFont(RadioFont);
	g2.setColor(Color.ORANGE);
	g2.drawString("Radio", 901, 70);
	
	
	//Chanel and Vol of TV next to values
	Font ChanelTvVar = new Font("Courier",Font.BOLD,30);
	g2.setFont(ChanelTvVar);
	g2.setColor(Color.BLACK);
	g2.drawString("Channel", 310, 300);
	
	Font VolTvVar = new Font("Courier",Font.BOLD,30);
	g2.setFont(VolTvVar);
	g2.setColor(Color.BLACK);
	g2.drawString("Volume", 310, 350);
	
	//Chanel and Vol of Radio next to values
	Font ChanelRadioVar = new Font("Courier",Font.BOLD,30);
	g2.setFont(ChanelRadioVar);
	g2.setColor(Color.BLACK);
	g2.drawString("Channel", 885, 300);
	
	Font VolRadioVar = new Font("Courier",Font.BOLD,30);
	g2.setFont(VolRadioVar);
	g2.setColor(Color.BLACK);
	g2.drawString("Volume", 885, 350);
	
	//Title Buttons TV

	//Title Buttons All OF/ON and Undo
	
	Font AllTitle = new Font("Courier",Font.BOLD,30);
	g2.setFont(AllTitle);
	g2.setColor(Color.BLACK);
	//g2.drawString("ALL", 395, 390);
			
	Font UndoTitle = new Font("Courier",Font.BOLD,30);
	g2.setFont(UndoTitle);
	g2.setColor(Color.BLACK);
	//g2.drawString("Undo", 395, 470);
	
	//Set Image TV On
	File ImageTVOn = new File("src/Images/TvOnImg.png");
	try {
	TvImageOn = ImageIO.read(ImageTVOn);		
	}
	catch(IOException e) {
		System.out.println("Image Not Found");
	}
	
	g.drawImage(TvImageOn,302,100,200,150,null,null);
	
	//Set and display Image Radio depending of the status
	File ImageRadioOn = new File("src/Images/RadioOn.png");
	File ImageRadioOff = new File("src/Images/RadioOff.png");
	try {
		RadioImageOff = ImageIO.read(ImageRadioOff);
		RadioImageOn = ImageIO.read(ImageRadioOn);
	}
	catch(IOException e) {
		System.out.println("Image Not Found");
	}

	if (radio.getOnOff()) {
		setSize(800,600);
		setSize(sizeWindow.width,sizeWindow.height); //Refresh the screen
		g.drawImage(RadioImageOn,850,70,250,230,null,null);
	} else if (radio.getOnOff() == false ) {
		setSize(sizeWindow.width,sizeWindow.height); //Refresh screen
		g.drawImage(RadioImageOff,850,70,250,230,null,null);
		setSize(sizeWindow.width,sizeWindow.height); //Refresh the screen
	}
	
	//Set Image RemoteControl
	File ImageRemoteControl = new File ("src/Images/remotecontrol.png");
	try {
		RemoteCtrl = ImageIO.read(ImageRemoteControl); 
	} catch (IOException e) {
		System.out.println("Image Not Found");
	}
	
	g.drawImage(RemoteCtrl, 350, 240, 580, 630, null, null);
	
	//Display of chanels depending of the status
	File ch1Img = new File ("src/Images/homer.jpg");
	File ch2Img = new File("src/Images/captain_america.jpg");
	File ch3Img = new File("src/Images/F24.png");
	File ch4Img = new File("src/Images/TF1.jpeg");
	File ch5Img = new File("src/Images/C8.png");
	File ch6Img = new File("src/Images/NT1.jpg");
	File ch7Img = new File("src/Images/TMC.jpg");
	File ch8Img = new File("src/Images/TFOU.jpg");
	File ch9Img = new File("src/Images/ARTE.jpg");
	File ch10Img = new File("src/Images/M6.jpg");
	if (television.getOnOff()) {
		g.setColor(Color.GREEN);	
		g.fillOval(475, 221, 7, 7);
		setSize(800,600);
		setSize(sizeWindow.width,sizeWindow.height); //Refresh TV by Elias
		if(television.getTotalChannel() == 1) {
			setSize(sizeWindow.width,sizeWindow.height); //Refresh
			
			try {
				Imgch1 = ImageIO.read(ch1Img);		
			}
			catch(IOException ex) {
				System.out.println("Image Not Found");
			}
		
			g.drawImage(Imgch1,315,112,175,106,null,null);
			setSize(sizeWindow.height,sizeWindow.width); //Refresh
		} else 
	
		if(television.getTotalChannel() == 2) {
			
			try {
				Imgch2 = ImageIO.read(ch2Img);		
			}
			catch(IOException ex) {
				System.out.println("Image Not Found");
			}
		
			g.drawImage(Imgch2,315,112,175,106,null,null);
		} else
	
		if (television.getTotalChannel() == 3) {
			try {
				Imgch3 = ImageIO.read(ch3Img);		
			}
			catch(IOException ex) {
				System.out.println("Image Not Found");
			}
		
			g.drawImage(Imgch3,315,112,175,106,null,null);
		} else
		
		if (television.getTotalChannel() == 4) {
			try {
				Imgch4 = ImageIO.read(ch4Img);		
			}
			catch(IOException ex) {
				System.out.println("Image Not Found");
			}
		
			g.drawImage(Imgch4,315,112,175,106,null,null);
		} else
		
		if (television.getTotalChannel() == 5) {
			try {
				Imgch5 = ImageIO.read(ch5Img);		
			}
			catch(IOException ex) {
				System.out.println("Image Not Found");
			}
		
			g.drawImage(Imgch5,315,112,175,106,null,null);
		} else
		
		if (television.getTotalChannel() == 6) {
			try {
				Imgch6 = ImageIO.read(ch6Img);		
			}
			catch(IOException ex) {
				System.out.println("Image Not Found");
			}
		
			g.drawImage(Imgch6,315,112,175,106,null,null);
		} else
		
		if (television.getTotalChannel() == 7) {
			try {
				Imgch7 = ImageIO.read(ch7Img);		
			}
			catch(IOException ex) {
				System.out.println("Image Not Found");
			}
		
			g.drawImage(Imgch7,315,112,175,106,null,null);
		} else
		
		if (television.getTotalChannel() == 8) {
			try {
				Imgch8 = ImageIO.read(ch8Img);		
			}
			catch(IOException ex) {
				System.out.println("Image Not Found");
			}
		
			g.drawImage(Imgch8,315,112,175,106,null,null);
		} else
		
		if (television.getTotalChannel() == 9) {
			try {
				Imgch9 = ImageIO.read(ch9Img);		
			}
			catch(IOException ex) {
				System.out.println("Image Not Found");
			}
		
			g.drawImage(Imgch9,315,112,175,106,null,null);
		} else
		
		if (television.getTotalChannel() == 10) {
			try {
				Imgch10 = ImageIO.read(ch10Img);		
			}
			catch(IOException ex) {
				System.out.println("Image Not Found");
			}
		
			g.drawImage(Imgch10,315,112,175,106,null,null);
		}
		
		
	} else if (television.getOnOff() == false ) {
		setSize(sizeWindow.width,sizeWindow.height); //Refresh
		//Set the point
		g.setColor(Color.RED);
		g.fillOval(475, 221, 7, 7);
		
		//Set the screen of the TV
		g2.draw(Chanels);

		g2.setPaint(Color.GRAY);
		g2.fill(Chanels);

	}
}
}



