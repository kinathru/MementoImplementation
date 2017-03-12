package com.kinath.memento;

/**
 * Created by Kinath on 3/12/2017.
 */
public class Memento
{
    private String article;

    public Memento( String article )
    {
        this.article = article;
    }

    public String getSavedArticle()
    {
        return article;
    }
}
