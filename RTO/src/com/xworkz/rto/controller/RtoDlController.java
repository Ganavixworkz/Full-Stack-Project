package com.xworkz.rto.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.rto.dto.DlDto;

import com.xworkz.rto.service.RtoDlService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
	
public class RtoDlController {

	@Autowired
	RtoDlService ser;
	
	@PostMapping("/dlentry")
	public String onSave(@ModelAttribute DlDto dto,Model model) {
		
		/*
		 * try {
		 * 
		 * String fileContentType = file.getContentType();
		 * 
		 * String filename = file.getOriginalFilename(); dto.setFile(filename);
		 * System.out.println("File Name is   : " + filename + "   content type is    "
		 * + fileContentType); byte[] bytes = file.getBytes(); Path path =
		 * Paths.get("D://filesave//" + file.getOriginalFilename()); Files.write(path,
		 * bytes);
		 * 
		 * model.addAttribute("message", "You successfully uploaded '" +
		 * file.getOriginalFilename() + "'");
		 * 
		 * } catch (IOException e) { e.printStackTrace(); }
		 */
		ser.onSave(dto);
			if(dto.getApplicationNumber()!=null) {
				model.addAttribute("success", "Registered Successfully!!!! "
						+ " Application Number:"+dto.getApplicationNumber() );
				model.addAttribute("appl",dto.getApplicationNumber());
				}
			return "uploadfile";
	}
	
	
	@GetMapping("updateDlStatus")
	public String dlStatus(@RequestParam int id,Model model) {
		boolean update=		ser.updateByIdDl(id);

		if(update==true) {
			model.addAttribute("updateMessage", "Updated successfully");
			return "dlprofile";
		}else {
			{
				model.addAttribute("updateMessage", "Not Updated");
				return "dlprofile";
			}
		}
		}
	
	@GetMapping("findByApplication")
	public String findByApplication(@RequestParam String applicationNumber,Model model) {
		DlDto dldto=ser.findByApplication(applicationNumber);
		model.addAttribute("app",dldto.getApplicationNumber() );
		model.addAttribute("dto", dldto);
		return "uploadfile";
	}
	
	@PostMapping("/upload")
	public String uploadFile(@RequestParam MultipartFile file,@RequestParam String applicationNumber, Model model) {
		System.out.println("Upload File Running ");
		DlDto dldto=ser.findByApplication(applicationNumber);
		System.err.println(applicationNumber);
		model.addAttribute("app",applicationNumber );
		System.err.println(applicationNumber);

		
		if (file.isEmpty()) {
			model.addAttribute("message", "Please select a file to upload");
			return "index";
		}
		try {

			String fileContentType = file.getContentType();
			dldto.setContentType(fileContentType);
			
			String filename = file.getOriginalFilename();
            dldto.setFile(filename); 
            
			System.out.println("File Name is   : " + filename + "   content type is    " + fileContentType);
			byte[] bytes = file.getBytes();
			Path path = Paths.get("D://filesave//" + file.getOriginalFilename());
			Files.write(path, bytes);
          ser.updateByDl(dldto);
            System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT"+dldto);
			model.addAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
            model.addAttribute("message", "You successfully uploaded");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "uploadfile";
	}

	@GetMapping("/download")
	public String downloadFile(HttpServletResponse response,String fileName, Model model) throws FileNotFoundException {
		// fetch data filename
		//Path path = Paths.get("D://filesave//E1t1 (2).png");
	//	path.toFile();
		response.setContentType("image/jpeg");
		File file = new File("D://filesave//" + fileName);

		try {
			InputStream buffer = new BufferedInputStream(new FileInputStream(file));
			ServletOutputStream out = response.getOutputStream();
			FileCopyUtils.copy(buffer, out);
			model.addAttribute("image", out);
			response.flushBuffer();
} catch (IOException e) {
			e.printStackTrace();
		}

		return "fileDownload.jsp";
	}

	@GetMapping("/display")
	public String dldisplay(@RequestParam String applicationNumber,HttpServletResponse response,Model model) {
		DlDto dlDto=ser.findByApplication(applicationNumber);
		model.addAttribute("UserImage", dlDto.getFile());
		model.addAttribute("dto", dlDto);
		return "dldisplay";
		
	}


}	
   

