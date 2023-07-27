package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.domain.Locacao;
import br.ufscar.dc.dsw.domain.Bicicleta;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.dao.LocacaoDAO;
import br.ufscar.dc.dsw.dao.LocadoraDAO;
import br.ufscar.dc.dsw.dao.ClienteDAO;
import br.ufscar.dc.dsw.util.Erro;


@WebServlet(urlPatterns = "/locacoes/*")
public class LocacaoController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private LocacaoDAO dao;

    @Override
    public void init() {
        dao = new LocacaoDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
		Erro erros = new Erro();

		if (usuario == null) {
			response.sendRedirect(request.getContextPath());
			return;
		} else if (usuario.getPapel().equals("ADMIN")) {
			erros.add("Acesso não autorizado!");
			erros.add("Apenas Papel [USER] tem acesso a essa página");
			request.setAttribute("mensagens", erros);
			RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
			rd.forward(request, response);
			return;
		}

        String action = request.getPathInfo();
        if (action == null) {
            action = "";
        }
        try {
        	lista(request, response);
            /*switch (action) {
            	
                case "/cadastro":
                    apresentaFormCadastro(request, response);
                    break;
                default:
                    lista(request, response);
                    break;
            }
            */
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }

    //Listagem de locações com login de cliente e locadora (R6 e R8)
    private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
        List<Locacao> listaLocacoes;
        if (usuario.getPapel().equals("LOCADORA")) 
            listaLocacoes = dao.getAllLocadora(usuario);
        else 
            listaLocacoes = dao.getAllCliente(usuario);
        request.setAttribute("listaLocacoes", listaLocacoes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/locacao/lista.jsp");
        dispatcher.forward(request, response);
    }
    
    /*

    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("livros", getLivros());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/compra/formulario.jsp");
        dispatcher.forward(request, response);
    }
    */

}