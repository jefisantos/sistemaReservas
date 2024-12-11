package com.exemplo.sistemareservas.repository;

import com.exemplo.sistemareservas.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
