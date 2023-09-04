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
import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.dao.BicicletaDAO;
import br.ufscar.dc.dsw.dao.ClienteDAO;
import br.ufscar.dc.dsw.util.Erro;


@WebServlet(urlPatterns = "/locacao/*")
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
    	} else if (usuario.getPapel().equals("CLIENTE") || usuario.getPapel().equals("LOCADORA")) {
    		String action = request.getPathInfo();
            if (action == null) {
                action = "";
            }
            
	            try{
	        	listaLocacoes(request, response);
	            switch (action) {
	            	
		            case "/CadastroLocacao":
		            	CadastroLocacao(request, response);
		            	break;
		            case "/formularioLocacao":
		            	apresentaFormLocacao(request, response);
		            	break;
	                case "/insercaoLocacao":
	                    insereLocacao(request, response);
	                    break;
	                case "/atualizacaoLocacao":
	                    atualizeLocacao(request, response);
	                    break;
	                default:
	                	listaLocacoes(request, response);
	                    break;
	            } 
            }catch (RuntimeException | IOException | ServletException e) {
                throw new ServletException(e);
            }
        }else {
        	erros.add("Acesso não autorizado!");
    		erros.add("Apenas Papel [CLIENTE] ou [LOCADORA] tem acesso a essa página");
    		request.setAttribute("mensagens", erros);
    		RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
    		rd.forward(request, response);
    	} 
    }

    //Listagem de locações com login de cliente e locadora (R6 e R8)
    private void listaLocacoes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
        List<Locacao> listaLocacoes;
        
        if (usuario == null)
    		response.sendRedirect(request.getContextPath());
        
        if (usuario.getPapel().equals("LOCADORA")) 
            listaLocacoes = dao.getAllLocacoes(usuario);
        else
            listaLocacoes = dao.getAllCliente(usuario);
        
        request.setAttribute("listaLocacoes", listaLocacoes);
        request.setAttribute("contextPath", request.getContextPath().replace("/", ""));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/locacao/lista.jsp");
        dispatcher.forward(request, response);
    }
    
    // Formulario de cadastro de locacao (R5)

    private void CadastroLocacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/locacao/formularioLocacao.jsp");
        dispatcher.forward(request, response);
    }


    private void apresentaFormLocacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Locacao locacao = dao.getbyId(id);
        request.setAttribute("locacao", locacao);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/locacao/formularioLocacao.jsp");
        dispatcher.forward(request, response);
    }

    // Insere a locacao e verifica se a locadora ou o cliente ja tem outra locacao naquele horario (R7)
    private void insereLocacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Erro erro = new Erro();
        String data 		= request.getParameter("data");
        String val	 		= request.getParameter("val");
        String cnpj			= request.getParameter("locadora");
        String cpf		 	= request.getParameter("cliente");
        String bike_id		= request.getParameter("bike_id");
        Cliente cliente = new ClienteDAO().getbyCpf(cpf);
        Bicicleta bicicleta = new BicicletaDAO().get(Long.parseLong(bike_id));  
        Locadora locadora = new LocadoraDAO().getbyCnpj(cnpj);  

        Locacao locacao = new Locacao(data, val, locadora, cliente, bicicleta);
        
        if(dao.verifyLocacao(locacao)){
            erro.add("Horário já usado por Locadora/Cliente");
            request.setAttribute("mensagens", erro);
            RequestDispatcher rd = request.getRequestDispatcher("cadastroLocacao");
            rd.forward(request, response);

        }else{
            dao.insert(locacao);
            response.sendRedirect("lista");
        }
        
    }
    

    private void atualizeLocacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Erro erro = new Erro();
        String data 		= request.getParameter("data");
        String val	 		= request.getParameter("val");
        String cnpj			= request.getParameter("locadora");
        String cpf		 	= request.getParameter("cliente");
        String bike_id		= request.getParameter("bike_id");
        Cliente cliente = new ClienteDAO().getbyCpf(cpf);
        Bicicleta bicicleta = new BicicletaDAO().get(Long.parseLong(bike_id));  
        Locadora locadora = new LocadoraDAO().getbyCnpj(cnpj);  

        Locacao locacao = new Locacao(data, val, locadora, cliente, bicicleta);
        
        if(dao.verifyLocacao(locacao)){
            erro.add("Horário já usado por Locadora/Cliente");
            request.setAttribute("mensagens", erro);
            RequestDispatcher rd = request.getRequestDispatcher("cadastroLocacao");
            rd.forward(request, response);

        }else{
            dao.update(locacao);
            response.sendRedirect("lista");
        }
        
    }

}