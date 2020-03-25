package co.chatsdk.core.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import co.chatsdk.core.dao.MessageMetaValue;
import co.chatsdk.core.dao.Message;
import co.chatsdk.core.dao.UserMetaValue;
import co.chatsdk.core.dao.ThreadMetaValue;
import co.chatsdk.core.dao.Thread;
import co.chatsdk.core.dao.ReadReceiptUserLink;
import co.chatsdk.core.dao.FollowerLink;
import co.chatsdk.core.dao.LinkedAccount;
import co.chatsdk.core.dao.UserThreadLink;
import co.chatsdk.core.dao.User;
import co.chatsdk.core.dao.ContactLink;

import co.chatsdk.core.dao.MessageMetaValueDao;
import co.chatsdk.core.dao.MessageDao;
import co.chatsdk.core.dao.UserMetaValueDao;
import co.chatsdk.core.dao.ThreadMetaValueDao;
import co.chatsdk.core.dao.ThreadDao;
import co.chatsdk.core.dao.ReadReceiptUserLinkDao;
import co.chatsdk.core.dao.FollowerLinkDao;
import co.chatsdk.core.dao.LinkedAccountDao;
import co.chatsdk.core.dao.UserThreadLinkDao;
import co.chatsdk.core.dao.UserDao;
import co.chatsdk.core.dao.ContactLinkDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig messageMetaValueDaoConfig;
    private final DaoConfig messageDaoConfig;
    private final DaoConfig userMetaValueDaoConfig;
    private final DaoConfig threadMetaValueDaoConfig;
    private final DaoConfig threadDaoConfig;
    private final DaoConfig readReceiptUserLinkDaoConfig;
    private final DaoConfig followerLinkDaoConfig;
    private final DaoConfig linkedAccountDaoConfig;
    private final DaoConfig userThreadLinkDaoConfig;
    private final DaoConfig userDaoConfig;
    private final DaoConfig contactLinkDaoConfig;

    private final MessageMetaValueDao messageMetaValueDao;
    private final MessageDao messageDao;
    private final UserMetaValueDao userMetaValueDao;
    private final ThreadMetaValueDao threadMetaValueDao;
    private final ThreadDao threadDao;
    private final ReadReceiptUserLinkDao readReceiptUserLinkDao;
    private final FollowerLinkDao followerLinkDao;
    private final LinkedAccountDao linkedAccountDao;
    private final UserThreadLinkDao userThreadLinkDao;
    private final UserDao userDao;
    private final ContactLinkDao contactLinkDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        messageMetaValueDaoConfig = daoConfigMap.get(MessageMetaValueDao.class).clone();
        messageMetaValueDaoConfig.initIdentityScope(type);

        messageDaoConfig = daoConfigMap.get(MessageDao.class).clone();
        messageDaoConfig.initIdentityScope(type);

        userMetaValueDaoConfig = daoConfigMap.get(UserMetaValueDao.class).clone();
        userMetaValueDaoConfig.initIdentityScope(type);

        threadMetaValueDaoConfig = daoConfigMap.get(ThreadMetaValueDao.class).clone();
        threadMetaValueDaoConfig.initIdentityScope(type);

        threadDaoConfig = daoConfigMap.get(ThreadDao.class).clone();
        threadDaoConfig.initIdentityScope(type);

        readReceiptUserLinkDaoConfig = daoConfigMap.get(ReadReceiptUserLinkDao.class).clone();
        readReceiptUserLinkDaoConfig.initIdentityScope(type);

        followerLinkDaoConfig = daoConfigMap.get(FollowerLinkDao.class).clone();
        followerLinkDaoConfig.initIdentityScope(type);

        linkedAccountDaoConfig = daoConfigMap.get(LinkedAccountDao.class).clone();
        linkedAccountDaoConfig.initIdentityScope(type);

        userThreadLinkDaoConfig = daoConfigMap.get(UserThreadLinkDao.class).clone();
        userThreadLinkDaoConfig.initIdentityScope(type);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        contactLinkDaoConfig = daoConfigMap.get(ContactLinkDao.class).clone();
        contactLinkDaoConfig.initIdentityScope(type);

        messageMetaValueDao = new MessageMetaValueDao(messageMetaValueDaoConfig, this);
        messageDao = new MessageDao(messageDaoConfig, this);
        userMetaValueDao = new UserMetaValueDao(userMetaValueDaoConfig, this);
        threadMetaValueDao = new ThreadMetaValueDao(threadMetaValueDaoConfig, this);
        threadDao = new ThreadDao(threadDaoConfig, this);
        readReceiptUserLinkDao = new ReadReceiptUserLinkDao(readReceiptUserLinkDaoConfig, this);
        followerLinkDao = new FollowerLinkDao(followerLinkDaoConfig, this);
        linkedAccountDao = new LinkedAccountDao(linkedAccountDaoConfig, this);
        userThreadLinkDao = new UserThreadLinkDao(userThreadLinkDaoConfig, this);
        userDao = new UserDao(userDaoConfig, this);
        contactLinkDao = new ContactLinkDao(contactLinkDaoConfig, this);

        registerDao(MessageMetaValue.class, messageMetaValueDao);
        registerDao(Message.class, messageDao);
        registerDao(UserMetaValue.class, userMetaValueDao);
        registerDao(ThreadMetaValue.class, threadMetaValueDao);
        registerDao(Thread.class, threadDao);
        registerDao(ReadReceiptUserLink.class, readReceiptUserLinkDao);
        registerDao(FollowerLink.class, followerLinkDao);
        registerDao(LinkedAccount.class, linkedAccountDao);
        registerDao(UserThreadLink.class, userThreadLinkDao);
        registerDao(User.class, userDao);
        registerDao(ContactLink.class, contactLinkDao);
    }
    
    public void clear() {
        messageMetaValueDaoConfig.clearIdentityScope();
        messageDaoConfig.clearIdentityScope();
        userMetaValueDaoConfig.clearIdentityScope();
        threadMetaValueDaoConfig.clearIdentityScope();
        threadDaoConfig.clearIdentityScope();
        readReceiptUserLinkDaoConfig.clearIdentityScope();
        followerLinkDaoConfig.clearIdentityScope();
        linkedAccountDaoConfig.clearIdentityScope();
        userThreadLinkDaoConfig.clearIdentityScope();
        userDaoConfig.clearIdentityScope();
        contactLinkDaoConfig.clearIdentityScope();
    }

    public MessageMetaValueDao getMessageMetaValueDao() {
        return messageMetaValueDao;
    }

    public MessageDao getMessageDao() {
        return messageDao;
    }

    public UserMetaValueDao getUserMetaValueDao() {
        return userMetaValueDao;
    }

    public ThreadMetaValueDao getThreadMetaValueDao() {
        return threadMetaValueDao;
    }

    public ThreadDao getThreadDao() {
        return threadDao;
    }

    public ReadReceiptUserLinkDao getReadReceiptUserLinkDao() {
        return readReceiptUserLinkDao;
    }

    public FollowerLinkDao getFollowerLinkDao() {
        return followerLinkDao;
    }

    public LinkedAccountDao getLinkedAccountDao() {
        return linkedAccountDao;
    }

    public UserThreadLinkDao getUserThreadLinkDao() {
        return userThreadLinkDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public ContactLinkDao getContactLinkDao() {
        return contactLinkDao;
    }

}