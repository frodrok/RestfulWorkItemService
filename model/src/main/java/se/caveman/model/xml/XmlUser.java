package se.caveman.model.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class XmlUser {

    @XmlElement
    private Long id;
    @XmlElement
    private String username;
    @XmlElement
    private String password;

    protected XmlUser() {}

    public XmlUser(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
