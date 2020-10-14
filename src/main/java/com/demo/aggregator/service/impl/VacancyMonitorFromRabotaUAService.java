package com.demo.aggregator.service.impl;

import com.demo.aggregator.config.sources.RabotaUASource;
import com.demo.aggregator.config.sources.Source;
import com.demo.aggregator.tasks.SourceMonitorTask;
import com.demo.aggregator.service.VacancyMonitorService;
import lombok.SneakyThrows;
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
    private RabotaUASource source;

    @Autowired
    @SneakyThrows
    public VacancyMonitorFromRabotaUAService(SourceMonitorTask sourceMonitorTask, TaskScheduler taskScheduler, RabotaUASource source) {
        this.sourceMonitorTask = sourceMonitorTask;
        this.taskScheduler = taskScheduler;
        this.source = source;
    }

    @Override
    public void monitoring() {
        final Long defaultInterval  = 1L;
        monitoring(defaultInterval);
    }

    @Override
    public void monitoring(Long intervalSeconds) {
        log.info("Start vacancy monitor for " + source.getUrl());
        PeriodicTrigger periodicTrigger = new PeriodicTrigger(intervalSeconds, TimeUnit.SECONDS);
        taskScheduler.schedule(sourceMonitorTask, periodicTrigger);
    }

    @Override
    public void stopMonitoring() {

    }
}
