package com.curso.controller;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.curso.domain.Producto;
import com.curso.services.ProductoService;
import com.curso.services.excepciones.ProductosException;

@Controller
@RequestMapping("productos")
public class ProductosController {
	@Autowired
    private ProductoService productoService;

	@GetMapping("/detalle")
	public String verProducto(@RequestParam("id")String idProducto,Model model) throws ProductosException {
		Producto p =productoService.getProducto(idProducto);
		p.setUnidadesEnStock(34);
		model.addAttribute("producto",p);
		return "producto";
	}
	
	@GetMapping()
	public String verProductos(Model model) {
		List<Producto> lista = productoService.getAllProductos();
		model.addAttribute("productos", lista);
		return "productos";
	}
	
	// mostrar el formulario de alta de un producto
	
	@GetMapping("/nuevo")
	public String altaProductoForm(Model model) {
		//paso un producto vacio
		model.addAttribute("nuevoProducto",new Producto());
		return "crear-producto";
	}
	
	//se llama al hacer submit el formulario alta producto
	
	@PostMapping("/nuevo")
	public String altaProductoSubmit(@ModelAttribute("nuevoProducto")@Valid Producto nuevo, BindingResult bindingResult, HttpServletRequest request) throws ProductosException {
		
		// ver si es valido
		
		if(bindingResult.hasErrors()) {
			//vuelvo al formulario
			return "crear-producto";
		}
		
		//obtener fichero
        MultipartFile imagenProducto = nuevo.getImagenProducto();

        String rootDirectory
                = request.getSession().getServletContext().getRealPath("/");

        if (imagenProducto != null && !imagenProducto.isEmpty()) {
            System.out.println("... hay imagen");
            try {
                imagenProducto.transferTo(new File(rootDirectory + "resources/imagenes/"
                        + nuevo.getIdProducto() + ".png"));
            } catch (Exception e) {
                throw new RuntimeException("Ha fallado la creación del nuevo Producto", e);
            }
        }
		
		productoService.crearProducto(nuevo);
		
		return "redirect:/productos";
	}
	
	@GetMapping("/{categoria}")
	public String verProductosCategoria(@PathVariable("categoria")String categoria,Model model) {
		List<Producto> lista = productoService.getAllCategoria(categoria);
		model.addAttribute("productos", lista);
		return "productos";
	}
	
	
	@ExceptionHandler(ProductosException.class)
    public ModelAndView handleError(HttpServletRequest req,
            ProductosException exception) {
        ModelAndView mav = new ModelAndView();
        // pasas una model con los datos de la excepcion
        mav.addObject("idProducto", 
                exception.getIdProducto());
        mav.addObject("mensaje", 
                exception.getMessage());
        // dices que renderice la pagina producto-exception.jsp
        mav.setViewName("producto-exception");
        return mav;
    }
	
}
