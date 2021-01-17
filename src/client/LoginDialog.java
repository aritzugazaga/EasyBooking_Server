package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPasswordField;

public class LoginDialog {

	private JFrame frmEasyBooking;
	private JTextField email;
	private JPasswordField contrase�a;

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
		
		email = new JTextField();
		email.setToolTipText("");
		email.setForeground(Color.WHITE);
		email.setBounds(116, 77, 189, 20);
		frmEasyBooking.getContentPane().add(email);
		email.setColumns(10);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSesion.setFont(new Font("Arial", Font.PLAIN, 12));
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					LoginController.getInstance().login(email.toString(), contrase�a.toString());
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		});
		btnIniciarSesion.setBounds(226, 180, 110, 25);
		frmEasyBooking.getContentPane().add(btnIniciarSesion);
		
		JButton btnRegistrarse = new JButton("Registrase");
		btnRegistrarse.setForeground(new Color(0, 0, 0));
		btnRegistrarse.setFont(new Font("Arial", Font.PLAIN, 12));
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					LoginController.getInstance().register(email.toString(), contrase�a.toString());
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		});
		btnRegistrarse.setBounds(96, 180, 110, 25);
		frmEasyBooking.getContentPane().add(btnRegistrarse);
		
		JLabel lblEasyBooking = new JLabel("Easy Booking");
		lblEasyBooking.setHorizontalAlignment(SwingConstants.CENTER);
		lblEasyBooking.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblEasyBooking.setBounds(137, 27, 136, 23);
		frmEasyBooking.getContentPane().add(lblEasyBooking);
		
		contrase�a = new JPasswordField();
		contrase�a.setBounds(116, 127, 189, 20);
		frmEasyBooking.getContentPane().add(contrase�a);
	}
}
