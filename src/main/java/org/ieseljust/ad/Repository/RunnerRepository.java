package org.ieseljust.ad.Repository;

import org.ieseljust.ad.Model.Runner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface RunnerRepository extends JpaRepository<Runner, Long>{

}
