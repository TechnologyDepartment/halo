package org.xujin.halo.validator;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;

/**
 * 使用组合模式，允许一个Validator可以组合多个其它的Validator完成validation的任务
 * 
 * @author xujin 2017-11-04
 */

public abstract class ValidatorCompoiste implements ValidatorI, InitializingBean {

    private List<ValidatorI> validators;
    
    /**
     * Composite other validators if necessary
     */
    abstract protected void addOtherValidators();
    
    /**
     * Aside from composited validators, do its own validation here
     * @param candidate candidate
     */
    abstract protected void doValidate(Object candidate);

    protected void add(ValidatorI validator) {
        if (validators == null) {
            validators = Lists.newArrayList();
        }
        validators.add(validator);
    }

    @Override
    public void validate(Object candidate) {
        if (validators != null) {
            for (ValidatorI validator : validators) {
                validator.validate(candidate);
            }
        }
        doValidate(candidate);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        addOtherValidators();
    }
}
