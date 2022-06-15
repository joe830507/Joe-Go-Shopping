package com.lin.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EmployeeQueryDto extends DtoBase {

	private String id;
}
