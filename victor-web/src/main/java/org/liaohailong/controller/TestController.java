package org.liaohailong.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.liaohailong.dao.VideoTypeMapper;
import org.liaohailong.entity.VideoType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	private static final Logger logger = Logger.getLogger(TestController.class);

	/**
	 * 跳转到测试页面 text.jsp
	 */
	private static final String TEST = "test";

	@Autowired
	private VideoTypeMapper VideoTypeMapper;

	@RequestMapping("/hello")
	public String hello() {
		System.out.println("hello() - > hello");
		return TEST;
	}

	@ResponseBody
	@RequestMapping("/getVideoType")
	public List<VideoType> getVideoType() {
		List<VideoType> selectAll = VideoTypeMapper.selectAll();
		System.out.println("getVideoType() - > getVideoType");
		for (VideoType videoType : selectAll) {
			logger.info(videoType.toString());
		}
		return selectAll;
	}
}
