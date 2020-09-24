package com.example.tml_mustache.service.impl;

import com.example.tml_mustache.entity.WorkTime;
import com.example.tml_mustache.repository.WorkTimeRepository;
import com.example.tml_mustache.service.WorkTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class WorkTimeServiceImpl implements WorkTimeService {

    @Autowired
    WorkTimeRepository workTimeRepository;

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<WorkTime> getAll() {
        return workTimeRepository.findAll();
    }

    @Override
    public List<WorkTime> getAll(String name, Date date) {

        HashMap<String, Object> params = new HashMap<>();

        String query = "select wt from WorkTime wt join fetch wt.employee where 1 = 1 ";

        if (null != name) {
            query = query + " and ( lower(wt.employee.firstName) like lower(:nameTml) " +
                    " or lower(wt.employee.lastName) like lower(:nameTml) " +
                    " or lower(wt.employee.patronymic) like lower(:nameTml) ) ";
            params.put("nameTml", "%" + name + "%");
        }

        if (null != date) {
            query = query + " and wt.workDate = :workDate ";
            params.put("workDate", date);
        }

        TypedQuery<WorkTime> typedQuery = em.createQuery(query, WorkTime.class);
        for (String key : params.keySet()) {
            typedQuery.setParameter(key, params.get(key));
        }

        return typedQuery.getResultList();
    }
}
