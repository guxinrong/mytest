package dao;

import entity.User;

public interface UserDao
{
    public void insert(User user);

    public User selectByUsername(String username);
}
