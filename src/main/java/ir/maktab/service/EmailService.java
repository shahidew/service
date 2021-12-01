package ir.maktab.service;

import ir.maktab.data.entity.Customer;
import ir.maktab.data.entity.Mail;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public interface EmailService {

    void sendEmail(Mail mail);


    void sendEmail(SimpleMailMessage mail);


    void sendSimpleEmail(String toAddress, String subject, String message);

    void sendEmailWithAttachment(String toAddress, String subject, String message, String attachment) throws MessagingException, FileNotFoundException;

    void sendVerificationEmail(Customer customer, String siteURL) throws MessagingException, UnsupportedEncodingException;
}
