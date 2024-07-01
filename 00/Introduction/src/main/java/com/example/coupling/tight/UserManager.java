package com.example.coupling.tight;

public class UserManager
{
    private DatabaseUser databaseUser = new DatabaseUser();

    public String getUserInfo()
    {
        return databaseUser.getUserDetails();
    }
}
