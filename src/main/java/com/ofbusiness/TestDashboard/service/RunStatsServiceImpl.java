package com.ofbusiness.TestDashboard.service;

import com.ofbusiness.TestDashboard.entity.RunStats;
import com.ofbusiness.TestDashboard.repository.RunStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunStatsServiceImpl implements RunStatsService{

    @Autowired
    RunStatsRepository runStatsRepository;

    @Override
    public List<RunStats> getAllRunStats() {
        return runStatsRepository.findAll();
    }

    @Override
    public Page<RunStats> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo-1, pageSize, sort);
        return this.runStatsRepository.findAll(pageable);
    }
}
