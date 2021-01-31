package entidades;
// Generated 08-nov-2020 18:36:10 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Auto generated by hbm2java
 */
@Entity
@Table(name="auto"
    ,schema="public"
)
public class Auto  implements java.io.Serializable {
    @Column(name="autoid", unique=true, nullable=false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long autoid;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="automovil_id", nullable=false)
     private Automovil automovil;
    @Column(name="numerochasis", nullable=false)
     private int numerochasis;
    @Column(name="patente", length=30)
     private String patente;
    @Column(name="precioventa", precision=17, scale=17)
     private Double precioventa;
    @Column(name="escerokm")
     private String esCeroKm;

    public Auto() {
    }

	
    public Auto(long autoid, Automovil automovil, int numerochasis) {
        this.autoid = autoid;
        this.automovil = automovil;
        this.numerochasis = numerochasis;
    }
    public Auto(long autoid, Automovil automovil, int numerochasis, String patente, Double precioventa, String esCeroKm) {
       this.autoid = autoid;
       this.automovil = automovil;
       this.numerochasis = numerochasis;
       this.patente = patente;
       this.precioventa = precioventa;
       this.esCeroKm = esCeroKm;
    }

    public Auto(Automovil automovil, int numerochasis, String patente, Double precioventa, String esCeroKm) {
        this.automovil = automovil;
        this.numerochasis = numerochasis;
        this.patente = patente;
        this.precioventa = precioventa;
        this.esCeroKm = esCeroKm;
    }



    
    
    public long getAutoid() {
        return this.autoid;
    }
    
    public void setAutoid(long autoid) {
        this.autoid = autoid;
    }

    
    public Automovil getAutomovil() {
        return this.automovil;
    }
    
    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
    }

    
    
    public int getNumerochasis() {
        return this.numerochasis;
    }
    
    public void setNumerochasis(int numerochasis) {
        this.numerochasis = numerochasis;
    }

    
    
    public String getPatente() {
        return this.patente;
    }
    
    public void setPatente(String patente) {
        this.patente = patente;
    }

    
    
    public Double getPrecioventa() {
        return this.precioventa;
    }
    
    public void setPrecioventa(Double precioventa) {
        this.precioventa = precioventa;
    }

    public String getEsCeroKm() {
        return this.esCeroKm;
    }
    
    public void setEsCeroKm(String esCeroKm) {
        this.esCeroKm = esCeroKm;
    }




}


