package com.example.demohttp.quartz;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@ConfigurationProperties(prefix = "quartz")
@Component
public class QuartzConfig {
    private List<ScheduleJob> jobs = new ArrayList<>();
}
