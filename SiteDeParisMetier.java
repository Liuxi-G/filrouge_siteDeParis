package siteParis;


import java.util.LinkedList;
import java.util.Random;
import java.util.Collection;


/**
 * 
 * @author Bernard Prou et Julien Mallet
 * <br><br>
 * La classe qui contient toutes les méthodes "Métier" de la gestion du site de paris. 
 * <br><br>
 * Dans toutes les méthodes :
 * <ul>
 * <li>un paramètre de type <code>String</code> est invalide si il n'est pas instancié.</li>
 *  <li>pour la validité d'un password de gestionnaire et d'un password de joueur :
 * <ul>
 * <li>       lettres et chiffres sont les seuls caractères autorisés </li>
 * <li>       il doit avoir une longueur d'au moins 8 caractères </li>
 * </ul></li>       
 * <li>pour la validité d'un pseudo de joueur  :
 * <ul>
 * <li>        lettres et chiffres sont les seuls caractères autorisés  </li>
 * <li>       il doit avoir une longueur d'au moins 4 caractères</li>
 * </ul></li>       
 * <li>pour la validité d'un prénom de joueur et d'un nom de joueur :
 *  <ul>
 *  <li>       lettres et tiret sont les seuls caractères autorisés  </li>
 *  <li>      il  doit avoir une longueur d'au moins 1 caractère </li>
 * </ul></li>
 * <li>pour la validité d'une compétition  :       
 *  <ul>
 *  <li>       lettres, chiffres, point, trait d'union et souligné sont les seuls caractères autorisés </li>
 *  <li>      elle  doit avoir une longueur d'au moins 4 caractères</li>
 * </ul></li>       
 * <li>pour la validité d'un compétiteur  :       
 *  <ul>
 *  <li>       lettres, chiffres, trait d'union et souligné sont les seuls caractères autorisés </li>
 *  <li>      il doit avoir une longueur d'au moins 4 caractères.</li>
 * </ul></li></ul>
 */

public class SiteDeParisMetier {

private String passwordGestionnaire;
private LinkedList<Joueur> allJoueurs = new LinkedList<Joueur>();
private LinkedList<competition> allCompetitions = new LinkedList<competition>();
private LinkedList<Paris> allParis = new LinkedList<Paris>();
	/**
	 * constructeur de <code>SiteDeParisMetier</code>. 
	 * 
	 * @param passwordGestionnaire   le password du gestionnaire.   
	 * 
	 * @throws MetierException  levée 
	 * si le <code>passwordGestionnaire</code>  est invalide 
	 */
	public SiteDeParisMetier(String passwordGestionnaire) throws MetierException {
       validitePasswordGestionnaire(passwordGestionnaire);
       this.passwordGestionnaire=passwordGestionnaire;
	}

    



	// Les méthodes du gestionnaire (avec mot de passe gestionnaire)



