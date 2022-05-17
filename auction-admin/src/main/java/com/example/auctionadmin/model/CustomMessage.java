package com.example.auctionadmin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class CustomMessage {
    @Id
    @GeneratedValue
    private long id;
    private String message;
    @Transient
    private byte[] pictureByte;
    private Date messageDate;
}
