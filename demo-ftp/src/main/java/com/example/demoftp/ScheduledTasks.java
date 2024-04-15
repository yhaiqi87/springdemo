package com.example.demoftp;

import cn.hutool.core.util.IdUtil;
import cn.hutool.extra.ftp.Ftp;
import cn.hutool.extra.ftp.FtpConfig;
import cn.hutool.extra.ftp.FtpMode;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.Date;

@Component
public class ScheduledTasks {

    // @Scheduled(cron = "0/1 * * * * ?")
    public void reportCurrentTime() {
        System.out.println("The time is now " + new Date());

        String host = "sit-f202-ftp.prod.bcs";
        int port = 21;
        String username = "ftpuser";
        String password = "abc@1234";
        FtpConfig ftpConfig = new FtpConfig(host, port, username, password, Charset.defaultCharset());
        Ftp ftp = new Ftp(ftpConfig, FtpMode.Active);
        String pwd = ftp.pwd();
        System.out.println(pwd);
    }
}