	/**
	 * inscrire un joueur. 
	 * 
	 * @param nom   le nom du joueur 
	 * @param prenom   le prénom du joueur   
	 * @param pseudo   le pseudo du joueur  
	 * @param passwordGestionnaire  le password du gestionnaire du site  
	 * 
	 * @throws MetierException   levée  
	 * si le <code>passwordGestionnaire</code> proposé est invalide,
	 * si le <code>passwordGestionnaire</code> est incorrect.
	 * @throws JoueurExistantException   levée si un joueur existe avec les mêmes noms et prénoms ou le même pseudo.
	 * @throws JoueurException levée si <code>nom</code>, <code>prenom</code>, <code>pseudo</code> sont invalides.
	 * 
	 * @return le mot de passe (déterminé par le site) du nouveau joueur inscrit.
	 */
	public String inscrireJoueur(String nom, String prenom, String pseudo, String passwordGestionnaire) throws MetierException, JoueurExistantException, JoueurException {
		validitePasswordGestionnaire(passwordGestionnaire);
		//if (!verifierpassword(passwordGestionnaire)) throw new  MetierException();
		verifierpassword(passwordGestionnaire);
		validitenometprenom(nom);
		validitenometprenom(prenom);
		validitepseudo(pseudo);
	    for (int i=0;i<allJoueurs.size()-1;i++){
	    	if ((allJoueurs.get(i).getNomDeJoueur().equals(nom)&&allJoueurs.get(i).getPrenomDeJoueur().equals(prenom))||allJoueurs.get(i).getPseudoDeJoueur().equals(pseudo)) throw new JoueurExistantException();
	    	}
	    Random r=new Random();
	    String passwordjoueur=nom+r.nextInt(1000)+prenom;
	    Joueur j=new Joueur(nom,prenom,pseudo,passwordjoueur);
	    allJoueurs.add(j);
		return  j.getMDPDeJoueur();
	}
    /**
	 * supprimer un joueur. 
	 * 
	 * @param nom   le nom du joueur 
	 * @param prenom   le prénom du joueur   
	 * @param pseudo   le pseudo du joueur  
	 * @param passwordGestionnaire  le password du gestionnaire du site  
	 * 
	 * @throws MetierException
	 * si le <code>passwordGestionnaire</code>  est invalide,
	 * si le <code>passwordGestionnaire</code> est incorrect.
	 * @throws JoueurInexistantException   levée si il n'y a pas de joueur  avec le même <code>nom</code>, <code>prenom</code>  et <code>pseudo</code>.
	 * @throws JoueurException levée 
	 * si le joueur a des paris en cours,
	 * si <code>nom</code>, <code>prenom</code>, <code>pseudo</code> sont invalides.
	 * 
	 * @return le nombre de jetons à rembourser  au joueur qui vient d'être désinscrit.
	 * 
	 */
	public long desinscrireJoueur(String nom, String prenom, String pseudo, String passwordGestionnaire) throws MetierException, JoueurInexistantException, JoueurException {
		validitePasswordGestionnaire(passwordGestionnaire);
		//if (!verifierpassword(passwordGestionnaire)) throw new  MetierException();
		verifierpassword(passwordGestionnaire);
		Joueur j=new Joueur(nom,prenom,pseudo,passwordGestionnaire);
		boolean flag=false;
		long k=0;
		for(int i=0;i<allParis.size();i++){
		if((trouver_joueur(allParis.get(i)).getPseudoDeJoueur().equals(pseudo))){
			throw new MetierException();
		}
		
		
		}
		for (int i=0;i<getAllJoueurs().size();i++)
		
			
			if (allJoueurs.get(i).getNomDeJoueur().equals(j.getNomDeJoueur())&&allJoueurs.get(i).getPrenomDeJoueur().equals(j.getPrenomDeJoueur())&&allJoueurs.get(i).getPseudoDeJoueur().equals(j.getPseudoDeJoueur()))
			{
				flag=true;
				allJoueurs.remove(i);
				k=allJoueurs.get(i).getSommeEnJeton();
				break;
				}
		
		
		if (!flag)
			throw new JoueurInexistantException("cuole");
		
		/*else if (flag==e){
			
			
		}*/
		return k; 
	}



	/**
	 * ajouter une compétition.  
	 * 
	 * @param competition le nom de la compétition
	 * @param dateCloture   la date à partir de laquelle il ne sera plus possible de miser  
	 * @param competiteurs   les noms des différents compétiteurs de la compétition 
	 * @param passwordGestionnaire  le password du gestionnaire du site 
	 * 
	 * @throws MetierException levée si le tableau des
	 * compétiteurs n'est pas instancié, si le
	 * <code>passwordGestionnaire</code> est invalide, si le
	 * <code>passwordGestionnaire</code> est incorrect.
	 * @throws CompetitionExistanteException levée si une compétition existe avec le même nom. 
	 * @throws CompetitionException levée si le nom de la
	 * compétition ou des compétiteurs sont invalides, si il y a
	 * moins de 2 compétiteurs, si un des competiteurs n'est pas instancié,
	 * si deux compétiteurs ont le même nom, si la date de clôture 
	 * n'est pas instanciée ou est dépassée.
	 */
	public void ajouterCompetition(String competition, DateFrancaise dateCloture, String [] competiteurs, String passwordGestionnaire) throws MetierException, CompetitionExistanteException, CompetitionException  {
		validitePasswordGestionnaire(passwordGestionnaire);
		verifierpassword(passwordGestionnaire);
		validitecompetition(competition);
        if (dateCloture==null){
			throw new CompetitionException();
		}
		if (dateCloture.estDansLePasse()){
			throw new CompetitionException();
		}
		if (competiteurs==null){
			throw new MetierException();
		}
		int l=-1;
		for (int i=0;i<competiteurs.length;i++){
			validitecompetiteur(competiteurs[i]);
			l=i;
		}
		for (int i=0;i<competiteurs.length;i++){
			for(int j=i+1; j<competiteurs.length;j++){
				if (competiteurs[i].equals(competiteurs[j])) throw new CompetitionException();
			}
		}
        if(l==0){
        	 throw new CompetitionException();
         }
        for(int i=0;i<allCompetitions.size();i++){
        	if (allCompetitions.get(i).getNomDeCompetition().equals(competition)) throw new CompetitionExistanteException();

        }
        
        competition c=new competition(competition,dateCloture,competiteurs);
	    allCompetitions.add(c);
		
	}


