package com.example.tml_mustache.controller;

import com.example.tml_mustache.entity.Href;
import com.example.tml_mustache.entity.Message;
import com.example.tml_mustache.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MessageController extends BaseController {

    @Autowired
    MessageService messageService;

    @RequestMapping(value = "/messages/add", method = RequestMethod.POST)
    public String messageAdd(@RequestParam(required = false) String subj,
                             @RequestParam(required = false) String body,
                             Map<String, Object> model,
                             final RedirectAttributes redirectAttrs) {

        Message message = null;
        boolean haveError = false;
        if (null == body || body.trim().isEmpty()) {
            redirectAttrs.addFlashAttribute("errorMessageNew", "Ошибка: пустое сообщение.");
        } else {
            message = messageService.save("Местный", subj, body);
            if (null == message) {
                redirectAttrs.addFlashAttribute("errorMessageNew", "Ошибка создания сообщения. Обратитесь к системному администратору.");
                haveError = true;
            }
        }

        if (null == message) {
            message = new Message();
            message.setSubj(subj);
            message.setBody(body);
        } else {
            message = null;
        }

        redirectAttrs.addFlashAttribute("messageNew", message);
        redirectAttrs.addFlashAttribute("isAddMessage", haveError);

        return "redirect:/messages";
    }

    @GetMapping("/messages")
    public ModelAndView messagesList(@RequestParam(required = false) Integer pgNumber,
                                     @RequestParam(required = false) Integer pgLength,
                                     Map<String, Object> model) {

        setBaseModel(model);

        if (null == pgNumber || 0 > pgNumber) {
            pgNumber = 0;
        }
        if (null == pgLength) {
            pgLength = 5;
        }
        List<Message> messagesList = messageService.getAll(pgNumber, pgLength);
        model.put("messagesList", messagesList);

        Long countAll = messageService.count();
        List<Href> paginator = new ArrayList<>();
        if (countAll > pgLength) {
            int idxPg;
            for (idxPg = 0; idxPg < countAll / pgLength; idxPg++) {
                Href href = new Href();
                href.setHref("/messages?pgNumber=" + idxPg);
                href.setText(String.valueOf(idxPg + 1));
                href.setActive(idxPg == pgNumber);
                paginator.add(href);
            }
            if (idxPg * pgLength < countAll) {
                Href href = new Href();
                href.setHref("/messages?pgNumber=" + idxPg);
                href.setText(String.valueOf(idxPg + 1));
                href.setActive(idxPg == pgNumber);
                paginator.add(href);
            }
        }
        model.put("paginator", paginator);

        model.put("hrefMessageAdd", "/messages/add");

        return new ModelAndView("messages", model);
    }
}
