package Colltrollers;

import Models.Computer;
import Models.ComputerGuest;
import io.ValidateChoice;
import io.WriteAndReadCartGuest;
import io.WriteAndReadComputerCartGuest;
import io.WriteAndReadStaff;

import java.util.List;
import java.util.Scanner;

public class ManagerGuest2 {
    static WriteAndReadCartGuest writeAndReadCartGuest=new WriteAndReadCartGuest();
    static WriteAndReadStaff writeAndReadStaff=new WriteAndReadStaff();
    static Scanner scannerGuest=new Scanner(System.in);
    public static void managerGuest2(List<Computer> computers, List<ComputerGuest> cartguest, String nameLogin, String nameID, List<Computer> computerscartguest){
        computers.clear();
        writeAndReadCartGuest.read(cartguest);
        writeAndReadStaff.read(computers);
        readCartGuest(cartguest,nameID,computerscartguest);
        while (true){
        System.out.println("===Menu===");
        System.out.println("1. Xem laptop theo hãng");
        System.out.println("2. Sắp xếp laptop theo giá");
        System.out.println("3. Xem giỏ hàng");
        System.out.println("4. Thanh toán");
        System.out.println("5. Đăng xuất");
        switch (Integer.parseInt(scannerGuest.nextLine())){
            case 1:
                computers.sort(new SortByName());
                buy(computers,cartguest,nameLogin,nameID,computerscartguest);
                break;
            case 2:
                computers.sort(new PriceMinToMax());
                buy(computers,cartguest,nameLogin,nameID,computerscartguest);
                break;
            case 3:
                showCart(cartguest,nameID,computerscartguest);
                break;
            case 4:
                pay(computerscartguest,computers);
                break;
            case 5:
                return;

        }
    }
    }
    public static void buy(List<Computer> computers, List<ComputerGuest> cartguest,String nameLogin,String nameID,List<Computer> computerscartguest){
        while (true){
            for (int i = 0; i < computers.size(); i++) {
                System.out.println((i+1)+". Tên mặt hàng: " + computers.get(i).getName());
                System.out.println("   Giá Tiền:     "+ computers.get(i).getPrice());
                System.out.println("");
            }


            try {
                int index=-1;
                System.out.println("Chọn sản phẩm bạn muốn mua");
                index=Integer.parseInt(scannerGuest.nextLine());
            if (index>computers.size()){
                System.out.println("Vui lòng chọn lại");
            }else {
                for (int i = 0; i < computers.size(); i++) {
                    if (index-1==i){
                        String brand=computers.get(i).getBrand();
                        String name=computers.get(i).getName();
                        String chip=computers.get(i).getChip();
                        String display=computers.get(i).getDisplay();
                        String ram=computers.get(i).getRam();
                        String battery=computers.get(i).getBattery();
                        int amount=computers.get(i).getAmount();
                        int price= computers.get(i).getPrice();
                        cartguest.add(new ComputerGuest(nameID,brand,name,chip,display,ram,battery,amount,price));
                        System.out.println("Đã thêm mặt hàng vào giỏ hàng");
                    }
                }
                writeAndReadCartGuest.write(cartguest);
            }
            computerscartguest.clear();
            readCartGuest(cartguest,nameID,computerscartguest);
//                for (int i = 0; i < cartguest.size(); i++) {
//                if (nameID.equals(cartguest.get(i).getNameID())){
//                    String brand=cartguest.get(i).getBrand();
//                    String name=cartguest.get(i).getName();
//                    String chip=cartguest.get(i).getChip();
//                    String display=cartguest.get(i).getDisplay();
//                    String ram=cartguest.get(i).getRam();
//                    String battery=cartguest.get(i).getBattery();
//                    int amount=cartguest.get(i).getAmount();
//                    int price= cartguest.get(i).getPrice();
//                    computerscartguest.add(new Computer(brand,name,chip,display,ram,battery,amount,price));}}
//                int sumPrice=0;
//                for (int j = 0; j <computerscartguest.size() ; j++) {
//                    System.out.println("Tên hàng hóa: "+computerscartguest.get(j).getName());
//                    System.out.println("Giá tiền :" + computerscartguest.get(j).getPrice());
//                    System.out.println("");
//                    sumPrice+=computerscartguest.get(j).getPrice();
//                }
//                System.out.println("Tổng số tiền  " + sumPrice);
//            managerGuest2(computers,cartguest,nameLogin,nameID,computerscartguest);
            break;
    }catch (Exception e){
                System.out.println("Vui lòng chọn lại");
            }
        }
    }
    public static void showCart(List<ComputerGuest> cartguest,String nameID,List<Computer> computerscartguest){

        int sumPrice=0;
//        for (int i = 0; i < cartguest.size(); i++) {
//            if (nameID.equals(cartguest.get(i).getNameID())){
//                String brand=cartguest.get(i).getBrand();
//                String name=cartguest.get(i).getName();
//                String chip=cartguest.get(i).getChip();
//                String display=cartguest.get(i).getDisplay();
//                String ram=cartguest.get(i).getRam();
//                String battery=cartguest.get(i).getBattery();
//                int amount=cartguest.get(i).getAmount();
//                int price= cartguest.get(i).getPrice();
//                computerscartguest.add(new Computer(brand,name,chip,display,ram,battery,amount,price));
//            }
//        }
        for (int i = 0; i <computerscartguest.size() ; i++) {
            System.out.println("Tên hàng hóa: "+computerscartguest.get(i).getName());
            System.out.println("Giá tiền :" + computerscartguest.get(i).getPrice());
            System.out.println("");
            sumPrice+=computerscartguest.get(i).getPrice();
        }
        System.out.println("Tổng số tiền  " + sumPrice);
    }
    public static void readCartGuest(List<ComputerGuest> cartguest,String nameID,List<Computer> computerscartguest){
        for (int i = 0; i < cartguest.size(); i++) {
            if (nameID.equals(cartguest.get(i).getNameID())){
                String brand=cartguest.get(i).getBrand();
                String name=cartguest.get(i).getName();
                String chip=cartguest.get(i).getChip();
                String display=cartguest.get(i).getDisplay();
                String ram=cartguest.get(i).getRam();
                String battery=cartguest.get(i).getBattery();
                int amount=cartguest.get(i).getAmount();
                int price= cartguest.get(i).getPrice();
                computerscartguest.add(new Computer(brand,name,chip,display,ram,battery,amount,price));
            }
        }
    }
    public static void pay(List<Computer> computerscartguest,List<Computer> computers){
        int sumPrice=0;
        for (int i = 0; i <computerscartguest.size() ; i++) {
            System.out.println("Tên hàng hóa: "+computerscartguest.get(i).getName());
            System.out.println("Giá tiền :" + computerscartguest.get(i).getPrice());
            System.out.println("");
            sumPrice+=computerscartguest.get(i).getPrice();
            for (int j = 0; j <computers.size() ; j++) {
                if (computerscartguest.get(i).getName().equals(computers.get(j).getName())){
                    computers.get(j).setAmount(computers.get(j).getAmount()-1);
                }
            }
        }
        System.out.println("Đã lên đơn thành công. Số tiền bạn cần thanh toán là : " + sumPrice);
    }
}
