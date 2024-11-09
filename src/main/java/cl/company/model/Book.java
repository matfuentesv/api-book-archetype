package cl.company.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    @NotBlank(message = "No puede ingresar un title vacio")
    @NotNull(message = "No puede ingresar un title nulo")
    private String title;

    @Column(name = "author")
    @NotBlank(message = "No puede ingresar un author vacio")
    @NotNull(message = "No puede ingresar un author nulo")
    private String author;

    @Column(name = "description")
    @NotBlank(message = "No puede description un title vacio")
    @NotNull(message = "No puede description un title nulo")
    private String description;

    @Column(name = "publishedDate")
    @NotBlank(message = "No puede publishedDate un author vacio")
    @NotNull(message = "No puede publishedDate un author nulo")
    private String publishedDate;


    @Column(name = "gender")
    @NotBlank(message = "No puede gender un gender vacio")
    @NotNull(message = "No puede gender un gender nulo")
    private String gender;

    @Column(name = "linkImage")
    @NotBlank(message = "No puede gender un linkImage image")
    @NotNull(message = "No puede gender un linkImage image")
    private String linkImage;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotBlank(message = "No puede ingresar un title vacio") @NotNull(message = "No puede ingresar un title nulo") String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank(message = "No puede ingresar un title vacio") @NotNull(message = "No puede ingresar un title nulo") String title) {
        this.title = title;
    }

    public @NotBlank(message = "No puede ingresar un author vacio") @NotNull(message = "No puede ingresar un author nulo") String getAuthor() {
        return author;
    }

    public void setAuthor(@NotBlank(message = "No puede ingresar un author vacio") @NotNull(message = "No puede ingresar un author nulo") String author) {
        this.author = author;
    }

    public @NotBlank(message = "No puede publishedDate un author vacio") @NotNull(message = "No puede publishedDate un author nulo") String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(@NotBlank(message = "No puede publishedDate un author vacio") @NotNull(message = "No puede publishedDate un author nulo") String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public @NotBlank(message = "No puede gender un gender vacio") @NotNull(message = "No puede gender un gender nulo") String getGender() {
        return gender;
    }

    public void setGender(@NotBlank(message = "No puede gender un gender vacio") @NotNull(message = "No puede gender un gender nulo") String gender) {
        this.gender = gender;
    }

    public @NotBlank(message = "No puede gender un linkImage image") @NotNull(message = "No puede gender un linkImage image") String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(@NotBlank(message = "No puede gender un linkImage image") @NotNull(message = "No puede gender un linkImage image") String linkImage) {
        this.linkImage = linkImage;
    }

    public @NotBlank(message = "No puede description un title vacio") @NotNull(message = "No puede description un title nulo") String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank(message = "No puede description un title vacio") @NotNull(message = "No puede description un title nulo") String description) {
        this.description = description;
    }
}
