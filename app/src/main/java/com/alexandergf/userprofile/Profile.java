package com.alexandergf.userprofile;

public class Profile {
    private String name, lastname, handle, following, followers, about;

    public Profile(String name, String lastname, String handle, String following, String followers, String about) {
        this.name = name;
        this.lastname = lastname;
        this.handle = handle;
        this.following = following;
        this.followers = followers;
        this.about = about;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getHandle() {
        return handle;
    }

    public String getFollowing() {
        return following;
    }

    public String getFollowers() {
        return followers;
    }

    public String getAbout() {
        return about;
    }
}
