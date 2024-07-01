package org.ioc.loose;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{
    public static void main(String[] args)
    {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationIoCLooseCoupling.xml");

        UserManager userManagerWithDbUserProvider = (UserManager) context.getBean("userManagerWithDbUserProvider");
        UserManager userManagerWithNoSqlDbUserProvider = (UserManager) context.getBean("userManagerWithNoSqlDbUserProvider");
        UserManager userManagerWithWebServiceDataProvider = (UserManager) context.getBean("userManagerWithWebServiceDataProvider");

        System.out.println(userManagerWithDbUserProvider.getUserInfo());
        System.out.println(userManagerWithNoSqlDbUserProvider.getUserInfo());
        System.out.println(userManagerWithWebServiceDataProvider.getUserInfo());
    }
}
