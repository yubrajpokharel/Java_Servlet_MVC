package com.yubarj.dao.repo;

import com.yubarj.model.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yubraj on 11/27/16.
 */
public class PersonRepoImpl implements PersonRepo{
    private List<Person> persons = new ArrayList<>();

    public void save(Person person){
        this.persons.add(person);
    }

    public void delete(int id){
        for (Iterator<Person> it = persons.iterator(); it.hasNext(); ) {
            Person aPerson = it.next();
            if (aPerson.getId() == id) {
                it.remove();
                break;
            }
        }
    }

    public List<Person> showAll(){
        return this.persons;
    }

    public boolean checkUserExists(int id){
        for (Iterator<Person> it = persons.iterator(); it.hasNext(); ) {
            Person aPerson = it.next();
            if (aPerson.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
