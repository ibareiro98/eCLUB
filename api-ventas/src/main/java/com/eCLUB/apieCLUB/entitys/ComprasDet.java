package com.eCLUB.apieCLUB.entitys;

import java.io.Serializable;
import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "t_compras_det")
public class ComprasDet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Long id_detalle;

    @NotNull
    @Column(name = "id_compra")
    private Long id_compra;
    
    @NotNull
    @Column(name = "id_prod")
    private Long id_prod;

    @NotBlank
    @Column(name = "desc_prod", length = 150)
    private String desc_prod;

    @NotNull
    @Column(name = "costo_com")
    private BigDecimal costo_com;

    @NotNull
    @Column(name = "cant") // 1 efectivo, 2 tc, 3 td, 4 transferencia
    private BigDecimal cant;

    public Long getIdDetalle() {
        return id_detalle;
    }

    public void setIdDetalle(Long _id_detalle) {
        this.id_compra = _id_detalle;
    }

    public Long getIdCompra() {
        return id_compra;
    }

    public void setIdCompra(Long _id_compra) {
        this.id_compra = _id_compra;
    }

    public Long getIdProd() {
        return id_prod;
    }

    public void setIdProd(Long _id_prod) {
        this.id_prod = _id_prod;
    }
   
    public String getDescProd() {
        return desc_prod;
    }

    public void setDescProd(String _desc_prod) {
        this.desc_prod = _desc_prod;
    }

    public BigDecimal getCostoCom() {
        return costo_com;
    }

    public void setCostoCom(BigDecimal _costo_com) {
        this.costo_com = _costo_com;
    }

    public BigDecimal getCant() {
        return cant;
    }

    public void setCant(BigDecimal _cant) {
        this.cant = _cant;
    }    

}