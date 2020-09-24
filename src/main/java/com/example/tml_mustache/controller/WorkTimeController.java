package com.example.tml_mustache.controller;

import com.example.tml_mustache.entity.WorkTime;
import com.example.tml_mustache.service.WorkTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class WorkTimeController extends BaseController {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    WorkTimeService workTimeService;

    @GetMapping("/worktime")
    public ModelAndView workTimeList(@RequestParam(required = false) String employeeName,
                                     @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date workDate,
                                     Map<String, Object> model) {
        setBaseModel(model);
        List<WorkTime> workTimeList = workTimeService.getAll(employeeName, workDate);
        model.put("workTimeList", workTimeList);
        model.put("employeeName", null != employeeName ? employeeName : "");
        model.put("workDate", null != workDate ? DATE_FORMAT.format(workDate) : "");
        return new ModelAndView("work_time", model);
    }
}
