package com.roytrack.monitor.service.metrics;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.health.HealthCheck;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;

/**
 * Created by roytrack on 2015/6/11.
 */
public class TheHealthCheck  extends HealthCheck{

    private final EmbeddedDatabase  database;

    public TheHealthCheck(EmbeddedDatabase database){
        this.database=database;
    }

    @Override
    protected Result check() throws Exception {
        if(database.getConnection()!=null){
            return HealthCheck.Result.healthy();
        }else {
            return HealthCheck.Result.unhealthy("cannot connect to database");
        }

    }


    public static void main(String[] args) {
        MetricRegistry Healthchecks=new MetricRegistry();
        EmbeddedDatabase database;
//        Healthchecks.register("HSQL",new TheHealthCheck());
    }
}
