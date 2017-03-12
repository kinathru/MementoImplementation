package com.kinath.main;

import com.kinath.memento.CareTaker;
import com.kinath.memento.Originator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kinath on 3/12/2017.
 */
public class MementoDemo extends JFrame implements ActionListener
{
    public static void main( String[] args )
    {
        new MementoDemo();
    }

    private JButton saveBut, undoBut, redoBut;
    private JTextArea theArticle = new JTextArea( 40, 60 );

    CareTaker careTaker = new CareTaker();
    Originator originator = new Originator();

    int saveFiles = 0, currentArticles = 0;

    public MementoDemo()
    {
        this.setSize( 750, 780 );
        this.setTitle( "Memento Design Pattern" );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        JPanel panel1 = new JPanel();
        panel1.add( new JLabel( "Article" ) );
        panel1.add( theArticle );

        saveBut = new JButton( "Save" );
        saveBut.addActionListener( this );

        undoBut = new JButton( "Undo" );
        undoBut.addActionListener( this );

        redoBut = new JButton( "Redo" );
        redoBut.addActionListener( this );

        panel1.add( saveBut );
        panel1.add( redoBut );
        panel1.add( undoBut );

        this.add( panel1 );
        this.setVisible( true );

    }

    @Override public void actionPerformed( ActionEvent e )
    {
        if( e.getSource().equals( saveBut ) )
        {
            String textInTextArea = theArticle.getText();
            originator.set( textInTextArea );
            careTaker.addMemento( originator.storeInMemento() );

            saveFiles++;
            currentArticles++;

            System.out.println( "Saved Files : " + saveFiles );
            undoBut.setEnabled( true );
        }
        else if( e.getSource().equals( undoBut ) )
        {
            if( currentArticles >= 1 )
            {
                currentArticles--;
                String textBoxString = originator.restoreFromMemento( careTaker.getMemento( currentArticles ) );
                theArticle.setText( textBoxString );

                redoBut.setEnabled( true );
            }
            else
            {
                undoBut.setEnabled( false );
            }
        }
        else if( e.getSource().equals( redoBut ) )
        {
            if( ( saveFiles - 1 ) > currentArticles )
            {
                currentArticles++;
                String textBoxString = originator.restoreFromMemento( careTaker.getMemento( currentArticles ) );
                theArticle.setText( textBoxString );
                undoBut.setEnabled( true );
            }
            else
            {
                redoBut.setEnabled( false );
            }
        }
    }
}
