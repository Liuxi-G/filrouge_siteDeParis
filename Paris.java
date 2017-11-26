package siteParis;


public class Paris {
	public Paris(String parieur,String nomDeCompetition,String vainqueurEnvisage,long miseEnJetons){
		//this.setNom(Nom);
		//this.setPrenom(Prenom);
		this.setParieur(parieur);
		this.setNomDeCompetition(nomDeCompetition);
		this.setVainqueurEnvisage(vainqueurEnvisage);
		this.setMiseEnJetons(miseEnJetons);
	}

	/*private String Nom;

	
	public String getNom() {
		return Nom;
	}

	
	public void setNom(String Nom) {
		this.Nom = Nom;
	}
    private String Prenom;

	
	public String getPrenom() {
		return Prenom;
	}

	
	public void setPrenom(String Prenom) {
		this.Prenom = Prenom;
	}*/

	private String parieur;

	/**
	 * Getter of the property <tt>Parieur</tt>
	 * @return  Returns the parieur.
	 * @uml.property  name="Parieur"
	 */
	public String getParieur() {
		return parieur;
	}

	/**
	 * Setter of the property <tt>Parieur</tt>
	 * @param Parieur  The parieur to set.
	 * @uml.property  name="Parieur"
	 */
	public void setParieur(String parieur) {
		this.parieur = parieur;
	}

	/**
	 * @uml.property  name="NomDeCompetition"
	 */
	private String nomDeCompetition;

	/**
	 * Getter of the property <tt>NomDeCompetition</tt>
	 * @return  Returns the nomDeCompetition.
	 * @uml.property  name="NomDeCompetition"
	 */
	public String getNomDeCompetition() {
		return nomDeCompetition;
	}

	/**
	 * Setter of the property <tt>NomDeCompetition</tt>
	 * @param NomDeCompetition  The nomDeCompetition to set.
	 * @uml.property  name="NomDeCompetition"
	 */
	public void setNomDeCompetition(String nomDeCompetition) {
		this.nomDeCompetition = nomDeCompetition;
	}

	/**
	 * @uml.property  name="VainqueurEnvisage"
	 */
	private String vainqueurEnvisage;

	/**
	 * Getter of the property <tt>VainqueurEnvisage</tt>
	 * @return  Returns the vainqueurEnvisage.
	 * @uml.property  name="VainqueurEnvisage"
	 */
	public String getVainqueurEnvisage() {
		return vainqueurEnvisage;
	}

	/**
	 * Setter of the property <tt>VainqueurEnvisage</tt>
	 * @param VainqueurEnvisage  The vainqueurEnvisage to set.
	 * @uml.property  name="VainqueurEnvisage"
	 */
	public void setVainqueurEnvisage(String vainqueurEnvisage) {
		this.vainqueurEnvisage = vainqueurEnvisage;
	}

	/** 
	 * @uml.property name="MiseEnJetons"
	 */
	private long miseEnJetons;

	/** 
	 * Getter of the property <tt>MiseEnJetons</tt>
	 * @return  Returns the miseEnJetons.
	 * @uml.property  name="MiseEnJetons"
	 */
	public long getMiseEnJetons() {
		return miseEnJetons;
	}

	/** 
	 * Setter of the property <tt>MiseEnJetons</tt>
	 * @param MiseEnJetons  The miseEnJetons to set.
	 * @uml.property  name="MiseEnJetons"
	 */
	public void setMiseEnJetons(long miseEnJetons) {
		this.miseEnJetons = miseEnJetons;
	}

}
