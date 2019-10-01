package com.all4tic.suiviscolaire.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.all4tic.suiviscolaire.dao.AnneeDao;
import com.all4tic.suiviscolaire.dao.EcoleEnseignantDao;
import com.all4tic.suiviscolaire.dao.EcoleEnseignantMatiereDao;
import com.all4tic.suiviscolaire.entities.Annee;
import com.all4tic.suiviscolaire.entities.Classe;
import com.all4tic.suiviscolaire.entities.ClasseEcole;
import com.all4tic.suiviscolaire.entities.ClasseMatiere;
import com.all4tic.suiviscolaire.entities.Ecole;
import com.all4tic.suiviscolaire.entities.EcoleClasseAnnee;
import com.all4tic.suiviscolaire.entities.EcoleEnseignant;
import com.all4tic.suiviscolaire.entities.EcoleEnseignantMatiereClasse;
import com.all4tic.suiviscolaire.entities.Eleve;
import com.all4tic.suiviscolaire.entities.EleveClasseAnnee;
import com.all4tic.suiviscolaire.entities.Enseignant;
import com.all4tic.suiviscolaire.entities.Matiere;
import com.all4tic.suiviscolaire.service.AnneeService;
import com.all4tic.suiviscolaire.service.ClasseService;
import com.all4tic.suiviscolaire.service.EcoleService;
import com.all4tic.suiviscolaire.service.EleveService;

