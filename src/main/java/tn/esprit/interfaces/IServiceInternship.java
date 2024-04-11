package tn.esprit.interfaces;

import java.util.ArrayList;

public interface IServiceInternship<T> {

    void add (T t );
    ArrayList<T> getAll();

    void update(T t );
    boolean delete (int t);
//findby..

    //getby ...

}

