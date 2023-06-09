package com.baeldung.extensions;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Gauge;
import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

public class SystemMetricsCollector {

    private final MeterRegistry meterRegistry;
    private final OperatingSystemMXBean osBean;

    public SystemMetricsCollector(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        this.osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
    }

    public void registerMetrics() {
        Gauge.builder("process_resident_memory_bytes", osBean, OperatingSystemMXBean::getTotalPhysicalMemorySize)
            .description("Resident memory usage of the process in bytes")
            .baseUnit("bytes")
            .register(meterRegistry);
    }
}


