package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;

public class LoginDialog {

	private JFrame frmEasyBooking;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginDialog window = new LoginDialog();
					window.frmEasyBooking.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginDialog() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEasyBooking = new JFrame();
		frmEasyBooking.getContentPane().setBackground(Color.WHITE);
		frmEasyBooking.getContentPane().setForeground(new Color(255, 255, 255));
		frmEasyBooking.setForeground(Color.WHITE);
		frmEasyBooking.setTitle("Easy Booking");
		frmEasyBooking.setBounds(100, 100, 450, 300);
		frmEasyBooking.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEasyBooking.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setForeground(Color.WHITE);
		textField.setBounds(116, 77, 189, 20);
		frmEasyBooking.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSesion.setFont(new Font("Arial", Font.PLAIN, 12));
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnIniciarSesion.setBounds(226, 180, 110, 25);
		frmEasyBooking.getContentPane().add(btnIniciarSesion);
		
		JButton btnNewButton_1 = new JButton("Registrase");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_1.setBounds(96, 180, 110, 25);
		frmEasyBooking.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Easy Booking");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel.setBounds(137, 27, 136, 23);
		frmEasyBooking.getContentPane().add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(116, 127, 189, 20);
		frmEasyBooking.getContentPane().add(passwordField);
	}
}
