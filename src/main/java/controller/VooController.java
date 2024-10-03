package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
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
        String origem = request.getParameter("origem");        
        String destino = request.getParameter("destino");        
        String ida = request.getParameter("ida");        
        String volta = request.getParameter("volta");        
        int pessoas = Integer.parseInt(request.getParameter("pessoas"));     
        
        Voo vooIda = new Voo(origem, destino, ida, pessoas);
        Voo vooVolta = new Voo(origem, destino, volta, pessoas);
        
        Cookie origemCookie = new Cookie("origem", origem);
        Cookie destinoCookie = new Cookie("destino", destino);
        Cookie idaCookie = new Cookie("ida", ida);
        Cookie voltaCookie = new Cookie("volta", volta);
        Cookie pessoasCookie = new Cookie("pessoas", String.valueOf(pessoas));
        
        response.addCookie(origemCookie);
        response.addCookie(destinoCookie);
        response.addCookie(idaCookie);
        response.addCookie(voltaCookie);
        response.addCookie(pessoasCookie);

        ArrayList<Voo> listaIda = vDAO.consultarVoos(vooIda);
        ArrayList<Voo> listaVolta = vDAO.consultarVoos(vooVolta);
        
    }
}
