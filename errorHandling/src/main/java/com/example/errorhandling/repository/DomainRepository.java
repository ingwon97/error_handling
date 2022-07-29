package com.example.errorhandling.repository;

import com.example.errorhandling.domain.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DomainRepository extends JpaRepository<Domain, Long> {
    List<Domain> findAllByOrderByModifiedAtDesc();
}
