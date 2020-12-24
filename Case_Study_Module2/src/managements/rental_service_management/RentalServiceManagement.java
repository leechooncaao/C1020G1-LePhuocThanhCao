package managements.rental_service_management;

import models.services.rental_services.RentalService;

public interface RentalServiceManagement {
    void addService(RentalService service);
    void showInfoService();
    void showInfoServiceNotDuplicate();
    RentalService getServiceByOrder(int index);
}
