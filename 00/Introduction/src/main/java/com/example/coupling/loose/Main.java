package com.example.coupling.loose;

public class Main
{
    public static void main(String[] args)
    {
        IUserDataProvider databaseProvider = new DatabaseUserProvider();
        UserManager userManagerWithDb = new UserManager(databaseProvider);
        System.out.println(userManagerWithDb.getUserInfo());

        IUserDataProvider webServiceProvider = new WebServiceDataProvider();
        UserManager userManagerWithWebService = new UserManager(webServiceProvider);
        System.out.println(userManagerWithWebService.getUserInfo());

        IUserDataProvider noSqlDbProvider = new NoSqlDbUserProvider();
        UserManager userManagerWithNoSqlDb = new UserManager(noSqlDbProvider);
        System.out.println(userManagerWithNoSqlDb.getUserInfo());
    }
}
