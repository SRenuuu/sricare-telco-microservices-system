package com.example.telcosystemservice.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Entity
@Table(name = "user_subscriptions")
public class UserSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Getter
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Getter
    @Column(nullable = false)
    private String phone;

    @Getter
    @Column(name = "pay_type", nullable = false, length = 10)
    private PayType payType;

    @Getter
    @Column(name = "base_package", nullable = false)
    private String basePackage;

    @Getter
    @Column(name = "reload_balance", nullable = false)
    private Integer reloadBalance;

    @Getter
    @Column(name = "voice_balance", nullable = false)
    private Integer voiceBalance;

    @Getter
    @Column(name = "data_balance", nullable = false)
    private Integer dataBalance;

    @Getter
    @Column(name = "outstanding_amount", nullable = false)
    private Integer outstandingAmount;

    public UserSubscription(User user, String phone, PayType payType, String basePackage, Integer reloadBalance, Integer voiceBalance, Integer dataBalance, Integer outstandingAmount) {
        this.user = user;
        this.phone = phone;
        this.payType = payType;
        this.basePackage = basePackage;
        this.reloadBalance = reloadBalance;
        this.voiceBalance = voiceBalance;
        this.dataBalance = dataBalance;
        this.outstandingAmount = outstandingAmount;
    }

    public UserSubscription() {

    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setReloadBalance(Integer reloadBalance) {
        this.reloadBalance = reloadBalance;
    }

    public void setVoiceBalance(Integer voiceBalance) {
        this.voiceBalance = voiceBalance;
    }

    public void setDataBalance(Integer dataBalance) {
        this.dataBalance = dataBalance;
    }

    public void setOutstandingAmount(Integer outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }
}