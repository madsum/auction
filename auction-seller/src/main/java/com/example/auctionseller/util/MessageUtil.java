package com.example.auctionseller.util;

import com.example.auctionseller.model.CustomMessage;

import java.util.Date;

public class MessageUtil {

    public static CustomMessage makeCustomMessage(byte[] photoByte){
        CustomMessage customMessage = new CustomMessage();
        customMessage.setMessage("Sell it");
        customMessage.setPictureByte(photoByte);
        customMessage.setMessageDate(new Date());
        return customMessage;
    }
}
