package com.example.tml_mustache.controller;

import com.example.tml_mustache.entity.Href;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class BaseController {

    protected void setBaseModel(Map<String, Object> model) {

        model.put("topImage", "img/shmelik1.jpg");

        //
        List<Href> topMenu = new ArrayList<>();

        Href href = new Href();
        href.setHref("/");
        href.setText("Главная");
        topMenu.add(href);

        href = new Href();
        href.setHref("/carousel");
        href.setText("Карусель");
        topMenu.add(href);

        href = new Href();
        href.setHref("/gallery");
        href.setText("Галерея");
        topMenu.add(href);

        href = new Href();
        href.setHref("/shmele");
        href.setText("Шмеле-страница");
        topMenu.add(href);

        href = new Href();
        href.setHref("/worktime");
        href.setText("Рабочее время");
        topMenu.add(href);

        href = new Href();
        href.setHref("#");
        href.setText("О шмелях");
        topMenu.add(href);

        href = new Href();
        href.setHref("#");
        href.setText("Место в истории");
        topMenu.add(href);

        href = new Href();
        href.setHref("#");
        href.setText("Стать бжж");
        topMenu.add(href);

        model.put("topMenu", topMenu);

        //
        List<Href> leftMenu = new ArrayList<>();

        href = new Href();
        href.setHref("#");
        href.setText("Летучесть");
        leftMenu.add(href);

        href = new Href();
        href.setHref("#");
        href.setText("Навигационная система");
        leftMenu.add(href);

        href = new Href();
        href.setHref("#");
        href.setText("Сбор нектара и урожайность растений");
        leftMenu.add(href);

        href = new Href();
        href.setHref("#");
        href.setText("Грузоподъемность");
        leftMenu.add(href);

        model.put("leftMenu", leftMenu);

        //
        if (5 < (Math.random() * 10)) {
            String congratulation = "Соседняя колония, что за ромашковыми клумбами чуть южнее рябин, принимает поздравления в связи с пополнением!";
            model.put("congratulation", congratulation);
        }

        //
        List<Href> rightMenu = new ArrayList<>();

        href = new Href();
        href.setHref("#");
        href.setText("Полеты временно приостановленны. Прогноз не утешителен на следующие двое суток!");
        rightMenu.add(href);

        href = new Href();
        href.setHref("#");
        href.setText("Очередной рекорд дня поставил Ветролет, опередив Тягача.");
        rightMenu.add(href);

        href = new Href();
        href.setHref("#");
        href.setText("Будьте внимательны и остороржны! Через два дня стартует сезон человеков, созрела малина.");
        rightMenu.add(href);

        model.put("rightMenu", rightMenu);

        //
        List<Href> winners = new ArrayList<>();

        if (5 < (Math.random() * 10)) {
            href = new Href();
            href.setHref("#");
            href.setText("Вертолет");
            winners.add(href);

            href = new Href();
            href.setHref("#");
            href.setText("Тягач");
            winners.add(href);

            href = new Href();
            href.setHref("#");
            href.setText("Обжора");
            winners.add(href);

            href = new Href();
            href.setHref("#");
            href.setText("Молния");
            winners.add(href);

            href = new Href();
            href.setHref("#");
            href.setText("Комета");
            winners.add(href);

            href = new Href();
            href.setHref("#");
            href.setText("Болтушка");
            winners.add(href);
        }

        model.put("winners", winners);
    }
}
