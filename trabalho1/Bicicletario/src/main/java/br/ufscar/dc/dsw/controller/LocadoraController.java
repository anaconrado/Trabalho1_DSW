package br.ufscar.dc.dsw.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.dao.LocadoraDAO;
import br.ufscar.dc.dsw.domain.Locadora;

@WebServlet(urlPatterns = "/locadora/*")
public class LocadoraController extends HttpServlet{
    
    LocadoraDAO dao;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getPathInfo();

        if(action == null){
            action = "";
        } else if(action.equals("locadorasPorCidade")){
            listLocadorasPorCidade(request, response);
        } else if(action.equals("listaLocadoras")) {
            listarLocadoras(request, response);
        }
    }

    private void listarLocadoras(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Locadora> listLoc = dao.getLocadoras();

        // Adicione a lista de locadoras ao request
        request.setAttribute("locadoras", listLoc);

        // Encaminhe para a página JSP para exibir a lista de locadoras
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listaLocadoras.jsp");
        dispatcher.forward(request, response);
    }

    private void listLocadorasPorCidade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtenha o parâmetro da cidade da solicitação
        String cidade = request.getParameter("cidade");
    
        // Valide se o parâmetro da cidade está presente
        if (cidade != null && !cidade.isEmpty()) {
            // Lógica para recuperar as locadoras por cidade do banco de dados
            List<Locadora> locadorasPorCidade = dao.getByCidade(cidade);
    
            // Adicione a lista de locadoras ao request
            request.setAttribute("locadoras", locadorasPorCidade);
            //request.setAttribute("cidade", cidade);
    
            // Encaminhe para a página JSP para exibir a lista de locadoras por cidade
            RequestDispatcher dispatcher = request.getRequestDispatcher("/listaPorCidade.jsp");
            dispatcher.forward(request, response);
        } else {
            // Redirecione para a página de listagem de locadoras caso não seja especificada uma cidade
            response.sendRedirect(request.getContextPath() + "/locadora");
        }
    }

    /*
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getPathInfo();

        if(action == null){
            listarLocadoras(request, response);
        } else if(action.equals("locadorasPorCidade")){
            listLocadorasPorCidade(request, response);
        }
    }

    private void listarLocadoras(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Locadora> listLoc = dao.getAll();

        // Adicione a lista de locadoras ao request
        request.setAttribute("locadoras", listLoc);

        // Encaminhe para a página JSP para exibir a lista de locadoras
        RequestDispatcher dispatcher = request.getRequestDispatcher("/geral/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void listLocadorasPorCidade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtenha o parâmetro da cidade da solicitação
        String cidade = request.getParameter("cidade");
    
        // Valide se o parâmetro da cidade está presente
        if (cidade != null && !cidade.isEmpty()) {
            // Lógica para recuperar as locadoras por cidade do banco de dados
            List<Locadora> locadorasPorCidade = getLocadorasPorCidade(cidade);
    
            // Adicione a lista de locadoras ao request
            request.setAttribute("locadoras", locadorasPorCidade);
            request.setAttribute("cidade", cidade);
    
            // Encaminhe para a página JSP para exibir a lista de locadoras por cidade
            RequestDispatcher dispatcher = request.getRequestDispatcher("/geral/listaPorCidade.jsp");
            dispatcher.forward(request, response);
        } else {
            // Redirecione para a página de listagem de locadoras caso não seja especificada uma cidade
            response.sendRedirect(request.getContextPath() + "/locadora");
        }
    }
    
    public List<Locadora> getLocadorasPorCidade(String cidade) {
        List<Locadora> locadorasPorCidade = new ArrayList<>();
        //Locadora loc = new Locadora("145.125.365-12", "Araraquara");

        //locadorasPorCidade.add(0, loc);

        return locadorasPorCidade;
    }*/
    
}