package com.example.tml_mustache.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "work_time")
public class WorkTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "work_date")
    @Temporal(TemporalType.DATE)
    private Date workDate;

    @Column(name = "work_time_minutes")
    private Long workTimeMinutes;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    //region - getters/setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public Long getWorkTimeMinutes() {
        return workTimeMinutes;
    }

    public void setWorkTimeMinutes(Long workTimeMinutes) {
        this.workTimeMinutes = workTimeMinutes;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    //endregion

    /**
     * Возвращает полное имя сотрудника
     * @return полное имя сотрудника
     */
    public String getEmployeeName() {
        return null != employee ? employee.getFullName() : "";
    }

    /**
     * Возвращает название должности
     * @return название должности
     */
    public String getPositionName() {
        return null != employee ? (null != employee.getPosition() ? employee.getPosition().getName() : "") : "";
    }
}
