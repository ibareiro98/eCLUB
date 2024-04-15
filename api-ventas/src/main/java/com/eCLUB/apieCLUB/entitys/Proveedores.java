package com.eCLUB.apieCLUB.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Entity
@Table(name="t_proveedores")
public class Proveedores implements Serializable{
    
    private static final long serialVersionUID = 1;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_prov")
    private Long id_prov;
    
    @NotBlank
    @Column(name = "desc_prov", length = 150)
    private String desc_prov;
    
    @NotBlank
    @Column(name = "nro_doc", length = 30)
    private String nro_doc;

    @NotBlank 
    @Column(name = "tipo_doc", length = 10) // Por practicidad es tipo texto ya que no cree una tabla maestra de tipos de documentos
    private String tipo_doc;
    
    @NotNull
    @Column(name = "estado")
    private Boolean estado; 

    @NotBlank
    @Column(name = "telefono", length = 15)
    private String telefono;

    @NotBlank
    @Column(name = "direccion", length = 250)
    private String direccion;

    @Email
    @Column(name = "email", length = 100)
    private String email;

    @NotBlank
    @Column(name = "fec_crea")
    private String fec_crea;
    
    @NotBlank
    @Column(name = "fec_modi")
    private String fec_modi;
    
    public Long getIdprov() {
        return id_prov;
    }
    
    public void setIdprov(Long _id_prov) {
        this.id_prov = _id_prov;
    }
    
    public String getDescProv() {
        return desc_prov;
    }
    
    public void setDescProv(String _desc_prov) {
        this.desc_prov = _desc_prov;
    }
    
    public String getNroDoc() {
        return nro_doc;
    }
    
    public void setNroDoc(String _nro_doc) {
        this.nro_doc = _nro_doc;        
    }

    public String getTipoDoc() {
        return tipo_doc;
    }
    
    public void setTipoDoc(String _tipo_doc) {
        this.tipo_doc = _tipo_doc;        
    }

    public Boolean getEstado() {
        return estado;
    }
    
    public void setEstado(Boolean _estado) {
        this.estado = _estado;        
    }    

    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String _telefono) {
        this.telefono = _telefono;        
    }

    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String _direccion) {
        this.direccion = _direccion;        
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String _email) {
        this.email = _email;        
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
