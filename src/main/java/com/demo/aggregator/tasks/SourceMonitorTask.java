package com.demo.aggregator.tasks;

import org.springframework.stereotype.Component;

@Component
public class SourceMonitorTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Test task");
    }
}
