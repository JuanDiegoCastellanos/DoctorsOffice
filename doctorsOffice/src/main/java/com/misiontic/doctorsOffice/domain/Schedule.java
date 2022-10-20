package com.misiontic.doctorsOffice.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "schedules")
public class Schedule implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Integer scheduleId;

    @Column(name="schedule_week")
    private String scheduleWeek;

    @Column(name="schedule_day")
    private String scheduleDay;

    @Column(name ="schedule_hour")
    private String scheduleHour;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public Schedule() {
    }

    public Schedule(Integer scheduleId, String scheduleWeek, String scheduleDay, String scheduleHour, Doctor doctor) {
        this.scheduleId = scheduleId;
        this.scheduleWeek = scheduleWeek;
        this.scheduleDay = scheduleDay;
        this.scheduleHour = scheduleHour;
        this.doctor = doctor;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getScheduleWeek() {
        return scheduleWeek;
    }

    public void setScheduleWeek(String scheduleWeek) {
        this.scheduleWeek = scheduleWeek;
    }

    public String getScheduleDay() {
        return scheduleDay;
    }

    public void setScheduleDay(String scheduleDay) {
        this.scheduleDay = scheduleDay;
    }

    public String getScheduleHour() {
        return scheduleHour;
    }

    public void setScheduleHour(String scheduleHour) {
        this.scheduleHour = scheduleHour;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    
}
