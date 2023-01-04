package thread.slideshow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class ImageSlideShow extends JFrame {
	JLabel lbl;
	JTextField tf;
	int time;
	ImageThread t;
	
	public ImageSlideShow() {
		JPanel pan = new JPanel();
		tf = new JTextField(10);
		JButton btnTime = new JButton("시간설정");
		btnTime.addActionListener(btnL);
		pan.add(tf);
		pan.add(btnTime);
		add(pan, "North");
		
		ImageIcon icon = new ImageIcon("images/idol01.jpg");
		lbl = new JLabel(icon);
		add(lbl, "Center");
		
		setTitle("이미지슬라이드쇼");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(20, 30, 400, 400);
		setVisible(true);
		setResizable(false);
		t = new ImageThread(lbl);
		t.start();
	}

	public static void main(String[] args) {
		new ImageSlideShow();
	}
	
	ActionListener btnL = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			time = (int) (Double.parseDouble(tf.getText())*1000);	
			t.setTime(time);
		}
	};

}