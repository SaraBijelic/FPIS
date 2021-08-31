package com.fon.fpis.repository;

import com.fon.fpis.domain.Proizvod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProizvodRepository extends JpaRepository<Proizvod, Long> {
}
