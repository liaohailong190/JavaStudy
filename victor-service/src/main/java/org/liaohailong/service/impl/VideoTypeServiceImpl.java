package org.liaohailong.service.impl;

import org.liaohailong.dao.VideoInfoMapper;
import org.liaohailong.service.VideoTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoTypeServiceImpl implements VideoTypeService {
	@Autowired
	private VideoInfoMapper videoInfoMapper;
	
}
