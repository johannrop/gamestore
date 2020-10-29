
package Controlador;

import Modelo.Juego;
import Modelo.Persona;
import ModeloDAO.JuegoDAO;
import ModeloDAO.PersonaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Controlador extends HttpServlet {

    String cantDias="vistas/cantDias.jsp";
    String listarCli="vistas/listarCli.jsp";
    String alquiler="vistas/alquiler.jsp";
    String listarJue="vistas/listarJue.jsp";
    String listar="vistas/listar.jsp";
    String add="vistas/add.jsp";
    String addJue="vistas/addJue.jsp";
    String edit="vistas/edit.jsp";
    String editJue="vistas/editJue.jsp";
    
    Persona p=new Persona();
    PersonaDAO dao=new PersonaDAO();
    
    Juego j=new Juego();
    JuegoDAO daoJ=new JuegoDAO();
    
    int id;
    int idJue;
    int dias;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String action=request.getParameter("accion");
        
        if(action.equalsIgnoreCase("listar")){
            acceso=listar;            
        }else if(action.equalsIgnoreCase("listarJue")){
            acceso=listarJue;            
        }else if(action.equalsIgnoreCase("alquiler")){
            acceso=alquiler;            
        }
        
        
        else if(action.equalsIgnoreCase("add")){
            acceso=add;
        }
        else if(action.equalsIgnoreCase("addJue")){
            acceso=addJue;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            String nom=request.getParameter("txtnom");
            String ape=request.getParameter("txtape");
            String dire=request.getParameter("txtdire");
            String tel=request.getParameter("txttel");
            p.setNombre(nom);
            p.setApellidos(ape);
            p.setDireccion(dire);
            p.setTelefono(tel);
            dao.add(p);
            acceso=listar;
        }
        
        else if(action.equalsIgnoreCase("AgregarJue")){
            String nom=request.getParameter("txtnom");
            String anho=request.getParameter("txtanho");
            String prot=request.getParameter("txtprot");
            String dir=request.getParameter("txtdir");
            String prod=request.getParameter("txtprod");
            String tec=request.getParameter("txttec");
            String can=request.getParameter("txtcan");
            String preV=request.getParameter("txtpreV");
            String preA=request.getParameter("txtpreA");
            
            j.setNombre(nom);
            j.setAnho(anho);
            j.setProtagonista(prot);
            j.setDirector(dir);       
            j.setProductor(prod);
            j.setTecnologia(tec);
            j.setDirector(can);
            j.setCantidad(preV);
            j.setPreciVenta(preV);
            j.setPrecioAlquiler(preA);
            daoJ.add(j);
            acceso=listarJue;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idper",request.getParameter("id"));
            acceso=edit;
        }
        
        
        else if(action.equalsIgnoreCase("editarJue")){
            request.setAttribute("idper",request.getParameter("id"));
            acceso=editJue;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            id=Integer.parseInt(request.getParameter("txtid"));
            String nom=request.getParameter("txtnom");
            String ape=request.getParameter("txtape");
            String dire=request.getParameter("txtdire");     
            String tel=request.getParameter("txttel");
            p.setId(id);
            p.setNombre(nom);
            p.setApellidos(ape);
            p.setDireccion(dire);
            p.setTelefono(tel);
            dao.edit(p);
            acceso=listar;
        }
        
        else if(action.equalsIgnoreCase("ActualizarJue")){
            id=Integer.parseInt(request.getParameter("txtid"));
            String nom=request.getParameter("txtnom");
            String anho=request.getParameter("txtanho");
            String prot=request.getParameter("txtprot");
            String dir=request.getParameter("txtdir");
            String prod=request.getParameter("txtprod");
            String tec=request.getParameter("txttec");
            String can=request.getParameter("txtcan");
            String preV=request.getParameter("txtpreV");
            String preA=request.getParameter("txtpreA");
            
            j.setId(id);
            j.setNombre(nom);
            j.setAnho(anho);
            j.setProtagonista(prot);
            j.setDirector(dir);       
            j.setProductor(prod);
            j.setTecnologia(tec);
            j.setDirector(can);
            j.setCantidad(preV);
            j.setPreciVenta(preV);
            j.setPrecioAlquiler(preA);
            daoJ.add(j);
            acceso=listarJue;
        }
        
        else if(action.equalsIgnoreCase("eliminar")){
            id=Integer.parseInt(request.getParameter("id"));
            p.setId(id);
            dao.eliminar(id);
            acceso=listar;
        }
        
        else if(action.equalsIgnoreCase("eliminarJue")){
            id=Integer.parseInt(request.getParameter("id"));
            
            j.setId(id);
            daoJ.eliminar(id);
            acceso=listarJue;
        }
        
        
        
        
        
        
        else if(action.equalsIgnoreCase("cliente")){
            id=Integer.parseInt(request.getParameter("id"));
            idJue=id;
            acceso=listarCli;
            
        }
        
        else if(action.equalsIgnoreCase("cantDias")){
            dias=Integer.parseInt(request.getParameter("id"));
            acceso=cantDias;
        }
        
        else if(action.equalsIgnoreCase("alquiJue")){
            id=Integer.parseInt(request.getParameter("id"));
            p.setId(id);
            dao.alquilarJ(id,idJue,dias);
            acceso=listar;
        }
        
        
        
        
        
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
