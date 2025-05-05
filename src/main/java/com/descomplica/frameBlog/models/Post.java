package com.descomplica.frameBlog.models;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "Post")

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long postId ;

    private String title;

    private Long content;

    private Date date;

    @ManyToOne

    private User userId;

    public Post(final Long postId,final String tittle,final Long content,final Date date,final User userId) {
        this.postId = postId;
        this.title = tittle;
        this.content = content;
        this.date = date;
        this.userId = userId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getTittle() {
        return title;
    }

    public void setTittle(String tittle) {
        this.title = tittle;
    }

    public Long getContent() {
        return content;
    }

    public void setContent(Long content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    
}
