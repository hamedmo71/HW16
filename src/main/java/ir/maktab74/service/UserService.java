package ir.maktab74.service;

import ir.maktab74.base.service.BaseService;
import ir.maktab74.model.User;

public interface UserService extends BaseService<User,Long> {

    User loginWithUsernameAndPassword(String username, String password);

    User findUserWithUsername(String username);
}
