package br.ufscar.dc.dsw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.service.spec.ILocadoraService;

@Controller
@RequestMapping("/locadoras")
public class LocadoraController {
	
	@Autowired
	private ILocadoraService service;
	

	
	@GetMapping("/cadastrar")
	public String cadastrar(Locadora locadora) {
		return "locadora/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("locadoras",service.buscarTodos());
		return "locadora/lista";
	}

	@GetMapping("/")
	public String listar(@RequestParam(value = "cidade", required = false) String cidade, ModelMap model) {
		if (cidade == null) {
			model.addAttribute("locadoras", service.buscarTodos());
		} else {
			model.addAttribute("locadoras", service.buscarPorCidade(cidade));
		}
		return "locadora/lista";
	}

	/*@GetMapping("/listar")
	public String listarIndex(ModelMap model) {
		model.addAttribute("locadoras",service.buscarTodos());
		return "locadora/lista";
	}*/
	
	@PostMapping("/salvar")
	public String salvar(@Valid Locadora locadora, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "locadora/cadastro";
		}

		System.out.println("password = " + locadora.getPassword());
		
		
		service.salvar(locadora);
		attr.addFlashAttribute("sucess", "Locadora inserido com sucesso.");
		return "redirect:/locadoras/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("locadora", service.buscarPorId(id));
		return "locadora/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Locadora locadora, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			
			Locadora locadora2 = service.buscarPorEmail(locadora.getEmail());
			if(locadora2 != null){
				if(locadora.getId() != locadora2.getId()){	
					return "locadora/cadastro";
				}
			}
			
		}	
		service.salvar(locadora);
		attr.addFlashAttribute("sucess", "Locadora editado com sucesso.");
		return "redirect:/locadoras/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("sucess", "Usuário excluído com sucesso.");
		return listar("", model);
	}
}