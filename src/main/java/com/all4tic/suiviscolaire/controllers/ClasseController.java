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

import com.all4tic.suiviscolaire.dao.CycleDao;
import com.all4tic.suiviscolaire.entities.Classe;
import com.all4tic.suiviscolaire.entities.ClasseMatiere;
import com.all4tic.suiviscolaire.entities.Matiere;
import com.all4tic.suiviscolaire.service.ClasseService;
import com.all4tic.suiviscolaire.service.MatiereService;

@Controller
public class ClasseController {
	@Autowired
	private  ClasseService classeService ;
	@Autowired
	private CycleDao cycleDao ;
	@Autowired
	private MatiereService matiereService;
	@GetMapping(value="/classe")
	public String index(Model model) {
		model.addAttribute("classes", classeService.listClasse());
		model.addAttribute("classe", new Classe()) ;
		model.addAttribute("cycles", cycleDao.findAll()) ;
		return "classe";
	}
	@PostMapping(value="/classe/add")
	public String addClasse(@Valid @ModelAttribute Classe classe, BindingResult bindingResult, Model model) {
		model.addAttribute("cycles", cycleDao.findAll()) ;
		if (bindingResult.hasErrors()) {
	           System.out.println("BINDING RESULT ERROR");
	            return "classe";
	        } else {
	        	if(!classe.getLibelle().equals("")) {
	        		classeService.save(classe);
	        	}
	        	return "redirect:/classe";
	        }
	}
	@GetMapping(value="/classe/edit/{id}")
	public  String editClasse(@PathVariable("id") int id, Model model) {
			model.addAttribute("cycles", cycleDao.findAll()) ;
		   List<Classe>  classes = classeService.listClasse() ;
	        model.addAttribute("classe", classeService.getClasseById(id));
	        model.addAttribute("classes", classes);
	        return "classe";
	}
	@GetMapping(value="/classe/delete/{id}")
	public  String deleteClass(@PathVariable("id") int id, Model model) {
		  classeService.delete(id);
		  return "redirect:/classe";
	}
	@GetMapping(value="/classe/matiere/{id}")
	public String  addMatiere(@PathVariable("id") int id, Model model) {
		//id classe
		Classe classe = classeService.getClasseById(id);
		System.out.println(classe.getCode());
		model.addAttribute("classe", classe);
		Set<Matiere> matieres = classe.getMatieres();
		List<Matiere> mats = matiereService.listMatiere();
		ClasseMatiere classeMatiere = new ClasseMatiere();
		classeMatiere.setClasse(classe);
		System.out.println(classeMatiere);
		model.addAttribute("matieres", matieres);
		model.addAttribute("mats", mats);
		model.addAttribute("classeMatiere", classeMatiere);
		model.addAttribute("cls", classeService.listClasse());
		return "classematiere" ;
		
	}
	
	@PostMapping(value="/classe/matadd")
	public String addMatiereCl(@ModelAttribute ClasseMatiere classeMatiere, BindingResult bindingResult, Model model) {
		
		if(classeMatiere != null) {
			System.out.println(classeMatiere.getClasse());
			Classe classe = classeMatiere.getClasse();
			Set<Matiere>matieres = classeMatiere.getMatieres();
			classe.setMatieres(matieres);
			classeService.save(classe);
			return "redirect:/classe/matiere/"+classe.getId_classe();
		}
		return "redirect:/classe";
		
	}
	

}
