package com.lin.serviceImpl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.lin.dto.ActivityAddDto;
import com.lin.dto.ActivityDeleteDto;
import com.lin.dto.ActivityQueryDto;
import com.lin.dto.ActivityUpdateDto;
import com.lin.entity.Activity;
import com.lin.repository.ActivityRepository;
import com.lin.service.ActivityService;
import com.lin.util.BeanUtil;
import com.lin.util.UUIDUtil;

@Service
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private ActivityRepository activityRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public void addActivity(ActivityAddDto dto) {
		Activity activity = modelMapper.map(dto, Activity.class);
		activity.setCreateTime(new Date());
		activity.setId(UUIDUtil.getIdWithoutDashes());
		activityRepository.insert(activity);
	}

	@Override
	public void updateActivity(ActivityUpdateDto dto) {
		Activity origin = activityRepository.findById(dto.getId()).get();
		origin.setUpdateTime(new Date());
		Activity updateOne = modelMapper.map(dto, Activity.class);
		BeanUtil.copyPropertiesWithoutNull(updateOne, origin);
		activityRepository.save(origin);
	}

	@Override
	public void deleteActivity(ActivityDeleteDto dto) {
		activityRepository.deleteById(dto.getId());
	}

	@Override
	public Activity findActivity(ActivityQueryDto dto) {
		return activityRepository.findById(dto.getId()).get();
	}

	@Override
	public Page<Activity> findActivities(ActivityQueryDto dto) {
		PageRequest request = PageRequest.of(dto.getPageNumber(), dto.getPageSize());
		return activityRepository.findAll(request);
	}

}
