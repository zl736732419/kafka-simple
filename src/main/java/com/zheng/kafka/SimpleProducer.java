package com.zheng.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @Author zhenglian
 * @Date 2018/1/30 19:10
 */
public class SimpleProducer {
    
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "zl200:9092,zl201:9092,zl202:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("partitioner.class", "com.zheng.kafka.MyPartitionar");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        for(int i = 0; i < 100; i++)
            producer.send(new ProducerRecord<>("partitiontest", Integer.toString(i), Integer.toString(i)));

        producer.close();
        System.out.println("producer消息生成完毕!");
    }
    
    
    
    
}
