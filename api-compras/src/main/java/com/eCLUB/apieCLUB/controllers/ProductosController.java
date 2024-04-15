package com.eCLUB.apieCLUB.controllers;

import com.eCLUB.apieCLUB.Interfaces.ProductosService;
import com.eCLUB.apieCLUB.entitys.Productos;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProductosController {
    @Autowired
    private ProductosService productosService;
    
    @GetMapping(value="/productos")
    public ResponseEntity<Object> get(){
        Map<String,Object> map = new HashMap<String, Object>();
        try{
            List<Productos> list = productosService.findAll();
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        }
        catch(Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping(value="/productos/{id_producto}")
    public ResponseEntity<Object> getById(@PathVariable Long id_producto){
        try{
            Productos data = productosService.findById(id_producto);
            return new ResponseEntity<Object>(data, HttpStatus.OK);
        }
        catch(Exception e){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping(value="/productos")
    public ResponseEntity<Object> create(@RequestBody Productos producto){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            Productos res = productosService.save(producto);
            return new ResponseEntity<Object>(res, HttpStatus.OK);
        }
        catch(Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);        
        }
    }
        
	@PutMapping("/productos/{id_producto}")
    public ResponseEntity<Object> update(@RequestBody Productos producto, @PathVariable Long id_producto){ 
    Map<String, Object> map = new HashMap<String, Object>();
    try {
        Productos currentProducto = productosService.findById(id_producto);
        currentProducto.setDescProd(producto.getDescProd());
        currentProducto.setActivo(producto.getActivo());
        currentProducto.setPrecio(producto.getPrecio());
        currentProducto.setCat(producto.getCat()); 
        currentProducto.setStock(producto.getStock());
        currentProducto.setFecCrea(producto.getFecCrea());        
        currentProducto.setFecModi(producto.getFecModi());

        Productos res = productosService.save(currentProducto);
        return new ResponseEntity<Object>(res, HttpStatus.OK);
        } 
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        } 
    }
	
	@DeleteMapping("/productos/{id_producto}")
	public ResponseEntity<Object> delete(@PathVariable Long id_producto){ 
		Map<String, Object> map = new HashMap<String, Object>();
		try { 
			Productos currentProductos = productosService.findById(id_producto); 
			productosService.delete(currentProductos);
			map.put("deleted", true);
			return new ResponseEntity<Object>(map,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
 	}
}
