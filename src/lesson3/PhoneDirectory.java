package lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneDirectory implements IPhoneDirectory {
    private Map<String, ArrayList<String>> phoneList;

    public PhoneDirectory() {
        phoneList = new HashMap<>();
    }

    private ArrayList<String> getPhone(String lastName) {
        return phoneList.get(lastName);
    }

    public void get (String lastName){
        ArrayList<String> phones = getPhone(lastName);
        if(phones == null){
            System.out.println("У фамилии " + lastName + " телефонов не обнаружено");
            return;
        }
        System.out.print("Фамилия: " + lastName + ", телефоны: ");
        for(String phone: phones){
            System.out.print(phone +"; ");
        }
        System.out.println(" ");
    }

    public void add(String lastName, String phone) {
        ArrayList phones = null;

        if (phoneList.containsKey(lastName)) {
            phones = phoneList.get(lastName);
        } else {
            phones = new ArrayList();
        }
        phones.add(phone);
        phoneList.put(lastName, phones);
    }


}
