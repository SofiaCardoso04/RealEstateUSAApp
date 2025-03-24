# US 004 - To submit a request

## 1. Requirements Engineering


### 1.1. User Story Description

As an owner, I intend to submit a request for listing a property sale or rent, choosing the responsible agent.


### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

> Owners go to one of the company's branches and meet with a real estate agent to sell or rent one or more properties, or they can use the company's application for the same purposes.

> The owner provides property characteristics (type of property (apartment, house or land),
  area in m2, location, distance from the city centre, requested price and one or more photographs. 
  If the property is an apartment or a house, also provides: number of bedrooms, bathrooms, parking 
  spaces and the available equipment, (central heating and/or air conditioning). In case the property 
  is a house, the existence of a basement, an inhabitable loft, and sun exposure must be registered 
  as well) and the requested price and sends the request to an agent.


**From the client clarifications:**

> **Question:** In the Project description, there are only specifications for a Sale. What are the required characteristics for a rental?
>  
> **Answer:** The caracteristics for a rental are the same as the ones for the sale of a property. The rent value is per month. Additionally, we have to define the contract duration.


> **Question:** Are there any restrictions on the choice of an Agent?
>
> **Answer:** No.


> **Question:** In case the submission of the listing is online may the owner choose any agent?
>
> **Answer:** Yes.


> **Question:** In case it is on an agency, must the agent be assigned automatically by the system?
>
> **Answer:** The agent that registers the information in the system can choose to assign any agent.


> **Question:** Is it possible to submit multiple listing for the same property and type of listing?
>
> **Answer:** No.


> **Question:** When publishing a property, if the owner leaves the listing unfinished, can it be saved or stay as a sketch to be finished later?
>
> **Answer:** No.


> **Question:** Should we consider that, until the request is reviewed and posted, the request stays in a "not published" state?
>
> **Answer:** This is an implementation detail. For me, as a client, I want the feature implemented as I already described in the project description.


> **Question:** Does an owner need to be registered in the system to submit a request for a property listing?
>
> **Answer:** No. When making the request to list a property, the owner should introduce his own data. The Owner attributes are: the name, the citizen's card number, the tax number, the address, the email address and the telephone number.


> **Question:** When assigning an agent to a property listing, are the available agents shown by the system for the owner to pick? Or does the owner need to provide the agent's information (name, agency,etc)?
>
> **Answer:** The owner should select one agent from a list of agents that work in the selected agency. The owner should select the agency before selecting the agent.


> **Question:** According to the Project Description, the agent when selling a property can charge a flat price comission or a percentage of the sale value, my question here is wether there is a minimum and/or a maximum to each of these types of comissions?
>
> **Answer:** There is no maximum and the minimum is 0.


> **Question:** In the case of listing a land property, shall the owner refer if there is a building permit already approved?
>
> **Answer:** No.


### 1.3. Acceptance Criteria


* **AC1:** The owner needs to choose a store.
* **AC2:** The owner chooses the responsible agent.
* **AC3:** The owner gives some characteristics about the property: type of property (apartment, house or land),
           area (m2), location, distance from the city centre, requested price and one or more photographs. 
           If the property is an apartment or a house, also provides: the number of bedrooms and parking spaces 
           In case the property is a house, the existence of a basement and an inhabitable loft must be registered as well.


### 1.4. Found out Dependencies


* There is a dependency to "US002 - To publish a sale" since it is necessary someone, in this case an agent, to publish the sale announcement of a property.


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
	
* Selected data:
    * Store
    * Responsible agent
	* Type of property (apartment, house or land)
    * Existence of basement
    * Existence of inhabitable loft
    * Sun exposure (optional)
    * Available equipment (central heating and/or air conditioning) (optional)
    * Sale or rent


**Output Data:**
* The list of a property
* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

#### Alternative One

![System Sequence Diagram - Alternative One](svg/us004-system-sequence-diagram-alternative-one-System_Sequence_Diagram__SSD____Alternative_One.svg)


### 1.7 Other Relevant Remarks

* The characteristics for a rental are the same as the ones for the sale of a property. The rent value is per month.
