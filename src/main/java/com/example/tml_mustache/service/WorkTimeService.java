package com.example.tml_mustache.service;

import com.example.tml_mustache.entity.WorkTime;

import java.util.Date;
import java.util.List;

public interface WorkTimeService {
    List<WorkTime> getAll();
    List<WorkTime> getAll(String name, Date date);
}
