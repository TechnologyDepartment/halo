package org.xujin.halo.rule;

/**
 * 业务规则接口，适合领域层的业务规则检查
 * @author xueliang.sxl
 *
 */
public interface RuleI {

	// 默认的规则检查接口，子接口可自定义
	default boolean check(Object roleContext){
		return true;
	}


	// This is specific for Validation cases where no Return is needed
	default void validate(Object... candidate){}
}
