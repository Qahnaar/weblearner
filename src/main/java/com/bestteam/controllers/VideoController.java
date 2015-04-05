package com.bestteam.controllers;

import java.io.File;
import java.io.FileInputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VideoController {

	@RequestMapping(value = "/loadVideoFile", method = RequestMethod.GET)
	@ResponseBody
	public void loadVideoFile(HttpServletResponse response) {
		try {
			String filePath = "D://video//mp4test.mp4";
			int fileSize = (int) new File(filePath).length();
			response.setContentLength(fileSize);
			response.setContentType("video/quicktime");
			FileInputStream inputStream = new FileInputStream(filePath);
			ServletOutputStream outputStream = response.getOutputStream();
			int value = IOUtils.copy(inputStream, outputStream);
			System.out.println("File Size :: " + fileSize);
			System.out.println("Copied Bytes :: " + value);
			IOUtils.closeQuietly(inputStream);
			IOUtils.closeQuietly(outputStream);
			response.setStatus(HttpServletResponse.SC_OK);
		} catch (java.io.FileNotFoundException e) {
			response.setStatus(HttpStatus.NOT_FOUND.value());
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}
}
