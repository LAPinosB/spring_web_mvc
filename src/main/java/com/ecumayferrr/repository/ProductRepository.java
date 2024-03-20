package com.ecumayferrr.repository;

import com.ecumayferrr.entity.Producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Producto, Long>{

}
