package com.kinath.memento;

import java.util.ArrayList;

/**
 * Created by Kinath on 3/12/2017.
 */
public class CareTaker
{
    ArrayList<Memento> savedArticles = new ArrayList<>();

    public void addMemento( Memento m )
    {
        savedArticles.add( m );
    }

    public Memento getMemento( int index )
    {
        return savedArticles.get( index );
    }
}
