package view;

import domain.House;
import service.HouseService;
import utils.Utility;

public class HouseView {
    private boolean loop = true;
    private char key = ' ';
    private HouseService houseService = new HouseService(10);

    public void mainMenu() {
        do {
            System.out.println("==============房屋出租系统菜单==============");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t3 删除房屋信息");
            System.out.println("\t\t\t4 修改房屋信息");
            System.out.println("\t\t\t5 显示房屋信息");
            System.out.println("\t\t\t6 退       出");
            System.out.println("请输入你的选择(1-6)：");
            key = Utility.readChar();
            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    searchHouseById();
                    break;
                case '3':
                    deleteHouse();
                    break;
                case '4':
                    editHouse();
                    break;
                case '5':
                    listHouses();
                    break;
                case '6':
                    quit();
                    break;
            }
        } while (loop);
    }

    private void editHouse() {
        System.out.println("==============修改房屋==============");
        System.out.print("请输入要修改房屋的id：");
        int id = Utility.readInt();
        House house = houseService.searchById(id);
        if (house == null) {
            System.out.print("不存在id为" + id + "的房屋...");
            return;
        }
        System.out.print("姓名(" + house.getName() + ")：");
        String name = Utility.readString(8, house.getName());
        house.setName(name);
        System.out.print("电话(" + house.getPhone() + ")：");
        String phone = Utility.readString(12, house.getPhone());
        house.setPhone(phone);
        System.out.print("地址(" + house.getAddress() + ")：");
        String address = Utility.readString(16, house.getAddress());
        house.setAddress(address);
        System.out.print("月租(" + house.getRent() + ")：");
        int rent = Utility.readInt(house.getRent());
        house.setRent(rent);
        System.out.print("状态(" + house.getState() + ")：");
        String status = Utility.readString(3, house.getState());
        house.setState(status);
        System.out.println("==============修改房屋完毕==============");
    }

    private void searchHouseById() {
        System.out.println("==============查找房屋==============");
        System.out.print("请输入要查找房屋的id：");
        int id = Utility.readInt();
        House house = houseService.searchById(id);
        if (house != null) {
            System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
            System.out.println(house);
        } else {
            System.out.println("不存在id为" + id + "的房屋...");
        }
    }

    public void listHouses() {
        System.out.println("==============房屋列表==============");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        House[] houses = houseService.list();
        for (House house : houses) {
            if (house == null) {
                break;
            }
            System.out.println(house);
        }
        System.out.println("==============房屋列表显示完毕==============");
    }

    public void addHouse() {
        System.out.println("==============添加房屋==============");
        System.out.print("姓名：");
        String name = Utility.readString(8);
        System.out.print("电话：");
        String phone = Utility.readString(12);
        System.out.print("地址：");
        String address = Utility.readString(16);
        System.out.print("月租：");
        int rent = Utility.readInt();
        System.out.print("状态：");
        String status = Utility.readString(3);
        House house = new House(name, 0, phone, rent, address, status);
        if (houseService.add(house)) {
            System.out.println("==============添加房屋完毕==============");
        } else {
            System.out.println("房屋列表已满，不能再添加了...");
        }
    }

    public void deleteHouse() {
        System.out.println("==============删除房屋==============");
        System.out.print("请输入待删除房屋的编号（-1）退出：");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("==============放弃删除房屋==============");
            return;
        }
        if (Utility.readConfirmSelection() == 'Y') {
            if (!houseService.delete(delId)) {
                System.out.println("==============房屋编号不存在，删除失败==============");
            }
        } else {
            System.out.println("==============放弃删除房屋==============");
        }
        System.out.println("==============删除房屋完毕==============");
    }

    public void quit() {
        if (Utility.readConfirmSelection() == 'Y') {
            loop = false;
        }
    }
}
