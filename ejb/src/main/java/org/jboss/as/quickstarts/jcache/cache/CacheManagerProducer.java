package org.jboss.as.quickstarts.jcache.cache;

import org.infinispan.manager.EmbeddedCacheManager;

import javax.annotation.Resource;
import javax.enterprise.inject.Produces;

/**
 * Created by fsierra on 4/16/17.
 */
public class CacheManagerProducer {

    @Produces
    @Resource(lookup = "java:jboss/infinispan/container/app-cache-container")
    private EmbeddedCacheManager cacheManager;
}
