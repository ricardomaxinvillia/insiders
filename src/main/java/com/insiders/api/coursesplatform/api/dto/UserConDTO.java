package com.insiders.api.coursesplatform.api.dto;

import java.util.HashSet;
import java.util.Set;

public class UserConDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String role;

    private Set<SubscriptionDTO> subscriptions = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<SubscriptionDTO> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Set<SubscriptionDTO> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
