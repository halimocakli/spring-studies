package com.loose;

public class UserManager
{
    private IUserDataProvider userDataProvider;

    public UserManager(IUserDataProvider userDataProvider)
    {
        this.userDataProvider = userDataProvider;
    }

    public String getUserInfo()
    {
        return userDataProvider.getUserDetails();
    }
}
