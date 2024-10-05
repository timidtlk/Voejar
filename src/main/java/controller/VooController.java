package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Voo;
import model.VooDAO;

@WebServlet("/VooController")
public class VooController extends HttpServlet {

    private VooDAO vDAO;
    @Resource(name="bancoVoejar")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        vDAO = new VooDAO(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String operacao = request.getParameter("operacao");
        operacao = operacao.toLowerCase();

        switch (operacao) {
            case "pesquisar":
                consultarVoo(request, response);
                break;
        
            default:
                break;
        }
    }

    private void consultarVoo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat original = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String origem = request.getParameter("origem");        
        String destino = request.getParameter("destino");        
        String ida = "";
        String volta = "";
        try {
            ida = formato.format(original.parse(request.getParameter("ida")));        
            volta = formato.format(original.parse(request.getParameter("volta")));     
        } catch (ParseException e) {
            e.printStackTrace();
        }   
        int pessoas = Integer.parseInt(request.getParameter("pessoas"));     
        
        Voo vooIda = new Voo(origem, destino, ida, pessoas);
        Voo vooVolta = new Voo(destino, origem, volta, pessoas);
        
        Cookie origemCookie = new Cookie("origem", String.valueOf(origem));
        Cookie destinoCookie = new Cookie("destino", String.valueOf(destino));
        Cookie idaCookie = new Cookie("ida", String.valueOf(request.getParameter("ida")));
        Cookie voltaCookie = new Cookie("volta", String.valueOf(request.getParameter("volta")));
        Cookie pessoasCookie = new Cookie("pessoas", String.valueOf(pessoas));
        
        origemCookie.setMaxAge(60*60*24*365);
        destinoCookie.setMaxAge(60*60*24*365);
        idaCookie.setMaxAge(60*60*24*365);
        voltaCookie.setMaxAge(60*60*24*365);
        pessoasCookie.setMaxAge(60*60*24*365);

        response.addCookie(origemCookie);
        response.addCookie(destinoCookie);
        response.addCookie(idaCookie);
        response.addCookie(voltaCookie);
        response.addCookie(pessoasCookie);

        ArrayList<Voo> listaIda = vDAO.consultarVoos(vooIda);
        ArrayList<Voo> listaVolta = vDAO.consultarVoos(vooVolta);
        
        request.setAttribute("vooIda", vooIda);
        request.setAttribute("listaIda", listaIda);
        
        request.setAttribute("vooVolta", vooVolta);
        request.setAttribute("listaVolta", listaVolta);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
        dispatcher.forward(request, response);
    }
}
