/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.servlet;

import com.pi.dao.ProdutoDaoImpl;
import com.pi.entities.Funcionario;
import com.pi.entities.Produto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andrew
 */
public class ProdutoServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nomeProduto = req.getParameter("nomeProduto");
        String codProduto = req.getParameter("codProduto");
        String categoriaProduto = req.getParameter("categoriaProduto");
        String operacao = req.getParameter("operacao");
        
            if(codProduto != null && !codProduto.equals("")){
            List<Produto> produtos = new ArrayList<>();
            Produto produto = new Produto();
            
            if(operacao.equals("deletar")){
                doDelete(req, resp);
            }
            
            produto = ProdutoDaoImpl.getProdutoCodigo(Integer.parseInt(codProduto));
            produtos.add(produto);
            req.setAttribute("listaProdutos", produtos);
        
            String url = "";
            
            switch(operacao){
                case "busca":
                    url = "/SenacToys/produto/buscarProduto.jsp";
                    break;
                case "atualizar":
                    url = "/SenacToys/produto/atualizar.jsp";
                    break;
            }
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
            dispatcher.forward(req,resp);
            
            }else if(nomeProduto != null && !nomeProduto.equals("")){
                try{
                    List<Produto> produtos = new ArrayList<>();
                    Produto produto = new Produto();
                    produtos = ProdutoDaoImpl.getProdutosNome(nomeProduto);
                    req.setAttribute("listaProdutos", produtos);

                    String url = "/SenacToys/produto/buscarProduto.jsp";
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
                    dispatcher.forward(req,resp);
                }catch(NullPointerException | ServletException e){
                    Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, e);
                }
            }else if(categoriaProduto != null && !categoriaProduto.equals("")){
                List<Produto> produtos = new ArrayList<>();
                produtos = ProdutoDaoImpl.getProdutosCategoria(categoriaProduto);
                req.setAttribute("listaProdutos", produtos);

                String url = "/SenacToys/produto/buscarProduto.jsp";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
                dispatcher.forward(req,resp);
            }else{
                List<Produto> produtos = new ArrayList<>();
                produtos = ProdutoDaoImpl.getProdutos();
                req.setAttribute("listaProdutos", produtos);

                String url = "/SenacToys/produto/buscarProduto.jsp";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
                dispatcher.forward(req,resp);
            }
        
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        if(req.getParameter("_method").equals("post")){
            String categoriaProduto = req.getParameter("categoriaProduto");
            String nomeProduto = req.getParameter("nomeProduto");
            String descricaoProduto = req.getParameter("descricaoProduto");
            String classificacaoProduto = req.getParameter("classificacaoProduto");
            String precoProduto = req.getParameter("precoProduto");
            String urlProduto = req.getParameter("urlProduto");

            Produto produto = new Produto();

            produto.setCategoria(categoriaProduto);
            produto.setClassificacaoIdade(classificacaoProduto);
            produto.setNome(nomeProduto);
            produto.setDescricao(descricaoProduto);
            produto.setPrecoUnitario(Double.parseDouble(precoProduto));
            produto.setImgUrl(urlProduto);
            
            try {
                boolean resposta = ProdutoDaoImpl.inserirProduto(produto);

                if(resposta){
                    String sucesso = "/SenacToys/produto/sucesso.jsp";
                    String urlVoltar = "/SenacToys/produto/cadastro.jsp";
                    req.setAttribute("urlVoltar", urlVoltar);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(sucesso);
                    dispatcher.forward(req,resp);
                }else{
                    String erro = "/SenacToys/produto/erro.jsp";
                    String urlVoltar = "/SenacToys/produto/funcionarios.jsp";
                    req.setAttribute("urlVoltar", urlVoltar);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(erro);
                    dispatcher.forward(req,resp);
                }
            } catch (IOException | ServletException e) {
                String erro = "/SenacToys/produto/erro.jsp";
                String urlVoltar = "/SenacToys/produto/funcionarios.jsp";
                req.setAttribute("urlVoltar", urlVoltar);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(erro);
                dispatcher.forward(req,resp);
                Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, e);
            }
        }else{
            doPut(req, resp);
        }
    }
    
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String codProduto = req.getParameter("codProduto");
        String categoriaProduto = req.getParameter("categoriaProduto");
        String nomeProduto = req.getParameter("nomeProduto");
        String descricaoProduto = req.getParameter("descricaoProduto");
        String classificacaoProduto = req.getParameter("classificacaoProduto");
        String precoProduto = req.getParameter("precoProduto");
        String urlProduto = req.getParameter("urlProduto");

        Produto produto = new Produto();

        produto.setCodProduto(Integer.parseInt(codProduto));
        produto.setCategoria(categoriaProduto);
        produto.setNome(nomeProduto);
        produto.setDescricao(descricaoProduto);
        produto.setClassificacaoIdade(classificacaoProduto);
        produto.setPrecoUnitario(Double.parseDouble(precoProduto));
        produto.setImgUrl(urlProduto);
        
        try {
            boolean resposta = ProdutoDaoImpl.atualizarProduto(produto);
            
            if(resposta){
                    String sucesso = "/SenacToys/produto/sucesso.jsp";
                    String urlVoltar = "/SenacToys/produto/cadastro.jsp";
                    req.setAttribute("urlVoltar", urlVoltar);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(sucesso);
                    dispatcher.forward(req,resp);
                }else{
                    String erro = "/SenacToys/produto/erro.jsp";
                    String urlVoltar = "/SenacToys/produto/funcionarios.jsp";
                    req.setAttribute("urlVoltar", urlVoltar);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(erro);
                    dispatcher.forward(req,resp);
                }
            
        } catch (IOException e) {
            String erro = "/SenacToys/produto/erro.jsp";
            String urlVoltar = "/SenacToys/produto/funcionarios.jsp";
            req.setAttribute("urlVoltar", urlVoltar);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(erro);
            dispatcher.forward(req,resp);
            Logger.getLogger(FuncionarioServlet.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
}
