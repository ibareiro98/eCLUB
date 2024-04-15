package com.eCLUB.apieCLUB.messengerService;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import com.eCLUB.apieCLUB.Interfaces.ProductosService;
import com.eCLUB.apieCLUB.entitys.Productos;
import com.eCLUB.apieCLUB.repositorys.ProductosRep;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ConsumerVentas {

    @SuppressWarnings("unused")
    private final ProductosRep productosRep;

    @Autowired
    public ConsumerVentas(ProductosRep productosRep) {
        this.productosRep = productosRep;
    }

    @Autowired
    private ProductosService productosService;

    @RabbitListener(queues = "stock")
    public void receive(@Payload String message) {
        try {
            log.info("Received message: {}", message);
            System.out.println("Mensaje recibido correctamente: " + message); // Esta línea imprime un mensaje en la consola
            Thread.sleep(2000);
            
            String[] parts = message.split(",");
            Long idProducto = Long.valueOf(parts[0]), cantidad = Long.valueOf(parts[1]);

            actualizarStock(idProducto, cantidad);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void actualizarStock(Long idProducto, Long cantidad) {
        try {
            Productos currentProducto = productosService.findById(idProducto);
            Long stockActual = currentProducto.getStock();
            Long nuevoStock = stockActual - cantidad;
            currentProducto.setStock(nuevoStock);
            productosService.save(currentProducto);
        } catch (Exception e) {
            log.error("Error al actualizar el stock: {}", e.getMessage());
        } 
    }
}

