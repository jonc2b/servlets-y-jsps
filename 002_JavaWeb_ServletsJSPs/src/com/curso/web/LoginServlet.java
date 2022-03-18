package com.curso.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.modelo.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(
		name = "loginServlet",
		urlPatterns = { 
				"/loginServlet", 
				"/login"},
		loadOnStartup=1
		)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// lee parametros de envio
		// convierte y valida
		// llama a la logica de negocio
		// Prepara los datos de la vista que se va a generar
		// despacha la peticion al jps que genera el html de salida
		String msg= null;
		// 1. leer los parametros
		String nombre = request.getParameter("paramName"); // si no existe devuelve null
		String clave = request.getParameter("paramPwd");
		if((nombre== null || nombre.trim().length()==0)
			||
			(clave== null || clave.trim().length()==0))
			{
			msg= "Debe indicar un nombre o clave";
		}
		if(msg==null) {
			//llamar a un servicio que diga si estoy logueado
			Usuario usuario= new Usuario(nombre,"gestor");
			//despachar a JSP ok
			System.out.println("Te has logueado como "+ nombre);
			// ir a inicio.jsp
			RequestDispatcher rd= request.getRequestDispatcher("inicio.jsp");
			//rd.include(request, response);
			request.setAttribute("usuario", usuario);
			rd.forward(request, response);
			
			//redirect
			
		}else {
			// mostrar error al usuario
			System.out.println("Error"+ msg);
			// ir a login.jsp y mostrar mensaje
			RequestDispatcher rd= request.getRequestDispatcher("login.jsp");
			request.setAttribute("error", msg);
			rd.forward(request, response);
		}
	}

}
