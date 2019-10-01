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

import com.all4tic.suiviscolaire.dao.EcoleEnseignantDao;
import com.all4tic.suiviscolaire.entities.Ecole;
import com.all4tic.suiviscolaire.entities.EcoleEnseignant;
import com.all4tic.suiviscolaire.entities.Enseignant;
import com.all4tic.suiviscolaire.entities.EnseignantMatiere;
import com.all4tic.suiviscolaire.entities.Matiere;
import com.all4tic.suiviscolaire.service.EcoleService;
import com.all4tic.suiviscolaire.service.EnseignantService;
import com.all4tic.suiviscolaire.service.MatiereService;

@Controller
public class EnseignantController {
	@Autowired
	private  EnseignantService enseignantService ;
	@Autowired
	private MatiereService matiereService ;
	@Autowired
	private EcoleEnseignantDao ecoleEnseignantDao ;
	@Autowired
	private EcoleService ecoleService ;
	@GetMapping(value="/enseignant")
	public String index(Model model) {
		model.addAttribute("enseignants", enseignantService.listEnseignant());
		model.addAttribute("enseignant", new Enseignant()) ;
		return "enseignant";
	}
	@PostMapping(value="/enseignant/add")
	public String addEnseignant(@Valid @ModelAttribute Enseignant enseignant, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
	           System.out.println("BINDING RESULT ERROR");
	            return "enseignant";
	        } else {
	        	if(!enseignant.getNom().equals("")) {
	        		enseignantService.save(enseignant);
	        	}
	        	return "redirect:/enseignant";
	        }
	}
	@GetMapping(value="/enseignant/edit/{id}")
	public  String editEnseignant(@PathVariable("id") int id, Model model) {
		   List<Enseignant>  enseignants = enseignantService.listEnseignant() ;
	        model.addAttribute("enseignant", enseignantService.getEnseignantById(id));
	        model.addAttribute("enseignants", enseignants);
	        return "enseignant";
	}
	@GetMapping(value="/enseignant/delete/{id}")
	public  String deleteEnseignant(@PathVariable("id") int id, Model model) {
		  enseignantService.delete(id);
		  return "redirect:/enseignant";
	}
	@GetMapping(value="/enseignant/matiere/{id}")
	public String getMatieresEnseignant(@PathVariable("id") int id, Model model) {
		
		Enseignant enseignant = enseignantService.getEnseignantById(id);
		if(enseignant !=null) {
			Set<Matiere> matieres = enseignant.getMatieres();
			model.addAttribute("enseignant", enseignant);
			model.addAttribute("matieres", matieres);
			List<Matiere> mats = matiereService.listMatiere();
			EnseignantMatiere enseignantMatiere = new EnseignantMatiere();
			enseignantMatiere.setEnseignant(enseignant);
			model.addAttribute("enseignantMatiere", enseignantMatiere);
			model.addAttribute("mats", mats);
			
			return "enseignantMatiere";
		}
		 return "redirect:/enseignant";
		
	}
	@PostMapping(value="/enseignant/matadd")
	public String addMatiereEns(@Valid @ModelAttribute EnseignantMatiere enseignantMatiere, BindingResult bindingResult, Model model) {
		Enseignant enseignant = enseignantMatiere.getEnseignant();
		enseignant.setMatieres(enseignantMatiere.getMatieres());
		enseignantService.save(enseignant);
		 return "redirect:/enseignant/matiere/"+enseignant.getId_enseignant();
	}
	@GetMapping(value="/enseignant/delete/{idmat}/{idens}")
	public  String deleteMatEnseignant(@PathVariable("idmat") int idmat,@PathVariable("idens") int idens, Model model) {
		  Enseignant enseignant = enseignantService.getEnseignantById(idens);
		  Set<Matiere> matieres = enseignant.getMatieres();
		 matieres.remove(matiereService.getMatiereById(idmat));
		 enseignantService.save(enseignant);
		  return "redirect:/enseignant/matiere/"+enseignant.getId_enseignant();
	}
	@GetMapping(value="/enseignant/ecole/{id}")
	public String getEcoleEnseignant(@PathVariable("id") int id, Model model) {
		
		Enseignant enseignant = enseignantService.getEnseignantById(id);
		if(enseignant !=null) {
			EcoleEnseignant ecoleEnseignant = new EcoleEnseignant();
			ecoleEnseignant.setEnseignant(enseignant);
			List<EcoleEnseignant> ecoleEnseignants = ecoleEnseignantDao.findAllByEnseignant(enseignant);
			List<Ecole> ecoles= new ArrayList<Ecole>();
			for(EcoleEnseignant e : ecoleEnseignants){
				ecoles.add(e.getEcole());
			}
			model.addAttribute("ecoleAll", ecoleService.listEcole());
			model.addAttribute("ecoles", ecoles);
			model.addAttribute("ecoleEnseignant", ecoleEnseignant);
			model.addAttribute("enseignant", enseignant);
			return "enseignantEcole";
		}
		 return "redirect:/enseignant";
		
	}
	@PostMapping(value="/enseignant/ecoleadd")
	public String addEcoleEns(@Valid @ModelAttribute EcoleEnseignant ecoleEnseignant, BindingResult bindingResult, Model model) {
		Enseignant enseignant = ecoleEnseignant.getEnseignant();
		ecoleEnseignantDao.save(ecoleEnseignant);
		 return "redirect:/enseignant/ecole/ "+enseignant.getId_enseignant();
	}
	@GetMapping(value="/enseignant/delecole/{id}")
	public  String deleteEcoleEnseignant(@PathVariable("id") int id, Model model) {
		EcoleEnseignant ecoleEnseignant =ecoleEnseignantDao.findByEcole(ecoleService.getEcoleById(id));
		  ecoleEnseignantDao.delete(ecoleEnseignant);
		  return "redirect:/enseignant/ecole/ "+ecoleEnseignant.getEnseignant().getId_enseignant();
	}
	

}
