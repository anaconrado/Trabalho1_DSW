package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.LocadoraDAO;
import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.dao.ClienteDAO;
import br.ufscar.dc.dsw.domain.Locadora;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.util.Erro;

@WebServlet(urlPatterns = "/admin/*")
public class AdminController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    private UsuarioDAO daoUsuario;
    private LocadoraDAO daoLocadora;
    private ClienteDAO daoCliente;

    @Override
    public void init() {
        daoUsuario = new UsuarioDAO();
        daoLocadora = new LocadoraDAO();
        daoCliente = new ClienteDAO();
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
    	} else if (usuario.getPapel().equals("ADMIN")) {
    		String action = request.getPathInfo();
            if (action == null) {
                action = "";
            }
            
            try {
                switch (action) {
                    case "/cadastro":
                        apresentaFormCadastro(request, response);
                        break;
                    case "/cadastroLocadora":
                    	CadastroLocadora(request, response);
                    	break;
                    case "/cadastroCliente":
                    	CadastroCliente(request, response);
                    	break;
                    case "/insercaoCliente":
                        insereCliente(request, response);
                        break;
                    case "/insercaoLocadora":
                        insereLocadora(request, response);
                    break;
                    case "/remocaoCliente":
                        removeCliente(request, response);
                        break;
                    case "/remocaoLocadora":
                        removeLocadora(request, response);
                    break;
                    case "/formularioCliente":
                        apresentaFormCliente(request, response);
                        break;
                    case "/formularioLocadora":
                        apresentaFormLocadora(request, response);
                        break;
                    case "/atualizacaoCliente":
                        atualizeCliente(request, response);
                        break;
                    case "/atualizacaoLocadora":
                        atualizeLocadora(request, response);
                    break;
                    default:
                        lista(request, response);
                    break;
                }
            } catch (RuntimeException | IOException | ServletException e) {
                throw new ServletException(e);
            }
        }else {
        	erros.add("Acesso não autorizado!");
    		erros.add("Apenas Papel [ADMIN] tem acesso a essa página");
    		request.setAttribute("mensagens", erros);
    		RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
    		rd.forward(request, response);
    	} 
    }
    
    private void lista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cliente> listaClientes = daoCliente.getAll();
        List<Locadora> listaLocadoras = daoLocadora.getAll();
        request.setAttribute("listaClientes", listaClientes);
        request.setAttribute("listaLocadoras", listaLocadoras);
        request.setAttribute("contextPath", request.getContextPath().replace("/", ""));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/lista.jsp");
        dispatcher.forward(request, response);
    }

    
    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/formulario.jsp");
        dispatcher.forward(request, response);
    }
    
    private void CadastroCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/formularioCliente.jsp");
        dispatcher.forward(request, response);
    }
    
    private void CadastroLocadora(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/formularioLocadora.jsp");
        dispatcher.forward(request, response);
    }



    private void apresentaFormCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        Cliente cliente = daoCliente.getbyCpf(cpf);
        request.setAttribute("cliente", cliente);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/formularioCliente.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormLocadora(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cnpj = request.getParameter("cnpj");
        Locadora locadora = daoLocadora.getbyCnpj(cnpj);
        request.setAttribute("locadora", locadora);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/admin/formularioLocadora.jsp");
        dispatcher.forward(request, response);
    }

/*
    private void insere(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String codigo	= request.getParameter("codigo");
        String email 	= request.getParameter("email");
        String senha 	= request.getParameter("senha");
        String papel 	= request.getParameter("papel");
        String nome 	= request.getParameter("nome");
        
        Usuario usuario = new Usuario(codigo, email, senha, papel, nome);
        daoUsuario.insert(usuario);
        response.sendRedirect("lista");
    }
    */
    private void insereCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String cpf  		= request.getParameter("cpf");
        String email 		= request.getParameter("email");
        String senha 		= request.getParameter("senha");
        String papel 		= request.getParameter("papel");
        String nome 		= request.getParameter("nome");
        String telefone 	= request.getParameter("telefone");
        String sexo 		= request.getParameter("sexo");
        String nascimento 	= request.getParameter("nascimento");
        //String cpf, String telefone, String sexo, String nascimento, String email, String senha, String papel, String nome)
        Cliente cliente = new Cliente(cpf, telefone, sexo, nascimento, email, senha, papel, nome);
        
        daoUsuario.insert((Usuario)cliente);
        daoCliente.insert(cliente);
        response.sendRedirect("lista");
    }

    private void insereLocadora(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        
        String cnpj	    	= request.getParameter("cnpj");
        String email 		= request.getParameter("email");
        String senha 		= request.getParameter("senha");
        String papel 		= request.getParameter("papel");
        String nome 		= request.getParameter("nome");
        String cidade    	= request.getParameter("cidade");
       
        //String cnpj, String cidade, String email, String senha, String papel, String nome
        Locadora locadora = new Locadora(cnpj, cidade, email, senha, papel, nome);
        
        daoUsuario.insert((Usuario)locadora);
        daoLocadora.insert(locadora);
        response.sendRedirect("lista");
    }

    private void atualizeCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cpf  		= request.getParameter("cpf");
        String email 		= request.getParameter("email");
        String senha 		= request.getParameter("senha");
        String papel 		= request.getParameter("papel");
        String nome 		= request.getParameter("nome");
        String telefone 	= request.getParameter("telefone");
        String sexo 		= request.getParameter("sexo");
        String nascimento 	= request.getParameter("nascimento");
        //String cpf, String telefone, String sexo, String nascimento, String email, String senha, String papel, String nome)
        Cliente cliente = new Cliente(cpf, telefone, sexo, nascimento, email, senha, papel, nome);
        
        daoUsuario.update((Usuario)cliente);
        daoCliente.update(cliente);
        response.sendRedirect("lista");
    }

    private void atualizeLocadora(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String cnpj	    	= request.getParameter("cnpj");
        String email 		= request.getParameter("email");
        String senha 		= request.getParameter("senha");
        String papel 		= request.getParameter("papel");
        String nome 		= request.getParameter("nome");
        String cidade    	= request.getParameter("cidade");
       
       
        //String cnpj, String cidade, String email, String senha, String papel, String nome
        Locadora locadora = new Locadora(cnpj, cidade, email, senha, papel, nome);
        
        daoUsuario.update((Usuario)locadora);
        daoLocadora.update(locadora);
        response.sendRedirect("lista");
    }


    private void removeCliente(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String codigo = request.getParameter("cpf");
        
        Usuario usuario = new Usuario(codigo);
        daoUsuario.delete(usuario);
        response.sendRedirect("lista");
    }

    private void removeLocadora(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String codigo = request.getParameter("cnpj");
        
        Usuario usuario = new Usuario(codigo);
        daoUsuario.delete(usuario);
        response.sendRedirect("lista");
    }
}