# DeliveryDispatch
<br><br>
## Table of contents
- [Overview](#overview)
- [Installation](#installation)
- [How the program works](#how-the-program-works)

## Overview
<p>The Delivery Dispatch System is a website application which purpose is to optimize deliveries’ sequence to meet 
customer satisfaction, reducing the journey time and the company’s cost. It also reduces the dispatcher's struggle of manually routing the orders.</p>
<p>This system will be used by a company that delivers food to restaurants and currently is using human judgment and Google Maps to define the delivery 
sequence, resulting in non-efficient journey time and delays.</p>
<p>The main objective of the system is to deliver a platform that will generate the sequence of delivery for the driver.</p>

### Technologies
<p>The technologies used to develop the project and keep version control are:</p>
<ul>
    <li>•	Java</li>
    <li>•	Spring Boot</li>
    <li>•	MySQL</li>
    <li>•	Tomcat</li>
    <li>•	Hibernate</li>
    <li>•	Thymeleaf</li>
</ul>

## Installation
<ol>
    <li>Clone the DeliveryDispatch repository.</li>
    <li>Fire up Eclipse and click on “Launch” button.</li>
    <li>Go to “File” -> "Open Projects from File System..." -> ”Directory…”.</li>
    <li>Select the folder of the project.</li>
    <li>While Maven download the dependencies, start MySQL and create a database called "dispatch".</li>
    <li>Got to the folder “src/main/java” and look for the package “com.Delivery.Dispatch”.</li>
    <li>Open the “DeliveryDispatchApplication.java” and Run!</li>
</ol>
<p>Type “localhost:8080/seed” on your browser: the database will be populated and it will be automatically redirected to the Home Page.</p>

## How the program works

### Deliveries Page and Menu
<p>The deliveries page contains information about all the deliveries and the user can sort them by the current day’s date.</p>
<p>Bellow, a brief explanation of the Delivery’s menu:</p>
<ol>
    <li><strong>Add Delivery:</strong>
        Page to add deliveries.</li>
    <li><strong>Deliveries:</strong>
        Page with all the deliveries, their information, and provide CRUD operations. The following image represents this page.</li>
    <li><strong>Driver Schedule:</strong>
        The page shows all Driver’s schedules, a weekly calendar, where the user can see when the drivers start to work and 
        their names of each day, and provide CRUD operations.</li>
    <li><strong>Assign Drivers:</strong>
        Page to assign drivers to the deliveries.</li>
    <li><strong>Sequences Created:</strong> 
        The page shows the sequences of deliveries created by the algorithm.</li>
</ol>
<img src="https://github.com/anapaularpontes/DeliveryDispatch/blob/master/imgs/Capture01.PNG?raw=true" />

### Driver Schedule Page
<p>This page shows a weekly calendar where the user can see when the drivers start to work and their names of each day. 
It also shows a list with the starting hours for all the drivers, where it is sorted by the date descending, and the start time ascending. 
This page allows the user to add, edit, and delete the drivers’ schedule.</p>
<img src="https://github.com/anapaularpontes/DeliveryDispatch/blob/master/imgs/Capture02.png?raw=true" />

### Assign Drivers Page
<p>This page shows all deliveries for the current day separated by the timing they must be delivered (Early, Midday, and Afternoon) and it 
is sorted by the area the restaurants are in. In the driver’s column, the drivers’ list is of the current day schedule with their name and the 
hour they start working.</p>
<img src="https://github.com/anapaularpontes/DeliveryDispatch/blob/master/imgs/Capture03.png?raw=true" />

### Sequences Created Page
<p>This page shows all the sequences created by the algorithm.</p>
<img src="https://github.com/anapaularpontes/DeliveryDispatch/blob/master/imgs/Capture04.png?raw=true" />
<p>When the user clicks in “Show details”, the page is redirected to a page that shows the details of the sequence created.</p>

### Sequence Detail Page
<p>This page shows the sequence of Deliveries created by the algorithm. It shows the driver assigned to these Deliveries, 
the date of the delivery, the sequence of the Restaurants, and a map with the visual of the sequence. When you click in the markers, 
you can see which restaurants correspond to that marker. In the image, the user can see that the marker for Restaurant 8 corresponds to The Bombay Restaurants.</p>
<img src="https://github.com/anapaularpontes/DeliveryDispatch/blob/master/imgs/Capture05.png?raw=true" />

### Restaurants Page and Database Menu
<p>Bellow, a brief explanation of the Database’s menu:</p>
<ul>
    <li>6.	<strong>Restaurants:</strong>
        The page shows all the restaurants in the database, their information, and provide CRUD operations. The following image represents this page.</li>
    <li>7.	<strong>Areas:</strong>
        The page shows all the areas in the database, their information, and provide CRUD operations. The areas are assigned to the restaurants.</li>
    <li>8.	<strong>Cities:</strong>
        The page shows all the cities in the database, their information, and provide CRUD operations. The cities are assigned to the restaurants.</li>
    <li>9.	<strong>Employees:</strong>
        The page shows all the employees in the database, their information, and provide CRUD operations.</li>
    <li>10.	<strong>Roles:</strong> 
        The page shows all the roles in the database, their information, and provide CRUD operations. The roles are assigned to the employees.</li>
</ul>
<img src="https://github.com/anapaularpontes/DeliveryDispatch/blob/master/imgs/Capture06.PNG?raw=true" />
<br/><br/>
