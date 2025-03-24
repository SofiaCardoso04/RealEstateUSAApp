
/**
 * The PropertiesListController class is a controller responsible for managing the list of properties and provides
 * functionality for filtering and sorting advertisements.
 */
/**

 The PropertiesListController class represents the controller responsible for managing the advertisements list and applying
 filters and sorting criteria to it.
 */
package pt.ipp.isep.dei.esoft.project.application.controller;
import pt.ipp.isep.dei.esoft.project.domain.Advertisement;
import pt.ipp.isep.dei.esoft.project.domain.Filtering;
import pt.ipp.isep.dei.esoft.project.domain.Sorting;
import pt.ipp.isep.dei.esoft.project.repository.AdvertisementRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.ArrayList;

public class PropertiesListController {

    /**
     * The filtering object responsible for filtering advertisements list by a specific criteria.
     */
    Filtering filter = new Filtering();

    /**
     * The sorting object responsible for sorting advertisements list by a specific criteria.
     */
    Sorting sorter = new Sorting();

    /**
     * The list of advertisements to be filtered and sorted.
     */
    ArrayList<Advertisement> advertisements;

    /**
     * The advertisement repository used to retrieve advertisements.
     */
    private AdvertisementRepository advertisementRepository = null;

    /**
     * Retrieves the advertisement repository instance.
     *
     * @return The advertisement repository instance.
     */
    private AdvertisementRepository getAdvertisementRepository(){
        if (advertisementRepository == null) {
            Repositories repositories = Repositories.getInstance();

            advertisementRepository = repositories.getAdvertisementRepository();
        }
        return advertisementRepository;
    }

    /**
     * Retrieves the list of advertisements from the advertisement repository.
     *
     * @return The list of advertisements.
     */
    public ArrayList<Advertisement> getAdvertisements(){
        AdvertisementRepository advertisementRepository = Repositories.getInstance().getAdvertisementRepository();
        this.advertisements = advertisementRepository.getAdvertisements();
        return advertisements;
    }

    /**
     * Filters the advertisements list by the given request type.
     *
     * @param list The list of advertisements to be filtered.
     * @param request The request type to be used as filter.
     * @return The filtered advertisements list.
     */
    public ArrayList<Advertisement> getFilteredByRequestTypeList(ArrayList<Advertisement> list, String request){
        return filter.filterRequestType(list, request);
    }

    /**
     * Filters the advertisements list by the given property type.
     *
     * @param list The list of advertisements to be filtered.
     * @param propertyType The property type to be used as filter.
     * @return The filtered advertisements list.
     */
    public ArrayList<Advertisement> getFilteredByPropertyTypeList(ArrayList<Advertisement> list, String propertyType){
        return filter.filterPropertyType(list, propertyType);
    }

    /**
     * Filters the advertisements list by the given number of bedrooms.
     *
     * @param list The list of advertisements to be filtered.
     * @param numberBedrooms The number of bedrooms to be used as filter.
     * @return The filtered advertisements list.
     */
    public ArrayList<Advertisement> getFilteredByNumberBedroomsList(ArrayList<Advertisement> list, int numberBedrooms){
        return filter.filterNumberOfRooms(list, numberBedrooms);
    }

    /**
     * Sorts the advertisements list by city.
     *
     * @param list The list of advertisements to be sorted.
     * @return The sorted advertisements list.
     */
    public ArrayList<Advertisement> getSortedByCityList(ArrayList<Advertisement> list){
        return sorter.sortByCity(list);
    }

    /**
     * Sorts the advertisements list by district.
     *
     * @param list The list of advertisements to be sorted.
     * @return The sorted advertisements list.
     */
    public ArrayList<Advertisement> getSortedByDistrictList(ArrayList<Advertisement> list){
        return sorter.sortByDistrict(list);
    }

    /**
     * Sorts the advertisements list by price.
     *
     * @param list The list of advertisements to be sorted.
     * @return The sorted advertisements list.
     */
    public ArrayList<Advertisement> getSortedByPriceList(ArrayList<Advertisement> list){
        return sorter.sortByPrice(list);
    }
    /**

     Displays the advertisements in the given list in the order they appear in the list.
     @param list the list of advertisements to display
     */
    public void showAdvertisementsByOrder(ArrayList<Advertisement> list){
            System.out.println(list);
    }
}