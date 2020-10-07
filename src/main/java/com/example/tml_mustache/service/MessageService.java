package com.example.tml_mustache.service;

import com.example.tml_mustache.entity.Message;
import java.util.List;

public interface MessageService {
    List<Message> getAll();
    List<Message> getAll(Integer pgNumber, Integer pgLength);
    Message save(String userName, String subj, String body);
    Long count();
}
