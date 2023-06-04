package com.ssan.api16san.repository;

import com.ssan.api16san.entity.Ban;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface BanRepository extends JpaRepository<Ban, Long> {
    List<Ban> findByBoard_Name(String name);
    @Transactional
    @Modifying
    @Query("update ban b set b.reason = ?1, b.expiresAt = ?2 where b.id = ?3")
    int updateReasonAndExpiresAtById(String reason, Date expiresAt, Long id);
}
