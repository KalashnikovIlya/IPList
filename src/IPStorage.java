import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPStorage {

    ArrayList<String> address = new ArrayList<String>();

    public void addAddress(String address) {
        if (checkAddress(address)) {
            this.address.add(address);
            System.out.println("Адрес " + address + " сохранён");
        }
        else {
            System.out.println("Некорректный IP адрес " + address);
        }
    }

    public void getAddress(String addressA, String addressB) {
        if (checkAddress(addressA)) {
            if (checkAddress(addressB)) {
                long a = Long.parseLong(addressA.replace(".",""));
                long b = Long.parseLong(addressB.replace(".",""));
                for(String address : address) {
                    long c = Long.parseLong(address.replace(".",""));
                    if ((a <= c && c <= b) | (b <= c && c <= a)) {
                        System.out.println(address);
                    }
                }
            }
            else {
                System.out.println("Некорректный IP адрес " + addressB);
            }
        }
        else {
            System.out.println("Некорректный IP адрес " + addressA);
        }
    }

    public void clearAddress(){
        address.clear();
        System.out.println("Список адресов очищен.");
    }

    private boolean checkAddress(String address){
        String regex = "^[0-9]{3}+[.]+[0-9]{3}+[.]+[0-9]{3}+[.]+[0-9]{3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(address);
        return matcher.matches();
    }

}
