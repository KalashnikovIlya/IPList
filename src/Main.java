import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        IPStorage ipStorage = new IPStorage();
        Scanner in = new Scanner(System.in);
        int variant;
        String addressA;
        String addressB;

        while(true) {
            System.out.println("1. Добавить IP адрес.");
            System.out.println("2. Получить список IP адресов.");
            System.out.println("3. Очистить список IP адресов.");
            System.out.println("4. Выход.");
            variant = in.nextInt();
            switch (variant){
                case 1:
                    System.out.println("Введите один или несколько адресов формата XXX.XXX.XXX.XXX");
                    System.out.println("Для завершения введите 0.");
                    while(true){
                        addressA = in.next();
                        if (addressA.equals("0")) {
                            break;
                        }
                        else{
                            ipStorage.addAddress(addressA);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Введите два адреса формата XXX.XXX.XXX.XXX для получения списка");
                    System.out.println("1.");
                    addressA = in.next();
                    System.out.println("2.");
                    addressB = in.next();
                    System.out.println("Список адресов.");
                    ipStorage.getAddress(addressA, addressB);
                    break;
                case 3:
                    ipStorage.clearAddress();
                    break;
            }
            if (variant == 4){
                break;
            }
        }

    }
}
