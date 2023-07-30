package br.ufscar.dc.dsw.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.security.UsuarioDetails;
import br.ufscar.dc.dsw.service.spec.ILocacaoService;

@Controller
@RequestMapping("/locacoes")
public class LocacaoController {
	
	@Autowired
	private ILocacaoService service;

	private Usuario getUsuario() {
		UsuarioDetails usuarioDetails = (UsuarioDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return usuarioDetails.getUsuario();
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
