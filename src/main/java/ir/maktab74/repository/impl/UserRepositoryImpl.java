package ir.maktab74.repository.impl;


import ir.maktab74.base.repository.impl.BaseRepositoryImpl;
import ir.maktab74.model.User;
import ir.maktab74.repository.UserRepository;

import javax.persistence.EntityManager;


public class UserRepositoryImpl extends BaseRepositoryImpl<User, Long> implements UserRepository {
    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }


    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = entityManager.createQuery
                        ("select u from User u where username=:username and password=:password", getEntityClass())
                .setParameter("username", username).setParameter("password",password).getSingleResult();
        return user;
    }

    @Override
    public User findByUsername(String username) {
        User user = entityManager.createQuery("select u from User u where username=:username", getEntityClass())
                .setParameter("username", username).getSingleResult();
        return user;
    }

}
