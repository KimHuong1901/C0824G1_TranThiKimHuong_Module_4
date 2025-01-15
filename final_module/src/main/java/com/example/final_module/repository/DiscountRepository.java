package com.example.final_module.repository;

import com.example.final_module.model.Discount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface DiscountRepository extends JpaRepository<Discount, Integer>{
    List<Discount> findAllByTitleContainingIgnoreCase(String title);
}
