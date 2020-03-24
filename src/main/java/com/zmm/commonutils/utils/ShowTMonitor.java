package com.zmm.commonutils.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @program: talkedu-bigdata
 * @description:简易定时器
 * @author: zhujiamin
 * @create: 2019-11-08 11:15
 **/
@Component
@EnableScheduling
public class ShowTMonitor {

    private final static Logger logger = LogManager.getLogger(ShowTMonitor.class);

    @Scheduled(cron = "0 0 18 * * ?", zone = "GMT+8:00")
    public void execute(){
        System.out.println("(♥◠‿◠)ﾉﾞ  开心就行   ლ(´ڡ`ლ)ﾞ  \n" +
                " .-------.       ____     __        \n" +
                " |  _ _   \\      \\   \\   /  /    \n" +
                " | ( ' )  |       \\  _. /  '       \n" +
                " |(_ o _) /        _( )_ .'         \n" +
                " | (_,_).' __  ___(_ o _)'          \n" +
                " |  |\\ \\  |  ||   |(_,_)'         \n" +
                " |  | \\ `'   /|   `-'  /           \n" +
                " |  |  \\    /  \\      /           \n" +
                " ''-'   `'-'    `-..-'              ");
    }

}
