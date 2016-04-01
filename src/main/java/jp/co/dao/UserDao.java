package jp.co.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import jp.co.entity.User;

/**
 */
@ConfigAutowireable
@Dao
public interface UserDao {

    /**
     * @param id
     * @return the User entity
     */
    @Select
    User selectById(Integer id);

    /**
     * @return the User entity
     */
    @Select
    List<User> selectAll();

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(User entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(User entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(User entity);
}