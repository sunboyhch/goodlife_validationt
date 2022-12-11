package com.goodlife.validationtest.controler;

import com.goodlife.validationtest.dataobject.User;
import com.goodlife.validationtest.param.ValidationRules;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试校验（这里不做实际的用户添加删除工作，只是测试validation校验）
 */
@RestController
@RequestMapping("/user")
public class UserAPI {

	/**
	 * 模拟添加用户，这里设置校验规则为ValidationRules.UserAdd
	 */
	@PostMapping("/add")
	public String add(@RequestBody @Validated(ValidationRules.UserAdd.class) User user, BindingResult errors) {
		if (errors.hasErrors()) {
			return errors.getFieldError().getDefaultMessage();
		}
		return "添加成功！";
	}

	/**
	 * 模拟修改用户，这里设置校验规则为ValidationRules.UserUpdate
	 */
	@PostMapping("/update")
	public String update(@RequestBody @Validated(ValidationRules.UserUpdate.class) User user, BindingResult errors) {
		if (errors.hasErrors()) {
			return errors.getFieldError().getDefaultMessage();
		}
		return "修改成功！";
	}

}