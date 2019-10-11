package com.flowers.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendExtentReportEmail {

	public static void sendMail() {
		// Create object of Property file
		Properties props = new Properties();
		// This will set host of server
		props.put("mail.smtp.host", "smtp.gmail.com");
		// Set the port of socket factory
		props.put("mail.smtp.socketFactory.port", "465");
		// Set socket factory
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		// Set the authentication to true
		props.put("mail.smtp.auth", "true");
		// Set the port of SMTP server
		props.put("mail.smtp.port", "465");
		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("sooryenqateam@gmail.com", "Sooryen@123");
			}
		});
		try {
			// Create object of MimeMessage class
			Message message = new MimeMessage(session);
			// Set the from address
			message.setFrom(new InternetAddress("sooryenqateam@gmail.com"));
			// Set the recipient address
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("sooryenqateam@gmail.com"));
			// message.addRecipient(RecipientType.BCC, new
			// InternetAddress("your@email.com"));
			message.addRecipient(Message.RecipientType.CC, new InternetAddress("darshit.shah@sooryen.com"));
			// Create object of SimpleDateFormat class and decide the format
			DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
			// Get current date-time with a date
			Date date = new Date();
			// Now format the date
			String date1 = dateFormat.format(date);
			// Add the subject link
			message.setSubject("1800Flowers Production " + date1 + " Report");
			// Create object to add multimedia type content
			BodyPart messageBodyPart1 = new MimeBodyPart();
			// Set the body of email
			messageBodyPart1.setContent(
					"<html><head><title>Automation Report has been created!</title></head><body style=\"margin: 0; padding: 0;\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tr><td style=\"padding: 15px 0 15px 0;\"><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"700\" style=\"border: 1px solid #cccccc; border-collapse: collapse;\"><tr><td align=\"center\" bgcolor=\"#ffffff\" style=\"padding: 15px 0 15px 0; color: #000000;\"><img src=\"http://image.em.1800flowersinc.com/lib/fe92127274650c7477/m/2/logo_flowers_mobile.jpg\" alt=\"1800FLOWERS\" height=\"80\" style=\"display: block;\" /></td></tr><tr><td bgcolor=\"#ffffff\" style=\"padding: 15px 15px 15px 15px;\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"><tr><td style=\"padding: 0px 0px 15px 0px; color: #000000; font-family: Roboto,RobotoDraft,Helvetica,Arial,sans-serif; font-size: 20px;\"><b>Automation Report</b></td></tr><tr><td style=\"color: #000000; font-family: Roboto,RobotoDraft,Helvetica,Arial,sans-serif; font-size: 13px; line-height: 20px;\">Please find attached the report file and download it! <br><hr>To run the report please follow these steps:<br><ol><li><b>Scroll down the message.</b> All files attached to a message are listed at the bottom of the body. All the attachments have thumbnails, regardless if it’s a document file or an image.</li><li><b>Move your mouse cursor over the attachment thumbnail.</b> Two buttons will appear on it: a Down Arrow icon and the Google Drive icon.</li><li><b>Download the attachment.</b> Just click the Down arrow on the thumbnail and the browser will begin downloading the file.</li><li><b>View the saved attachment.</b> Wait for the download to finish, and then open your computer’s Download folder (located inside your My Documents folder) to view the saved attachment.</li></ol>If you have any questions, please feel free to contact us.<br></td></tr></table></td></tr> <tr><td align=\"center\" valign=\"top\"><table border=\"0\" style=\"font-family:Roboto,RobotoDraft,Helvetica,Arial,sans-serif\"><tbody><tr><td align=\"center\" style=\"padding: 15px 15px 15px 15px; color:#000000;font-size:12px\"><a href=\"https://www.1800flowersinc.com/about-us\" style=\"text-decoration:underline;color:#000000\" target=\"_blank\">About Us</a> &nbsp;|&nbsp; <a href=\"https://www.1800flowersinc.com/our-brands\" style=\"text-decoration:underline;color:#000000\" target=\"_blank\">Our Brands</a> &nbsp;|&nbsp; <a href=\"https://investor.1800flowers.com/investors/news-and-events/press-releases/2019\" style=\"text-decoration:underline;color:#000000\" target=\"_blank\">News &amp; Media</a> &nbsp;|&nbsp; <a href=\"https://www.1800flowers.com/About-Us-Terms-of-Use\" style=\"text-decoration:underline;color:#000000\" target=\"_blank\">Terms of Use</a> &nbsp;|&nbsp; <a href=\"https://www.1800flowers.com/About-Us-Privacy-Policy\" style=\"text-decoration:underline;color:#000000\" target=\"_blank\">Privacy Notice</a> &nbsp;|&nbsp;<a href=\"https://www.1800flowers.com/customer-service\" style=\"text-decoration:underline;color:#000000\" target=\"_blank\">Customer Service</a> &nbsp;|&nbsp;<a href=\"https://www.1800flowers.com/contact-us\" style=\"text-decoration:underline;color:#000000\" target=\"_blank\">Contact Us</a> &nbsp;|&nbsp;<a href=\"https://www.1800flowers.com/blog/\" style=\"text-decoration:underline;color:#000000\" target=\"_blank\">Blog</a></td></tr></tbody></table></td></tr><tr><td align=\"center\" valign=\"top\" style=\"padding: 15px 15px 15px 15px; color: #000000; font-family:Roboto,RobotoDraft,Helvetica,Arial,sans-serif; font-size: 12px; line-height: 20px;\">© 2019 <a href=\"tel:1800FLOWERS\" style=\"color:#000000\" target=\"_blank\">1800Flowers.com</a> - One Old Country Road, Suite 500 - Carle Place, New York, 11514-1801, United States</td></tr></table></td></tr></table></body></html>",
					"text/html");
			// Create another object to add another content
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
			// Mention the file which you want to send
			String filename = "extentreport\\1800Flowers.html";
			// String filename = "test-output\\emailable-report.html";
			// Create data source and pass the filename
			DataSource source = new FileDataSource(filename);
			// Set the handler
			messageBodyPart2.setDataHandler(new DataHandler(source));
			// Set the file
			messageBodyPart2.setFileName(filename);
			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();
			// Add body part 1
			multipart.addBodyPart(messageBodyPart2);
			// Add body part 2
			multipart.addBodyPart(messageBodyPart1);
			// Set the content
			message.setContent(multipart);
			// Finally send the email
			Transport.send(message);
			System.out.println("Email sent successfully....");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}