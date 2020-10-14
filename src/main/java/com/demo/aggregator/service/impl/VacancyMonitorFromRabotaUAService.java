package com.demo.aggregator.service.impl;

import com.demo.aggregator.model.core.Source;
import com.demo.aggregator.tasks.SourceMonitorTask;
import com.demo.aggregator.service.VacancyMonitorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class VacancyMonitorFromRabotaUAService implements VacancyMonitorService {

    private SourceMonitorTask sourceMonitorTask;
    private TaskScheduler taskScheduler;

    @Autowired
    public VacancyMonitorFromRabotaUAService(SourceMonitorTask sourceMonitorTask, TaskScheduler taskScheduler) {
        this.sourceMonitorTask = sourceMonitorTask;
        this.taskScheduler = taskScheduler;
    }

    @Override
    public void monitoring(Source source) {
        final Long defaultInterval  = 1L;
        monitoring(source, defaultInterval);
    }

    @Override
    public void monitoring(Source source, Long intervalSeconds) {
        log.info("Start vacancy monitor for " + source.getUrl());
        PeriodicTrigger periodicTrigger = new PeriodicTrigger(intervalSeconds, TimeUnit.SECONDS);
        taskScheduler.schedule(sourceMonitorTask, periodicTrigger);
    }
}
