package com.lin.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PermissionQueryDto extends DtoBase {

	private String id;
}
