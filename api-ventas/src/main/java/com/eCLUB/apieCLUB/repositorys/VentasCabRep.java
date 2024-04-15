package com.eCLUB.apieCLUB.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.eCLUB.apieCLUB.entitys.VentasCab;

@Repository
public interface VentasCabRep extends JpaRepository<VentasCab, Long> {
    
}
