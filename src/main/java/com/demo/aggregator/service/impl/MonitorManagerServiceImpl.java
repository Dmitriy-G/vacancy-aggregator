package com.demo.aggregator.service.impl;

import com.demo.aggregator.service.MonitorManagerService;
import com.demo.aggregator.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MonitorManagerServiceImpl implements MonitorManagerService {

    private List<MonitorService> services;

    @Autowired
    public MonitorManagerServiceImpl(VacancyMonitorFromRabotaUAService vacancyMonitorFromRabotaUAService) {
        this.services = new ArrayList<>();
        this.services.add(vacancyMonitorFromRabotaUAService);
        process();
    }

    @Override
    public void process() {
        for (MonitorService service: services) {
            startMonitor(service);
        }
    }

    @Override
    public void startMonitor(MonitorService monitorService) {
        monitorService.monitoring();
    }

    @Override
    public void stopMonitor(MonitorService monitorService) {
       monitorService.stopMonitoring();
    }
}
