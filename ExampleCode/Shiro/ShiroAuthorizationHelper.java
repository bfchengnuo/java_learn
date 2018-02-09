import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShiroAuthorizationHelper {
@Autowired
    private EhCacheManager ehCacheManager;

    //private static Logger log = LoggerFactory.getLogger(ShiroAuthorizationHelper.class);

    /**
     * 清除用户的授权信息
     *
     * @param username
     */
    public void clearAuthorizationInfo(String username) {
        Cache<Object, Object> cache = ehCacheManager.getCache(ShiroDbRealm.class.getName() + ".authorizationCache");
        //cache.remove(username);
        Set<Object> keys = cache.keys();
        Iterator<Object> it = keys.iterator();
        System.out.println(keys);
        while (it.hasNext()) {
            Object key = it.next();
            System.out.println(key.getClass());
            if (username.equals(key.toString())) {
                cache.remove(key);
            }
        }
        //System.out.println(keys.contains(username));
        //System.out.println(ss);
    }

    /**
     * 清除当前用户的授权信息
     */
    public void clearAuthorizationInfo() {
        if (SecurityUtils.getSubject().isAuthenticated()) {
            clearAuthorizationInfo(((ShiroUser) SecurityUtils.getSubject().getPrincipal()).username);
        }
    }

    /**
     * 清除session(认证信息)
     *
     * @param JSESSIONID
     */
    public void clearAuthenticationInfo(Serializable JSESSIONID) {
        //shiro-activeSessionCache 为shiro自义cache名，该名在org.apache.shiro.session.mgt.eis.CachingSessionDAO抽象类中定义
        //如果要改变此名，可以将名称注入到sessionDao中，例如注入到CachingSessionDAO的子类EnterpriseCacheSessionDAO类中
        Cache<Object, Object> cache = ehCacheManager.getCache("shiro-activeSessionCache");
        cache.remove(JSESSIONID);
    }

    public EhCacheManager getEhCacheManager() {
        return ehCacheManager;
    }

    public void setEhCacheManager(EhCacheManager ehCacheManager) {
        this.ehCacheManager = ehCacheManager;
    }
}

/******************************** 分割线 ****************************************/

// 从缓存的管理器中去获取缓存，然后删除对应的用户名的缓存，这样就可以更新权限了 
Subject subject = SecurityUtils.getSubject(); 
String realmName = subject.getPrincipals().getRealmNames().iterator().next(); 

//第一个参数为用户名,第二个参数为realmName,test想要操作权限的用户 
// 第一个参数可以是集合，应该是存的用户授权信息，比如用户名；第二个参数是 realm 的名字，如果你自定义了多个 realm 的话就需要考虑下了
SimplePrincipalCollection principals = new SimplePrincipalCollection("test",realmName); 
subject.runAs(principals); 
userRealm.getAuthorizationCache().remove(subject.getPrincipals());
subject.releaseRunAs();