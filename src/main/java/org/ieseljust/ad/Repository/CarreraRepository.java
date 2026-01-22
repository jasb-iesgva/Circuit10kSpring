package org.ieseljust.ad.Repository;

import jakarta.transaction.Transactional;
import org.ieseljust.ad.Model.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CarreraRepository extends JpaRepository<Carrera, Long>{
    public List<Carrera> findByLocalitatContainsIgnoreCase(String nom);
}