	/**
	 * solder une compétition vainqueur (compétition avec vainqueur).  
	 * 
	 * Chaque joueur ayant misé sur cette compétition
	 * en choisissant ce compétiteur est crédité d'un nombre de
	 * jetons égal à :
	 * 
	 * (le montant de sa mise * la somme des
	 * jetons misés pour cette compétition) / la somme des jetons
	 * misés sur ce compétiteur.
	 *
	 * Si aucun joueur n'a trouvé le
	 * bon compétiteur, des jetons sont crédités aux joueurs ayant
	 * misé sur cette compétition (conformément au montant de
	 * leurs mises). La compétition est "supprimée" si il ne reste
	 * plus de mises suite à ce solde.
	 * 
	 * @param competition   le nom de la compétition  
	 * @param vainqueur   le nom du vainqueur de la compétition 
	 * @param passwordGestionnaire  le password du gestionnaire du site 
	 * 
	 * @throws MetierException   levée 
	 * si le <code>passwordGestionnaire</code>  est invalide,
	 * si le <code>passwordGestionnaire</code> est incorrect.
	 * @throws CompetitionInexistanteException   levée si il n'existe pas de compétition de même nom.
	 * @throws CompetitionException levée 
	 * si le nom de la compétition ou du vainqueur est invalide, 
	 * si il n'existe pas de compétiteur du nom du vainqueur dans la compétition,
	 * si la date de clôture de la compétition est dans le futur.
	 * 
	 */	
	public void solderVainqueur(String competition, String vainqueur, String passwordGestionnaire) throws MetierException,  CompetitionInexistanteException, CompetitionException  {
		validitePasswordGestionnaire(passwordGestionnaire);
		verifierpassword(passwordGestionnaire);
		validitecompetition(competition);
		validitecompetiteur(vainqueur);
		
		boolean flag=false;
        int j=-1;
        for(int i=0;i<allCompetitions.size();i++){
       	 if(allCompetitions.get(i).getNomDeCompetition().equals(competition)){
       	 j=i;
       	 flag=true;
        
       	 break;
       	 }
        }
        if(flag==false){
       	 throw new CompetitionInexistanteException();
        }
        
        boolean flaggy=false;
        for(int i=0;i<allCompetitions.get(j).getNomDeCompetiteur().length;i++){
       	 if(allCompetitions.get(j).getNomDeCompetiteur()[i].equals(vainqueur)){
       		 flaggy=true;
       		 break;
       	 }
        }
        if(!flaggy) {throw new CompetitionException();}
        if(!allCompetitions.get(j).getDateCloture().estDansLePasse()) {throw new CompetitionException();}
        long misevainqueur=0;
        long misecompetition=0;
        for(int i=0;i<allParis.size();i++){
        	if(allParis.get(i).getNomDeCompetition().equals(competition)&&allParis.get(i).getVainqueurEnvisage().equals(vainqueur)){
        		misevainqueur+=allParis.get(i).getMiseEnJetons();
        	}
        }
        for(int i=0;i<allParis.size();i++){
        	if(allParis.get(i).getNomDeCompetition().equals(competition)){
        		misecompetition+=allParis.get(i).getMiseEnJetons();
        	}
        }
        if(misecompetition==0){
        	System.out.println("La competition est supprimée");
        }
        if(misevainqueur==0){
        	for(int i=0;i<allParis.size();i++){
        	trouver_joueur(allParis.get(i)).crediter(allParis.get(i).getMiseEnJetons());
			//System.out.println(allParis.get(i).getMiseEnJetons()+"  "+allParis.get(i).getParieur());
			allParis.remove(i);
			i=i-1;
        }
        }
        	for(int i=0;i<allParis.size();i++){
        		if(allParis.get(i).getNomDeCompetition().equals(competition)&&allParis.get(i).getVainqueurEnvisage().equals(vainqueur))
        			//if(misevainqueur==0){
            			//trouver_joueur(allParis.get(i)).crediter(allParis.get(i).getMiseEnJetons());
        			//System.out.println(allParis.get(i).getMiseEnJetons()+"  "+allParis.get(i).getParieur());
        			//allParis.remove(i);
        			//i=i-1;
        			
        			{
        				trouver_joueur(allParis.get(i)).crediter(allParis.get(i).getMiseEnJetons()*misecompetition/misevainqueur);
        				
        				allParis.remove(i);
        			i=i-1;
        			}
        		else if (allParis.get(i).getNomDeCompetition().equals(competition)&&!allParis.get(i).getVainqueurEnvisage().equals(vainqueur))
        		{
        			allParis.remove(i);
        			i=i-1;
        		}
        		}
        	
        
       allCompetitions.remove(j);
        
	}



