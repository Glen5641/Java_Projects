import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginView extends JFrame implements ActionListener , KeyListener{

	private static final long serialVersionUID = 6399080280316193514L;
	HashMap<String, String> passwords;

	GridBagConstraints c = new GridBagConstraints();
	JLabel username = new JLabel("Username");
	JLabel p = new JLabel("Password");
	JPanel p1 = new JPanel(new GridBagLayout());
	JPanel p2 = new JPanel(new GridBagLayout());
	JPanel p3 = new JPanel(new GridBagLayout());
	JPanel p4 = new JPanel(new GridBagLayout());
	JPanel p5 = new JPanel(new BorderLayout());
	JTextField user = new JTextField();
	JTextField pass = new JTextField();
	JButton login = new JButton("Login");

	public LoginView() {

		c.fill = GridBagConstraints.NONE;
		c.weightx = 1;
		username.setHorizontalAlignment(SwingConstants.RIGHT);
		user.setHorizontalAlignment(SwingConstants.LEFT);
		p.setHorizontalAlignment(SwingConstants.RIGHT);
		pass.setHorizontalAlignment(SwingConstants.LEFT);
		login.addActionListener(this);
		login.addKeyListener(this);
		pass.addKeyListener(this);

		try {
			addComponent(p1, new JLabel(new ImageIcon(ImageIO.read(new File("occupoint.ico")))), 0, 0, 2, 1,
					new Insets(10, 10, 10, 10));
		} catch (IOException e) {
		}
		addComponent(p2, username, 0, 0, 1, 1, new Insets(1, 1, 1, 1));
		addComponent(p2, p, 1, 0, 1, 1, new Insets(1, 1, 1, 1));
		addComponent(p3, user, 1, 1, 100, 1, new Insets(1, 1, 1, 1), 150 , 1);
		addComponent(p3, pass, 2, 1, 100, 1, new Insets(1, 1, 1, 1), 150, 1);
		addComponent(p4, p2, 0, 0, 1, 1, new Insets(1, 1, 1, 1));
		addComponent(p4, p3, 0, 1, 1, 1, new Insets(1, 1, 1, 1));
		
		p5.add(login, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setTitle("OccuPointer");
		setSize(320, 300);
		setLocation(500, 240);
		add(p1, BorderLayout.NORTH);
		add(p4, BorderLayout.CENTER);
		add(p5, BorderLayout.SOUTH);
		setVisible(true);
	}

	public void addComponent(JPanel panel, JComponent component2, int row, int column, int width, int height,
			Insets inset) {
		c.gridx = column;
		c.gridy = row;
		c.gridwidth = width;
		c.gridheight = height;
		c.insets = inset;
		c.ipadx = 0;
		c.ipady = 0;
		panel.add(component2, c);
	}
	
	public void addComponent(JPanel panel, JComponent component2, int row, int column, int width, int height,
			Insets inset, int ipadx, int ipady) {
		c.gridx = column;
		c.gridy = row;
		c.gridwidth = width;
		c.gridheight = height;
		c.insets = inset;
		c.ipadx = ipadx;
		c.ipady = ipady;
		panel.add(component2, c);
	}
	
	public void setPasswords(HashMap<String, String> passwords) {
		this.passwords = passwords;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String password = "";
		try {
			password = passwords.get(user.getText().toLowerCase());
		} catch (NullPointerException n) {
			JOptionPane.showMessageDialog(this, "Please enter a valid username", "Invalid Username",
					JOptionPane.WARNING_MESSAGE);
		}
		if (password == null) {
			JOptionPane.showMessageDialog(this, "Please enter a valid username", "Invalid Username",
					JOptionPane.WARNING_MESSAGE);
		} else {
			if (password.equals(pass.getText())) {
				Driver.setMVC();
				setVisible(false);
			} else {
				JOptionPane.showMessageDialog(this, "Please enter a valid password", "Invalid Password",
						JOptionPane.WARNING_MESSAGE);
			}
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_ENTER){
			String password = "";
			try {
				password = passwords.get(user.getText().toLowerCase());
			} catch (NullPointerException n) {
				JOptionPane.showMessageDialog(this, "Please enter a valid username", "Invalid Username",
						JOptionPane.WARNING_MESSAGE);
			}
			if (password == null) {
				JOptionPane.showMessageDialog(this, "Please enter a valid username", "Invalid Username",
						JOptionPane.WARNING_MESSAGE);
			} else {
				if (password.equals(pass.getText())) {
					Driver.setMVC();
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(this, "Please enter a valid password", "Invalid Password",
							JOptionPane.WARNING_MESSAGE);
				}
			}
        }
	}

	@Override
	public void keyReleased(KeyEvent arg0) {		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {		
	}
}
