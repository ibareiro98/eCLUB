package com.eCLUB.apieCLUB.entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "t_compras_cab")
public class ComprasCab implements Serializable {

    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Long id_compra;

    @NotNull
    @Column(name = "id_prov")
    private Integer id_prov;

    @NotBlank
    @Column(name = "desc_prov", length = 150)
    private String desc_prov;

    @NotBlank
    @Column(name = "direccion", length = 150)
    private String direccion;

    @NotNull
    @Column(name = "tipo_com") // 1 contado, 2 efectivo
    private Integer tipo_com;

    @NotNull
    @Column(name = "tipo_pago") // 1 efectivo, 2 tc, 3 td, 4 transferencia
    private Integer tipo_pago;

    @NotNull
    @Column(name = "monto_tot")
    private BigDecimal monto_tot;

    @NotBlank
    @Column(name = "fec_compra")
    private String fec_compra;
    
    public Long getIdCompra() {
        return id_compra;
    }

    public void setIdCompra(Long _id_compra) {
        this.id_compra = _id_compra;
    }

    public Integer getIdProv() {
        return id_prov;
    }

    public void setIdProv(Integer _id_prov) {
        this.id_prov = _id_prov;
    }

    public String getDescProv() {
        return desc_prov;
    }

    public void setDescProv(String _desc_prov) {
        this.desc_prov = _desc_prov;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTipoCom() {
        return tipo_com;
    }

    public void setTipoCom(Integer _tipo_com) {
        this.tipo_com = _tipo_com;
    }

    public Integer getTipoPago() {
        return tipo_pago;
    }

    public void setTipoPago(Integer _tipo_pago) {
        this.tipo_pago = _tipo_pago;
    }

    public BigDecimal getMontoTot() {
        return monto_tot;
    }

    public void setMontoTot(BigDecimal _monto_tot) {
        this.monto_tot = _monto_tot;
    }

    public String getFecCompra() {
        return fec_compra;
    }

    public void setFecCompra(String _fechaCompra) {
        this.fec_compra = _fechaCompra;
    }    
}