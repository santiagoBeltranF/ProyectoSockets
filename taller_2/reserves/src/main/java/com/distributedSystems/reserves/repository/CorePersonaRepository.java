package com.distributedSystems.reserves.repository;

import com.distributedSystems.reserves.models.entity.CorePersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorePersonaRepository extends JpaRepository<CorePersona, Integer> {
}
