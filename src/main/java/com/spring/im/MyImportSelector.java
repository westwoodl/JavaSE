package com.spring.im;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author xu rongchao
 * @date 2020/12/14 23:22
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        return new String[]{"SysoutBeanPostProcessor"};
    }
}
