package fr.bge.crudjson.sauvegarde;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.bge.crudjson.entites.Chaussure;
import fr.bge.crudjson.entites.Fabricant;
import fr.bge.crudjson.entites.Vetement;


public class TestEnregistreur {
	
	@Test
	public void testFonctionnementClassique() throws Exception{
		
		Enregistreur enregistreur = new Enregistreur();
		
		//On charge la liste actuelle des vêtements 
		List < Vetement > dressing1 = enregistreur.lireTous();
		
		//On instancie un nouveau vêtement
		Chaussure chaussure = new Chaussure();
		chaussure.setTaille("42");
		chaussure.setCouleur("Rouge");
		chaussure.setLongueurLacet(25);
		
		Fabricant fabricant = new Fabricant();
		fabricant.setNom("Prada");
		chaussure.setFabricant(fabricant);
		
		//On sauvegarde ce vetement
		enregistreur.enregistrer(chaussure);
		
		//On verifie que la liste a pris en compte ce vetement
		List < Vetement > dressing2 = enregistreur.lireTous();
		Assert.assertEquals("Le nouveau dressing a un element de plus", dressing1.size() +1, dressing2.size());
		
		//On modifie ce vetement et on le sauvegarde
		chaussure.setTaille("38");
		enregistreur.enregistrer(chaussure);
		
		//On verifie que la liste a pris en compte cette modification
		
		//On supprime le vêtement
		enregistreur.supprimer(chaussure);
		
		//On verifie que la liste a pris en compte la suppression
		List < Vetement> dressing3 = enregistreur.lireTous();
		Assert.assertEquals("les deux doivent avoir le même nombre d'élement", dressing1.size(), dressing3.size());
		
	}

}
