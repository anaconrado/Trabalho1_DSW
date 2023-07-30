package br.ufscar.dc.dsw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufscar.dc.dsw.service.spec.ILocadoraService;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private ILocadoraService service;

	@GetMapping("")
	public String listarIndex(ModelMap model) {
		model.addAttribute("locadoras",service.buscarTodos());
		return "/index";
	}
}