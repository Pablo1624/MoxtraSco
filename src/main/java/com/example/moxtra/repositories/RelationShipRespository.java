package com.example.moxtra.repositories;

import com.example.moxtra.entities.RelationShipEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RelationShipRespository extends PagingAndSortingRepository<RelationShipEntity, Long>,
        JpaSpecificationExecutor<RelationShipEntity> {


}
