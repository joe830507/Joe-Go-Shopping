package com.lin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.lin.controller.ActivityController;
import com.lin.dto.ActivityAddDto;
import com.lin.dto.ActivityDeleteDto;
import com.lin.dto.ActivityQueryDto;
import com.lin.dto.ActivityUpdateDto;
import com.lin.dto.ApiResult;
import com.lin.entity.Activity;
import com.lin.mongo.repository.ActivityMongoRepository;

@SpringBootTest
public class ActivityTests {

	@Autowired
	ActivityController activityController;

	@Autowired
	ActivityMongoRepository activityRepository;

	@Autowired
	ModelMapper modelMapper;

	@Test
	void addActivity() {
		ActivityAddDto addDto = new ActivityAddDto();
		addDto.setTitle("Christmas");
		addDto.setContent("Happy Christmas!!! Everything is 30% off. Buy now!!");
		addDto.setDiscountType(1);
		addDto.setPercentOff(30f);
		activityController.addActivity(addDto);
		Activity activity = activityRepository.findAll().get(0);
		assertNotNull(activity);
		assertEquals("Christmas", activity.getTitle());
		assertEquals("Happy Christmas!!! Everything is 30% off. Buy now!!", addDto.getContent());
		assertEquals(30f, addDto.getPercentOff());
		activityRepository.deleteAll();
	}

	void addSingleActivity() {
		ActivityAddDto addDto = new ActivityAddDto();
		addDto.setTitle("Christmas");
		addDto.setContent("Happy Christmas!!! Everything is 30% off. Buy now!!");
		addDto.setDiscountType(1);
		addDto.setPercentOff(30f);
		activityController.addActivity(addDto);
	}

	@Test
	void updateActivity() {
		addSingleActivity();
		Activity activity = activityRepository.findAll().get(0);
		ActivityUpdateDto updateDto = modelMapper.map(activity, ActivityUpdateDto.class);
		updateDto.setContent("Happy Christmas!!! Everything is 40% off. Buy now!!");
		updateDto.setPercentOff(40f);
		activityController.updateActivity(updateDto);
		activity = activityRepository.findById(activity.getId()).get();
		assertEquals(40f, activity.getPercentOff());
		activityRepository.deleteAll();
	}

	@Test
	void deleteActivity() {
		addSingleActivity();
		Activity activity = activityRepository.findAll().get(0);
		ActivityDeleteDto deleteDto = new ActivityDeleteDto();
		deleteDto.setId(activity.getId());
		activityController.deleteActivity(deleteDto);
		Boolean isPresent = activityRepository.findById(activity.getId()).isPresent();
		assertFalse(isPresent);
	}

	@Test
	void queryActivities() {
		addSingleActivity();
		ActivityAddDto addDto = new ActivityAddDto();
		addDto.setTitle("Happy New Year");
		addDto.setContent("Get a coupon right now! We wish you have a happy year!");
		addDto.setDiscountType(2);
		addDto.setCashOff(10f);
		activityController.addActivity(addDto);
		ActivityQueryDto queryDto = new ActivityQueryDto();
		ApiResult result = activityController.queryActivity(queryDto);
		@SuppressWarnings("unchecked")
		Page<Activity> activityPage = (Page<Activity>) result.getResponseBody();
		List<Activity> activities = activityPage.getContent();
		assertEquals(2, activities.size());
		queryDto.setId(activities.get(0).getId());
		Activity activity = (Activity) activityController.queryActivity(queryDto).getResponseBody();
		assertNotNull(activity);
	}
}
