package com.eCLUB.apieCLUB.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.eCLUB.apieCLUB.entitys.VentasDet;

@Repository
public interface VentasDetRep extends JpaRepository<VentasDet, Long> {
    
}