	/**
	 * créditer le compte en jetons d'un joueur du site de paris.
	 * 
	 * @param nom   le nom du joueur 
	 * @param prenom   le prénom du joueur   
	 * @param pseudo   le pseudo du joueur  
	 * @param sommeEnJetons   la somme en jetons à créditer  
	 * @param passwordGestionnaire  le password du gestionnaire du site  
	 * 
	 * @throws MetierException   levée 
	 * si le <code>passwordGestionnaire</code>  est invalide,
	 * si le <code>passwordGestionnaire</code> est incorrect,
	 * si la somme en jetons est négative.
	 * @throws JoueurException levée  
	 * si <code>nom</code>, <code>prenom</code>,  <code>pseudo</code> sont invalides.
	 * @throws JoueurInexistantException   levée si il n'y a pas de joueur  avec les mêmes nom,  prénom et pseudo.
	 */
	public void crediterJoueur(String nom, String prenom, String pseudo, long sommeEnJetons, String passwordGestionnaire) throws MetierException, JoueurException, JoueurInexistantException {
   
		validitePasswordGestionnaire(passwordGestionnaire);
		verifierpassword(passwordGestionnaire);
		validitesommeenjeton(sommeEnJetons);
		validitenometprenom(nom);
		validitenometprenom(prenom);
		validitepseudo(pseudo);
		boolean flag=false;
		int j=-1;
		for(int i=0;i<allJoueurs.size();i++){
			if (allJoueurs.get(i).getNomDeJoueur().equals(nom)&&allJoueurs.get(i).getPrenomDeJoueur().equals(prenom)&&allJoueurs.get(i).getPseudoDeJoueur().equals(pseudo))
			{
				flag=true;
				j=i;
				break;
				}
		}
		if(!flag)throw new JoueurInexistantException(); 
		allJoueurs.get(j).crediter(sommeEnJetons);
	}


	/**
	 * débiter le compte en jetons d'un joueur du site de paris.
	 * 
	 * @param nom   le nom du joueur 
	 * @param prenom   le prénom du joueur   
	 * @param pseudo   le pseudo du joueur  
	 * @param sommeEnJetons   la somme en jetons à débiter  
	 * @param passwordGestionnaire  le password du gestionnaire du site  
	 * 
	 * @throws MetierException   levée 
	 * si le <code>passwordGestionnaire</code>  est invalide,
	 * si le <code>passwordGestionnaire</code> est incorrect,
	 * si la somme en jetons est négative.
	 * @throws JoueurException levée  
	 * si <code>nom</code>, <code>prenom</code>,  <code>pseudo</code> sont invalides 
	 * si le compte en jetons du joueur est insuffisant (il deviendrait négatif).
	 * @throws JoueurInexistantException   levée si il n'y a pas de joueur  avec les mêmes nom,  prénom et pseudo.
	 * 
	 */

