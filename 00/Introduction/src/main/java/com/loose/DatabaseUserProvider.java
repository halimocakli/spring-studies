package com.loose;

public class DatabaseUserProvider implements IUserDataProvider
{
    @Override
    public String getUserDetails()
    {
        return "User details fetched from \"Database\"";
    }
}
