package com.jiankong.mapper;


import com.jiankong.model.User;

import java.util.List;

public interface IUserMapper {

    int insert(User user);
    List<User> queryAll();
}
