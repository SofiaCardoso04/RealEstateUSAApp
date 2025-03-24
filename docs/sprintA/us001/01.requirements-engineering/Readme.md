# US 001 -  To display listed properties

## 1. Requirements Engineering


### 1.1. User Story Description


As an unregistered user, I want to display listed properties.



### 1.2. Customer Specifications and Clarifications


**From the specifications document:**


> The unregistered user must have access to the properties' list. The user may also have the choice to make an appointment to visit the property.




**From the client clarifications:**

> **Question:** In the project's documentation it's mentioned that "All those who wish to use the application must be authenticated", but in the US1 it's said that an unregistered user can see a list of properties. Can users who aren't authenticated do this?
>
> **Answer:** Non-authenticated users can only list properties.

> **Question:** The properties can be in sale and lease at the same time?
>
> **Answer:** No.

> **Question:** In the project description it is stated that "the client is, then, responsible for being able to consult the properties by type, number of rooms, and sort by criteria such as price or the parish where the property is located.". Is the client able to sort properties by only these 4 criteria or is he able to sort properties by any of the properties' characteristics?
>
> **Answer:** The client should be able to select the type of business (renting or buying), the type of property and the number of rooms. Then, the client should be able to sort properties by price or by parish where the property is located.
If the client does not select the type of business, the type of property and the number of rooms, the application should allow the client to sort all properties that are on sale or on renting.

> **Question:** An unregistered user can olny see sale announcements or he is able to contact the agency agents to make a purchase request ?
>
> **Answer:** From the project description: "As an unregistered user, I want to display listed properties". For now this is the only functionality of the system that the non-registered user can use.

> **Question:** When an unregistered user opens the application, are there already properties being listed? If the answer is "YES": then by default, by which criteria are the properties listed? If the answer is "NO": is it mandatory for the user to choose an option (type, number of rooms) or can he/her simply request to view a list of properties that will be automatically ordered, for example, by "most recent"?
>
> **Answer:** I already clarified what the unregistered user will see and what he can do within the application. If the system does not contain any properties, the system should show an empty list of properties.

> **Question:** The property size, location and type are typed or selected in order to filter the results?
>
> **Answer:** I think you are asking about US1. The client should be able to select (from a list) the type of business, the type of property and the number of rooms.


### 1.3. Acceptance Criteria

* **AC1:** The user must have the option to choose between renting or leasing properties, the types of properties (apartments, houses or lands), the number of rooms
and being able to sort the properties by prices and by parishes.


### 1.4. Found out Dependencies


There is a dependency to "US002 publish a sale" since there must exist properties to be displayed to the unregisted users.


### 1.5 Input and Output Data


**Input Data:**

* Selected data:
  * type of business (rent or lease)
  * type of property
  * number of rooms
  * sort by price
  * sort by parish

**Output Data:**

(In)Success of the operation
Properties display

### 1.6. System Sequence Diagram (SSD)

#### Alternative One

![System Sequence Diagram - Alternative One](svg/us001-system-sequence-diagram-alternative-one.svg)


### 1.7 Other Relevant Remarks

* n/a