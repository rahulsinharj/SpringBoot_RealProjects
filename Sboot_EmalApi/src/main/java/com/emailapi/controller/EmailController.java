package com.emailapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emailapi.model.EmailRequest;
import com.emailapi.service.EmailService;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;

	@RequestMapping("/welcome")
	public String welcome() {
		return "hello this is my email api";
	}

//===========[ JSon ke format me bheja hua data iss @RequestBody ke karan emailRequest me aajayega ]===========	
	
	@PostMapping("/sendemail")
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest emailRequest) 		
	{
		System.out.println("EmailRequest : "+emailRequest);
		
		try {
			boolean emailResponseStatus = this.emailService.sendTextEmail(emailRequest.getReceiverMail(), emailRequest.getSubject() , emailRequest.getTextMessage());
			if(emailResponseStatus) {
				return ResponseEntity.status(HttpStatus.CREATED).body("Email sent Successfully to "+emailRequest.getReceiverMail());
			}
			else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email not sent, carefully write details again !");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error in sending mail !");
		}
	
	}
	
//==========[ User can take "receiverMail" , "subject" , "textMessage" as in this method parameter ]=============

/*	@PostMapping("/sendemail")
	public ResponseEntity<?> sendEmail() 		
	{
		try {
			String receiverMail = "rj532903@gmail.com";
			
			String subject = "Normal Message for check";
			
			String textMessage = "Hello dear, This message is only for Demo Purposes. " 
									+ "\n" + "\n" + "Thanks & regards,"
									+ "\n" + "Rahul Sinha";
			
			//	return new ResponseEntity<>(this.emailService.sendTextEmail(receiverMail, subject, textMessage), HttpStatus.OK);
		
			boolean emailResponseStatus = this.emailService.sendTextEmail(receiverMail, subject, textMessage);
			if(emailResponseStatus) {
				return ResponseEntity.status(HttpStatus.CREATED).body("Email sent Successfully to "+receiverMail);
			}
			else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error in sending mail");
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error in sending mail");
		}
	
	}
*/
	
	
}
