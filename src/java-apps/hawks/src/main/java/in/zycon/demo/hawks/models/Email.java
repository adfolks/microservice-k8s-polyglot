package com.adfolks.demo.amqs.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Email {
    String to;
    String from;
    String subject;
    String message;

}
