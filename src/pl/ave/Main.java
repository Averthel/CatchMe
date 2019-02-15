package pl.ave;

import pl.ave.exception.HumanLastNameWrongFormat;
import pl.ave.exception.HumanNameWrongFormat;
import pl.ave.exception.HumanNotFoundException;
import pl.ave.service.HumanService;

public class Main {

    public static void main(String[] args) {

        HumanService service = new HumanService();

        try {
            service.addHuman("Marek", "Marowski");
        } catch (HumanNameWrongFormat e) {
            e.printStackTrace();
        } catch (HumanLastNameWrongFormat e) {
            e.printStackTrace();
        }

        try {
            service.addHuman("Joanna", "Marzanna");
        } catch (HumanNameWrongFormat | HumanLastNameWrongFormat e) {
            e.printStackTrace();
        }

        try {
            System.out.println(service.getHumanById(0).toString());
        } catch (HumanNotFoundException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(service.getHumanByLastName("Marzanna").toString());
        } catch (HumanNotFoundException e) {
            e.printStackTrace();
        }


        try {
            service.addHuman("Marek", "Maro");
        } catch (HumanNameWrongFormat | HumanLastNameWrongFormat e) {
            e.printStackTrace();
        }

    }
}
