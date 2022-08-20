package ir.maktab74.repository;

import ir.maktab74.base.repository.BaseRepository;
import ir.maktab74.model.User;

public interface UserRepository extends BaseRepository<User,Long> {

    User findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);
}
