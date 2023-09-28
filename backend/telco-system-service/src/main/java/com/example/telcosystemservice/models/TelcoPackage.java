package com.example.telcosystemservice.models;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Entity
@Table(name = "telco_package")
public class TelcoPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Getter
    @Column(nullable = false)
    private String name;

    @Getter
    @Column(nullable = false)
    private Float price;

    @Getter
    @Column(nullable = false)
    private Integer size;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(name = "pay_type", nullable = false)
    private PayType payType;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(name = "service_type", nullable = false)
    private ServiceType serviceType;

    public TelcoPackage(String name, Float price, Integer size, PayType payType, ServiceType serviceType) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.payType = payType;
        this.serviceType = serviceType;
    }

    public TelcoPackage() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setPayType(PayType payType) {
        this.payType = payType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
