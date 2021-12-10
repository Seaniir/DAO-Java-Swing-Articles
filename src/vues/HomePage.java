package vues;

import controller.ArticleDao;
import controller.PanelsManager;
import model.Article;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomePage extends JPanel {
	private JTable table;
	/**
	 * Create the panel.
	 */

	public HomePage() {
		int scrollHeigth = 0;
		setLayout(null);
		setVisible(true);
		setBounds(0, 0, 800, 564);
		ArticleDao articleDao = new ArticleDao();
		articleDao.readAll();
		if(Article.listeArticles.size() != 0)
		{
			JPanel articlesPanel = new JPanel();
			articlesPanel.setLayout(null);
			articlesPanel.setBounds(47, 47, 536, 489);
			System.out.println("Fire !");
			int yLabel = 0;
			int yResume = 30;
			int yDate = 60;
			int yAuteur = 90;
			for (int i = 0 ; i < Article.listeArticles.size() ; i++)
			{
				JLabel newLabel = new JLabel(Article.listeArticles.get(i).getTitre());
				newLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
				JLabel resumeLabel = new JLabel(Article.listeArticles.get(i).getResume());
				resumeLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				Date dateObj = Article.listeArticles.get(i).getCreated_at();
				String text = df.format(dateObj);
				JLabel dateLabel = new JLabel(text);
				resumeLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
				JLabel auteurLabel = new JLabel(Article.listeArticles.get(i).getAuteur());
				resumeLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
					newLabel.setBounds(10, yLabel, 351, 39);
					resumeLabel.setBounds(10, yResume, 351, 39);
					dateLabel.setBounds(10, yDate, 351, 39);
					auteurLabel.setBounds(10, yAuteur, 351, 39);
				articlesPanel.add(newLabel);
				articlesPanel.add(resumeLabel);
				articlesPanel.add(dateLabel);
				articlesPanel.add(auteurLabel);
				yLabel += 200;
				yResume += 200;
				yDate += 200;
				yAuteur += 200;
				scrollHeigth += 200;
			}
			JScrollPane scroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			articlesPanel.setPreferredSize(new Dimension(500,scrollHeigth));
			scroll.setViewportView(articlesPanel);
			scroll.setVisible(true);
			scroll.setBounds(100, 100, 500, 300);
			add(scroll);
		}
		else
		{
			JLabel noArticles = new JLabel("D\u00e9sol\u00e9, aucuns article, mais vous pouvez en cr\u00e9er un !");
			noArticles.setFont(new Font("Tahoma", Font.PLAIN, 16));
			noArticles.setBounds(10, 40, 500, 39);
			add(noArticles);
		}
		if(User.currentUser != null) {
			JLabel UserIsConnected = new JLabel("Bienvenu(e), "+ User.currentUser.getPrenom() + " " + User.currentUser.getNom() + " !");
			UserIsConnected.setFont(new Font("Tahoma", Font.PLAIN, 16));
			UserIsConnected.setBounds(10, 11, 351, 39);
			add(UserIsConnected);
			JButton articleCreateButton = new JButton("Cr\u00e9er un article");
			articleCreateButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					removeAll();
					add(PanelsManager.switchCreateArticle());
					repaint();
					revalidate();
				}
			});
			articleCreateButton.setBounds(577, 11, 196, 23);
			add(articleCreateButton);
		}
		else
		{
			JLabel UserIsNotConnected = new JLabel("Bienvenu(e), vous n'\u00eates pas connect\u00e9  !");
			UserIsNotConnected.setFont(new Font("Tahoma", Font.PLAIN, 16));
			UserIsNotConnected.setBounds(10, 11, 335, 39);
			add(UserIsNotConnected);
			JButton btnNewButton = new JButton("Connexion/Inscription");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PanelsManager.contentPane.removeAll();
					PanelsManager.contentPane.add(PanelsManager.switchSignInUp());
					PanelsManager.contentPane.repaint();
					PanelsManager.contentPane.revalidate();
				}
			});
			btnNewButton.setBounds(577, 11, 196, 23);
			add(btnNewButton);
		}
	}
}
