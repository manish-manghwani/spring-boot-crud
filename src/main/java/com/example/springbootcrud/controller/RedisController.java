package com.example.springbootcrud.controller;

import com.example.springbootcrud.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

@RestController
public class RedisController {

    private StudentService studentSerive;

    @GetMapping("/redis-students")
    public String viewRedisStudents() {

        Jedis jedis = new Jedis("127.0.0.1");

        String allStudents = jedis.get("all-students");

        return allStudents;
    }
}
