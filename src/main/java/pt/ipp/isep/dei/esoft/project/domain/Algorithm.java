package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.List;

/**
 * This class provides sorting algorithms for a list of PurchaseOrder objects based on the property area.
 */
public class Algorithm implements Serializable {

    /**
     * Sorts a list of PurchaseOrder objects in ascending or descending order based on the property area using the Gnome Sort algorithm.
     *
     * @param listDeals the list of PurchaseOrder objects to be sorted
     * @param option    the sorting option: 1 for ascending order, 2 for descending order
     * @return the sorted list of PurchaseOrder objects
     */
    public List<PurchaseOrder> gnomeSortByPropertyArea(List<PurchaseOrder> listDeals, int option) {
        int index = 0;
        while (index < listDeals.size()) {
            if (option == 1) {
                if (index == 0 || listDeals.get(index).getAdvertisement().getProperty().getArea() >= listDeals.get(index - 1).getAdvertisement().getProperty().getArea()) {
                    index++;
                } else {
                    PurchaseOrder temp = listDeals.get(index);
                    listDeals.set(index, listDeals.get(index - 1));
                    listDeals.set(index - 1, temp);
                    index--;
                }
            } else {
                if (index == 0 || listDeals.get(index).getAdvertisement().getProperty().getArea() <= listDeals.get(index - 1).getAdvertisement().getProperty().getArea()) {
                    index++;
                } else {
                    PurchaseOrder temp = listDeals.get(index);
                    listDeals.set(index, listDeals.get(index - 1));
                    listDeals.set(index - 1, temp);
                    index--;
                }
            }
        }
        return listDeals;
    }

    /**
     * Sorts a list of PurchaseOrder objects in ascending or descending order based on the property area using the Bubble Sort algorithm.
     *
     * @param listDeals the list of PurchaseOrder objects to be sorted
     * @param option    the sorting option: 1 for ascending order, 2 for descending order
     * @return the sorted list of PurchaseOrder objects
     */
    public List<PurchaseOrder> bubbleSortByPropertyArea(List<PurchaseOrder> listDeals, int option) {
        int n = listDeals.size();
        if (option == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < n - i; j++) {
                    if (listDeals.get(j - 1).getAdvertisement().getProperty().getArea() > listDeals.get(j).getAdvertisement().getProperty().getArea()) {
                        PurchaseOrder temp = listDeals.get(j - 1);
                        listDeals.set(j - 1, listDeals.get(j));
                        listDeals.set(j, temp);
                    }
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < n - i; j++) {
                    if (listDeals.get(j - 1).getAdvertisement().getProperty().getArea() < listDeals.get(j).getAdvertisement().getProperty().getArea()) {
                        PurchaseOrder temp = listDeals.get(j - 1);
                        listDeals.set(j - 1, listDeals.get(j));
                        listDeals.set(j, temp);
                    }
                }
            }
        }

        return listDeals;
    }
}
