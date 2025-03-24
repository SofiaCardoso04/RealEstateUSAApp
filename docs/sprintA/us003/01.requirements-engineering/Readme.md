# US 003 - To register a new employee

## 1. Requirements Engineering


### 1.1. User Story Description


As a system administrator, I want to register a new employee.


### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

>	Each task is characterized by having a unique reference per organization, a designation, an informal and a technical description, an estimated duration and cost as well as the its classifying task category. 


>	As long as it is not published, access to the task is exclusive to the employees of the respective organization. 



**From the client clarifications:**

> **Question:** What is considered pertinent employee information?
>
> **Answer:** Pertinent employee information includes name, contact information, job title, store affiliation, and any other relevant details that the organization deems necessary.


> **Question:** How will the system check for duplicate entries?
>
> **Answer:** The system will check for duplicate entries based on a unique identifier, such as an employee ID.


> **Question:** Does the system administrator select the agency to which the employee is assigned and his role from a list? Or does he just type that data?
>
> **Answer:** The System Administrator should select.


> **Question:** When registering a new employee, will the administrator set the respective employee password?
>
> **Answer:** The password should have eight characters in length and should be generated automatically. The password is sent to the employee by e-mail.


> **Question:** When registering a new employee, all the required data (name, citizen's card number, etc...) have to be filled or exists not mandatory data?
>
> **Answer:** Required/Mandatory data that should be filled when registering an employee: name, the citizen's card number, the tax number, the email address, the contact telephone number and the agency to which it is assigned.


### 1.3. Acceptance Criteria


* **AC1:** All required fields must be filled in.
* **AC2:** The system should check for duplicate entries based on a unique identifier, such as an employee ID, and reject the operation if a duplicate entry is detected.
* **AC3:** The system should allow the system administrator to edit employee information if necessary.

### 1.4. Found out Dependencies


* This US doesn´t have any dependencies because the actor is the System Administrator.

### 1.5 Input and Output Data


**Input Data:**

* Typed data:
  * Name
  * Citizen's card number
  * Tax number
  * Address 
  * Email address
  * Phone number
  * Assigned store
  * Role

* Selected data:
  * Assigned Store
  * Role


**Output Data:**

* List of existing employees
* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)


#### Alternative One

![System Sequence Diagram - Alternative One](svg/us003-system-sequence-diagram-alternative-one-System_Sequence_Diagram__SSD____Alternative_One.svg)


### 1.7 Other Relevant Remarks

* The emplyee's password should have eight characters in length and should be generated automatically. The password is sent to the employee by e-mail.