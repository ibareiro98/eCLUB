package com.eCLUB.apieCLUB.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.eCLUB.apieCLUB.entitys.Productos;

@Repository
public interface ProductosRep extends JpaRepository<Productos, Long> {
    
}
