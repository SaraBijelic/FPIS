package com.fon.fpis.repository;

import com.fon.fpis.domain.AdresaVeterinara;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresaVeterinaraRepository extends JpaRepository<AdresaVeterinara, Long> {
}
