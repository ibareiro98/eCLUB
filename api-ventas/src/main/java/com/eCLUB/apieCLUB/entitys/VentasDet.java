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
@Table(name = "t_ventas_det")
public class VentasDet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Long id_venta;

    @NotNull
    @Column(name = "id_venta")
    private Long id_detalle;
    
    @NotNull
    @Column(name = "id_prod")
    private Long id_prod;

    @NotBlank
    @Column(name = "desc_prod", length = 150)
    private String desc_prod;

    @NotNull
    @Column(name = "precio_ven")
    private BigDecimal precio_ven;

    @NotNull
    @Column(name = "cant") // 1 efectivo, 2 tc, 3 td, 4 transferencia
    private BigDecimal cant;

    @NotBlank
    @Column(name = "fec_ven")
    private String fec_ven;

    public Long getIdDetalle() {
        return id_detalle;
    }

    public void setIdDetalle(Long _id_detalle) {
        this.id_detalle = _id_detalle;
    }

    public Long getIdVenta() {
        return id_venta;
    }

    public void setIdVenta(Long _id_venta) {
        this.id_venta = _id_venta;
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

    public BigDecimal getPrecioVen() {
        return precio_ven;
    }

    public void setPrecioVen(BigDecimal _precio_ven) {
        this.precio_ven = _precio_ven;
    }

    public BigDecimal getCant() {
        return cant;
    }

    public void setCant(BigDecimal _cant) {
        this.cant = _cant;
    }    

    public String getFecVen() {
        return fec_ven;
    }

    public void setFecVen(String _fec_ven) {
        this.fec_ven = _fec_ven;
    }    
}