package edu.co.unab.DoctorsOffice.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "SCHEDULES")
public class Schedule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id", nullable = false)
    private Integer scheduleId;

    @Column(name="schedule_week", nullable = false)
    private String scheduleWeek;

    @Column(name="schedule_day", nullable = false)
    private String scheduleDay;

    @Column(name ="schedule_hour", nullable = false)
    private String scheduleHour;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;


}
