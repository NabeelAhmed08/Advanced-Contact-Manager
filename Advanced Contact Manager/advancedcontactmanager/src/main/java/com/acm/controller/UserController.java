package com.acm.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.acm.dao.ContactRepository;
import com.acm.dao.UserRepository;
import com.acm.model.Contact;
import com.acm.model.User;
import com.acm.service.ContactServiceImpl;
import com.acm.utill.Message;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ContactRepository contactRepo;
	
	@Autowired
	ContactServiceImpl service;
	
	
	@ModelAttribute
	public void addCommonData(Model model ,Principal principal) {
		model.addAttribute("title","Dashboard - ACM");
		String userName =  principal.getName();
	 	User user = userRepo.findByEmail(userName);
	 	model.addAttribute("user",user);
	}

	@GetMapping("/index")
	public String dashboard(Model model ,Principal principal) {
		
		return "normal/user_dashboard";
	
	}
	
	@GetMapping("/add-contact")
	public String addContactForm(Model model) {
		model.addAttribute("title","Add Contact - ACM");
		model.addAttribute("contact",new Contact());
		
		return "normal/add_contact_form";	
	}
	
//	processing add contact form
	
	@PostMapping("/process-contact")
	public String processContact(
			@ModelAttribute Contact contact,
			@RequestParam("profileImage") MultipartFile file,
			Principal principal,
			HttpSession session,
			Model model) {
		
		try {
		
		String userName =  principal.getName();
	 	User user = userRepo.findByEmail(userName);
	 	
//	 	processing image
	 	if(file.isEmpty())
	 	{
	 		contact.setImage("default.png");	
	 	}
	 	
	 	else {
	 		
			contact.setImage(file.getOriginalFilename());
//			/static/img/profile	
	File saveFile =	new ClassPathResource("static/img/").getFile();
	Path path = Paths.get(saveFile.getAbsolutePath()+File.separator+file.getOriginalFilename());
	Files.copy(file.getInputStream(), path,StandardCopyOption.REPLACE_EXISTING);
	 	}
	
	 	contact.setUser(user);
	 	user.getContacts().add(contact);
	 	
	 	userRepo.save(user);
	 	session.setAttribute("message", new Message("Contact Saved Sucessfully", "alert-success"));
		}catch (Exception e) {
			System.out.println(e.getMessage());
			session.setAttribute("message",new Message("Somthing Went Wrong !! "+e.getMessage(), "alert-danger"));	
		}
	//	System.out.println("contact: "+contact);
		return "normal/add_contact_form";
	}
	
	@GetMapping("/view-contacts/{page}")
	public String viewContact(@PathVariable("page") Integer page, Model model ,Principal principal) {
		model.addAttribute("title","All Contacts - ACM");
		String userName =  principal.getName();
	 	User user = userRepo.findByEmail(userName);
	 	
	//Pageable of =	PageRequest.of(page, 5, asc, properties);
	Pageable pageable =	PageRequest.of(page-1, 3);	
	 	Page<Contact> contacts =  contactRepo.findContactsByUser(user.getId(),pageable);
		model.addAttribute("contacts",contacts);
		model.addAttribute("currentPage",page);
		model.addAttribute("totalPages",contacts.getTotalPages());
		return "normal/view_contacts";
		
	}
	
//	get contact by id
	
	@GetMapping("/contact/{cId}")
	public String viewContactById(@PathVariable("cId") Integer cId, Model model ,Principal principal) {
	
			String userName =  principal.getName();
		 	User user = userRepo.findByEmail(userName);		 	
		 	Optional<Contact> optional =	contactRepo.findById(cId);
	  if(optional.isPresent()) {
				model.addAttribute("title","Contact Details - ACM");
			  Contact contact = optional.get();
				if (user.getId()==contact.getUser().getId()) {
					model.addAttribute("contact",contact);
				}
				
				return "normal/contact_detail";
		  }
	  		else {
			model.addAttribute("title","404 Error - ACM");
			
			return "normal/404error";
		}
	}
	
	@GetMapping("/delete/{cId}")
	public String DeleteContactById(@PathVariable("cId") Integer cId,
			Model model ,
			Principal principal,
			HttpSession session) {
	
			String userName =  principal.getName();
		 	User user = userRepo.findByEmail(userName);
		 	
		 	Optional<Contact> optional =	contactRepo.findById(cId);
			  if(optional.isPresent()) {
				  
						
					  Contact contact = optional.get();
					 service.deleteContact(contact);
					 
		 	session.setAttribute("message", new Message("Contact deleted Sucessfully","alert-success"));
				 		
	}
			return "redirect:/user/view-contacts/1";
	}

	@PostMapping("/update-contact/{cId}")
	public String updateContact(
			@PathVariable("cId") Integer cId,
			Model model) {
		
		Optional<Contact> optional = contactRepo.findById(cId);		
		  Contact contact = optional.get();
		  
		model.addAttribute("title","Update Contact - ACM");
		model.addAttribute("contact",contact);
		return "normal/update_contact";

	}

//	process update form
	
	//process-update
	@PostMapping("/process-update")
	public String updateContactProcessing(
			@ModelAttribute Contact contact,
			@RequestParam("profileImage") MultipartFile file,
			Principal principal,
			HttpSession session,
			Model model ) {
		

		String userName =  principal.getName();
	 	User user = userRepo.findByEmail(userName);
	 	Contact oldContact = contactRepo.findById(contact.getcId()).get();
		
		try {
			
		 	
//		 	    processing image
		 	if(!file.isEmpty())
		 	{
//		 		delete old pic
		 		
		 		File deleteFile =	new ClassPathResource("static/img/").getFile();
		 		File file_old = new File(deleteFile, oldContact.getImage());
		 		file_old.delete();
		 		
		 		
//		 		updating with new image
		 		
		 		File saveFile =	new ClassPathResource("static/img/").getFile();
		 		Path path = Paths.get(saveFile.getAbsolutePath()+File.separator+file.getOriginalFilename());
		 		Files.copy(file.getInputStream(), path,StandardCopyOption.REPLACE_EXISTING);
		 		 	
		 		contact.setImage(file.getOriginalFilename());
		 	}

		 	else {
		 		contact.setImage(oldContact.getImage());	
		 		}
		 	
		 	
		 	contact.setUser(user);
		 	contactRepo.save(contact);
		 	session.setAttribute("message", new Message("Contact Updated Sucessfully", "alert-success"));

		} 	
		 	catch (Exception e) {
				e.printStackTrace();
			}
		 	
	
		return "redirect:/user/contact/"+contact.getcId();	
	}
	
	
	@GetMapping("/profile")
	public String myProfile(Model model) {
		model.addAttribute("title","My Profile - ACM");
		
		return "normal/profile";
		
	}
	
}
