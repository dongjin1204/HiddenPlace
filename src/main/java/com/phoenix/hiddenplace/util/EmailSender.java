package com.phoenix.hiddenplace.util;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailSender {

	private JavaMailSender mailSender;

	public JavaMailSender getMailSender() {

		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {

		this.mailSender = mailSender;
	}

	public void SendEmail(Email email) throws Exception {

		if (mailSender == null) {
			
			return;
		}

		MimeMessage msg = mailSender.createMimeMessage();

		try {
			msg.setSubject(email.getSubject());
			msg.setText(email.getContent());
			msg.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(email.getReciver()));

		} catch (MessagingException e) {
			e.printStackTrace();
		}

		try {
			mailSender.send(msg);
		} catch (MailException e) {
			e.printStackTrace();
		}

	}
	
}