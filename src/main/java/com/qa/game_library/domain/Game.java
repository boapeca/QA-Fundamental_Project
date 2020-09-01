package com.qa.game_library.domain;

import javax.persistence.*;

@Entity
public class Game {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String genre;

    public Game() {
    }

    @ManyToOne(targetEntity = Library.class)
    private Library library;

    public Game(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
