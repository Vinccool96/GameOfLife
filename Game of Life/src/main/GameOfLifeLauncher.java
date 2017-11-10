package main;

import controleur.Controleur;

public class GameOfLifeLauncher {

	public static void main(String[] args) {
		Controleur controleur = new Controleur(50);
		controleur.start();
	}

}
