package com.example.exercise.repository.impl;

import com.example.exercise.domain.User;
import com.example.exercise.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    //计数  每次增加一个用户，计数器增加1
    private static AtomicLong counter = new AtomicLong();
    //使用内存存储  模拟存储库
    private final ConcurrentHashMap<Long, User> userMap = new ConcurrentHashMap<>();


    @Override
    public User saveOrUpdateUser(User user) {
        Long id = user.getId();
        if(id == null){
            id = counter.incrementAndGet();
            user.setId(id);
        }
        this.userMap.put(id, user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        this.userMap.remove(id);
    }

    @Override
    public User getUserById(Long id) {
        return this.userMap.get(id);
    }

    @Override
    public List<User> listUser() {
        return new ArrayList<User>(this.userMap.values());
    }
}
