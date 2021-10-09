package com.example.beertasting.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name= "beers")
@Entity
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    @Column
    private BeerType beerType;

    @Column
    private Date dateTasted;

    @Column
    private int looks;

    @Column
    private int smell;

    @Column
    private int taste;

    @Column
    private int mouthfeel;

    @Column
    private double overallScore;


}
