package org.ieseljust.ad.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "carrera")
public class Carrera {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "localitat")
    private String localitat;
    
    @Column(name = "distancia_km")
    private int distancia;
      
    @Column(name = "num_participants")
    private int num_participants;
    
    @ManyToMany(mappedBy = "listaCarreras" , fetch =FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Runner> corredores = new ArrayList<>();


	

}
