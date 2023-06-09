package com.baeldung.extensions;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Gauge;
import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

public class ProcessMemoryMetrics {

    private final MeterRegistry meterRegistry;
    private final OperatingSystemMXBean osBean;

    public ProcessMemoryMetrics(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        this.osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
    }

    public void registerMetrics() {
        Gauge.builder("process_virtual_memory_bytes", osBean, OperatingSystemMXBean::getCommittedVirtualMemorySize)
            .description("Virtual memory usage of the process in bytes")
            .baseUnit("bytes")
            .register(meterRegistry);
    }
    
    
}





        