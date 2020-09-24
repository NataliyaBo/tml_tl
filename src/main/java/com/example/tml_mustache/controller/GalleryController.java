package com.example.tml_mustache.controller;

import com.example.tml_mustache.entity.GalleryItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class GalleryController extends BaseController {

    @GetMapping("/gallery")
    public ModelAndView workTimeList(Map<String, Object> model) {

        setBaseModel(model);

        List<GalleryItem> galleryList = new ArrayList<>();
        for (int idxItem = 1; idxItem <= 17; idxItem++) {
            GalleryItem galleryItem = new GalleryItem();
            galleryItem.setImage("img/gallery/moskow" + idxItem + ".jpg");
            galleryItem.setThumbnail("img/gallery/moskow" + idxItem + "_tn.jpg");
            galleryList.add(galleryItem);
        }
        model.put("galleryList", galleryList);

        return new ModelAndView("gallery", model);
    }
}
