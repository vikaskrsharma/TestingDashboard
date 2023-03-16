package com.ofbusiness.TestDashboard.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="runStats")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RunStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String iterations;
    private String testName;
    private String items;
    private String totalRequests;
    private String failedAssertions;
    private Long started;
    private Long completed;
    private String startedby;
    private String report;

}
