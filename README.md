JBoss JCache: Deployment of an EAR Containing a JSF WAR and EJB JAR and JCache with eclipselink
====================================================================

Example using the CacheResult annotation from JCache bound to the implementation from Infinispan and configure it.

Configure Cache
-------------

```
/subsystem=infinispan/cache-container=app-cache-container/:add(start=EAGER)
/subsystem=infinispan/cache-container=app-cache-container:write-attribute(name=statistics-enabled,value=true)
/subsystem=infinispan/cache-container=app-cache-container/local-cache=text-cache:add
/subsystem=infinispan/cache-container=app-cache-container/local-cache=text-cache/eviction=EVICTION:add(strategy=LRU,max-entries=10000)
/subsystem=infinispan/cache-container=app-cache-container/local-cache=text-cache/transaction=TRANSACTION:add(mode=NONE)

:reload
```

xml:

```
<cache-container name="app-cache-container" start="EAGER" statistics-enabled="true">
    <local-cache name="text-cache">
        <transaction mode="NONE"/>
        <eviction strategy="LRU" max-entries="10000"/>
    </local-cache>
</cache-container>
```

Configure Maven 
-------------

If you have not yet done so, you must [Configure Maven](https://github.com/jboss-developer/jboss-developer-shared-resources/blob/master/guides/CONFIGURE_MAVEN.md#configure-maven-to-build-and-deploy-the-quickstarts) before testing the quickstarts.



Start the JBoss EAP Server
-------------------------

1. Open a command prompt and navigate to the root of the JBoss EAP directory.
2. The following shows the command line to start the server:

        For Linux:   EAP_HOME/bin/standalone.sh
        For Windows: EAP_HOME\bin\standalone.bat

Access the application 
---------------------

The application will be running at the following URL <http://localhost:8080/jboss-jcache>.


