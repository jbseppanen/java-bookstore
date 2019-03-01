package com.lambdaschool.javabookstore.repositories;

import com.lambdaschool.javabookstore.models.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Long> {
}
