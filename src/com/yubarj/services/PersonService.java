package com.yubarj.services;

import com.yubarj.model.Person;

import java.util.List;

/**
 * Created by yubraj on 11/27/16.
 */
public interface PersonService {
    public void save(Person person);
    public void delete(int id);
    public List<Person> showAll();
    public boolean checkUserExists(int id);
}
