package com.example.todos.model;


import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "todo.todo")
public class Todo {
//public class Todo extends Serialize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "description")
    private String description;

    @Column(name = "targetdate")
    private LocalDate targetdate;

    @Column(name = "done")
    private boolean done;

    public Todo() {
    }

    public Todo(Long id, String username, String description, LocalDate targetdate, boolean done) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetdate = targetdate;
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public LocalDate getTargetdate() {
        return targetdate;
    }

    public void setTargetDate(LocalDate targetdate) {
        this.targetdate = targetdate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
