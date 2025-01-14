package org.epf.hadoop.colfil3;

public class Recommendation {
    private final String user;
    private final int commonFriends;

    public Recommendation(String user, int commonFriends) {
        this.user = user;
        this.commonFriends = commonFriends;
    }

    public String getUser() {
        return user;
    }

    public int getCommonFriends() {
        return commonFriends;
    }
}