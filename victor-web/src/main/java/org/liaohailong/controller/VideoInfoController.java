package org.liaohailong.controller;

import javax.servlet.http.HttpServletRequest;

import org.liaohailong.service.VideoInfoSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VideoInfoController {
	private static final String INDEX_VIDEO = "indexVideo";

	@Autowired
	private VideoInfoSerivice videoInfoSerivice;

	@RequestMapping("/indexVideo")
	public String getIndexVideo(HttpServletRequest request) {
		request.setAttribute("videoList", videoInfoSerivice.getVideoInfo());
		return INDEX_VIDEO;
	}
}
