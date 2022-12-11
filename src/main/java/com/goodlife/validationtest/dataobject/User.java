package com.goodlife.validationtest.dataobject;

import com.goodlife.validationtest.param.ValidationRules;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * 用户类
 */
@Setter
@Getter
@NoArgsConstructor
public class User implements Serializable {

	/**
	 * 主键id，将其设定分组为ValidationRules.UserUpdate，表示用户信息修改时校验该规则
	 */
	@NotNull(groups = ValidationRules.UserUpdate.class, message = "用户id不能为空！")
	private Integer id;

	/**
	 * 用户名，将其设定分组为ValidationRules.UserAdd，表示添加用户时校验该规则
	 */
	@NotEmpty(groups = ValidationRules.UserAdd.class, message = "用户名不能为空！")
	private String username;

	/**
	 * 密码，将长度校验规则同时加入到ValidationRules.UserAdd和ValidationRules.UserUpdate组，表示添加用户和用户信息修改时都要校验这个规则，空值校验只有添加时校验
	 */
	@Size(groups = {ValidationRules.UserAdd.class, ValidationRules.UserUpdate.class}, min = 8, message = "密码长度不能小于8！")
	@NotEmpty(groups = ValidationRules.UserAdd.class, message = "密码不能为空！")
	private String password;

	// 下面都是一回事

	/**
	 * 邮箱
	 */
	@Email(groups = {ValidationRules.UserAdd.class, ValidationRules.UserUpdate.class}, message = "邮箱格式错误！")
	private String email;

	/**
	 * 年龄
	 */
	@Min(groups = {ValidationRules.UserAdd.class, ValidationRules.UserUpdate.class}, value = 18, message = "年龄不能小于18！")
	@Max(groups = {ValidationRules.UserAdd.class, ValidationRules.UserUpdate.class}, value = 150, message = "年龄不能小于150！")
	private int age;

}