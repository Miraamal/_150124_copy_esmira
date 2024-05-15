package org.example._2024_05_07.testCollection;

import java.util.*;

public class DetailedHouseCollectionTasks {

    // Задание 1: Вернуть список всех коробок, вес которых больше среднего веса всех коробок (List)
    public static List<Box> getBoxesHeavierThanAverage(List<House> houses) {
        double sumWeight = 0;
        int count = 0;
        for (House h : houses) {
            for (Flat f : h.flats) {
                for (Room r : f.roomList) {
                    for (Box b : r.boxes) {
                        count++;
                        sumWeight = sumWeight + b.weight;
                    }
                }
            }
        }
        double average = sumWeight / count;
        List<Box> heavyBoxes = new ArrayList<>();
        for (House h : houses) {
            for (Flat f : h.flats) {
                for (Room r : f.roomList) {
                    for (Box b : r.boxes) {
                        if (b.weight > average) {
                            heavyBoxes.add(b);
                        }
                    }
                }
            }
        }
        return heavyBoxes;
    }

    // Задание 2: Вернуть карту, где ключи — это цвета коробок,
    // а значения — количество комнат, содержащих хотя бы одну коробку такого цвета (List, Map)
    public static Map<Color, Integer> getRoomCountByBoxColor(List<House> houses) {
        Map<Color, Integer> colorToRoomCount = new HashMap<>();
        Map<Color, Set<Room>> colorToRooms = new HashMap<>();
        for (House h : houses) {
            for (Flat f : h.flats) {
                for (Room r : f.roomList) {
                    for (Box b : r.boxes) {
                        Color color = b.color;
                        if (!colorToRooms.containsKey(color)) colorToRooms.put(color, new HashSet<>(Set.of(r)));
                        else {
                            colorToRooms.get(color).add(r);
                        }
                    }

                }
            }
        }
        colorToRooms.forEach((color, roomSet) -> colorToRoomCount.put(color, roomSet.size()));
        return colorToRoomCount;
    }

    // Задание 3: Найти средний вес коробок в комнатах с зелеными стенами (List)
    public static double getAverageWeightOfBoxesInGreenRooms(List<House> houses) {
        double sumWeight = 0;
        int count = 0;
        for (House h : houses) {
            for (Flat f : h.flats) {
                for (Room r : f.roomList) {
                    if (r.color != Color.GREEN ) continue;
                    for (Box b : r.boxes) {
                        count++;
                        sumWeight = sumWeight + b.weight;
                    }
                }
            }
        }


        return count > 0 ? sumWeight / count : 0;
    }

    // Задание 4: Определить, в каком доме самый большой процент квартир с коробками (List)
    public static House getHouseWithHighestPercentageOfFlatsWithBoxes(List<House> houses) {
        House houseWithHighestPercentage = null;

        return houseWithHighestPercentage;
    }

    // Задание 5: Подсчитать количество квартир, которые находятся в домах без лифтов и содержат коробки (List)
    public static int countFlatsWithBoxesInHousesWithoutElevators(List<House> houses) {
        int count = 0;
        for (House h : houses) {
            if (!h.hasElevator ) continue;
            for (Flat f : h.flats) {
                int boxCount = 0;
                for (Room r : f.roomList) {
                    boxCount += r.boxes.size();
                }
                if (boxCount==0) continue;
                count++;
            }

        }

        return count;
    }

    public static void main(String[] args) {
        List<House> houses = HouseGenerator.generateHouses(777);

        System.out.println("Коробки тяжелее среднего: " + getBoxesHeavierThanAverage(houses).size());
        System.out.println("Количество комнат по цветам коробок: " + getRoomCountByBoxColor(houses));
        System.out.println("Средний вес коробок в зеленых комнатах: " + getAverageWeightOfBoxesInGreenRooms(houses));
        System.out.println("Дом с самым большим процентом квартир с коробками: " + getHouseWithHighestPercentageOfFlatsWithBoxes(houses));
        System.out.println("Квартиры с коробками в домах без лифтов: " + countFlatsWithBoxesInHousesWithoutElevators(houses));
    }
}