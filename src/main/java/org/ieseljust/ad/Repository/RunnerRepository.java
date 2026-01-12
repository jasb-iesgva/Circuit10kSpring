package org.ieseljust.ad.Repository;

import org.ieseljust.ad.Model.Runner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface RunnerRepository extends JpaRepository<Runner, Long>{
    public Optional<Runner> findByNomAndCognoms(String nom, String cognoms);

     @Query(value="Select R from Runner R where R.edat < :edat ")
     public List<Runner> menorsEdat(@Param("edat") int edat);
}
