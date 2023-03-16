package com.ofbusiness.TestDashboard.controller;

import com.ofbusiness.TestDashboard.entity.RunStats;
import com.ofbusiness.TestDashboard.repository.RunStatsRepository;
import com.ofbusiness.TestDashboard.service.RunStatsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RunStatsController {

    @Autowired
    RunStatsRepository runStatsRepository;
    @Autowired
    RunStatsServiceImpl runStatsService;

    @GetMapping({"/runstats", "/"})
    public ModelAndView getAllRunStats(){
        ModelAndView mav = new ModelAndView("runStats");
        List<RunStats> allRunStats = runStatsRepository.findAll();
        System.out.println("RunStats fetched from db: " + allRunStats.size());
        mav.addObject("runStats", allRunStats);
        return mav;
    }

    @GetMapping("/runstats/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
//                                @RequestParam("sortField") String sortField1,
//                                @RequestParam("sortDir") String sortDir1,
                                Model model){
        int pageSize=15;
        String sortField = "started";
        String sortDir = "DSC";
        Page<RunStats> page = runStatsService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<RunStats> listRunStats = page.getContent();



        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);

        model.addAttribute("listRunStats", listRunStats);

        return "runStatsPaginated";
    }
}
