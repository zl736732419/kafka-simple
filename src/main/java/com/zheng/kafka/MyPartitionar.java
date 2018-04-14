package com.zheng.kafka;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

/**
 * @Author zhenglian
 * @Date 2018/4/14 11:20
 */
public class MyPartitionar implements Partitioner {
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        System.out.println("key: " + key);
        System.out.println("value: " + value);
        Integer num = Integer.parseInt(key+"");
        int partition = num % 3;
        return partition;
    }

    @Override
    public void close() {
    }

    @Override
    public void configure(Map<String, ?> configs) {
    }
}
