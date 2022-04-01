package com.curso.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.curso.domain.Producto;
import com.curso.domain.repository.ProductoRepository;
import com.curso.services.PedidosService;
import com.curso.services.excepciones.PedidosException;
import com.curso.services.excepciones.ProductosException;

@Controller
@RequestMapping("/pedidos")
public class PedidosController {
	
	@Autowired
	private PedidosService pedidosService;
	
	
//	@GetMapping("/")
//	public String inicio() {
//		return"pedidos";
//	}
	@GetMapping("/{idProducto}/{cantidad}")
	public String comprarUnidad(@PathVariable("idProducto")String id,@PathVariable("cantidad")int cantidad) throws PedidosException {
		
		pedidosService.hacerPedido(id, cantidad);
		
		
		return "redirect:/productos";
	}
	
	
	

	@ExceptionHandler(PedidosException.class)
	public ModelAndView handleError(
	    		HttpServletRequest req,
	    		ProductosException exception) {
		 
	        ModelAndView mav = new ModelAndView();
	        
	        //pasas una model con los datos de la excepcion 	       
	        mav.addObject("mensaje", 
	                exception.getMessage());
	        
	        // dices que renderice la pagina producto-exception.jsp
	        mav.setViewName("pedido-exception");
	        return mav; 
	    }
}