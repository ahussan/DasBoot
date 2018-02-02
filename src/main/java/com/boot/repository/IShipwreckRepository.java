package com.boot.repository;

import com.boot.model.Shipwreck;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by anjalhussan on 2/1/18.
 */
public interface IShipwreckRepository extends JpaRepository<Shipwreck, Long> {
}
