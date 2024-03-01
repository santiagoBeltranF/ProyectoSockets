package com.distributedSystems.reserves.repository;

import com.distributedSystems.reserves.models.entity.CoreReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreReservaRepository extends JpaRepository<CoreReserva, Integer> {
}
