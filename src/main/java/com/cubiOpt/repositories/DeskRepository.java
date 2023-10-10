package com.cubiOpt.repositories;

import com.cubiOpt.entities.Desk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeskRepository extends JpaRepository<Desk, String> {
}
