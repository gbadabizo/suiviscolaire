package com.all4tic.suiviscolaire.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.all4tic.suiviscolaire.entities.Enseignant;
import com.all4tic.suiviscolaire.entities.Matiere;
import com.all4tic.suiviscolaire.service.MatiereService;

@Controller
public class MatiereController {
	@Autowired
	private MatiereService matiereService ;
	@GetMapping(value="/matiere")
	public String index(Model model) {
		model.addAttribute("matieres", matiereService.listMatiere());
		model.addAttribute("matiere", new Matiere()) ;
		return "matiere";
	}
	@PostMapping(value="/matiere/add")
	public String addMatiere(@Valid @ModelAttribute Matiere matiere, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
	           System.out.println("BINDING RESULT ERROR");
	            return "matiere";
	        } else {
	        	if(!matiere.getLibelle().equals("")) {
	        		matiereService.save(matiere);
	        	}
	        	return "redirect:/matiere";
	        }
	}
	@GetMapping(value="/matiere/edit/{id}")
	public  String editMatiere(@PathVariable("id") int id, Model model) {
		   List<Matiere>  matieres = matiereService.listMatiere() ;
	        model.addAttribute("matiere", matiereService.getMatiereById(id));
	        model.addAttribute("matieres", matieres);
	        return "matiere";
	}
	@GetMapping(value="/matiere/delete/{id}")
	public  String deleteMatiere(@PathVariable("id") int id, Model model) {
		  matiereService.delete(id);
		  return "redirect:/matiere";
	}

	
	
}
