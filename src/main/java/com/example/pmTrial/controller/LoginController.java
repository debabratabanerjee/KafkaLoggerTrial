package com.example.pmTrial.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.example.pmTrial.dao.UserRepository;
//import com.example.pmTrial.engine.AsyncProducerTrial;
import com.example.pmTrial.engine.Producer1;
import com.example.pmTrial.engine.Producer2;
//import com.example.pmTrial.engine.Producer1;
//import com.example.pmTrial.engine.Producer2;
//import com.example.pmTrial.engine.Producer1;
import com.example.pmTrial.entities.UserEntity;
//import com.example.pmTrial.response.ResponseHandler;
import com.example.pmTrial.services.LoginService;

@RestController // using Rest for using Rest Service
public class LoginController {

//stacktrace	
//	Logger log= LogManager.getLogger(UserRepository.class); or we can write like below
	Logger log = LogManager.getLogger(this.getClass());

	@Autowired
	private LoginService loginService;

	// it will just take the impl class and inject the data to the object
	private Producer2 proSync;

	private Producer1 proAsync;

	@Autowired(required = false)
	LoginController(Producer1 proAsync) {
		this.proAsync = proAsync;
	}

	@Autowired(required = false)
	LoginController(Producer2 proSync) {
		this.proSync = proSync;
	}

//	
//	
//	
//
//
//	public LoginController (LoginService loginService, UserRepository userRepository) {
//		this.loginService = loginService;
//	}

//cereating a sepearte thread to handel kafka	

	// getLogin Details

//Async Operation	

	@SuppressWarnings("unchecked")
	@GetMapping("/logins")

	public ResponseEntity<String> getLogins() {

		// running
		try {
			List<UserEntity> result = loginService.getLogins();
			log.info("Geting all the login details of all");
			proAsync.sendAsync("the details" + result);
			proAsync.sendAsync("the details" + result);
			proAsync.sendAsync("the details" + result);
			proAsync.sendAsync("the details" + result);
			proAsync.sendAsync("the details" + result);
			proAsync.sendAsync("the details" + result);
//           log.info("the deatils" + result);
//           	 return ResponseHandler.genarateResponse("Successfully retrieved data!", HttpStatus.OK, result);
			return ResponseEntity.ok("Message sent to loginInfo topic");
		} catch (Exception e) {
			proAsync.sendAsync(e.getMessage());
//            return ResponseHandler.genarateResponse("Bad request", HttpStatus.BAD_REQUEST, null);

			return (ResponseEntity<String>) ResponseEntity.notFound();

		}
	}

// Sync Operation

//@SuppressWarnings("unchecked")
//@GetMapping("/logins")
//	
//	public ResponseEntity<String> getLogins(){
//		
//		//running
//		try {
//            List<UserEntity> result = loginService.getLogins();
//            log.info("Geting all the login details of all");
//            proSync.sendSync("the details" + result);
//            proSync.sendSync("the details" + result);
//            proSync.sendSync("the details" + result);
//            proSync.sendSync("the details" + result);
////           log.info("the deatils" + result);
////           	 return ResponseHandler.genarateResponse("Successfully retrieved data!", HttpStatus.OK, result);
//            return ResponseEntity.ok("Message sent to loginInfo topic");
//        } catch (Exception e) {
//        	proSync.sendSync(e.getMessage());
////            return ResponseHandler.genarateResponse("Bad request", HttpStatus.BAD_REQUEST, null);
//        	
//            return (ResponseEntity<String>) ResponseEntity.notFound();
//
//        	
//        	
//        	
//        }
//	}

	@SuppressWarnings("unchecked")
	@GetMapping("/logins/{loginId}")
	public ResponseEntity<String> getLogin(@PathVariable int loginId) throws InterruptedException {

		// logger entry
		// doubt edited and running

		try {
			UserEntity result = loginService.getLogin(loginId);
//	            log.info("Geting details of "+ loginId + "with details"+result);
			proAsync.sendAsync("Geting details of " + loginId + result);
//	            return ResponseHandler.genarateResponse("Successfully retrieved data!", HttpStatus.OK, result);
			return ResponseEntity.ok("Message sent to loginInfo topic");
		} catch (Exception e) {
//	            return ResponseHandler.genarateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
			proAsync.sendAsync(e.getMessage());
//	        	log.error(e.getMessage());
//	            return ResponseHandler.genarateResponse("Bad request", HttpStatus.BAD_REQUEST, null);
			return (ResponseEntity<String>) ResponseEntity.notFound();
		}

	}

	@PostMapping("/logins")
	public void addLogin(@Valid @RequestBody UserEntity login) {

		// running
		try {
			UserEntity result = loginService.addLogin(login);
			proSync.sendSync("Posting new details which are " + "[ id =" + result.getId() + ", name = "
					+ result.getName() + ", email = " + result.getEmail() + "]");
//	            return ResponseHandler.genarateResponse("Successfully added data!", HttpStatus.OK, result);
		} catch (Exception e) {

			log.error(e.getMessage());
//	            return ResponseHandler.genarateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}

	}

	@PutMapping("/logins/{loginId}")
	public void updateLogin(@PathVariable int loginId, @Valid @RequestBody UserEntity login) {
		// running

		try {
			UserEntity result = loginService.updateLogin(login, loginId);
			log.info("Editing the details of an login " + loginId + " with new details as [ name = " + result.getName()
					+ " Email = " + result.getEmail() + "]");
//            return ResponseHandler.genarateResponse("Updated", HttpStatus.OK, result);
		} catch (Exception e) {
			log.info(e.getMessage());
//            return ResponseHandler.genarateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}

	@DeleteMapping("logins/{loginId}")
	public void deleteLogin(@PathVariable int loginId) {
		try {
			loginService.deleteLogin(loginId);
			log.info("Deleting the details of an loginId " + loginId);

//            return ResponseHandler.genarateResponse("Deleted!", HttpStatus.OK, result);
		} catch (Exception e) {
			log.error(e.getMessage());
//            return ResponseHandler.genarateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
	}
}
