package com.eCLUB.apieCLUB.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="t_productos")
public class Productos implements Serializable{
    
    private static final long serialVersionUID = 1;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_prod")
    private Long id_prod;
    
    @NotBlank
    @Column(name = "desc_prod", length = 150)
    private String desc_prod;
    
    @NotNull
    @Column(name = "activo")
    private Boolean activo;

    @NotNull
    @Min(0)
    @Column(name = "precio")
    private BigDecimal precio;

    @NotBlank
    @Column(name = "cat", length = 20)
    private String cat; // Si bien la categoria debe ser segun mi criterio, una FK numerica, por practicidad para el proyecto actual lo hice tipo texto

    @NotNull
    @Min(0)
    @Column(name = "stock")
    private Long stock;

    @NotBlank
    @Column(name = "fec_crea")
    private String fec_crea;

    @NotBlank
    @Column(name = "fec_modi")
    private String fec_modi; // Para no hacer tan extenso el codigo, solo puse esos campos obviando los usuarios de creacion y modificacion, y el estado (alta de registro, modificacion, aprobado o rechazado)

        
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
    
    public Boolean getActivo() {
        return activo;
    }
    
    public void setActivo(Boolean _activo) {
        this.activo = _activo;        
    }

    public BigDecimal getPrecio() {
        return precio;
    }
    
    public void setPrecio(BigDecimal _precio) {
        this.precio = _precio;        
    }

    public String getCat() {
        return cat;
    }
    
    public void setCat(String _cat) {
        this.cat = _cat;
    }

    public Long getStock() {
        return stock;
    }
    
    public void setStock(Long _stock) {
        this.stock = _stock;
    }
    
    public String getFecCrea() {
        return fec_crea;
    }
    
    public void setFecCrea(String _fec_crea) {
        this.fec_crea = _fec_crea;
    }

    public String getFecModi() {
        return fec_modi;
    }
    
    public void setFecModi(String _fec_modi) {
        this.fec_modi = _fec_modi;
    }
}
