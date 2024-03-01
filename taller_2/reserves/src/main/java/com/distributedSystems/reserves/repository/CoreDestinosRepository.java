package com.distributedSystems.reserves.repository;

import com.distributedSystems.reserves.models.entity.CoreDestinos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoreDestinosRepository extends JpaRepository<CoreDestinos, Integer> {
}
