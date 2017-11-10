package modele;

public class GrilleCellules {

	private int nbColonnes;
	private int nbLignes;
	private Cellule[][] grilleCellules;

	public GrilleCellules(int nbLignes, int nbColonnes) {
		this.nbLignes = nbLignes;
		this.nbColonnes = nbColonnes;
		this.grilleCellules = new Cellule[this.getNbLignes()][this.getNbColonnes()];
		setGrilleCellules();
		for (int i = 5; i < 15; i++) {
			this.grilleCellules[15][i].setVivante(true);
		}
	}

	public void generationSuivante() {
		for (int i = 0; i < grilleCellules.length; i++) {
			for (int j = 0; j < grilleCellules[i].length; j++) {
				grilleCellules[i][j].setNbVoisinesVivantes();
			}
		}

		for (int i = 0; i < grilleCellules.length; i++) {
			for (int j = 0; j < grilleCellules[i].length; j++) {
				Cellule cellule = grilleCellules[i][j];
				if (cellule.isVivante()) {
					if (!((cellule.getNbVoisinesVivantes() == 2) || (cellule.getNbVoisinesVivantes() == 3))) {
						grilleCellules[i][j].setVivante(false);
					}
				} else {
					if (cellule.getNbVoisinesVivantes() == 3) {
						grilleCellules[i][j].setVivante(true);
					}
				}
			}
		}
		System.out.println(this);
	}

	public int getNbColonnes() {
		return nbColonnes;
	}

	public void setNbColonnes(int nbColonnes) {
		this.nbColonnes = nbColonnes;
	}

	public int getNbLignes() {
		return nbLignes;
	}

	public void setNbLignes(int nbLignes) {
		this.nbLignes = nbLignes;
	}

	public Cellule[][] getGrilleCellules() {
		return grilleCellules;
	}

	public void setGrilleCellules(Cellule[][] grilleCellules) {
		this.grilleCellules = grilleCellules;
	}

	public void setGrilleCellules() {
		for (int i = 0; i < this.grilleCellules.length; i++) {
			for (int j = 0; j < this.grilleCellules[i].length; j++) {
				Cellule cellule = new Cellule(i, j, false);
				this.grilleCellules[i][j] = cellule;
			}
		}

		for (int i = 0; i < this.grilleCellules.length; i++) {
			for (int j = 0; j < this.grilleCellules[i].length; j++) {
				Cellule cellule = this.grilleCellules[i][j];

				int kInf = i - 1;
				int kSup = i + 1;
				int lInf = j - 1;
				int lSup = j + 1;

				if (i == 0) {
					kInf = 0;
				}
				if (i == this.nbLignes - 1) {
					kSup = this.nbLignes - 1;
				}
				if (j == 0) {
					lInf = 0;
				}
				if (j == this.nbColonnes - 1) {
					lSup = this.nbColonnes - 1;
				}

				for (int k = kInf; k <= kSup; k++) {
					for (int l = lInf; l <= lSup; l++) {
						cellule.getListeVoisines().add(grilleCellules[k][l]);
						cellule.getListeVoisines().remove(cellule);
					}
				}
			}
		}
	}

	@Override
	public String toString() {

		String toString = "";

		for (int i = 0; i < grilleCellules.length; i++) {
			toString += "|";
			for (int j = 0; j < grilleCellules[i].length; j++) {
				toString += grilleCellules[i][j] + "|";
			}
			toString += "\n";
		}

		return toString;
	}

}
