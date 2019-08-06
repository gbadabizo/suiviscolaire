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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.all4tic.suiviscolaire.entities.Ecole;
import com.all4tic.suiviscolaire.service.EcoleService;

@Controller
public class EcoleController {
	@Autowired
	EcoleService ecoleService ;
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
	
	
}
