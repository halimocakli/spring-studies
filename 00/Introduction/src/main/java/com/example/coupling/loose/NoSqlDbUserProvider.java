package com.example.coupling.loose;

public class NoSqlDbUserProvider implements IUserDataProvider
{

    @Override
    public String getUserDetails()
    {
        return "User details fetched from \"No SQL Database\"";
    }
}
