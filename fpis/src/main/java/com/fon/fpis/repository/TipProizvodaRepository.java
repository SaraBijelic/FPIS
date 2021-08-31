package com.fon.fpis.repository;

import com.fon.fpis.domain.TipProizvoda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipProizvodaRepository extends JpaRepository<TipProizvoda, Long> {
}
