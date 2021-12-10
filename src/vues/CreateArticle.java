package vues;

import controller.ArticleDao;
import controller.PanelsManager;
import model.Article;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

public class CreateArticle extends JPanel {
	private JTextField titreField;

	/**
	 * Create the panel.
	 */
	public CreateArticle() {
		setLayout(null);
		setVisible(true);
		setBounds(0, 0, 800, 564);
		
		JLabel lblNewLabel = new JLabel("Titre :");
		lblNewLabel.setBounds(127, 67, 88, 31);
		add(lblNewLabel);
		
		JLabel lblResum = new JLabel("Resum\u00e9 :");
		lblResum.setBounds(127, 153, 88, 31);
		add(lblResum);
		
		JLabel lblContenu = new JLabel("Contenu :");
		lblContenu.setBounds(127, 304, 88, 31);
		add(lblContenu);
		
		titreField = new JTextField();
		titreField.setBounds(209, 72, 371, 20);
		add(titreField);
		titreField.setColumns(10);
		
		JTextArea resumeField = new JTextArea();
		resumeField.setBounds(209, 109, 371, 109);
		add(resumeField);
		
		JTextArea contenuField = new JTextArea();
		contenuField.setBounds(209, 249, 371, 200);
		add(contenuField);
		
		JLabel lblNewLabel_3 = new JLabel("Cr\u00e9er un article");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(234, 25, 296, 31);
		add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Cr\u00e9er l'article");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Article nouvel = new Article(titreField.getText(), resumeField.getText(), contenuField.getText());
				ArticleDao artDao = new ArticleDao();
				artDao.create(nouvel);
			}
		});
		btnNewButton.setBounds(282, 460, 212, 38);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelsManager.contentPane.removeAll();
				PanelsManager.contentPane.add(PanelsManager.switchHomePage());
				PanelsManager.contentPane.repaint();
				PanelsManager.contentPane.revalidate();
			}
		});
		btnNewButton_1.setBounds(685, 11, 89, 23);
		add(btnNewButton_1);
	}
}
