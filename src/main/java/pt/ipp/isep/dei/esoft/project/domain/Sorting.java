/**
 * The Sorting class implements methods to sort an ArrayList of Advertisement objects by price, city, or district.
 */
package pt.ipp.isep.dei.esoft.project.domain;

import pt.ipp.isep.dei.esoft.project.DTO.AdvertisementRequestDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sorting implements Serializable {


    /**
     * This method sorts an ArrayList of Advertisement objects by price.
     *
     * @param list the ArrayList of Advertisement objects to be sorted by price
     * @return the sorted ArrayList of Advertisement objects by price
     */
    public ArrayList<Advertisement> sortByPrice(ArrayList<Advertisement> list) {

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i; j < list.size(); j++) {
                if (list.get(i).getSalePrice() > list.get(j).getSalePrice()) {
                    Collections.swap(list, i, j);
                }
            }

        }
        return list;
    }

    /**
     * This method sorts an ArrayList of Advertisement objects by city.
     *
     * @param list the ArrayList of Advertisement objects to be sorted by city
     * @return the sorted ArrayList of Advertisement objects by city
     */
    public ArrayList<Advertisement> sortByCity(ArrayList<Advertisement> list) {

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i; j < list.size(); j++) {
                if (!(list.get(i).getProperty().getAddress().getCityName().compareTo(list.get(j).getProperty().getAddress().getCityName()) < 0)) {
                    Collections.swap(list, i, j);
                }
            }

        }
        return list;
    }

    /**
     * This method sorts an ArrayList of Advertisement objects by district.
     *
     * @param list the ArrayList of Advertisement objects to be sorted by district
     * @return the sorted ArrayList of Advertisement objects by district
     */
    public ArrayList<Advertisement> sortByDistrict(ArrayList<Advertisement> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i; j < list.size(); j++) {
                if (!(list.get(i).getProperty().getAddress().getDistrict().compareTo(list.get(j).getProperty().getAddress().getDistrict()) < 0)) {
                    Collections.swap(list, i, j);
                }
            }

        }
        return list;
    }


    /**
     * Sorts the list of employees in alphabetical order based on their names.
     *
     * @param employees The list of employees to sort.
     * @return The sorted list of employees.
     */
    public static ArrayList<Employee> sortEmployees(ArrayList<Employee> employees) {
        int n = employees.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (employees.get(j).getName().compareTo(employees.get(j + 1).getName()) > 0) {
                    Employee temp = employees.get(j);
                    employees.set(j, employees.get(j + 1));
                    employees.set(j + 1, temp);
                }
            }
        }

        return employees;
    }

    public ArrayList<AdvertisementRequestDTO> getAdvertisementRequestsSortedFromTheMostRecentToTheOldest(ArrayList<AdvertisementRequestDTO> advertisementRequestList) {
        for (int i = 0; i < advertisementRequestList.size() - 1; i++) {
            for (int j = i; j < advertisementRequestList.size(); j++) {
                if (!(advertisementRequestList.get(i).getDate().compareTo(advertisementRequestList.get(j).getDate()) > 0)) {
                    Collections.swap(advertisementRequestList, i, j);
                }
            }
        }
        return advertisementRequestList;
    }
}



