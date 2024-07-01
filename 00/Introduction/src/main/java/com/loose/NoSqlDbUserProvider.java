package com.loose;

public class NoSqlDbUserProvider implements IUserDataProvider
{

    @Override
    public String getUserDetails()
    {
        return "User details fetched from \"No SQL Database\"";
    }
}
