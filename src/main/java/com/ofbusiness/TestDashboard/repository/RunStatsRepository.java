package com.ofbusiness.TestDashboard.repository;

import com.ofbusiness.TestDashboard.entity.RunStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RunStatsRepository extends JpaRepository<RunStats, Long> {
}
