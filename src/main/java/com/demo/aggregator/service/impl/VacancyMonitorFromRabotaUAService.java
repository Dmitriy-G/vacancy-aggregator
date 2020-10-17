package com.demo.aggregator.service.impl;

import com.demo.aggregator.tasks.RabotaUAVacancyMonitorTask;
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

    private RabotaUAVacancyMonitorTask rabotaUAVacancyMonitorTask;
    private TaskScheduler taskScheduler;

    @Autowired
    public VacancyMonitorFromRabotaUAService(RabotaUAVacancyMonitorTask rabotaUAVacancyMonitorTask, TaskScheduler taskScheduler) {
        this.rabotaUAVacancyMonitorTask = rabotaUAVacancyMonitorTask;
        this.taskScheduler = taskScheduler;
    }

    @Override
    public void monitoring() {
        final Long defaultInterval  = 30L;
        monitoring(defaultInterval);
    }

    @Override
    public void monitoring(Long intervalSeconds) {
        PeriodicTrigger periodicTrigger = new PeriodicTrigger(intervalSeconds, TimeUnit.SECONDS);
        taskScheduler.schedule(rabotaUAVacancyMonitorTask, periodicTrigger);
    }

    @Override
    public void stopMonitoring() {

    }
}
