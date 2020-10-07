package com.example.tml_mustache.service.impl;

import com.example.tml_mustache.entity.Message;
import com.example.tml_mustache.repository.MessageRepository;
import com.example.tml_mustache.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    @Override
    public List<Message> getAll(Integer pgNumber, Integer pgLength) {

        if (null == pgNumber || 0 > pgNumber) {
            pgNumber = 0;
        }
        if (null == pgLength) {
            pgLength = 5;
        }

        PageRequest paging = PageRequest.of(pgNumber, pgLength, Sort.by(Sort.Direction.DESC, "dtm"));
        Slice<Message> pagedResult = messageRepository.findAll(paging);
        return pagedResult.getContent();
    }

    @Override
    public Message save(String userName, String subj, String body) {
        if (null == userName || userName.isEmpty() || null == body || body.isEmpty()) {
            return null;
        }
        Message message = new Message();
        message.setDtm(new Date());
        message.setUserName(userName);
        message.setSubj(subj);
        message.setBody(body);
        message = messageRepository.saveAndFlush(message);
        return message;
    }

    @Override
    public Long count() {
        return messageRepository.count();
    }
}