@Controller
public class EcoleController {
	@Autowired
	EcoleService ecoleService ;
	@Autowired
	ClasseService classeService ;
	@Autowired
	private AnneeDao anneeDao ;
	@Autowired
	private EcoleEnseignantMatiereDao ecoleEnseignantMatiereDao;
	@Autowired
	private EcoleEnseignantDao ecoleEnseignantDao ;
	@Autowired 
	private EleveService eleveService ;
	@Autowired
	private AnneeService anneeService ;
	private List<Enseignant> enseignants;
	@RequestMapping(value = { "/ecole"}, method = RequestMethod.GET)
    public String index(Model model) {
       List<Ecole>  ecoles = ecoleService.listEcole();
        model.addAttribute("ecole", new Ecole());
        model.addAttribute("ecoles", ecoles);
        return "ecole";
    }
	@PostMapping(value="/ecole/add")
	public String addEcole(@Valid @ModelAttribute  Ecole ecole, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
           System.out.println("BINDING RESULT ERROR");
            return "ecole";
        } else {
        	if(!ecole.getNom().equals("")) {
        		ecoleService.save(ecole);
        	}
        	return "redirect:/ecole";
        }
	}
	@GetMapping(value="/ecole/edit/{id}")
	public  String editEcole(@PathVariable("id") int id, Model model) {
		   List<Ecole>  ecoles = ecoleService.listEcole();
	        model.addAttribute("ecole", ecoleService.getEcoleById(id));
	        model.addAttribute("ecoles", ecoles);
	        return "ecole";
	}
	@GetMapping(value="/ecole/delete/{id}")
	public  String deleteEcole(@PathVariable("id") int id, Model model) {
		  ecoleService.delete(id);
		  return "redirect:/ecole";
	}
	@GetMapping(value="/ecole/classe/{id}")
	public String addClasse(@PathVariable("id")int id , Model model) {
		Ecole ecole  = ecoleService.getEcoleById(id);
		Set<Classe> classes = ecole.getClasses();
		List<Classe> cls = classeService.listClasse();
		ClasseEcole classeEcole = new ClasseEcole();
		classeEcole.setEcole(ecole);
		model.addAttribute("classeEcole", classeEcole);
		model.addAttribute("classes", classes);
		model.addAttribute("cls", cls);
		model.addAttribute("ecole", ecole);
		return "ecoleclasse";
	}
	@PostMapping(value="/ecole/classeadd")
	public String addClasseEcole(@Valid @ModelAttribute ClasseEcole classeEcole , BindingResult bindingResult, Model model) {
		Ecole ecole = classeEcole.getEcole();
		Set<Classe> classes = classeEcole.getClasses();
		ecole.setClasses(classes);
		ecoleService.save(ecole);
		 return "redirect:/ecole/classe/"+ecole.getId_ecole();
	}
	@GetMapping(value="/ecole/params/{id}")
	public String paramEcole(@PathVariable("id")int id, Model model) {
		Ecole ecole = ecoleService.getEcoleById(id);
		Set<Classe> classes = ecole.getClasses();
		//List<Annee> annees = anneeDao.findByStatus(1);
		List<EcoleEnseignantMatiereClasse>  ecoleEnseignantMatiereClasses = ecoleEnseignantMatiereDao.findAllByEcoleAndStatut(ecole, 1);
		model.addAttribute("ecoleEnseignantMatiereClasses", ecoleEnseignantMatiereClasses);
		model.addAttribute("ecole", ecole);
		//model.addAttribute("annees", annees);
		model.addAttribute("classes", classes);
		return "paramsecole";
	}
	@GetMapping(value="/ecole/pclasse/{idclasse}/{idecole}")
	public String paramEcoleClasse(@PathVariable("idclasse") int idclasse, @PathVariable("idecole") int idecole,  Model model) {
		Ecole ecole = ecoleService.getEcoleById(idecole);
		Set<Classe> classes = ecole.getClasses();
		List<Annee> annees = anneeDao.findByStatus(1);
		Classe classe = classeService.getClasseById(idclasse);
		List<EcoleEnseignantMatiereClasse>  ecoleEnseignantMatiereClasses = ecoleEnseignantMatiereDao.findAllByEcoleAndClasseAndStatut(ecole, classe,1);
		Set<Matiere> matieres = classe.getMatieres();
		List<EcoleEnseignant> ecoleEnseignants = ecoleEnseignantDao.findAllByEcole(ecole);
		enseignants = new ArrayList<>();
		for(EcoleEnseignant ens : ecoleEnseignants) {
			enseignants.add(ens.getEnseignant());
		}
		model.addAttribute("classe",classe);
		model.addAttribute("matieres",matieres);
		model.addAttribute("ecole", ecole);
		model.addAttribute("annees", annees);
		model.addAttribute("classes", classes);
		model.addAttribute("enseignants",enseignants);
		model.addAttribute("ecoleEnseignantMatiereClasses", ecoleEnseignantMatiereClasses);
		model.addAttribute("ecoleEnseignantMatiereClasse", new EcoleEnseignantMatiereClasse());
		
		return "paramsecoleclasse";
	}
	@PostMapping(value="/ecole/pclasse")
	public String paramAnneeClasseEnseignant(@Valid @ModelAttribute EcoleEnseignantMatiereClasse ecoleEnseignantMatiereClasse , 
			BindingResult bindingResult, Model model) {
	
		Ecole ecole = ecoleEnseignantMatiereClasse.getEcole();
		System.out.println(ecole.getNom());
		Classe classe = ecoleEnseignantMatiereClasse.getClasse();
		System.out.println(classe.getLibelle());
		ecoleEnseignantMatiereDao.save(ecoleEnseignantMatiereClasse);
		return "redirect:/ecole/pclasse/"+classe.getId_classe()+"/"+ecole.getId_ecole();
	}
	@GetMapping(value="/ecole/pclasse/{id}")
	public String deleteAnneClasseEnseignant(@PathVariable int id, Model model) {
		EcoleEnseignantMatiereClasse  ecoleEnseignantMatiereClasse = ecoleEnseignantMatiereDao.findById(id).get();
		Ecole ecole = ecoleEnseignantMatiereClasse.getEcole();
		Classe classe = ecoleEnseignantMatiereClasse.getClasse();	
		ecoleEnseignantMatiereClasse.setStatut(0);
		ecoleEnseignantMatiereDao.save(ecoleEnseignantMatiereClasse);
		return "redirect:/ecole/pclasse/"+classe.getId_classe()+"/"+ecole.getId_ecole();
	}
	@GetMapping(value="/ecole/eleve/{id}")
	public String ecoleEleve(@PathVariable int id, Model model) {
		Ecole ecole = ecoleService.getEcoleById(id);
		List<Eleve> eleves = eleveService.getlistEleveByEcole(id);
		model.addAttribute("classes",ecole.getClasses());
		model.addAttribute("annees",anneeService.listAnnee());
		model.addAttribute("ecole", ecole);
		model.addAttribute("eleves",eleves);
		model.addAttribute("ecoleClasseAnnee", new EcoleClasseAnnee());
		return "listEleve";
	}
	
	
}
