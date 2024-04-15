package com.eCLUB.apieCLUB.controllers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.eCLUB.apieCLUB.Interfaces.VentasCabService;
import com.eCLUB.apieCLUB.Interfaces.VentasDetService;
import com.eCLUB.apieCLUB.entitys.VentasCab;
import com.eCLUB.apieCLUB.entitys.VentasDet;
import org.springframework.amqp.core.Queue;


@RestController
@RequestMapping("/api/v1")
public class VentasController {
    
    @Autowired
    private VentasCabService ventasCabService;

    @Autowired
    private VentasDetService ventasDetService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;
    
    @GetMapping(value="/ventas")
    public ResponseEntity<Object> getCab(){
        Map<String,Object> map = new HashMap<String, Object>();
        try{
            List<VentasCab> list = ventasCabService.findAll();
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        }
        catch(Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="/ventas/detalles")
    public ResponseEntity<Object> getDet(){
        Map<String,Object> map = new HashMap<String, Object>();
        try{
            List<VentasDet> list = ventasDetService.findAll();
            return new ResponseEntity<Object>(list, HttpStatus.OK);
        }
        catch(Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping(value="/ventas/{idVentas}")
    public ResponseEntity<Object> getById(@PathVariable Long idVentas){
        try{
            VentasCab data = ventasCabService.findById(idVentas);
            return new ResponseEntity<Object>(data, HttpStatus.OK);
        }
        catch(Exception e){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="/ventas/{idVentas}/detalles")
    public ResponseEntity<Object> getByIdDet(@PathVariable Long idVentas){
        try{
            VentasDet data = ventasDetService.findById(idVentas);
            return new ResponseEntity<Object>(data, HttpStatus.OK);
        }
        catch(Exception e){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping(value="/ventas")
    public ResponseEntity<Object> createCab(@RequestBody VentasCab VentasCab){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            VentasCab res = ventasCabService.save(VentasCab);
            return new ResponseEntity<Object>(res, HttpStatus.OK);
        }
        catch(Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);        
        }
    }

    @PostMapping(value="/ventas/detalles")
    public ResponseEntity<Object> createDet(@RequestBody VentasDet ventasDet){
        Map<String, Object> map = new HashMap<String, Object>();
        try{
            Long idProducto = ventasDet.getIdProd();
            BigDecimal stock = ventasDet.getCant();            
            String message = idProducto + "," + stock;

            VentasDet res = ventasDetService.save(ventasDet);

            rabbitTemplate.convertAndSend(queue.getName(), message);

            return new ResponseEntity<Object>(res, HttpStatus.OK);
        }
        catch(Exception e){
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);        
        }
    }
        
	@PutMapping("/ventas/{idVentas}")
    public ResponseEntity<Object> updateCab(@RequestBody VentasCab ventasCab, @PathVariable Long idVentas){ 
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            VentasCab currentVenta = ventasCabService.findById(idVentas);
            currentVenta.setIdCliente(ventasCab.getIdCiente());        
            currentVenta.setDescClie(ventasCab.getDescClie());            
            currentVenta.setDireccion(ventasCab.getDireccion());
            currentVenta.setTipoVenta(ventasCab.getTipoVenta()); 
            currentVenta.setDireccion(ventasCab.getDireccion());    
            currentVenta.setTipoPago(ventasCab.getTipoPago());
            currentVenta.setMontoTot(ventasCab.getMontoTot());        
            currentVenta.setFecVenta(ventasCab.getFecVenta());
            
            VentasCab res = ventasCabService.save(currentVenta);
            return new ResponseEntity<Object>(res, HttpStatus.OK);
        } 
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        } 
    }

    @PutMapping("/ventas/{idVentas}/detalles")
    public ResponseEntity<Object> updateDet(@RequestBody VentasDet ventasDet, @PathVariable Long idVentas){ 
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            VentasDet currentVenta = ventasDetService.findById(idVentas);
            currentVenta.setIdProd(ventasDet.getIdProd());        
            currentVenta.setDescProd(ventasDet.getDescProd());            
            currentVenta.setPrecioVen(ventasDet.getPrecioVen());
            currentVenta.setCant(ventasDet.getCant()); 
            currentVenta.setFecVen(ventasDet.getFecVen());    
            
            VentasDet res = ventasDetService.save(currentVenta);
            return new ResponseEntity<Object>(res, HttpStatus.OK);
        } 
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        } 
    }
	
	@DeleteMapping("/ventas/{idventas}")
	public ResponseEntity<Object> delete(@PathVariable Long idVenta){ 
		Map<String, Object> map = new HashMap<String, Object>();
		try { 
			VentasCab currentVenta = ventasCabService.findById(idVenta); 
			ventasCabService.delete(currentVenta);
			map.put("deleted", true);
			return new ResponseEntity<Object>(map,HttpStatus.OK);
		} 
		catch (Exception e) {
			map.put("message", e.getMessage());
			return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
 	}

     @DeleteMapping("/ventas/{idVentas}/detalles")
     public ResponseEntity<Object> deleteDet(@PathVariable Long idVenta){ 
         Map<String, Object> map = new HashMap<String, Object>();
         try { 
             VentasDet currentVenta = ventasDetService.findById(idVenta); 
             ventasDetService.delete(currentVenta);
             map.put("deleted", true);
             return new ResponseEntity<Object>(map,HttpStatus.OK);
         } 
         catch (Exception e) {
             map.put("message", e.getMessage());
             return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
         } 
      }
}
