package com.curso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.domain.Pedido;
import com.curso.domain.Producto;
import com.curso.domain.repository.PedidoRepository;
import com.curso.domain.repository.ProductoRepository;
import com.curso.services.excepciones.PedidosException;

@Service
public class PedidosServiceImp implements PedidosService {

	@Autowired
	@Qualifier("JpaProductoRepository")
	private ProductoRepository repositorio;
	
	@Autowired
	private PedidoRepository repositorioPedido;
	
	
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void hacerPedido(String idProducto, int cantidad) throws PedidosException {
		
		Producto pAmodf = repositorio.getProducto(idProducto);
		
		
		//Todo validar que existe
		
		if(pAmodf ==null) {
			throw new PedidosException("No se pudo realizar el pedido. El producto no existe");
		}
		
		//Todo validar que hay stock
		
		if(pAmodf.getUnidadesEnStock() - cantidad <0) {
			throw new PedidosException("No se pudo realizar el pedido. No hay stock disponible");
		}
		
		
		
		//Modificar el stock disponible
				long stock = pAmodf.getUnidadesEnStock();
				pAmodf.setUnidadesEnStock(stock-cantidad);
				repositorio.update(pAmodf);
				
				//  crear pedido
				Pedido pedido = new Pedido();
				pedido.setCantidad(cantidad);
				pedido.setFechaPedido(new java.util.Date());
				pedido.setProducto(pAmodf);
				repositorioPedido.create(pedido);

	}

}
