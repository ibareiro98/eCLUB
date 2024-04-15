package com.eCLUB.apieCLUB.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.eCLUB.apieCLUB.entitys.ComprasCab;

@Repository
public interface ComprasCabRep extends JpaRepository<ComprasCab, Long> {
    
}

