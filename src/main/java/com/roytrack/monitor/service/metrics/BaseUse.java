package com.roytrack.monitor.service.metrics;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

import javax.swing.plaf.TableHeaderUI;
import java.util.concurrent.TimeUnit;

/**
 * Created by roytrack on 2015/6/11.
 */
public class BaseUse {
    static final MetricRegistry metrics=new MetricRegistry();
    public static void main(String args[]){
        startReport();
        Meter requests=metrics.meter("requests");
        while(true){
            requests.mark();
            wait5second();
        }


    }


    static void startReport(){
        ConsoleReporter consoleReporter=ConsoleReporter.forRegistry(metrics).
                convertDurationsTo(TimeUnit.MILLISECONDS).convertRatesTo(TimeUnit.SECONDS).build();
        consoleReporter.start(1,TimeUnit.SECONDS);
    }

    static void wait5second(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