	public void debiterJoueur(String nom, String prenom, String pseudo, long sommeEnJetons, String passwordGestionnaire) throws  MetierException, JoueurInexistantException, JoueurException {
		validitePasswordGestionnaire(passwordGestionnaire);
		verifierpassword(passwordGestionnaire);
		validitesommeenjeton(sommeEnJetons);
		validitenometprenom(nom);
		validitenometprenom(prenom);
		validitepseudo(pseudo);
		boolean flag=false;
		long k=0;
		int j=-1;
		for(int i=0;i<allJoueurs.size();i++){
			if (allJoueurs.get(i).getNomDeJoueur().equals(nom)&&allJoueurs.get(i).getPrenomDeJoueur().equals(prenom)&&allJoueurs.get(i).getPseudoDeJoueur().equals(pseudo))
			{
				flag=true;
				k=allJoueurs.get(i).getSommeEnJeton();
				j=i;
				break;
				}
		}
		if(!flag)throw new JoueurInexistantException(); 
		if(k<sommeEnJetons)throw new JoueurException();
		
		allJoueurs.get(j).debiter(sommeEnJetons);
	}



	/** 
	 * consulter les  joueurs.
	 * 
	 * @param passwordGestionnaire  le password du gestionnaire du site de paris 

	 * @throws MetierException   levée  
	 * si le <code>passwordGestionnaire</code>  est invalide,
	 * si le <code>passwordGestionnaire</code> est incorrect.
	 * 
	 * @return une liste de liste dont les éléments (de type <code>String</code>) représentent un joueur avec dans l'ordre : 
	 *  <ul>
	 *  <li>       le nom du joueur  </li>
	 *  <li>       le prénom du joueur </li>
	 *  <li>       le pseudo du joueur  </li>
	 *  <li>       son compte en jetons restant disponibles </li>
	 *  <li>       le total de jetons engagés dans ses mises en cours. </li>
	 *  </ul>
	 */
public LinkedList <LinkedList <String>> consulterJoueurs(String passwordGestionnaire) throws MetierException {
		
		validitePasswordGestionnaire(passwordGestionnaire);
		verifierpassword(passwordGestionnaire);
		
		LinkedList<LinkedList <String>> listeDesJoueurs = new LinkedList<LinkedList <String>>();
		
		/*LinkedList<Paris> listeParis = new LinkedList<Paris>();
		for (competition c:allCompetitions){
			for (Paris p:allParis){
				listeParis.add(p);
			}	
		}*/
		
		for (Joueur j: allJoueurs){
			LinkedList<String> attributsDuJoueur = new LinkedList<String>();
			attributsDuJoueur.add(j.getNomDeJoueur());
			attributsDuJoueur.add(j.getPrenomDeJoueur());
			attributsDuJoueur.add(j.getPseudoDeJoueur());
			String compteDuJoueur = Long.toString(j.getSommeEnJeton());
			attributsDuJoueur.add(compteDuJoueur);
			
			long sommeEngagee = 0;
			for (Paris p:allParis){
				if(p.getParieur().equals(j.getPseudoDeJoueur())){
					sommeEngagee += p.getMiseEnJetons();
				}
			}
			attributsDuJoueur.add(Long.toString(sommeEngagee));
			listeDesJoueurs.add(attributsDuJoueur);
		}
		return listeDesJoueurs;
	}
	      
	
	








	// Les méthodes avec mot de passe utilisateur



