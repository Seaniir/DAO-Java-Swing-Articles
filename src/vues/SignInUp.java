package vues;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controller.ArticleDao;
import controller.UserDao;
import model.Article;
import model.User;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.regex.Pattern;

public class SignInUp extends JPanel {
	private JTextField emailFieldLogin;
	private JPasswordField passwordFieldLogin;
	private JTextField nameField;
	private JTextField prenomField;
	private JTextField emailField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public SignInUp(JPanel contentPane, JPanel oldPane) {
		setLayout(null);
		setVisible(true);
		setBounds(0, 0, 800, 564);
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 379, 454);
		panel.setLayout(null);
		panel.setBackground(Color.ORANGE);
		add(panel);
		
		JLabel lblConnexion = new JLabel("Connexion");
		lblConnexion.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblConnexion.setBounds(125, 11, 133, 46);
		panel.add(lblConnexion);
		
		emailFieldLogin = new JTextField();
		emailFieldLogin.setColumns(10);
		emailFieldLogin.setBounds(176, 168, 133, 20);
		panel.add(emailFieldLogin);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Email");
		lblNewLabel_1_2_1.setBounds(76, 171, 46, 14);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Mot de passe");
		lblNewLabel_1_3_1.setBounds(76, 218, 74, 14);
		panel.add(lblNewLabel_1_3_1);
		
		JButton btnConnexion = new JButton("Connexion !");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String email_saisie = emailFieldLogin.getText();
				//String pwd_saisie = pwd_login.getPassword().toString();
				String pwd_saisie = String.valueOf(passwordFieldLogin.getText());

				User nouveau = new User();

				nouveau.setEmail(email_saisie);
				nouveau.setPwd(pwd_saisie);

				UserDao usDao = new UserDao();

				usDao.login(email_saisie, pwd_saisie);

				if(usDao.login(email_saisie, pwd_saisie)) {
					JOptionPane.showMessageDialog(null, "Connecté !");
					contentPane.removeAll();
					contentPane.add(new HomePage(contentPane, oldPane));
					contentPane.repaint();
					contentPane.revalidate();
				}else {
					JOptionPane.showMessageDialog(null, "Impossible de se connecter");
				}
			}
		});
		btnConnexion.setBounds(76, 278, 233, 41);
		panel.add(btnConnexion);
		
		passwordFieldLogin = new JPasswordField();
		passwordFieldLogin.setBounds(176, 216, 133, 17);
		panel.add(passwordFieldLogin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(399, 11, 374, 454);
		panel_1.setLayout(null);
		add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Inscription");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(122, 11, 133, 46);
		panel_1.add(lblNewLabel);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(175, 95, 133, 20);
		panel_1.add(nameField);
		
		prenomField = new JTextField();
		prenomField.setColumns(10);
		prenomField.setBounds(175, 162, 133, 20);
		panel_1.add(prenomField);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(175, 230, 133, 20);
		panel_1.add(emailField);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setBounds(75, 98, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prenom");
		lblNewLabel_1_1.setBounds(75, 165, 46, 14);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Email");
		lblNewLabel_1_2.setBounds(75, 233, 46, 14);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Mot de passe");
		lblNewLabel_1_3.setBounds(75, 299, 71, 14);
		panel_1.add(lblNewLabel_1_3);
		
		JButton btnNewButton = new JButton("Inscription !");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String nom_saisie = nameField.getText();
				String prenom_saisie = prenomField.getText();
				String email_saisie = emailField.getText();
				String pwd_saisie = passwordField.getText();
				User nouvel = new User(nom_saisie, prenom_saisie, email_saisie, pwd_saisie);
				if(!(Pattern.matches("^[a-zA-Z0-9_.-]+[@][a-zA-Z0-9-]+[.]+[a-zA-Z0-9]+$", email_saisie) )) {
					JOptionPane.showMessageDialog(null, "Mail pas valide","Error",JOptionPane.ERROR_MESSAGE);
				}else {
					UserDao userDao = new UserDao();

					if(userDao.mailExist(email_saisie)) {
						userDao.inscription(nouvel);
						JOptionPane.showMessageDialog(null, "Inscris !");
					}else {
						JOptionPane.showMessageDialog(null, "Ce mail existe deja !","Error",JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});
		btnNewButton.setBounds(75, 370, 233, 41);
		panel_1.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(175, 296, 133, 17);
		panel_1.add(passwordField);
		
		JButton returnButton = new JButton("Retour");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				contentPane.add(new HomePage(contentPane, oldPane));
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		returnButton.setBounds(275, 11, 89, 23);
		panel_1.add(returnButton);

	}

}
