package org.jboss.as.quickstarts.jcache.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by fsierra on 4/15/17.
 */
@Entity
@Table(name = "LANGUAGES")
public class Language implements Serializable{

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="code")
    private String code;

    public Language() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Language)) return false;

        Language language = (Language) o;

        return id != null ? id.equals(language.id) : language.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
