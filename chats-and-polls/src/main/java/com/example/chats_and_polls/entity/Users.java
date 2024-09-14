package com.example.chats_and_polls.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Entity
@Table(name = "users")
public class Users {

    @Id
    private String id;
    private String email;
    private String name;
    private String givenName;
    private String familyName;
    private String picture;

    @ManyToMany
    @JoinTable(name = "users_groups",
    joinColumns = @JoinColumn(name = "users_id"),
    inverseJoinColumns = @JoinColumn(name = "groups_id")
    )
    private List<Groups> groups;
}
