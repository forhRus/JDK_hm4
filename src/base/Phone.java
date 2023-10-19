package base;

import java.util.ArrayList;
import java.util.Random;

public class Phone {
    private static ArrayList<String> phones = new ArrayList<>();

    public String getPhone(){
        while(true){
            String phone = generatePhoneNumber();
            if(!phones.contains(phone)){
                phones.add(phone);
                return phone;
            }
        }
    }

    private String generatePhoneNumber(){
        Random random = new Random();
        StringBuilder phone = new StringBuilder("8(9");
        for (int i = 0; i < 9; i++) {
            phone.append(random.nextInt(10));
            if(i == 1){
                phone.append(")");
            }
            if(i == 4 || i == 6){
                phone.append("-");
            }
        }
        return phone.toString();
    }
}
