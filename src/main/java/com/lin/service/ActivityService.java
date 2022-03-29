package com.lin.service;

import org.springframework.data.domain.Page;

import com.lin.dto.ActivityAddDto;
import com.lin.dto.ActivityDeleteDto;
import com.lin.dto.ActivityQueryDto;
import com.lin.dto.ActivityUpdateDto;
import com.lin.entity.Activity;

public interface ActivityService {
	void addActivity(ActivityAddDto dto);

	void updateActivity(ActivityUpdateDto dto);

	void deleteActivity(ActivityDeleteDto dto);

	Activity findActivity(ActivityQueryDto dto);

	Page<Activity> findActivities(ActivityQueryDto dto);
}
