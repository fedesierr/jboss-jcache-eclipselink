/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.as.quickstarts.jcache.ejb;

import org.jboss.as.quickstarts.jcache.model.Text;

import javax.cache.annotation.CacheResult;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Stateless
@Named
public class TextEJB {

    @PersistenceContext(unitName="demo-pu")
    protected EntityManager em;

    @CacheResult(cacheName = "text-cache")
    public List<Text> getList(Integer langId) {
        Query query = em.createNamedQuery(Text.FIND_ALL_TEXT_BY_LANG);
        query.setParameter("langId", langId);

        return query.getResultList();
    }
}
