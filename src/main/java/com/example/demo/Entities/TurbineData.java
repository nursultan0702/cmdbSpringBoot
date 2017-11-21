package com.example.demo.Entities;

import javax.persistence.*;

@Entity
@Table(name = "turbinedata")
public class TurbineData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @Column(name = "time_stamp")
    public String timeStamp;
    @Column(name = "pcd")
    public String pcd;
    @Column(name = "hpcDischarge")
    public String hpcDischarge;
    @Column(name = "hpcSuction")
    public String hpcSuction;
    @Column(name = "ngp")
    public String ngp;
    @Column(name = "npt")
    public String npt;
    @Column(name = "average")
    public String average;
}
