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

import com.all4tic.suiviscolaire.entities.Ecole;
import com.all4tic.suiviscolaire.entities.Enseignant;
import com.all4tic.suiviscolaire.service.EnseignantService;

@Controller
public class EnseignantController {
	@Autowired
	private  EnseignantService enseignantService ;
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

}
