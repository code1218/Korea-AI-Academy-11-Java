package com.korai.study.ch10.TODO;

import com.korai.study.ch10.TODO.repository.UserRepository;
import com.korai.study.ch10.TODO.service.UserService;
import com.korai.study.ch10.TODO.view.LoginView;

public class TodoApplication {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);
        LoginView loginView = new LoginView(userService);

        while(true) {
            loginView.show();
        }
    }
}
