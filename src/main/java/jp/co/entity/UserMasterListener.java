package jp.co.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 *
 */
public class UserMasterListener implements EntityListener<UserMaster> {

	@Override
	public void preInsert(UserMaster entity, PreInsertContext<UserMaster> context) {
	}

	@Override
	public void preUpdate(UserMaster entity, PreUpdateContext<UserMaster> context) {
	}

	@Override
	public void preDelete(UserMaster entity, PreDeleteContext<UserMaster> context) {
	}

	@Override
	public void postInsert(UserMaster entity, PostInsertContext<UserMaster> context) {
	}

	@Override
	public void postUpdate(UserMaster entity, PostUpdateContext<UserMaster> context) {
	}

	@Override
	public void postDelete(UserMaster entity, PostDeleteContext<UserMaster> context) {
	}
}