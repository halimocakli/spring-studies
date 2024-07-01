package org.ioc.loose;

public class NoSqlDbUserProvider implements IUserDataProvider
{
    private String id;
    private String name;
    private String surname;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    @Override
    public String getUserDetails()
    {
        return "NoSqlDbUserProvider{" +
                "Id='" + id + '\'' + ", " +
                "Name='" + name + '\'' + ", " +
                "Surname='" + surname + '\'' + ", " +
                '}';
    }
}
