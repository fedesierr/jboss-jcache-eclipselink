package org.jboss.as.quickstarts.jcache.model;

import org.eclipse.persistence.config.QueryHints;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by fsierra on 4/15/17.
 */
@Entity
@Table(name="TEXTS")
@NamedQuery(name = Text.FIND_ALL_TEXT_BY_LANG,
    query = "SELECT t FROM Text t WHERE t.language.id = :langId",
    hints = {
            @QueryHint(
                    name=QueryHints.FETCH,
                    value="t.language"
            )
    })
public class Text implements Serializable{

    public static final String FIND_ALL_TEXT_BY_LANG = "findAllTextByLanguage";

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="value")
    private String value;

    @ManyToOne
    @JoinColumn(name="lang_id")
    private Language language;

    public Text() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Text)) return false;

        Text text = (Text) o;

        return id != null ? id.equals(text.id) : text.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
