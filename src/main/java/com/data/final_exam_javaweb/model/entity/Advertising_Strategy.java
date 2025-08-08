package com.data.final_exam_javaweb.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "advertising_strategy")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Advertising_Strategy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "stategory_id")
    private int id;

    @Column(name = "manager_name")
    private String managerName;

    @Column(name = "manager_phone")
    private String managerPhone;

    @Column(name = "staff_name")
    private String staffName;

    @Column(name = "staff_phone")
    private String staffPhone;

    @Column(name = "implement_date")
    private Date implementDate;

    @Column(name = "day_duration")
    private int dayDuration;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "Content")
    private String content;

    private Integer status = 1;
}
