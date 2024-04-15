package com.eCLUB.apieCLUB.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.eCLUB.apieCLUB.entitys.ComprasDet;

@Repository
public interface ComprasDetRep extends JpaRepository<ComprasDet, Long> {
    
}

