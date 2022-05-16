package com.lin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lin.dto.ActivityAddDto;
import com.lin.dto.ActivityDeleteDto;
import com.lin.dto.ActivityQueryDto;
import com.lin.dto.ActivityUpdateDto;
import com.lin.dto.ApiResult;
import com.lin.service.ActivityService;

@RestController
@RequestMapping(value = "/activity")
public class ActivityController {

	@Autowired
	private ActivityService activityService;

	@PostMapping
	public ApiResult addActivity(@RequestBody ActivityAddDto dto) {
		activityService.addActivity(dto);
		return ApiResult.ok();
	}

	@PutMapping
	public ApiResult updateActivity(@RequestBody ActivityUpdateDto dto) {
		activityService.updateActivity(dto);
		return ApiResult.ok();
	}

	@DeleteMapping
	public ApiResult deleteActivity(@RequestBody ActivityDeleteDto dto) {
		activityService.deleteActivity(dto);
		return ApiResult.ok();
	}

	@GetMapping
	public ApiResult queryActivity(ActivityQueryDto dto) {
		if (StringUtils.hasText(dto.getId())) {
			return ApiResult.ok(activityService.findActivity(dto));
		}
		return ApiResult.ok(activityService.findActivities(dto));
	}
}
