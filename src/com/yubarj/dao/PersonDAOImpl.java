package com.yubarj.dao;

import com.yubarj.dao.repo.PersonRepo;
import com.yubarj.dao.repo.PersonRepoImpl;
import com.yubarj.model.Person;

import java.util.List;

/**
 * Created by yubraj on 11/27/16.
 */
public class PersonDAOImpl implements PersonDAO {

    private PersonRepo repo = new PersonRepoImpl();

    @Override
    public void save(Person person) {
        repo.save(person);
    }

    @Override
    public void delete(int id) {
        repo.delete(id);
    }

    @Override
    public List<Person> showAll() {
        return repo.showAll();
    }

    @Override
    public boolean checkUserExists(int id) {
        return repo.checkUserExists(id);
    }
}
