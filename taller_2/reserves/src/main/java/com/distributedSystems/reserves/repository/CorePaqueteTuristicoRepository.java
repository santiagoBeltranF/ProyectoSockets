package com.distributedSystems.reserves.repository;

import com.distributedSystems.reserves.models.entity.CorePaqueteTuristico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorePaqueteTuristicoRepository extends JpaRepository<CorePaqueteTuristico, Integer> {
}
