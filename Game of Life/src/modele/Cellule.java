package modele;

import java.util.ArrayList;

public class Cellule {

	private int coordonneeX;
	private int coordonneeY;
	private boolean vivante;
	private ArrayList<Cellule> listeVoisines = new ArrayList<>();
	private int nbVoisinesVivantes;

	public Cellule(int coordonneeY, int coordonneeX, boolean vivante) {
		this.coordonneeY = coordonneeY;
		this.coordonneeX = coordonneeX;
		this.vivante = vivante;
		this.nbVoisinesVivantes = 0;
	}

	public int getCoordonneeX() {
		return coordonneeX;
	}

	public void setCoordonneeX(int coordonneeX) {
		this.coordonneeX = coordonneeX;
	}

	public int getCoordonneeY() {
		return coordonneeY;
	}

	public void setCoordonneeY(int coordonneeY) {
		this.coordonneeY = coordonneeY;
	}

	public boolean isVivante() {
		return vivante;
	}

	public void setVivante(boolean vivante) {
		this.vivante = vivante;
	}

	public ArrayList<Cellule> getListeVoisines() {
		return listeVoisines;
	}

	public void setListeVoisines(ArrayList<Cellule> listeVoisines) {
		this.listeVoisines = listeVoisines;
	}

	public int getNbVoisinesVivantes() {
		return nbVoisinesVivantes;
	}

	public void setNbVoisinesVivantes() {
		int nbVoisinesVivantes = 0;
		for (Cellule cellule : listeVoisines) {
			if (cellule.isVivante()) {
				nbVoisinesVivantes++;
			}
		}
		this.nbVoisinesVivantes = nbVoisinesVivantes;
	}

	@Override
	public String toString() {
		return isVivante() ? "*" : " ";
	}

}
