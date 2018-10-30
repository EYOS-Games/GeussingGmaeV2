package com.eyos.ofir.guessinggame;

public class Session {

    private static Session session = null;

    private long matchingCategoryId;
    private long matchingSubCategoryId;
    private long matchingDifficultyId;


    private Session() {
    }

    public static Session getInstance() {
        if (session == null) {
            session = new Session();
        }
        return session;
    }

    public long getMatchingCategoryId() {
        return matchingCategoryId;
    }

    public void setMatchingCategoryId(long matchingCategoryId) {
        this.matchingCategoryId = matchingCategoryId;
    }

    public long getMatchingSubCategoryId() {
        return matchingSubCategoryId;
    }

    public void setMatchingSubCategoryId(long matchingSubCategoryId) {
        this.matchingSubCategoryId = matchingSubCategoryId;
    }

    public long getMatchingDifficultyId() {
        return matchingDifficultyId;
    }

    public void setMatchingDifficultyId(long matchingDifficultyId) {
        this.matchingDifficultyId = matchingDifficultyId;
    }


}
