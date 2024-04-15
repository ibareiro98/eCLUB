package com.eCLUB.apieCLUB.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.eCLUB.apieCLUB.entitys.Clientes;

@Repository
public interface ClientesRep extends JpaRepository<Clientes, Long> {
    
}
