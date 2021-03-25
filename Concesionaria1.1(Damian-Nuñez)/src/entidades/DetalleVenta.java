/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author damia
 */
@Entity
@Table(name="ventadetalle"
    ,schema="public"
)
public class DetalleVenta implements java.io.Serializable {
    @Id
    @Column(name="ventadetalleid", unique=true, nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long ventaDetalleId;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="automovil_id", nullable=false)
     private Automovil automovil;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="venta_id", nullable=false)
     private Venta venta;

    public DetalleVenta() {
    }
    public DetalleVenta(long ventaDetalleId, Automovil automovil, Venta venta) {
        this.ventaDetalleId = ventaDetalleId;
        this.automovil = automovil;
        this.venta = venta;
    }
public DetalleVenta(Automovil automovil, Venta venta) {
        this.automovil = automovil;
        this.venta = venta;
    }
    
    
    public Automovil getAutomovil() {
        return automovil;
    }

    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public long getVentaDetalleId() {
        return ventaDetalleId;
    }

    public void setVentaDetalleId(long ventaDetalleId) {
        this.ventaDetalleId = ventaDetalleId;
    }
}
