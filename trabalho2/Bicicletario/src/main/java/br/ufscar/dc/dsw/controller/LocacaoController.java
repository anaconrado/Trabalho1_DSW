package br.ufscar.dc.dsw.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.core.Authentication;

import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.service.spec.ILocacaoService;
import br.ufscar.dc.dsw.service.spec.ILocadoraService;
import br.ufscar.dc.dsw.service.spec.IClienteService;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.security.UsuarioDetails;

@Controller
@RequestMapping("/locacoes")
public class LocacaoController {
	
	@Autowired
	private ILocacaoService service;
	@Autowired
	private ILocadoraService locadoraService;
	@Autowired
	private IClienteService clienteService;
	
	private Usuario getUsuario() {
		UsuarioDetails usuarioDetails = (UsuarioDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return usuarioDetails.getUsuario();
	}

	
	@GetMapping("/cadastrar")
	public String cadastrar(Locacao locacao, Model model, Authentication auth) {
		List<Locadora> locadoras = locadoraService.buscarTodos();
        model.addAttribute("Locadora", locadoras);

        String email = auth.getName();
        Cliente clienteLogado = clienteService.buscarPorEmail(email);
        locacao.setCliente(clienteLogado);
        
		return "locacao/cadastro";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Locacao locacao, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "locacao/cadastro";
		}		
		
		service.salvar(locacao);
		attr.addFlashAttribute("sucess", "Locação inserida com sucesso.");
		return "redirect:/locacoes/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("locacao", service.buscarPorId(id));
		return "locacao/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Locacao locacao, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			
		}				
		service.salvar(locacao);
		attr.addFlashAttribute("sucess", "Locação editada com sucesso.");
		return "redirect:/locacoes/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		model.addAttribute("sucess", "Locação excluída com sucesso.");
		return listar(model);
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		Usuario usuario = this.getUsuario();
		String role = usuario.getRole(); 
		
		if (role.equals("ROLE_CLIENTE"))
			model.addAttribute("locacoes",service.buscarTodosPorCliente(usuario.getId()));
		else 
			model.addAttribute("locacoes",service.buscarTodosPorLocadora(usuario.getId()));

		return "locacao/lista";
	}
	
	
}
