package com.example.coupling.loose;

public class WebServiceDataProvider implements IUserDataProvider
{

    @Override
    public String getUserDetails()
    {
        return "User details fetched from \"Web Service\"";
    }
}
