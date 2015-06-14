package com.roytrack.monitor.service.metrics;

import com.codahale.metrics.*;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

import static com.codahale.metrics.MetricRegistry.name;

/**
 * Created by roytrack on 2015/6/11.
 */
public class QueueManager {
    private final Queue queue;
    public Queue getQueue(){
        return queue;
    }

    public QueueManager(MetricRegistry metrics, String name){
        this.queue=new ArrayBlockingQueue(30);
        metrics.register(name(QueueManager.class, name, "size"), new Gauge<Integer>() {
            @Override
            public Integer getValue() {
                return queue.size();
            }
        });
    }

    public static void main(String[] args) throws InterruptedException {

        MetricRegistry metrics=new MetricRegistry();
        ConsoleReporter consoleReporter=ConsoleReporter.forRegistry(metrics).
                convertDurationsTo(TimeUnit.MILLISECONDS).convertRatesTo(TimeUnit.SECONDS).build();
        consoleReporter.start(1,TimeUnit.SECONDS);

        Counter pendingjobs=metrics.counter(name(QueueManager.class,"pending-jobs"));

        Histogram histogram=metrics.histogram(name(QueueManager.class,"his"));

        Timer timer=metrics.timer(name(QueueManager.class,"timer"));
        QueueManager q=new QueueManager(metrics,"roy");
        Queue queue1=q.getQueue();
        for (int i=0;i<29;i++){
            pendingjobs.inc();
            Timer.Context c=timer.time();
            queue1.add("");
            c.stop();
            histogram.update(queue1.size());
            Thread.sleep(500);
        }
        for (int i=0;i<29;i++){
            pendingjobs.inc();
            Timer.Context c=timer.time();
            queue1.poll();
            c.stop();
            Thread.sleep(500);
        }


    }


}
