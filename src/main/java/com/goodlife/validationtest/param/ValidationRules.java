package com.goodlife.validationtest.param;

import javax.validation.GroupSequence;

/**
 * 校验规则类
 */
public class ValidationRules {

	/**
	 * 注册（添加）用户规则
	 */
	public interface UserAdd {

	}

	/**
	 * 更新（修改）用户规则
	 */
	public interface UserUpdate {

	}

	@GroupSequence({UserAdd.class, UserUpdate.class})
	public interface all{

	};
}