	/**
	 * miserVainqueur  (parier sur une compétition, en désignant un vainqueur).
	 * Le compte du joueur est débité du nombre de jetons misés.
	 * 
	 * @param pseudo   le pseudo du joueur  
	 * @param passwordJoueur  le password du joueur  
	 * @param miseEnJetons   la somme en jetons à miser  
	 * @param competition   le nom de la compétition  relative au pari effectué
	 * @param vainqueurEnvisage   le nom du compétiteur  sur lequel le joueur mise comme étant le  vainqueur de la compétition  
	 * 
	 * @throws MetierException levée si la somme en jetons est négative.
	 * @throws JoueurInexistantException levée si il n'y a pas de
	 * joueur avec les mêmes pseudos et password.
	 * @throws CompetitionInexistanteException   levée si il n'existe pas de compétition de même nom. 
	 * @throws CompetitionException levée 
	 * si <code>competition</code> ou <code>vainqueurEnvisage</code> sont invalides,
	 * si il n'existe pas un compétiteur de  nom <code>vainqueurEnvisage</code> dans la compétition,
	 * si la compétition n'est plus ouverte (la date de clôture est dans le passé).
	 * @throws JoueurException   levée 
	 * si <code>pseudo</code> ou <code>password</code> sont invalides, 
	 * si le <code>compteEnJetons</code> du joueur est insuffisant (il deviendrait négatif).
	 */
    public void miserVainqueur(String pseudo, String passwordJoueur, long miseEnJetons, String competition, String vainqueurEnvisage) throws MetierException, JoueurInexistantException, CompetitionInexistanteException, CompetitionException, JoueurException  {
             validitepseudo(pseudo);
             validitePasswordGestionnaire(passwordJoueur);
             validitecompetition(competition);
             validitecompetiteur(vainqueurEnvisage);
             validitesommeenjeton(miseEnJetons);
             
             boolean flag=false;
             int j=-1;
             for(int i=0;i<allCompetitions.size();i++){
            	 if(allCompetitions.get(i).getNomDeCompetition().equals(competition)){
            	 j=i;
            	
            	 flag=true;
            	 break;
            	 }
             }
             if(flag==false){
            	 throw new CompetitionInexistanteException();
             }
             if(allCompetitions.get(j).getDateCloture().estDansLePasse()){
            	 throw new CompetitionException();
             }
             
             boolean flagg=false;
            
             for(int i=0;i<allCompetitions.get(j).getNomDeCompetiteur().length;i++){
            	 if(allCompetitions.get(j).getNomDeCompetiteur()[i].equals(vainqueurEnvisage)){
            		 flagg=true;
            		 
            		  break;
            	 }
             }
             if(!flagg) {throw new CompetitionException();}
             boolean anotherflag=false;
             long c=0;
 
             int k=-1;
             for(int i=0;i<allJoueurs.size();i++){
            	 if(allJoueurs.get(i).getPseudoDeJoueur().equals(pseudo)&&allJoueurs.get(i).getMDPDeJoueur().equals(passwordJoueur)){
            		 c=allJoueurs.get(i).getSommeEnJeton();
   
            		 k=i;
            		 anotherflag=true;
            		 break;
            	 }
             }
             if(!anotherflag){
             	throw new JoueurInexistantException();
             }
             if(c<miseEnJetons){
             	throw new JoueurException();
             }
             Paris p=new Paris(pseudo,competition,vainqueurEnvisage,miseEnJetons);
             allJoueurs.get(k).debiter(miseEnJetons);
             //System.out.println(allJoueurs.get(k).getPrenomDeJoueur());
            // System.out.println(allJoueurs.get(k).getSommeEnJeton());
             allParis.add(p);
             
             
	}


    

	// Les méthodes sans mot de passe


	/**
	 * connaître les compétitions en cours.
	 * 
	 * @return une liste de liste dont les éléments (de type <code>String</code>) représentent une compétition avec dans l'ordre : 
	 *  <ul>
	 *  <li>       le nom de la compétition,  </li>
	 *  <li>       la date de clôture de la compétition. </li>
	 *  </ul>
	 */
public LinkedList <LinkedList <String>> consulterCompetitions(){
		
		LinkedList<LinkedList<String>> listeCompetitions = new LinkedList<LinkedList<String>>();
		
		int k = allCompetitions.size();
		if(k > 0){
			for(competition c:allCompetitions){
				LinkedList<String> liste = new LinkedList<String>();
				liste.add(c.getNomDeCompetition());
				liste.add(c.getDateCloture().toString());
				listeCompetitions.add(liste);
			}
		}
//		for(competition c:allCompetitions){
//			LinkedList<String> attributsCompetition = new LinkedList<String>();
//			attributsCompetition.add(c.getNomDeCompetition());
//			String dateCloture = c.getDateCloture().toString();
//			attributsCompetition.add(dateCloture);
//			listeCompetitions.add(attributsCompetition);
//		}
		
		return listeCompetitions;
	} 

