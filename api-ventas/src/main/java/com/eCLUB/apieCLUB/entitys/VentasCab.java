package com.eCLUB.apieCLUB.entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "t_ventas_cab")
public class VentasCab implements Serializable {

    private static final long serialVersionUID = 1L;    

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Long id_venta;

    @NotNull
    @Column(name = "id_cliente")
    private Integer id_cliente;

    @NotBlank
    @Column(name = "desc_clie", length = 150)
    private String desc_clie;

    @NotBlank
    @Column(name = "direccion", length = 150)
    private String direccion;

    @NotNull
    @Column(name = "tipo_venta") // 1 contado, 2 credito
    private Integer tipo_venta;

    @NotNull
    @Column(name = "tipo_pago") // 1 efectivo, 2 tc, 3 td, 4 transferencia
    private Integer tipo_pago;

    @NotNull
    @Column(name = "monto_tot")
    private BigDecimal monto_tot;

    @NotBlank
    @Column(name = "fec_venta")
    private String fec_venta;

    public Long getIdVenta() {
        return id_venta;
    }

    public void setIdVenta(Long _id_venta) {
        this.id_venta = _id_venta;
    }

    public Integer getIdCiente() {
        return id_cliente;
    }

    public void setIdCliente(Integer _id_cliente) {
        this.id_cliente = _id_cliente;
    }

    public String getDescClie() {
        return desc_clie;
    }

    public void setDescClie(String _desc_clie) {
        this.desc_clie = _desc_clie;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String _direccion) {
        this.direccion = _direccion;
    }

    public Integer getTipoVenta() {
        return tipo_venta;
    }

    public void setTipoVenta(Integer _tipo_venta) {
        this.tipo_venta = _tipo_venta;
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

    public String getFecVenta() {
        return fec_venta;
    }

    public void setFecVenta(String _fec_venta) {
        this.fec_venta = _fec_venta;
    }    
}
