package com.example.coupling.loose;

public class DatabaseUserProvider implements IUserDataProvider
{
    @Override
    public String getUserDetails()
    {
        return "User details fetched from \"Database\"";
    }
}
