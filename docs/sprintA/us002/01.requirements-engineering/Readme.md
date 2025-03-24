# US 002 - To publish a sale

## 1. Requirements Engineering


### 1.1. User Story Description

As an agent, I can publish any sale announcement on the system, for example received through a phone call.


### 1.2. Customer Specifications and Clarifications


**From the specifications document:**

>   The owner must provide information on: the type of property (apartment, house or land),
the area in m2, the location, the distance from the city centre, the requested price and one or more
photographs. If the property is an apartment or a house, the owner also provides: the number of
bedrooms, the number of bathrooms, the number of parking spaces and the available equipment,
such as central heating and/or air conditioning. In case the property is a house, the existence of a
basement, an inhabitable loft, and sun exposure must be registered as well.

>   Upon receiving the order, the agent sets the commission and publishes the offer in the system.

>   The commission can be a fixed amount or a percentage.

>	The real estate agent reviews advertisement requests, registers the information in the system and
publishes the offer so that it is visible to all clients who visit the agency and use the application.

>	All registered information, except the agency commission, can be accessed by the client who intends to
buy or rent the property.


**From the client clarifications:**

> **Question:** Is the phone call the only way the agent can receive the sale announcement? Or he can receive them via e-mail/ letter/ etc.
>
> **Answer:** For now this is the only way.

> **Question:** When the request arrives at the agent, are all the essential characteristics of the property in question already present?
>
> **Answer:** Yes.

> **Question:** Is it mandatory for the agent to input the commission value before publishing an announcement?
> 
> **Answer:** Yes.

> **Question:** Are there only 2 types of commission or can the Administrator define more types of commission?
>
> **Answer:** For now we only have two types of commissions.

> **Question:** Is it necessary to publish the owner atributes on the sale announcement?
>
> **Answer:** No.

> **Question:** If the comission is percentage what is the value? Is it the same for all agents?
>
> **Answer:** There is no maximum and the minimum is 0. The commission is for the agency and for that given property.

> **Question:** Are all the criteria for publishing the sale of a property in the system mandatory, or is there any data that the
owner can choose not to give?
>
> **Answer:** The number of bathrooms, the available equipment and the sun exposure are not mandatory. At least one photograph is required.

> **Question:** When the agent receives the phone call is it the agent who registers the order in the system or has the order already 
been entered into the system by the owner? Or is the phone call just for the owner to tell the agent that he registered a request in the system?
>
> **Answer:** The agent registers the order in the system.


### 1.3. Acceptance Criteria

* **AC1:** It is mandatory for the agent to input the commission value before publishing an announcement.


### 1.4. Found out Dependencies

* There is a dependency to "US004 To submit a request" because the agent is only able to publish the sale announcement if there is
  a request for listing a property sale or rent submited by the owner.
* There is a dependency to "US003 To register a new employee" because for the agent to be able to publish the sale announcement,
  he needs to be registered in the system as an employee.


### 1.5 Input and Output Data

**Input Data:**

* Typed data:
  * Area (m2)
  * Location
  * Distance from the city centre
  * Price
  * One or more photographs
  * Number of bedrooms
  * Number of bathrooms (optional)
  * Number of parking spaces
  * Comission


* Selected data:
  * Type of property (apartment, house or land)
  * Existence of basement
  * Existence of inhabitable loft
  * Sun exposure (optional)
  * Available equipment (central heating and/or air conditioning) (optional)


**Output Data:**

* Sale announcement published
* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

#### Alternative One
> Request is entered by the agent

![System Sequence Diagram - Alternative One](svg/us002-system-sequence-diagram-alternative-one-System_Sequence_Diagram__SSD____Alternative_One.svg)

#### Alternative Two
> Request is in the system

![System Sequence Diagram - Alternative One](svg/us002-system-sequence-diagram-alternative-two-System_Sequence_Diagram__SSD____Alternative_Two.svg)


### 1.7 Other Relevant Remarks

* The commission is one value/percentage paid when the transaction is made.