	/**
	 * connaître  la liste des noms des compétiteurs d'une compétition.  
	 * 
	 * @param competition   le nom de la compétition  
	 * 
	 * @throws CompetitionException   levée  
	 * si le nom de la compétition est invalide.
	 * @throws CompetitionInexistanteException   levée si il n'existe pas de compétition de même nom. 
	 * 
	 * @return la liste des compétiteurs de la  compétition.
	 */
public LinkedList <String> consulterCompetiteurs(String competition) throws CompetitionException, CompetitionInexistanteException{
	
	validitecompetition(competition);		
	boolean flag = false;
	int j=-1;
	for(competition c:allCompetitions){
		j++;
		if (c.getNomDeCompetition().equals(competition)){
			flag = true;
			break;
		}
	}
	if(flag == false) throw new CompetitionInexistanteException();
	LinkedList<String>listeCompetition = new LinkedList<String>();
	for(String c:allCompetitions.get(j).getNomDeCompetiteur()){
		listeCompetition.add(c);
	}

	
	return listeCompetition;
}

	/**
	 * vérifier la validité du password du gestionnaire.
	 * 
	 * @param passwordGestionnaire   le password du gestionnaire à vérifier
	 * 
	 * @throws MetierException   levée 
	 * si le <code>passwordGestionnaire</code> est invalide.  
	 */
	//protected String setpasswordGestionnaire(String passwordGestionnaire) throws MetierException {
	//	this.passwordGestionnaire=passwordGestionnaire;
	//	return passwordGestionnaire;
	//}
	protected void validitePasswordGestionnaire(String passwordGestionnaire) throws MetierException {
	    if (passwordGestionnaire==null) throw new MetierException();
	    if (!passwordGestionnaire.matches("[0-9A-Za-z]{8,}")) throw new MetierException();
	}

    protected void validitenometprenom(String NomOuPrenom) throws JoueurException{
    	if (NomOuPrenom==null) throw new JoueurException();
    	if (!NomOuPrenom.matches("[0-9A-Za-z]{1,}")) throw new JoueurException();
    }
    
    protected void validitepseudo(String Pseudo) throws JoueurException{
    	if (Pseudo==null) throw new JoueurException();
    	if (!Pseudo.matches("[0-9A-Za-z]{4,}")) throw new JoueurException();
    }
    
    protected void validitecompetition(String Competition) throws CompetitionException{
    	if (Competition==null) throw new CompetitionException();
    	if (!Competition.matches("[0-9A-Za-z'.''-''_']{4,}")) throw new CompetitionException();
    	//pas encore finit
    }
    
    protected void verifierpassword(String passwordGestionnaire) throws MetierException{
    	if (!this.passwordGestionnaire.equals(passwordGestionnaire)) throw new MetierException();
    }
    protected void validitecompetiteur(String competiteur) throws CompetitionException{
    	if(competiteur==null) throw new CompetitionException();
    	if (!competiteur.matches("[0-9A-Za-z'-''_']{4,}")) throw new CompetitionException();
    }
    protected void validitesommeenjeton(long sommeenjeton) throws MetierException {
	    if (sommeenjeton<0) throw new MetierException();
    }
    protected long calculerjeton(long samise,long sommecompetition,long sommecompetiteur){
    	return samise*sommecompetition/sommecompetiteur;
    }
    protected Joueur trouver_joueur(Paris p){
    	int j=-1;
    	for (int i=0;i<allJoueurs.size();i++){
    		if (allJoueurs.get(i).getPseudoDeJoueur().equals(p.getParieur())){
    			j=i;
    			break;
    		}
    	}
    	if(j==-1)return null;
    	else return allJoueurs.get(j);
    }
 
   /* protected boolean verifierpassword(String passwordGestionnaire){
    	return this.passwordGestionnaire==passwordGestionnaire;
    }*/
    
   // protected LinkedList <String> judgeRepetition(String nom, String prenom) throws JoueurExistantException{
    //	if (this.nom == nom && this.prenom == prenom) throw new JoueurExistantException();
    
    //public LinkedList <LinkedList <String>> consulterJoueurs(String passwordGestionnaire) throws MetierException {
	//return new LinkedList <LinkedList <String>>();
    //}







	public LinkedList<Joueur> getAllJoueurs() {
		return allJoueurs;
	}





	public void setAllJoueurs(LinkedList<Joueur> allJoueurs) {
		this.allJoueurs = allJoueurs;
	}
}


