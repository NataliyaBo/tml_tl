package com.example.tml_mustache.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.tml_mustache.entity.ItemWithNum;

@Controller
public class CarouselController extends BaseController {

    @GetMapping("/carousel")
    public ModelAndView workTimeList(Map<String, Object> model) {

        setBaseModel(model);

        List<ItemWithNum> carouselList = new ArrayList<>();

        ItemWithNum itemWithNum = new ItemWithNum();
        itemWithNum.setIsFirst("y");
        itemWithNum.setName("img/shmel12a.jpg");
        itemWithNum.setIdx(0);
        carouselList.add(itemWithNum);

        itemWithNum = new ItemWithNum();
        itemWithNum.setName("img/shmel1a.jpg");
        itemWithNum.setIdx(1);
        carouselList.add(itemWithNum);

        itemWithNum = new ItemWithNum();
        itemWithNum.setName("img/shmel3a.jpg");
        itemWithNum.setIdx(2);
        carouselList.add(itemWithNum);

        itemWithNum = new ItemWithNum();
        itemWithNum.setName("img/shmel6a.jpg");
        itemWithNum.setIdx(3);
        carouselList.add(itemWithNum);

        itemWithNum = new ItemWithNum();
        itemWithNum.setName("img/shmel9a.jpg");
        itemWithNum.setIdx(4);
        carouselList.add(itemWithNum);

        itemWithNum = new ItemWithNum();
        itemWithNum.setName("img/shmel10a.jpg");
        itemWithNum.setIdx(5);
        carouselList.add(itemWithNum);

        model.put("carouselList", carouselList);

        return new ModelAndView("carousel", model);
    }
}
