package io.playdata.springboot03.service;

import io.playdata.springboot03.model.User;
import io.playdata.springboot03.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Spring에 Service 등록, Repository에서 바로 Controller로 가지 않고 Service로 한번 거른다.
public class UserService {

    @Autowired // 서비스에 레포지토리 자동 연결
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User update(Long userId, User user) {  // 복잡한 로직이기 때문에 Controller 노출시키지 않음
        // optional -> null이 될수도 있다.
        Optional<User> optioanlUser = userRepository.findById(userId); // 이미 저장되었던 유저가 있는지 확인, findById
        if(!optioanlUser.isPresent()) {
            return null;
        }

        user.setId(userId);
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id); // deleteById
    }
}
