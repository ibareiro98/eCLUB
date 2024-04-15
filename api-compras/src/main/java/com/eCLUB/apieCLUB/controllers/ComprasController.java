package com.eCLUB.apieCLUB.controllers;

import com.eCLUB.apieCLUB.Interfaces.ComprasCabService;
import com.eCLUB.apieCLUB.Interfaces.ComprasDetService;
import com.eCLUB.apieCLUB.entitys.ComprasCab;
import com.eCLUB.apieCLUB.entitys.ComprasDet;
import org.springframework.amqp.core.Queue;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
@EnableRabbit
@RequestMapping("/api/v1")
public class ComprasController {

    @Autowired
    private ComprasCabService comprasCabService;

    @Autowired
    private ComprasDetService comprasDetService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;
    
    @GetMapping(value="/compras")
    public ResponseEntity<Object> getCab(){
        Map<String,Object> map = new HashMap<String, Object>();
        try{
            List<ComprasCab> list = comprasCabService.findAll();
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        }
        catch(Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="/compras/detalles")
    public ResponseEntity<Object> getDet(){
        Map<String,Object> map = new HashMap<String, Object>();
        try{
            List<ComprasDet> list = comprasDetService.findAll();
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        }
        catch(Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping(value="/compras/{idCompra}")
    public ResponseEntity<Object> getByIdCab(@PathVariable Long idCompras){
        try{
            ComprasCab data = comprasCabService.findById(idCompras);
            return new ResponseEntity<Object>(data, HttpStatus.OK);
        }
        catch(Exception e){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="/compras/{idCompra}/detalles")
    public ResponseEntity<Object> getByIdDet(@PathVariable Long idCompras){
        try{
            ComprasDet data = comprasDetService.findById(idCompras);
            return new ResponseEntity<Object>(data, HttpStatus.OK);
        }
        catch(Exception e){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping(value="/compras")
    public ResponseEntity<Object> createCab(@RequestBody ComprasCab comprascab){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            ComprasCab res = comprasCabService.save(comprascab);
            return new ResponseEntity<Object>(res, HttpStatus.OK);
        }
        catch(Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);        
        }
    }

    @PostMapping(value="/compras/detalles")
    public ResponseEntity<Object> createDet(@RequestBody ComprasDet comprasDet){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            Long idProducto = comprasDet.getIdProd();
            BigDecimal stock = comprasDet.getCant();            
            String message = idProducto + "," + stock;

            ComprasDet res = comprasDetService.save(comprasDet);

            rabbitTemplate.convertAndSend(queue.getName(), message);

            return new ResponseEntity<Object>(res, HttpStatus.OK);
        }
        catch(Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);        
        }
    }
        
	@PutMapping("/compras/{idCompra}")
    public ResponseEntity<Object> updateCab(@RequestBody ComprasCab ComprasCab, @PathVariable Long idCompra){ 
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            ComprasCab currentCompra = comprasCabService.findById(idCompra);
            currentCompra.setIdProv(ComprasCab.getIdProv());    
            currentCompra.setDescProv(ComprasCab.getDescProv());  
            currentCompra.setDireccion(ComprasCab.getDireccion());  
            currentCompra.setIdProv(ComprasCab.getTipoCom());  
            currentCompra.setIdProv(ComprasCab.getTipoPago());  
            currentCompra.setMontoTot(ComprasCab.getMontoTot());  
            currentCompra.setFecCompra(ComprasCab.getFecCompra());  

            ComprasCab res = comprasCabService.save(currentCompra);
            return new ResponseEntity<Object>(res, HttpStatus.OK);
        } 
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        } 
    }

    @PutMapping("/compras/{idCompras}/detalles")
    public ResponseEntity<Object> updateDet(@RequestBody ComprasDet ComprasDet, @PathVariable Long idCompra){ 
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            ComprasDet currentCompra = comprasDetService.findById(idCompra);            
            currentCompra.setIdProd(ComprasDet.getIdProd());    
            currentCompra.setDescProd(ComprasDet.getDescProd());  
            currentCompra.setCostoCom(ComprasDet.getCostoCom());  
            currentCompra.setCant(ComprasDet.getCant());  

            ComprasDet res = comprasDetService.save(currentCompra);
            return new ResponseEntity<Object>(res, HttpStatus.OK);
        } 
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        } 
    }
	
	@DeleteMapping("/compras/{idCompras}")
	public ResponseEntity<Object> deleteCab(@PathVariable Long idCompra){ 
		Map<String, Object> map = new HashMap<String, Object>();
		try { 
			ComprasCab currentCompra = comprasCabService.findById(idCompra); 
			comprasCabService.delete(currentCompra);
			map.put("deleted", true);
			return new ResponseEntity<Object>(map,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
 	}

     @DeleteMapping("/compras/{idCompras}/detalles")
     public ResponseEntity<Object> deleteDet(@PathVariable Long idCompra){ 
         Map<String, Object> map = new HashMap<String, Object>();
         try { 
             ComprasDet currentCompra = comprasDetService.findById(idCompra); 
             comprasDetService.delete(currentCompra);
             map.put("deleted", true);
             return new ResponseEntity<Object>(map,HttpStatus.OK);
         } 
         catch (Exception e) {
             map.put("message", e.getMessage());
             return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
         } 
      }
}