package siteParis;


public class Gestionnnaire {

	/**
	 * @uml.property  name="MDPGestionnaire"
	 */
	private String mdpGestionnaire;

	/**
	 * Getter of the property <tt>MDPGestionnaire</tt>
	 * @return  Returns the mdpGestionnaire.
	 * @uml.property  name="MDPGestionnaire"
	 */
	public String getMDPGestionnaire() {
		return mdpGestionnaire;
	}

	/**
	 * Setter of the property <tt>MDPGestionnaire</tt>
	 * @param MDPGestionnaire  The mdpGestionnaire to set.
	 * @uml.property  name="MDPGestionnaire"
	 */
	public void setMDPGestionnaire(String mdpGestionnaire) {
		this.mdpGestionnaire = mdpGestionnaire;
	}

	/** 
	 * @uml.property name="siteDeParisMetier"
	 * @uml.associationEnd multiplicity="(1 1)" inverse="gestionnnaire:siteParis.SiteDeParisMetier"
	 */
	private SiteDeParisMetier siteDeParisMetier = null;

	/** 
	 * Getter of the property <tt>siteDeParisMetier</tt>
	 * @return  Returns the siteDeParisMetier.
	 * @uml.property  name="siteDeParisMetier"
	 */
	public SiteDeParisMetier getSiteDeParisMetier() {
		return siteDeParisMetier;
	}

	/** 
	 * Setter of the property <tt>siteDeParisMetier</tt>
	 * @param siteDeParisMetier  The siteDeParisMetier to set.
	 * @uml.property  name="siteDeParisMetier"
	 */
	public void setSiteDeParisMetier(SiteDeParisMetier siteDeParisMetier) {
		this.siteDeParisMetier = siteDeParisMetier;
	}

}
