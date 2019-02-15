package pl.ave.validator;

import pl.ave.exception.HumanLastNameWrongFormat;
import pl.ave.exception.HumanNameWrongFormat;

public class HumanValidator {

    public static boolean isHumanNameIsLongerThan3(String name) throws HumanNameWrongFormat{
        boolean flag = name.length() > 3;
        if(flag){
            return true;
        }
        throw new HumanNameWrongFormat("Name is too short");
    }

    public static boolean isHumanLastNameIsLongerThan5(String lastName) throws HumanLastNameWrongFormat {
        if(lastName.length() > 5){
            return true;
        }
        throw new HumanLastNameWrongFormat("Last name too short");
    }

}
