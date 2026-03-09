package com.Project.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Project.DTO.UserDTO;
import com.Project.Entity.UserEntity;
import com.Project.Service.MailSenderService;
import com.Project.Service.UserService;

import jakarta.mail.MessagingException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

	private UserService service;

	private MailSenderService service2;

	public UserController(UserService service, MailSenderService service2) {
		this.service = service;
		this.service2 = service2;

	}

	@PostMapping("/add-user")
	public UserEntity createUser(@RequestBody UserDTO dto) throws MessagingException {
		service2.sendMessage(dto);
		return service.saveUser(dto);
	}

	@GetMapping("/get-users")
	public List<UserEntity> getAll() {
		return service.getAllUser();
	}

	@GetMapping("/get-one/{id}")
	public UserEntity getById(@PathVariable Long id) {
		return service.getUserById(id);
	}

	@PostMapping("/upload")
	public String uploadFile(@RequestPart("file") MultipartFile file) throws IOException {
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getContentType());
		System.out.println(file.getSize());
		
		String path="E:/uploads";
		File file2 =new File(path+"/"+file.getOriginalFilename());
		if(file2.exists())
		{
		 throw new FileAlreadyExistsException(path);
		}
		else {
		file2.createNewFile();
		file.transferTo(file2);
		}
		
		return file.getOriginalFilename() + "Uploaded Successfully";
	}

	@PostMapping("/upload-multiple")
	public String uploadMultiplefiles(@RequestPart("files") MultipartFile files[]) {
		StringBuffer s = new StringBuffer();
	  for(int i=0;i<files.length;i++) {
		  s.append(files[i].getOriginalFilename()+"::");
	  }
		return "Fiels Uploaded Successfully...!";
	}
}
	