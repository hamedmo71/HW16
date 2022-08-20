package ir.maktab74.service.impl;


import ir.maktab74.base.service.impl.BaseServiceImpl;
import ir.maktab74.model.User;
import ir.maktab74.repository.UserRepository;
import ir.maktab74.service.UserService;

public class UserServiceImpl extends BaseServiceImpl<User, Long, UserRepository>
        implements UserService {
    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public User loginWithUsernameAndPassword(String username, String password) {

        User user = null;
        try {
            user = repository.findByUsernameAndPassword(username, password);
        } catch (Exception ex) {
            System.out.println("This username does not exist.");
        }
        return user;
    }

    @Override
    public User findUserWithUsername(String username) {
        User user = null;
        try {
            user = repository.findByUsername(username);
        } catch (Exception ex) {

        }
        return user;
    }
}
