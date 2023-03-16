package com.ofbusiness.TestDashboard.service;

import com.ofbusiness.TestDashboard.entity.RunStats;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface RunStatsService {

    List<RunStats> getAllRunStats();
    Page<RunStats> findPaginated(int pageNo, int pageSize, String sortField, String sortDir);
}
