package pt.ipp.isep.dei.esoft.project.repository;
import pt.ipp.isep.dei.esoft.project.domain.PurchaseOrder;
import java.util.Comparator;

public class AmountAndDateComparator implements Comparator<PurchaseOrder> {


    @Override
    public int compare(PurchaseOrder po1, PurchaseOrder po2) {
        // First, compare the advertisement dates
        int dateComparison = po1.getAdvertisement().getDate().compareTo(po2.getAdvertisement().getDate());
        if (dateComparison != 0) {
            // If the dates are different, return the result of the date comparison
            return dateComparison;
        } else {
            // If the dates are the same, compare the amounts offered
            double amount1 = po1.getOrderAmount();
            double amount2 = po2.getOrderAmount();

            // Sort in descending order (highest offer first)
            return Double.compare(amount2, amount1);
        }
    }
}