package test.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import test.entity.User;

/**
 * Created by wowa on 27.10.2018.
 */
public interface UserDao extends JpaRepository<User, Integer>{

}
