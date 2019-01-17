package org.liaohailong.service.impl;

import java.util.List;

import org.liaohailong.dao.VideoInfoMapper;
import org.liaohailong.dao.VideoTypeMapper;
import org.liaohailong.entity.VideoInfo;
import org.liaohailong.entity.VideoType;
import org.liaohailong.service.VideoInfoSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoInfoServiceImpl implements VideoInfoSerivice {
	@Autowired
	private VideoInfoMapper videoInfoMapper;
	@Autowired
	private VideoTypeMapper videoTypeMapper;

	@Override
	public List<VideoInfo> getVideoInfo() {
		List<VideoInfo> selectAll = videoInfoMapper.selectAll();
		for (VideoInfo videoInfo : selectAll) {
			VideoType videoType = videoTypeMapper.select(videoInfo.getType_id());
			String name = videoType.getName();
			videoInfo.setTypeName(name);
		}
		return selectAll;
	}
}
