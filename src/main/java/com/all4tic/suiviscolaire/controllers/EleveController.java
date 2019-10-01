package com.all4tic.suiviscolaire.controllers;

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

import com.all4tic.suiviscolaire.dao.EleveClasseAnneeDao;
import com.all4tic.suiviscolaire.entities.Annee;
import com.all4tic.suiviscolaire.entities.Classe;
import com.all4tic.suiviscolaire.entities.Ecole;
import com.all4tic.suiviscolaire.entities.Eleve;
import com.all4tic.suiviscolaire.entities.EleveClasseAnnee;
import com.all4tic.suiviscolaire.entities.Enseignant;
import com.all4tic.suiviscolaire.service.AnneeService;
import com.all4tic.suiviscolaire.service.EcoleService;
import com.all4tic.suiviscolaire.service.EleveService;



@Controller
public class EleveController {
	@Autowired
	private EleveService eleveService;
	@Autowired
	private EcoleService ecoleService;
	@Autowired
	private AnneeService anneeService ;
	@Autowired
	private EleveClasseAnneeDao eleveClasseAnneeDao ;
/*	@GetMapping("/eleve/list/{idecole}")
	public List<Eleve> getListByEcole(@PathVariable int idecole){
		return eleveService.getElevesByEcole(idecole);
	}
	@GetMapping("/eleve/{ideleve}")
	public  Eleve getEleve(@PathVariable int ideleve) {
		return eleveService.findOne((long)ideleve);
	}*/
	@GetMapping ("/eleve/add/{idecole}")
	public String addEleve(@PathVariable int idecole , Model model) {
		model.addAttribute("eleve", new Eleve());
		model.addAttribute("ecole", ecoleService.getEcoleById(idecole));
		model.addAttribute("eleves",  eleveService.getlistEleveByEcole(idecole));
		model.addAttribute("ecoles", ecoleService.listEcole());
		return"eleveEcole";
	}
	@GetMapping ("/eleves")
	public String getEleves( Model model) {
		model.addAttribute("ecoles", ecoleService.listEcole());
		model.addAttribute("eleves",  eleveService.listEleve());
		return"eleve";
	}
	@PostMapping("/eleve/add")
	public String addEleve(@Valid @ModelAttribute  Eleve eleve, BindingResult bindingResult, Model model) {
		if(eleve != null) {
			System.out.println(eleve.toString());
			Ecole ecole = eleve.getEcole();
			eleveService.save(eleve);
			return "redirect:/eleve/add/"+ecole.getId_ecole();
		}
		return "redirect:/eleves";
	}
	@GetMapping("/eleve/classe/{ideleve}")
	public String getClasseByEleve(@PathVariable int ideleve, Model model) {
		Eleve eleve = eleveService.getEleve(ideleve);
		model.addAttribute("eleve",eleve);
		List<EleveClasseAnnee> eleveClasseAnnees = eleveClasseAnneeDao.findAllByEleveAndStatut(eleve, 1);
		model.addAttribute("classes",eleve.getEcole().getClasses());
		model.addAttribute("annees",anneeService.listAnnee());
		model.addAttribute("eleveClasseAnnees",eleveClasseAnnees);
		model.addAttribute("eleveClasseAnnee", new EleveClasseAnnee());
		return "eleveClasse" ;
	}
	@PostMapping("/eleve/classe")
	public String addEleveToClasse(@Valid @ModelAttribute EleveClasseAnnee eleveClasseAnnee, 
			BindingResult bindingResult, Model model) {
		Eleve eleve= eleveClasseAnnee.getEleve();
		eleveClasseAnneeDao.save(eleveClasseAnnee);
		return "redirect:/eleve/classe/"+eleve.getId_eleve();
	}
	@GetMapping("/eleve/retirerclasse/{id}")
	public String retirerEleveClasse(@PathVariable int id, Model model) {
		EleveClasseAnnee eleveClasseAnnee= eleveClasseAnneeDao.findById((long)id).get();
		Eleve eleve = eleveClasseAnnee.getEleve();
		eleveClasseAnnee.setStatut(0);
		eleveClasseAnneeDao.save(eleveClasseAnnee);
		
		return "redirect:/eleve/classe/"+eleve.getId_eleve();
	}
	
}
