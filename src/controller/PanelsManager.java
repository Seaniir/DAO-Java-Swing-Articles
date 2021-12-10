package controller;

import vues.CreateArticle;
import vues.HomePage;
import vues.SignInUp;

import javax.swing.*;

public class PanelsManager {
    public static JPanel contentPane;
    public static JPanel switchHomePage() {return new HomePage();}
    public static JPanel switchCreateArticle() {return new CreateArticle();}
    public static JPanel switchSignInUp() {return new SignInUp();}
}
