package com.eCLUB.apieCLUB.controllers;

import com.eCLUB.apieCLUB.Interfaces.ClientesServiceImplement;
import com.eCLUB.apieCLUB.entitys.Clientes;

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
public class ClientesController {
    
    @Autowired
    private ClientesServiceImplement clientesService;
    
    @GetMapping(value="/clientes")
    public ResponseEntity<Object> get(){
        Map<String,Object> map = new HashMap<String, Object>();
        try{
            List<Clientes> list = clientesService.findAll();
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        }
        catch(Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping(value="/clientes/{idCliente}")
    public ResponseEntity<Object> getById(@PathVariable Long idCliente){
        try{
            Clientes data = clientesService.findById(idCliente);
            return new ResponseEntity<Object>(data, HttpStatus.OK);
        }
        catch(Exception e){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping(value="/clientes")
    public ResponseEntity<Object> create(@RequestBody Clientes producto){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            Clientes res = clientesService.save(producto);
            return new ResponseEntity<Object>(res, HttpStatus.OK);
        }
        catch(Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);        
        }
    }
        
	@PutMapping("/clientes/{idCliente}")
    public ResponseEntity<Object> update(@RequestBody Clientes cliente, @PathVariable Long idCliente){ 
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Clientes currentCliente = clientesService.findById(idCliente);
            currentCliente.setDescClie(cliente.getDesCli());
            currentCliente.setNroDoc(cliente.getNroDoc());        
            currentCliente.setTipoDoc(cliente.getTipoDoc());            
            currentCliente.setEstado(cliente.getEstado());
            currentCliente.setTelefono(cliente.getTelefono()); 
            currentCliente.setDireccion(cliente.getDireccion());    
            currentCliente.setEmail(cliente.getEmail());
            currentCliente.setFecCrea(cliente.getFecCrea());        
            currentCliente.setFecModi(cliente.getFecModi());
            
            Clientes res = clientesService.save(currentCliente);
            return new ResponseEntity<Object>(res, HttpStatus.OK);
        } 
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        } 
    }

	
	@DeleteMapping("/clientes/{idCliente}")
	public ResponseEntity<Object> delete(@PathVariable Long idCliente){ 
		Map<String, Object> map = new HashMap<String, Object>();
		try { 
			Clientes currentCliente = clientesService.findById(idCliente); 
			clientesService.delete(currentCliente);
			map.put("deleted", true);
			return new ResponseEntity<Object>(map,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
 	}
}
