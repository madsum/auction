package com.example.auctionbuyer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomMessage {
    private long id;
    private String message;
    private byte[] pictureByte;
    private Date messageDate;
}
