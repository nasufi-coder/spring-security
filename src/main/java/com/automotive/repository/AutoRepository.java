package com.automotive.repository;

import com.automotive.models.entity.AutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutoRepository extends JpaRepository<AutoEntity, Integer> {

    @Transactional
    @Query(nativeQuery = true, value = "Select * from auto where owned_By = ?1")
    List<AutoEntity> findByUser(Integer userID);

    @Transactional
    @Query(nativeQuery = true, value = "Select * from auto where owned_By = ?1 and id = ?2")
    Optional<AutoEntity> findOneByUser(Integer userID, Integer autoID);

}
