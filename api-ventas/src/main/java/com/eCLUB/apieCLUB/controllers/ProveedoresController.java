package com.eCLUB.apieCLUB.controllers;

import com.eCLUB.apieCLUB.Interfaces.ProveedoresService;
import com.eCLUB.apieCLUB.entitys.Proveedores;
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
public class ProveedoresController {
    @Autowired
    private ProveedoresService proveedoresService;
    
    @GetMapping(value="/proveedores")
    public ResponseEntity<Object> get(){
        Map<String,Object> map = new HashMap<String, Object>();
        try{
            List<Proveedores> list = proveedoresService.findAll();
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        }
        catch(Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping(value="/proveedor/{idproveedor}")
    public ResponseEntity<Object> getById(@PathVariable Long idproveedor){
        try{
            Proveedores data = proveedoresService.findById(idproveedor);
            return new ResponseEntity<Object>(data, HttpStatus.OK);
        }
        catch(Exception e){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping(value="/proveedor")
    public ResponseEntity<Object> create(@RequestBody Proveedores proveedor){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            Proveedores res = proveedoresService.save(proveedor);
            return new ResponseEntity<Object>(res, HttpStatus.OK);
        }
        catch(Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);        
        }
    }
        
	@PutMapping("/proveedor/{idproveedor}")
    public ResponseEntity<Object> update(@RequestBody Proveedores proveedor, @PathVariable Long idproveedor){ 
        Map<String, Object> map = new HashMap<String, Object>();
        try {            
            Proveedores currentProveedor = proveedoresService.findById(idproveedor);
            currentProveedor.setDescProv(proveedor.getDescProv());
            currentProveedor.setNroDoc(proveedor.getNroDoc());        
            currentProveedor.setTipoDoc(proveedor.getTipoDoc());            
            currentProveedor.setEstado(proveedor.getEstado());
            currentProveedor.setTelefono(proveedor.getTelefono());        
            currentProveedor.setDireccion(proveedor.getDireccion());    
            currentProveedor.setEmail(proveedor.getEmail());
            currentProveedor.setFecCrea(proveedor.getFecCrea());        
            currentProveedor.setFecModi(proveedor.getFecModi()); 
            
            Proveedores res = proveedoresService.save(currentProveedor);
            return new ResponseEntity<Object>(res, HttpStatus.OK);
        } 
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        } 
    }
	
	@DeleteMapping("/proveedor/{idproveedor}")
	public ResponseEntity<Object> delete(@PathVariable Long idproveedor){ 
		Map<String, Object> map = new HashMap<String, Object>();
		try { 
			Proveedores currentProveedor = proveedoresService.findById(idproveedor); 
			proveedoresService.delete(currentProveedor);
			map.put("deleted", true);
			return new ResponseEntity<Object>(map,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
 	}
}
