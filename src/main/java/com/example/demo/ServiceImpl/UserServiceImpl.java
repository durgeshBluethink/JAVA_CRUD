package com.example.demo.ServiceImpl;

import com.example.demo.Repo.UserRepository;
import com.example.demo.Service.UserService;
import com.example.demo.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private  UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity Post(UserEntity params) {
        userRepository.save(params);
        return params;
    }

    @Override
    public List<UserEntity> Get() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity Get(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public UserEntity Update(UserEntity params, int id) {

        UserEntity user =  userRepository.findById(id).get();
        user.setName(params.getName());
        user.setEmail(params.getEmail());

        return userRepository.save(user);

    }

    @Override
    public String Delete(int id) {
        userRepository.deleteById(id);
        return "User(" + id + ")" + " has been deleted!";
    }
}
