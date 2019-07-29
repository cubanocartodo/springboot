package com.tulay.springcourse.component;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Scheduler {

    @Scheduled(fixedRate = 10000)
    public void TaskScheduling(){
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd");
        Date date= new Date();
        String strDate=simpleDateFormat.format(date);
        System.out.println("Fixed Date scheduler : " + strDate);

    }
}
