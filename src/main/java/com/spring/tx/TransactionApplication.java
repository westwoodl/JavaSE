package com.spring.tx;

import org.springframework.aop.framework.autoproxy.InfrastructureAdvisorAutoProxyCreator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AutoProxyRegistrar;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration;
import org.springframework.transaction.annotation.TransactionManagementConfigurationSelector;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xu rongchao
 * @date 2020/10/2 21:14
 */
@ComponentScan("com.bf.spring.tx")
@EnableTransactionManagement
public class TransactionApplication {

    @Transactional
    public void oneDataOpMethodWithTran() {
        // insert
        // throw
        // un commit (roll back)
    }

    /**
     * EnableTransactionManagement:
     * import {@link TransactionManagementConfigurationSelector}
     * 1. import {@link AutoProxyRegistrar}
     *     registerAutoProxyCreatorIfNecessary {@link InfrastructureAdvisorAutoProxyCreator}
     * 2. import {@link ProxyTransactionManagementConfiguration}
     *
     *
     *
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TransactionApplication.class);
    }
}
