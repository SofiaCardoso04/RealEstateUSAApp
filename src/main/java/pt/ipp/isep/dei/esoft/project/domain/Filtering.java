/**

 The Filtering class provides methods for filtering a list of advertisements based on various criteria.
 */
package pt.ipp.isep.dei.esoft.project.domain;
import java.io.Serializable;
import java.util.ArrayList;

public class Filtering implements Serializable {

    /**
     * Filters the list of advertisements based on the request type.
     *
     * @param list        the list of advertisements to be filtered
     * @param RequestType the request type to filter by (either "r" for rent or "s" for sale)
     * @return the filtered list of advertisements
     */
    public ArrayList<Advertisement> filterRequestType(ArrayList<Advertisement> list, String RequestType) {

        if (RequestType.equals("r")) {
            for (int i = 0; i < list.size(); i++) {
                if (!(list.get(i).getRequestType().equals("rent"))) {
                    list.remove(i);
                }
            }
        }

        if (RequestType.equals("s")) {
            for (int i = 0; i < list.size(); i++) {
                if (!(list.get(i).getRequestType().equals("sale"))) {
                    list.remove(i);
                }
            }
        }

        return list;
    }

    /**
     * Filters the list of advertisements based on the property type.
     *
     * @param list         the list of advertisements to be filtered
     * @param propertyType the property type to filter by (either "l" for land, "h" for house, or "a" for apartment)
     * @return the filtered list of advertisements
     */
    public ArrayList<Advertisement> filterPropertyType(ArrayList<Advertisement> list, String propertyType) {

        if (propertyType.equals("l")) {
            for (int i = 0; i < list.size(); i++) {
                if (!(list.get(i).getPropertyType().equals("Land"))) {
                    list.remove(i);
                }
            }
        }

        if (propertyType.equals("h")) {
            for (int i = 0; i < list.size(); i++) {
                if (!(list.get(i).getPropertyType().equals("House"))) {
                    list.remove(i);
                }
            }
        }

        if (propertyType.equals("a")) {
            for (int i = 0; i < list.size(); i++) {
                if (!(list.get(i).getPropertyType().equals("Apartment"))) {
                    list.remove(i);
                }
            }
        }

        return list;
    }

    /**
     * Filters the list of advertisements based on the number of bedrooms in a residence.
     *
     * @param list           the list of advertisements to be filtered
     * @param numberBedrooms the number of bedrooms to filter by
     * @return the filtered list of advertisements
     */
    public ArrayList<Advertisement> filterNumberOfRooms(ArrayList<Advertisement> list, int numberBedrooms) {

        for (int i = 0; i < list.size(); i++) {
            Property propriedade = list.get(i).getProperty();
            if (propriedade instanceof Residence) {
                if (((Residence) propriedade).getNumberBedrooms() != numberBedrooms) {
                    list.remove(i);
                }
            }
        }

        return list;
    }
}
