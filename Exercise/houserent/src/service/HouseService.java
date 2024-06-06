package service;

import domain.House;

public class HouseService {
    private House[] houses;
    private int count = 0;
    private int idCount = 0;

    public HouseService(int size) {
        houses = new House[size];
        houses[0] = new House("jack", 1, "112", 2000, "海淀区", "未出租");
        count ++;
        idCount ++;
    }

    public House[] list() {
        return houses;
    }

    public boolean add(House house) {
        if (count >= houses.length) {
            return false;
        }
        house.setId(++this.idCount);
        houses[this.count++] = house;
        return true;
    }

    public boolean delete(int id) {
        int index = -1;
        for (int i = 0; i < this.count; i++) {
            if (houses[i].getId() == id) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        for (int i = index; i < this.count - 1; i++) {
            houses[i] = houses[i + 1];
        }
        houses[--this.count] = null;
        return true;
    }

    public House searchById(int id) {
        for (int i = 0; i < this.count; i++) {
            if (houses[i].getId() == id) {
                return houses[i];
            }
        }
        return null;
    }
}
