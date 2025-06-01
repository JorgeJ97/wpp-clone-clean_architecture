package com.api.chat_app.domain.entity;

public class User {
    private String id;
    private String username;
    private String email;
    private String image;
    private String password;

    public User(String id, String username, String email, String image, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.image = image;
        this.password = password;
    }

    private User(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.email = builder.email;
        this.image = builder.image;
        this.password = builder.password;

    }
    public static class Builder {
        private String id;
        private String username;
        private String email;
        private String image;
        private String password;

        private Builder(){}

        public Builder id(String id){
            this.id = id;
            return this;
        }
        public Builder username(String username){
            this.username = username;
            return this;
        }
        public Builder email(String email){
            this.email = email;
            return this;
        }
        public Builder image(String image){
            this.image = image;
            return this;
        }
        public Builder password(String password){
            this.password = password;
            return this;
        }
        public User build(){
            return new User(this);
        }
    }

    public static Builder builder(){
        return new Builder();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
