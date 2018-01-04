package com.roy.tools.services;

import com.roy.tools.moduls.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by roy on 2018/1/4.
 */
public interface CommodityRepository extends JpaRepository<Commodity,Long> {
}
