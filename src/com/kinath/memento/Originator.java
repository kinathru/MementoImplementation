package com.kinath.memento;

/**
 * Created by Kinath on 3/12/2017.
 */
public class Originator
{
    private String article;

    public void set( String newArticle )
    {
        System.out.println( "From Originator : Current version of Article \n" + newArticle + "\n" );
        article = newArticle;
    }

    public Memento storeInMemento()
    {
        System.out.println( "From Originator : Saving to Memento\n" );
        return new Memento( article );
    }

    public String restoreFromMemento( Memento memento )
    {
        article = memento.getSavedArticle();
        System.out.println( "From Originator : Previous Article Saved in memento \n" + article + "\n" );
        return article;
    }
}
