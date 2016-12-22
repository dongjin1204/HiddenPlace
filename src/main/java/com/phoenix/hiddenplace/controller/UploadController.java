package com.phoenix.hiddenplace.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.phoenix.hiddenplace.util.MediaUtils;
import com.phoenix.hiddenplace.util.UploadFileUtils;

@Controller
public class UploadController {

	@Resource(name = "uploadPath")
	private String uploadPath; //= "C:\\imageUpload\\upload";

	@RequestMapping(value = "/uploadForm", method = RequestMethod.GET)
	public void uploadForm() {
	}

	@RequestMapping(value = "/uploadForm", method = RequestMethod.POST)
	public String uploadForm(MultipartFile file, Model model) throws Exception {

		String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());
		model.addAttribute("savedName", savedName);
		return "uploadResult";
	}

	@RequestMapping(value = "/uploadAjax", method = RequestMethod.GET)
	public void uploadAjax() {
	}

	@ResponseBody
	@RequestMapping(value ="/uploadAjax", method=RequestMethod.POST, 
	produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file)throws Exception{

		return new ResponseEntity<>(UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()), HttpStatus.CREATED);
	}

	private String uploadFile(String originalName, byte[] fileData) throws Exception {

		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() + "_" + originalName;
		File target = new File(uploadPath, savedName);
		FileCopyUtils.copy(fileData, target);

		return savedName;
	}

	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName)throws Exception{

		InputStream in = null; 
		ResponseEntity<byte[]> entity = null;

		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
			MediaType mType = MediaUtils.getMediaType(formatName);
			HttpHeaders headers = new HttpHeaders();

			in = new FileInputStream(uploadPath + fileName);

			if(mType != null){
				headers.setContentType(mType);
			} else {
				fileName = fileName.substring(fileName.indexOf("_") + 1);       
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition", "attachment; filename=\"" + 
				new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
			}

			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
			
		} catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			if(in != null) {
				in.close();
			}
		}

		return entity;    
	}

	@ResponseBody
	@RequestMapping(value="/deleteFile", method=RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String fileName){

		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
		MediaType mType = MediaUtils.getMediaType(formatName);

		if(mType != null) {  //이미지 파일이라면.. 원본 이미지 파일 삭제
			String front = fileName.substring(0,12); // /2016/11/28/
			String end = fileName.substring(14); //uid_원본파일이름.확장자
			new File(uploadPath + (front + end).replace('/', File.separatorChar)).delete();
		}

		//이미지 파일(썸네일 이미지), 일반파일 삭제 
		new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();

		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value="/deleteAllFiles", method=RequestMethod.POST)
	public ResponseEntity<String> deleteFile(@RequestParam("files[]") String[] files){

		if(files == null || files.length == 0) {
			return new ResponseEntity<String>("deleted", HttpStatus.OK);
		}

		for (String fileName : files) {
			String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
			MediaType mType = MediaUtils.getMediaType(formatName);
			
			if(mType != null){      
				String front = fileName.substring(0,12);
				String end = fileName.substring(14);
				new File(uploadPath + (front+end).replace('/', File.separatorChar)).delete();
			}

			new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();
		}

		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}

}