package org.ieseljust.ad.Model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Data
@Entity
@Table(name = "runner")
public class Runner implements Serializable{
	
	static final long serialVersionUID = 17L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dni")
    private String dni;

    @Column(name = "nom")
    private String nom;
    
    @Column(name = "cognoms")
    private String cognoms;
    
    @Column(name = "edat")
    private int edat;

    @Column(name = "localitat")
    private String localitat;

    @Column(name = "email")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="categoria")
    @ToString.Exclude
    private Categoria categoria;
   
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "miscarreras", // Tabla que mantiene la relacion N-N
            joinColumns = @JoinColumn(name = "corredor"), 
            inverseJoinColumns = @JoinColumn(name = "carrera")) 
    @ToString.Exclude
    private List<Carrera> listaCarreras = new ArrayList<>();

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime data_creacio;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime data_modif;


    @PrePersist
    protected void onCreate() {
        data_creacio = LocalDateTime.now();
        data_modif = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        data_modif = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Runner other = (Runner) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}