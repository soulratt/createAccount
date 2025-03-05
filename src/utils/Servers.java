package utils;

/**
 *
 * @author apvjx
 */
public class Servers {
    private String id;
    private String hostname;
    private String user;
    private String password;
    private String type;

    public Servers(String id, String hostname, String user, String password, String type) {
        this.id = id;
        this.hostname = hostname;
        this.user = user;
        this.password = password;
        this.type = type;
    }

    public Servers() {
        this.id = "";
        this.hostname = "";
        this.user = "";
        this.password = "";
        this.type = "";
    }
    
    public String getId() {
        return id;
    }
    
    public String getHostname() {
        return hostname;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
