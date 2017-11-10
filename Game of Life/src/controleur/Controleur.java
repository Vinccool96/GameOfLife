package controleur;

import modele.GrilleCellules;

public class Controleur {

	private int generation;
	private int generationsAPasser;
	private GrilleCellules grilleCellules;

	public Controleur(int generationsAPasser) {
		generation = 1;
		this.generationsAPasser = generationsAPasser;
		this.grilleCellules = new GrilleCellules(30, 25);
		System.out.println("Génération #0");
		System.out.println(this.grilleCellules);
	}

	public void start() {
		while (generationsAPasser != 0) {
			System.out.println("Génération #" + this.generation);
			this.grilleCellules.generationSuivante();
			generationsAPasser -= 1;
			generation += 1;
		}
	}

	public int getGenerationsAPasser() {
		return generationsAPasser;
	}

	public void setGenerationsAPasser(int generationsAPasser) {
		this.generationsAPasser = generationsAPasser;
	}

	public GrilleCellules getGrilleCellules() {
		return grilleCellules;
	}

	public void setGrilleCellules(GrilleCellules grilleCellules) {
		this.grilleCellules = grilleCellules;
	}

}
