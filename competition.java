package siteParis;


public class competition {
	public competition(String nomDeCompetition,DateFrancaise dateCloture,String[] nomDeCompetiteur){
		this.setNomDeCompetition(nomDeCompetition);
		this.setDateCloture(dateCloture);
		this.setNomDeCompetiteur(nomDeCompetiteur);
	}

	/**
	 * @uml.property  name="DateFrancaise"
	 */
	private DateFrancaise dateFrancaise;

	/**
	 * Getter of the property <tt>DateFrancaise</tt>
	 * @return  Returns the dateFrancaise.
	 * @uml.property  name="DateFrancaise"
	 */
	public DateFrancaise getDateFrancaise() {
		return dateFrancaise;
	}

	/**
	 * Setter of the property <tt>DateFrancaise</tt>
	 * @param DateFrancaise  The dateFrancaise to set.
	 * @uml.property  name="DateFrancaise"
	 */
	public void setDateFrancaise(DateFrancaise dateFrancaise) {
		this.dateFrancaise = dateFrancaise;
	}

	/**
	 * @uml.property  name="DateCloture"
	 */
	private DateFrancaise dateCloture;

	/**
	 * Getter of the property <tt>DateCloture</tt>
	 * @return  Returns the dateCloture.
	 * @uml.property  name="DateCloture"
	 */
	public DateFrancaise getDateCloture() {
		return dateCloture;
	}

	/**
	 * Setter of the property <tt>DateCloture</tt>
	 * @param DateCloture  The dateCloture to set.
	 * @uml.property  name="DateCloture"
	 */
	public void setDateCloture(DateFrancaise dateCloture) {
		this.dateCloture = dateCloture;
	}

	/**
	 * @uml.property  name="Vainqueur"
	 */
	private String vainqueur=null;

	/**
	 * Getter of the property <tt>Vainqueur</tt>
	 * @return  Returns the vainqueur.
	 * @uml.property  name="Vainqueur"
	 */
	public String getVainqueur() {
		return vainqueur;
	}

	/**
	 * Setter of the property <tt>Vainqueur</tt>
	 * @param Vainqueur  The vainqueur to set.
	 * @uml.property  name="Vainqueur"
	 */
	public void setVainqueur(String vainqueur) {
		this.vainqueur = vainqueur;
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
	private String[] nomDeCompetiteur;
	public String[] getNomDeCompetiteur() {
		return nomDeCompetiteur;
	}
	public void setNomDeCompetiteur(String[] nomDeCompetiteur) {
		this.nomDeCompetiteur = nomDeCompetiteur;
	}
}
