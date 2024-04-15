package com.eCLUB.apieCLUB.Interfaces;

import com.eCLUB.apieCLUB.entitys.Clientes;
import com.eCLUB.apieCLUB.repositorys.ClientesRep;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ivan
 */

@Service
public class ClientesServiceImplement implements ClientesServices{

    @Autowired
    private ClientesRep clientesRep;
    
    @Override
    @Transactional
    public List<Clientes> findAll() {
        return (List<Clientes>) clientesRep.findAll();        
    }

    @Override
    @Transactional
    public Clientes save(Clientes clientes) {
        return clientesRep.save(clientes);        
    }
    @Override
    public Clientes findById(Long idClientes) {
        return clientesRep.findById(idClientes).orElse(null);        
    }

    @Override
    @Transactional
    public void delete(Clientes clientes) {
        clientesRep.delete(clientes);        
    }
    
}
