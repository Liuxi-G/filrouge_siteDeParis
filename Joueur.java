package siteParis;


public class Joueur {
    public Joueur(String nomDeJoueur,String prenomDeJoueur,String pseudoDeJoueur,String mdpDeJoueur){
    		this.setNomDeJoueur(nomDeJoueur);
    		this.setPrenomDeJoueur(prenomDeJoueur);
    		this.setPseudoDeJoueur(pseudoDeJoueur);
    		this.setMDPDeJoueur(mdpDeJoueur);
    	}
    	
	private String nomDeJoueur;
	/**
	 * @uml.property  name="NomDeJoueur"
	 */

	/**
	 * Getter of the property <tt>NomDeJoueur</tt>
	 * @return  Returns the nomDeJoueur.
	 * @uml.property  name="NomDeJoueur"
	 */
	public String getNomDeJoueur() {
		return nomDeJoueur;
	}

	/**
	 * Setter of the property <tt>NomDeJoueur</tt>
	 * @param NomDeJoueur  The nomDeJoueur to set.
	 * @uml.property  name="NomDeJoueur"
	 */
	public void setNomDeJoueur(String nomDeJoueur) {
		this.nomDeJoueur = nomDeJoueur;
	}

	/**
	 * @uml.property  name="PrenomDeJoueur"
	 */
	private String prenomDeJoueur;

	/**
	 * Getter of the property <tt>PrenomDeJoueur</tt>
	 * @return  Returns the prenomDeJoueur.
	 * @uml.property  name="PrenomDeJoueur"
	 */
	public String getPrenomDeJoueur() {
		return prenomDeJoueur;
	}

	/**
	 * Setter of the property <tt>PrenomDeJoueur</tt>
	 * @param PrenomDeJoueur  The prenomDeJoueur to set.
	 * @uml.property  name="PrenomDeJoueur"
	 */
	public void setPrenomDeJoueur(String prenomDeJoueur) {
		this.prenomDeJoueur = prenomDeJoueur;
	}

	/**
	 * @uml.property  name="PseudoDeJoueur"
	 */
	private String pseudoDeJoueur;

	/**
	 * Getter of the property <tt>PseudoDeJoueur</tt>
	 * @return  Returns the pseudoDeJoueur.
	 * @uml.property  name="PseudoDeJoueur"
	 */
	public String getPseudoDeJoueur() {
		return pseudoDeJoueur;
	}

	/**
	 * Setter of the property <tt>PseudoDeJoueur</tt>
	 * @param PseudoDeJoueur  The pseudoDeJoueur to set.
	 * @uml.property  name="PseudoDeJoueur"
	 */
	public void setPseudoDeJoueur(String pseudoDeJoueur) {
		this.pseudoDeJoueur = pseudoDeJoueur;
	}

	/**
	 * @uml.property  name="MDPDeJoueur"
	 */
	private String mdpDeJoueur;

	/**
	 * Getter of the property <tt>MDPDeJoueur</tt>
	 * @return  Returns the mdpDeJoueur.
	 * @uml.property  name="MDPDeJoueur"
	 */
	public String getMDPDeJoueur() {
		return mdpDeJoueur;
	}

	/**
	 * Setter of the property <tt>MDPDeJoueur</tt>
	 * @param MDPDeJoueur  The mdpDeJoueur to set.
	 * @uml.property  name="MDPDeJoueur"
	 */
	public void setMDPDeJoueur(String mdpDeJoueur) {
		this.mdpDeJoueur = mdpDeJoueur;
	}
	
	private long SommeEnJeton=0;
	
	public long getSommeEnJeton(){
		return SommeEnJeton;
	}
	public void crediter(long jetons){
		 SommeEnJeton+=jetons;
	}
	public void debiter(long jetons){
		SommeEnJeton-=jetons;
	}
    
}
