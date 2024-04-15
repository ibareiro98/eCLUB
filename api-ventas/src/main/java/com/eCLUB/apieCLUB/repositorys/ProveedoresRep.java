package com.eCLUB.apieCLUB.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.eCLUB.apieCLUB.entitys.Proveedores;

@Repository
public interface ProveedoresRep extends JpaRepository<Proveedores, Long> {
    
}
