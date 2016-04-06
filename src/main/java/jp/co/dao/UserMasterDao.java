package jp.co.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.transaction.annotation.Transactional;

import jp.co.entity.UserMaster;

/**
 */
@ConfigAutowireable
@Dao
public interface UserMasterDao {

	/**
	 * @param id
	 * @return the UserMaster entity
	 */
	@Select
	UserMaster selectById(Integer id);

	/**
	 * @return the UserMaster entity
	 */
	@Select
	List<UserMaster> selectAll();

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Insert
	@Transactional
	int insert(UserMaster entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Update
	int update(UserMaster entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Delete
	int delete(UserMaster entity);
}