# Supplementary Specification (FURPS+)

## Functionality

> **Audit and Reporting:**
- Create an application to manage the business (lease and sale) of real estate.
- Property owners contact Real Estate USA with the purpose of selling or renting their properties.
- If the owner wants to sale a property, he must provide information about: the type of property (house, apartment or land),
the area (m2), the location, the distance to the city center, the requested price and one or more photographs.
- If the property is a house or an apartment, he also provides: the number of bedrooms, bathrooms, parking spaces, and the 
available equipment (central heating and/or air conditioning).
- In case the property is a house, some more information must be registered, such as: the existence of basement, and inhabitable 
loft and sun exposure.
- The agents should be able to review advertisement requests, register information, publish offers visible to all clients, record visits 
to properties and indicate whether they think a deal will take place.
- The client should be able to sort the list of properties by type of property, number of bedrooms, by price and by location.
- The client should also be able to ask for a visit to the property and the agent needs to confirm and schedule the visit.
- If the property is sold or rented it should disappear from the listing of properties.
- The Store Manager needs to be able to oversee the deals of every agent on his store.
- The Network Manager has access to the data from every store in order to analyse it.
- The System administrator needs to insert every relevant information about the employees and each store.

> **Security:**
- All those who wish to use the application must be authenticated with a password (seven alphanumeric characters, including capital letters and two digits).
- Every information about the property should be visible to the client except the commission of the agent.


## Usability

- It will implement unit tests for all methods to prevent errors.
- The software should be user-friendly and easy to navigate.
- The software should have a clean and professional user interface.
- The application must support the English language.

## Reliability

- The system must run 7 days a week, 24 hours a day.
- The system must have as few failures as possible and if they do happen, they should be resolved as quickly as possible.
- The software should be reliable and stable, with minimal downtime.
- The software should be secure and protect confidential information.

## Performance

- The system must respond quickly to all operations.
- The application should consume little memory and CPU.
- The software should be able to handle a large number of transactions and users.

## Supportability

- The app will support English language.
- It should be easy to maintain and update the system.
- The software should have good documentation and customer support.
- The software should be compatible with future updates.
- The software application should also be conceived having in mind that it can be further commercialized to other companies.

## +

### Design Constraints

- The programming language will be Java.
- The application will be developed using the IntelliJ IDE and the graphical interface is to be developed in JavaFX 11.
- The unit tests should be implemented using the JUnit 5 framework.
- The JaCoCo plugin will be used to generate the coverage report.


### Implementation Constraints

- The application will be developed in Java language using the IntelliJ IDE or NetBeans.
- All those who wish to use the application must be authenticated with a password (seven alphanumeric characters, including capital letters and two digits).
- The app must support English language.
- The graphical interface is to be developed in JavaFX 11.
- The development team must implement unit tests for all methods, except for methods that
  implement Input/Output operations.
- The unit tests should be implemented using the JUnit 5 framework.
- The JaCoCo plugin will be used to generate the coverage report.
- During the system development, the team must adopt best practices for identifying
  requirements, and for OO software analysis and design.
- The team must adopt recognized coding standards (e.g., CamelCase);


### Interface Constraints

- The application graphical interface is to be developed in JavaFX 11.


### Physical Constraints

- The system must use a database to store and manage data, with appropriate backups and redundancy measures in place.
- The application should be optimized for fast loading times.