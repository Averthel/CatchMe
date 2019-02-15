package pl.ave.service;

import pl.ave.exception.HumanLastNameWrongFormat;
import pl.ave.exception.HumanNameWrongFormat;
import pl.ave.exception.HumanNotFoundException;
import pl.ave.model.Human;
import pl.ave.validator.HumanValidator;

import java.util.ArrayList;
import java.util.List;

public class HumanService {

    List<Human> humans;

    public HumanService(){
        humans = new ArrayList<>();
    }

    public Human getHumanByLastName(String lastName) throws HumanNotFoundException {
        for(Human human: humans){
            if(human.getLastName().equals(lastName)){
                return human;
            }
        }
        throw new HumanNotFoundException("Human with lastName: "+lastName+" not found!");
    }

    public Human getHumanById(Integer id) throws HumanNotFoundException {
        for(Human human: humans){
            if(human.getId().equals(id)){
                return human;
            }
        }
        throw new HumanNotFoundException("Human not found!");
    }

    public void addHuman(String name, String lastName)throws HumanLastNameWrongFormat, HumanNameWrongFormat {
        if(HumanValidator.isHumanNameIsLongerThan3(name) && HumanValidator.isHumanLastNameIsLongerThan5(lastName)) {
            Human human = new Human(humans.size(), name, lastName);
            humans.add(human);
        }
    }
}
