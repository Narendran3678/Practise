package com.directory.entity;

import jakarta.persistence.*;
import org.json.JSONObject;

@Entity
@Table(name="roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="role_id")
    private long role_id;
    @Column(name="rolename")
    private String rolename;

    public Roles() {

    }
    public Roles(String rolename) {
        this.rolename = rolename;
    }
    public Roles(long role_id, String rolename) {
        this.role_id = role_id;
        this.rolename = rolename;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRole_id() {
        return role_id;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("role_id", role_id);
        jsonObject.put("rolename", rolename);
        System.out.println("JsonStringRoles.."+jsonObject.toString());
        return jsonObject.toString();
    }
}
