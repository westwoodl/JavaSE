package com.mianshi;

import org.junit.Test;

import java.util.*;

/**
 * @author xu rongchao
 * @date 2020-12-02 11:56
 */
public class JVMDemo {

    static {
        System.out.println("JVM");
    }
    /**
     * -XX:MetaspaceSize=256m 元空间最小FGC内存
     * -XX:MaxMetaspaceSize=256m"
     * -XX:MaxDirectMemorySize=1g"
     * -XX:SurvivorRatio=10"
     * -XX:+UseConcMarkSweepGC -XX:CMSMaxAbortablePrecleanTime=5000"
     * -XX:+CMSClassUnloadingEnabled -XX:CMSInitiatingOccupancyFraction=80 -XX:+UseCMSInitiatingOccupancyOnly"
     * -XX:+ExplicitGCInvokesConcurrent -Dsun.rmi.dgc.server.gcInterval=2592000000 -Dsun.rmi.dgc.client.gcInterval=2592000000"
     * -XX:ParallelGCThreads=${CPU_COUNT}"
     * -Xloggc:${MIDDLEWARE_LOGS}/gc.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps"
     * -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=${MIDDLEWARE_LOGS}/java.hprof"
     * -Djava.awt.headless=true"
     * -Dsun.net.client.defaultConnectTimeout=10000"
     * -Dsun.net.client.defaultReadTimeout=30000"
     * -Dfile.encoding=UTF-8"
     * -Dproject.name=${APP_NAME}"
     * -Dpandora.location=/root/task-center/bin/taobao-hsf.sar -Daddress.server.domain=addr-sh-internal.edas.aliyun.com -Daddress.server.port=8080 -Dconfigserver.client.port=8000 -Dalicloud.deployment.mode=EDAS_MANAGED -Dtenant.id=cac91549-54aa-4413-aaa4-7d4684c3c3c8 -Dspas.identity=/root/task-center/spaskey/default"
     */

}
