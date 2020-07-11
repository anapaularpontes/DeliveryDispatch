package com.DeliveryDispatch.Controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.DeliveryDispatch.Boundaries.AreaDAO;
import com.DeliveryDispatch.Boundaries.CityDAO;
import com.DeliveryDispatch.Boundaries.DeliveryDAO;
import com.DeliveryDispatch.Boundaries.EmployeeDAO;
import com.DeliveryDispatch.Boundaries.EmployeeRoleDAO;
import com.DeliveryDispatch.Boundaries.RestaurantDAO;
import com.DeliveryDispatch.Entities.Area;
import com.DeliveryDispatch.Entities.City;
import com.DeliveryDispatch.Entities.Delivery;
import com.DeliveryDispatch.Entities.Employee;
import com.DeliveryDispatch.Entities.EmployeeRole;
import com.DeliveryDispatch.Entities.Restaurant;

/**
 * Populate the database
 * @author Ana Paula
 *
 */
@Controller
public class PopulateDatabase {
	
	@Autowired
	CityDAO cityDAO;
	
	@Autowired
	AreaDAO areaDAO;
	
	@Autowired
	RestaurantDAO restDAO;
	
	@Autowired
	EmployeeRoleDAO roleDAO;
	
	@Autowired
	EmployeeDAO empDAO;
	
	@GetMapping("/seed")
	@ResponseBody
	public String seed() {
		
		
		
		/**************** Roles ***************/
		ArrayList<EmployeeRole> rolesList = new ArrayList<>();
		
		rolesList.add(new EmployeeRole("admin"));		//ID: 1
		rolesList.add(new EmployeeRole("dispatcher"));	//ID: 2
		rolesList.add(new EmployeeRole("driver"));		//ID: 3
		
		for(EmployeeRole role : rolesList) {
			roleDAO.save(role);
		}
		
		/**************** Employees ***************/		
		ArrayList<Employee> employeesList = new ArrayList<>();
		
		employeesList.add(new Employee("Lily", "Charles", "admin", "pass1234", roleDAO.findById(1).get()));
		employeesList.add(new Employee("Leticia", "Hollington", "dispatcher", "pass1234", roleDAO.findById(2).get()));
		employeesList.add(new Employee("Aron", "Sybbe", "", "", roleDAO.findById(3).get()));
		employeesList.add(new Employee("Denis", "Kirmond", "", "", roleDAO.findById(3).get()));
		employeesList.add(new Employee("Giralda", "Aizlewood", "", "", roleDAO.findById(3).get()));
		employeesList.add(new Employee("Filmore", "Fulmen", "", "", roleDAO.findById(3).get()));
		employeesList.add(new Employee("Burke", "Boulden", "", "", roleDAO.findById(3).get()));
		employeesList.add(new Employee("Theobald", "Slegg", "", "", roleDAO.findById(3).get()));
		employeesList.add(new Employee("Dud", "Ewdale", "", "", roleDAO.findById(3).get()));
		employeesList.add(new Employee("Renaud", "Elsmore", "", "", roleDAO.findById(3).get()));
		employeesList.add(new Employee("Henry", "O'Mailey", "", "", roleDAO.findById(3).get()));
		employeesList.add(new Employee("Elsey", "Woffinden", "", "", roleDAO.findById(3).get()));
		employeesList.add(new Employee("Issiah", "Lowis", "", "", roleDAO.findById(3).get()));
		employeesList.add(new Employee("Josias", "Diter", "", "", roleDAO.findById(3).get()));
		employeesList.add(new Employee("Raven", "Barwise", "", "", roleDAO.findById(3).get()));
		employeesList.add(new Employee("Keenan", "Bennetto", "", "", roleDAO.findById(3).get()));
		
		for(Employee emp : employeesList) {
			empDAO.save(emp);
		}
		
		/**************** Cities ***************/
		ArrayList<City> citiesList = new ArrayList<>();
		
		citiesList.add(new City("Vancouver"));			//ID: 1
		citiesList.add(new City("Burnaby"));			//ID: 2
		citiesList.add(new City("New Westminster"));	//ID: 3
		citiesList.add(new City("Surrey"));				//ID: 4
		citiesList.add(new City("North Vancouver"));	//ID: 5
		citiesList.add(new City("West Vancouver"));		//ID: 6
		citiesList.add(new City("Coquitlam"));			//ID: 7
		citiesList.add(new City("Port Coquitlam"));		//ID: 8
		citiesList.add(new City("Richmond"));			//ID: 9
		
		for(City city : citiesList) {
			cityDAO.save(city);
		}
		
		/**************** Areas ***************/
		ArrayList<Area> areasList = new ArrayList<>();
		
		areasList.add(new Area("Coal Harbour")); 	//ID: 1
		areasList.add(new Area("Deep Cove"));		//ID: 2
		areasList.add(new Area("East Vancouver"));	//ID: 3 
		areasList.add(new Area("False Creek"));		//ID: 4
		areasList.add(new Area("Gastown"));			//ID: 5
		areasList.add(new Area("Granville Island"));//ID: 6
		areasList.add(new Area("Kerrisdale"));		//ID: 7
		areasList.add(new Area("Kitsilano"));		//ID: 8
		areasList.add(new Area("Mount Pleasant"));	//ID: 9
		areasList.add(new Area("North Burnaby"));	//ID: 10
		areasList.add(new Area("North Vancouver"));	//ID: 11 
		areasList.add(new Area("Richmond"));		//ID: 12
		areasList.add(new Area("South Burnaby / New Westminster"));	//ID: 13
		areasList.add(new Area("South Vancouver"));	//ID: 14
		areasList.add(new Area("Tri-Cities"));		//ID: 15
		areasList.add(new Area("West End"));		//ID: 16
		areasList.add(new Area("West Vancouver"));	//ID: 17
		areasList.add(new Area("Yaletown"));		//ID: 18

		for(Area area : areasList) {
			areaDAO.save(area);
		}
		
		/**************** Restaraunts ***************/
		ArrayList<Restaurant> restaurantsList = new ArrayList<>();
		
		// Coal Harbour
		restaurantsList.add(new Restaurant("6 Degrees Eatery", "1590 Coal Harbour Quay", cityDAO.findById(1).get(), areaDAO.findById(1).get()));
		restaurantsList.add(new Restaurant("Cardero's Restaurant", "1583 Coal Harbour Quay", cityDAO.findById(1).get(), areaDAO.findById(1).get()));
		restaurantsList.add(new Restaurant("Festal Paleo Cafe", "433 Granville St", cityDAO.findById(1).get(), areaDAO.findById(1).get()));
		restaurantsList.add(new Restaurant("Hawksworth Restaurant", "801 W Georgia St", cityDAO.findById(1).get(), areaDAO.findById(1).get()));
		restaurantsList.add(new Restaurant("Kari Kitchen", "1055 W Georgia St", cityDAO.findById(1).get(), areaDAO.findById(1).get()));
		restaurantsList.add(new Restaurant("Kitchen by Yugo", "792 Denman St", cityDAO.findById(1).get(), areaDAO.findById(1).get()));
		restaurantsList.add(new Restaurant("Lift Bar Grill View", "333 Menchion Mews", cityDAO.findById(1).get(), areaDAO.findById(1).get()));
		restaurantsList.add(new Restaurant("Nightingale", "1017 W Hastings St", cityDAO.findById(1).get(), areaDAO.findById(1).get()));
		restaurantsList.add(new Restaurant("Nook (Coal Harbour)", "781 Denman St", cityDAO.findById(1).get(), areaDAO.findById(1).get()));
		restaurantsList.add(new Restaurant("Tableau Bar Bistro", "1181 Melville St", cityDAO.findById(1).get(), areaDAO.findById(1).get()));
		restaurantsList.add(new Restaurant("Tavola", "1829 Robson St", cityDAO.findById(1).get(), areaDAO.findById(1).get()));
		restaurantsList.add(new Restaurant("Verre", "550 Denman St", cityDAO.findById(1).get(), areaDAO.findById(1).get()));
		restaurantsList.add(new Restaurant("Hydra Estiatorio Mediterranean Restaurant", "475 Howe St", cityDAO.findById(1).get(), areaDAO.findById(1).get()));
		
		// Deep Cove
		restaurantsList.add(new Restaurant("Arms Reach Bistro", "4390 Gallant Ave #107c", cityDAO.findById(5).get(), areaDAO.findById(2).get()));
		restaurantsList.add(new Restaurant("Café Orso", "4316 Gallant Ave", cityDAO.findById(5).get(), areaDAO.findById(2).get()));
		restaurantsList.add(new Restaurant("Coach House Lounge", "700 Old Lillooet Rd", cityDAO.findById(5).get(), areaDAO.findById(2).get()));
		restaurantsList.add(new Restaurant("Deep Cove Brewers and Distillers", "2270 Dollarton Hwy #170", cityDAO.findById(5).get(), areaDAO.findById(2).get()));
		restaurantsList.add(new Restaurant("InGrain Pastificio", "126-1133 Mt Seymour Rd", cityDAO.findById(5).get(), areaDAO.findById(2).get()));
		restaurantsList.add(new Restaurant("Scratch Kitchen", "437 Dollarton Hwy N", cityDAO.findById(5).get(), areaDAO.findById(2).get()));
		restaurantsList.add(new Restaurant("The Raven Pub", "1052 Deep Cove Rd", cityDAO.findById(5).get(), areaDAO.findById(2).get()));
		restaurantsList.add(new Restaurant("Tommy's Cafe", "1308 Ross Rd", cityDAO.findById(5).get(), areaDAO.findById(2).get()));
		
		// East Vancouver
		restaurantsList.add(new Restaurant("Arriva Ristorante", "1537 Commercial Dr", cityDAO.findById(1).get(), areaDAO.findById(3).get()));
		restaurantsList.add(new Restaurant("Cabrito", "2270 Commercial Dr", cityDAO.findById(1).get(), areaDAO.findById(3).get()));
		restaurantsList.add(new Restaurant("The Cannibal Cafe", "1818 Commercial Dr", cityDAO.findById(1).get(), areaDAO.findById(3).get()));
		restaurantsList.add(new Restaurant("Dachi", "2297 E Hastings St", cityDAO.findById(1).get(), areaDAO.findById(3).get()));
		restaurantsList.add(new Restaurant("Fets Whisky Kitchen", "1230 Commercial Dr", cityDAO.findById(1).get(), areaDAO.findById(3).get()));
		restaurantsList.add(new Restaurant("La Mezcaleria (East Vancouver)", "1622 Commercial Dr", cityDAO.findById(1).get(), areaDAO.findById(3).get()));
		restaurantsList.add(new Restaurant("La Piazza Dario", "3075 Slocan St", cityDAO.findById(1).get(), areaDAO.findById(3).get()));
		restaurantsList.add(new Restaurant("Nonna's Table Pizzeria & Restaurant", "1489 E Hastings St", cityDAO.findById(1).get(), areaDAO.findById(3).get()));
		restaurantsList.add(new Restaurant("Pizzeria Barbarella", "654 E Broadway at, Fraser St", cityDAO.findById(1).get(), areaDAO.findById(3).get()));
		restaurantsList.add(new Restaurant("Poor Italian Ristorante", "3296 E 1st Ave", cityDAO.findById(1).get(), areaDAO.findById(3).get()));
		restaurantsList.add(new Restaurant("Tamam: Fine Palestinian Cuisine", "2616 E Hastings St", cityDAO.findById(1).get(), areaDAO.findById(3).get()));
		restaurantsList.add(new Restaurant("Ugly Dumpling", "1590 Commercial Dr", cityDAO.findById(1).get(), areaDAO.findById(3).get()));
		restaurantsList.add(new Restaurant("Whiskey Six BBQ", "826 Renfrew St", cityDAO.findById(1).get(), areaDAO.findById(3).get()));
		
		// False Creek
		restaurantsList.add(new Restaurant("Bao Bei", "163 Keefer St", cityDAO.findById(1).get(), areaDAO.findById(4).get()));
		restaurantsList.add(new Restaurant("Campagnolo", "1020 Main St", cityDAO.findById(1).get(), areaDAO.findById(4).get()));
		restaurantsList.add(new Restaurant("Kissa Tanto", "263 E Pender St", cityDAO.findById(1).get(), areaDAO.findById(4).get()));
		restaurantsList.add(new Restaurant("Nook (False Creek)", "195 W 2nd Ave", cityDAO.findById(1).get(), areaDAO.findById(4).get()));
		restaurantsList.add(new Restaurant("Pizzeria Farina", "915 Main St", cityDAO.findById(1).get(), areaDAO.findById(4).get()));
		restaurantsList.add(new Restaurant("Torafuku", "958 Main St", cityDAO.findById(1).get(), areaDAO.findById(4).get()));
		restaurantsList.add(new Restaurant("Mommo's Smokehaus", "401 Industrial Ave", cityDAO.findById(1).get(), areaDAO.findById(4).get()));
		
		// Gastown
		restaurantsList.add(new Restaurant("Aleph Eatery", "1889 Powell St", cityDAO.findById(1).get(), areaDAO.findById(5).get()));
		restaurantsList.add(new Restaurant("Bauhaus Restaurant", "1 W Cordova St", cityDAO.findById(1).get(), areaDAO.findById(5).get()));
		restaurantsList.add(new Restaurant("Coquille Fine Seafood", "181 Carrall St", cityDAO.findById(1).get(), areaDAO.findById(5).get()));
		restaurantsList.add(new Restaurant("Cuchillo", "261 Powell St", cityDAO.findById(1).get(), areaDAO.findById(5).get()));
		restaurantsList.add(new Restaurant("The Dirty Apron", "540 Beatty St", cityDAO.findById(1).get(), areaDAO.findById(5).get()));
		restaurantsList.add(new Restaurant("L'Abattoir", "217 Carrall St", cityDAO.findById(1).get(), areaDAO.findById(5).get()));
		restaurantsList.add(new Restaurant("La Mezcaleria (Gastown)", "68 E Cordova St", cityDAO.findById(1).get(), areaDAO.findById(5).get()));
		restaurantsList.add(new Restaurant("New Amsterdam Cafe", "301 W Hastings St", cityDAO.findById(1).get(), areaDAO.findById(5).get()));
		restaurantsList.add(new Restaurant("Peckinpah", "2 Water St", cityDAO.findById(1).get(), areaDAO.findById(5).get()));
		restaurantsList.add(new Restaurant("Pidgin Restaurant", "350 Carrall St", cityDAO.findById(1).get(), areaDAO.findById(5).get()));
		restaurantsList.add(new Restaurant("Tuc Craft Kitchen", "60 W Cordova St", cityDAO.findById(1).get(), areaDAO.findById(5).get()));
		restaurantsList.add(new Restaurant("Water St. Café", "300 Water St", cityDAO.findById(1).get(), areaDAO.findById(5).get()));
		restaurantsList.add(new Restaurant("Wildebeest", "120 W Hastings St", cityDAO.findById(1).get(), areaDAO.findById(5).get()));
		
		// Granville Island
		restaurantsList.add(new Restaurant("Edible Canada", "1596 Johnston St", cityDAO.findById(1).get(), areaDAO.findById(6).get()));
		restaurantsList.add(new Restaurant("Stock Market", "1689 Johnston St", cityDAO.findById(1).get(), areaDAO.findById(6).get()));
		restaurantsList.add(new Restaurant("Tenderland Meats Ltd", "1689 Johnston St", cityDAO.findById(1).get(), areaDAO.findById(6).get()));
		restaurantsList.add(new Restaurant("The Sandbar Seafood Restaurant", "1535 Johnston Street, Creekhouse #102", cityDAO.findById(1).get(), areaDAO.findById(6).get()));
		
		// Kerrisdale
		restaurantsList.add(new Restaurant("Bigsby The Bakehouse", "4894 MacKenzie St", cityDAO.findById(1).get(), areaDAO.findById(7).get()));
		restaurantsList.add(new Restaurant("Bufala", "5395 West Blvd", cityDAO.findById(1).get(), areaDAO.findById(7).get()));
		restaurantsList.add(new Restaurant("Butter Baked Goods Ltd", "4907 MacKenzie St", cityDAO.findById(1).get(), areaDAO.findById(7).get()));
		restaurantsList.add(new Restaurant("Choices Markets (Kerrisdale)", "1888 W 57th Ave W", cityDAO.findById(1).get(), areaDAO.findById(7).get()));
		restaurantsList.add(new Restaurant("La Buca Restaurant", "4025 Macdonald St", cityDAO.findById(1).get(), areaDAO.findById(7).get()));
		
		// Kitsilano
		restaurantsList.add(new Restaurant("Au Comptoir", "2278 W 4th Ave", cityDAO.findById(1).get(), areaDAO.findById(8).get()));
		restaurantsList.add(new Restaurant("BiBo Pizzeria con Cucina (Kitsilano)", "1835 W 4th Ave", cityDAO.findById(1).get(), areaDAO.findById(8).get()));
		restaurantsList.add(new Restaurant("Bishop's", "2183 W 4th Ave", cityDAO.findById(1).get(), areaDAO.findById(8).get()));
		restaurantsList.add(new Restaurant("Blue Martini Cafe & Jazz", "1516 Yew St", cityDAO.findById(1).get(), areaDAO.findById(8).get()));
		restaurantsList.add(new Restaurant("La Quercia", "3689 W 4th Ave", cityDAO.findById(1).get(), areaDAO.findById(8).get()));
		restaurantsList.add(new Restaurant("Romer's Burger Bar (Kitsilano)", "1873 W 4th Ave", cityDAO.findById(1).get(), areaDAO.findById(8).get()));
		restaurantsList.add(new Restaurant("Thomas Haas", "2539 W Broadway", cityDAO.findById(1).get(), areaDAO.findById(8).get()));
		restaurantsList.add(new Restaurant("TurF", "2041 W 4th Ave", cityDAO.findById(1).get(), areaDAO.findById(8).get()));
		restaurantsList.add(new Restaurant("Yuwa Japanese Cuisine", "2775 W 16th Ave", cityDAO.findById(1).get(), areaDAO.findById(8).get()));
		
		// Mount Pleasant
		restaurantsList.add(new Restaurant("Bacio Rosso", "4600 Cambie St", cityDAO.findById(1).get(), areaDAO.findById(9).get()));
		restaurantsList.add(new Restaurant("Continental Coffee", "4295 Main St", cityDAO.findById(1).get(), areaDAO.findById(9).get()));
		restaurantsList.add(new Restaurant("Dock Lunch", "152 E 11th Ave", cityDAO.findById(1).get(), areaDAO.findById(9).get()));
		restaurantsList.add(new Restaurant("The Fish Counter", "3825 Main St", cityDAO.findById(1).get(), areaDAO.findById(9).get()));
		restaurantsList.add(new Restaurant("Restaurant Yugo", "4265 Main St", cityDAO.findById(1).get(), areaDAO.findById(9).get()));
		restaurantsList.add(new Restaurant("Prado Café (Mount Pleasant)", "4208 Fraser St, Vancouver, BC V5V 4E8", cityDAO.findById(1).get(), areaDAO.findById(9).get()));
		restaurantsList.add(new Restaurant("Ubuntu Canteen", "4194 Fraser St", cityDAO.findById(1).get(), areaDAO.findById(9).get()));
		restaurantsList.add(new Restaurant("The Acorn Restaurant", "3995 Main St", cityDAO.findById(1).get(), areaDAO.findById(9).get()));
		restaurantsList.add(new Restaurant("The Arbor Restaurant", "3941 Main St", cityDAO.findById(1).get(), areaDAO.findById(9).get()));
		restaurantsList.add(new Restaurant("Liberty Bakery + Café", "3699 Main St", cityDAO.findById(1).get(), areaDAO.findById(9).get()));
		
		// North Burnaby
		restaurantsList.add(new Restaurant("Baci Ristorante", "3728 E Hastings St", cityDAO.findById(2).get(), areaDAO.findById(10).get()));
		restaurantsList.add(new Restaurant("Caffè Artigiano", "4359 Hastings St", cityDAO.findById(2).get(), areaDAO.findById(10).get()));
		restaurantsList.add(new Restaurant("Caffe Divano", "4568 Hastings St", cityDAO.findById(2).get(), areaDAO.findById(10).get()));
		restaurantsList.add(new Restaurant("Chez Christophe", "4717 Hastings St", cityDAO.findById(2).get(), areaDAO.findById(10).get()));
		restaurantsList.add(new Restaurant("Chez Meme Baguette Bistro", "4016 Hastings St", cityDAO.findById(2).get(), areaDAO.findById(10).get()));
		restaurantsList.add(new Restaurant("Butchers Block BBQ", "4091 Hastings St", cityDAO.findById(2).get(), areaDAO.findById(10).get()));
		restaurantsList.add(new Restaurant("L'Artista Italian Restaurant", "3891 E Hastings St", cityDAO.findById(2).get(), areaDAO.findById(10).get()));
		restaurantsList.add(new Restaurant("Little Billy's Steakhouse", "6785 Hastings St", cityDAO.findById(2).get(), areaDAO.findById(10).get()));
		restaurantsList.add(new Restaurant("Osaka Sushi", "4152 Hastings St", cityDAO.findById(2).get(), areaDAO.findById(10).get()));
		restaurantsList.add(new Restaurant("Pear Tree Restaurant", "4120 E Hastings St", cityDAO.findById(2).get(), areaDAO.findById(10).get()));
		restaurantsList.add(new Restaurant("Thai Cafe Restaurant", "4160 Hastings St", cityDAO.findById(2).get(), areaDAO.findById(10).get()));
		
		// North Vancouver
		restaurantsList.add(new Restaurant("Fishworks", "91 Lonsdale Ave", cityDAO.findById(5).get(), areaDAO.findById(11).get()));
		restaurantsList.add(new Restaurant("Farina a Legna", "119 2nd St E", cityDAO.findById(5).get(), areaDAO.findById(11).get()));
		restaurantsList.add(new Restaurant("Bravo Cucina Ristorante", "1209 Lonsdale Ave", cityDAO.findById(5).get(), areaDAO.findById(11).get()));
		restaurantsList.add(new Restaurant("Nicli Antica Pizzeria", "3142 Highland Blvd", cityDAO.findById(5).get(), areaDAO.findById(11).get()));
		restaurantsList.add(new Restaurant("Orto Artisan Pasta", "1600 Mackay Rd", cityDAO.findById(5).get(), areaDAO.findById(11).get()));
		restaurantsList.add(new Restaurant("S'wich Cafe", "644 Queensbury Ave", cityDAO.findById(5).get(), areaDAO.findById(11).get()));
		restaurantsList.add(new Restaurant("The Gull Bar and Kitchen", "175 1st St E", cityDAO.findById(5).get(), areaDAO.findById(11).get()));
		restaurantsList.add(new Restaurant("The Portly Chef", "1211 Lonsdale Ave", cityDAO.findById(5).get(), areaDAO.findById(11).get()));
		restaurantsList.add(new Restaurant("Tomahawk Restaurant", "1550 Philip Ave", cityDAO.findById(5).get(), areaDAO.findById(11).get()));
		restaurantsList.add(new Restaurant("Hachiro Ramen Bar", "140 16th St W", cityDAO.findById(5).get(), areaDAO.findById(11).get()));
		
		// Richmond
		restaurantsList.add(new Restaurant("Bibo Pizzeria (McArthurGlen Outlet)", "1067c Templeton Station Road", cityDAO.findById(9).get(), areaDAO.findById(12).get()));
		restaurantsList.add(new Restaurant("Blundell Seafoods Ltd", "11351 River Rd", cityDAO.findById(9).get(), areaDAO.findById(12).get()));
		restaurantsList.add(new Restaurant("Cucina Piccolo Italian Restaurant", "130-3760 Moncton St", cityDAO.findById(9).get(), areaDAO.findById(12).get()));
		restaurantsList.add(new Restaurant("The Westin Wall Centre Restaurant", "3099 Corvette Way", cityDAO.findById(9).get(), areaDAO.findById(12).get()));
		restaurantsList.add(new Restaurant("River Rock Casino Resort", "8811 River Rd", cityDAO.findById(9).get(), areaDAO.findById(12).get()));
		restaurantsList.add(new Restaurant("The Apron", "3099 Corvette Way", cityDAO.findById(9).get(), areaDAO.findById(12).get()));
		restaurantsList.add(new Restaurant("Moxie's Grill & Bar", "3233 St Edwards Dr", cityDAO.findById(9).get(), areaDAO.findById(12).get()));;
		
		// South Burnaby / New Westminster
		restaurantsList.add(new Restaurant("Balkan House Restaurant", "7530 Edmonds St", cityDAO.findById(2).get(), areaDAO.findById(13).get()));
		restaurantsList.add(new Restaurant("Fratelli Pasta", "6958 Palm Ave", cityDAO.findById(2).get(), areaDAO.findById(13).get()));
		restaurantsList.add(new Restaurant("Hart House Restaurant", "6664 Deer Lake Ave", cityDAO.findById(2).get(), areaDAO.findById(13).get()));
		restaurantsList.add(new Restaurant("Boemma Euro Foods & Deli", "5172 Kingsway", cityDAO.findById(2).get(), areaDAO.findById(13).get()));
		restaurantsList.add(new Restaurant("Choices Markets (Burnaby)", "8683 10th Ave", cityDAO.findById(2).get(), areaDAO.findById(13).get()));
		restaurantsList.add(new Restaurant("Orlando's Catering", "810 Quayside Dr", cityDAO.findById(3).get(), areaDAO.findById(13).get()));
		restaurantsList.add(new Restaurant("Old Crow Coffee Co.", "655 Front St", cityDAO.findById(3).get(), areaDAO.findById(13).get()));
		restaurantsList.add(new Restaurant("New Westminster City Hall Cafeteria", "511 Royal Ave", cityDAO.findById(3).get(), areaDAO.findById(13).get()));
		
		// South Vancouver
		restaurantsList.add(new Restaurant("In The Mood Food", "418 East Kent Ave S #119", cityDAO.findById(1).get(), areaDAO.findById(14).get()));
		restaurantsList.add(new Restaurant("Romer's Burger Bar (South Vancouver)", "8683 Kerr St", cityDAO.findById(1).get(), areaDAO.findById(14).get()));
		restaurantsList.add(new Restaurant("Denny's", "622 SW Marine Dr", cityDAO.findById(1).get(), areaDAO.findById(14).get()));
		restaurantsList.add(new Restaurant("Hometown Pizza", "6665 Fraser St", cityDAO.findById(1).get(), areaDAO.findById(14).get()));
		restaurantsList.add(new Restaurant("Applause Japanese Restaurant", "8269 Oak St", cityDAO.findById(1).get(), areaDAO.findById(14).get()));
		
		
		// Tri-Cities
		restaurantsList.add(new Restaurant("Caffé Divano", "3003 Burlington Dr, Coquitlam, BC V3B 6X1", cityDAO.findById(7).get(), areaDAO.findById(15).get()));
		restaurantsList.add(new Restaurant("Doppio Zero Pizza", "1655 Como Lake Ave", cityDAO.findById(7).get(), areaDAO.findById(15).get()));
		restaurantsList.add(new Restaurant("La Ruota Pizzeria", "100-1168 The High St", cityDAO.findById(7).get(), areaDAO.findById(15).get()));
		restaurantsList.add(new Restaurant("Rio Brazilian Steakhouse (Coquitlam)", "2729 Barnet Hwy", cityDAO.findById(7).get(), areaDAO.findById(15).get()));
		restaurantsList.add(new Restaurant("Ethno Restaurant Vayat", "1147 Austin Ave", cityDAO.findById(7).get(), areaDAO.findById(15).get()));
		restaurantsList.add(new Restaurant("The Golden Boot Caffé", "1028 Ridgeway Ave", cityDAO.findById(7).get(), areaDAO.findById(15).get()));
		restaurantsList.add(new Restaurant("Europe Old Fashion Bakery & Deli", "2552 Shaughnessy St", cityDAO.findById(8).get(), areaDAO.findById(15).get()));
		restaurantsList.add(new Restaurant("Sky Dragon Restaurant", "1538 Prairie Ave", cityDAO.findById(8).get(), areaDAO.findById(15).get()));
		restaurantsList.add(new Restaurant("Cat & Fiddle Sports Bar & Restaurant", "1979 Brown St", cityDAO.findById(8).get(), areaDAO.findById(15).get()));
		restaurantsList.add(new Restaurant("The Bombay Restaurant", "2748 Lougheed Hwy", cityDAO.findById(8).get(), areaDAO.findById(15).get()));
		
		
		// West End
		restaurantsList.add(new Restaurant("Amici Miei Italian Restaurant", "1114 Denman St", cityDAO.findById(1).get(), areaDAO.findById(16).get()));
		restaurantsList.add(new Restaurant("CinCin Ristorante + Bar", "1154 Robson St", cityDAO.findById(1).get(), areaDAO.findById(16).get()));
		restaurantsList.add(new Restaurant("Hook Seabar", "1210 Denman St", cityDAO.findById(1).get(), areaDAO.findById(16).get()));
		restaurantsList.add(new Restaurant("Milano Espresso Bar", "849 Denman St", cityDAO.findById(1).get(), areaDAO.findById(16).get()));
		restaurantsList.add(new Restaurant("Nat's New York Pizzeria", "1080 Denman St", cityDAO.findById(1).get(), areaDAO.findById(16).get()));
		restaurantsList.add(new Restaurant("Rio Brazilian Steakhouse (West End)", "1122 Denman St", cityDAO.findById(1).get(), areaDAO.findById(16).get()));
		restaurantsList.add(new Restaurant("The Red Accordion", "1616 Alberni St", cityDAO.findById(1).get(), areaDAO.findById(16).get()));
		restaurantsList.add(new Restaurant("The Sauce Pasta Cafe", "861 Denman St", cityDAO.findById(1).get(), areaDAO.findById(16).get()));
		restaurantsList.add(new Restaurant("Teahouse", "7501 Stanley Park Dr", cityDAO.findById(1).get(), areaDAO.findById(16).get()));
		restaurantsList.add(new Restaurant("Zefferelli's", "1136 Robson St", cityDAO.findById(1).get(), areaDAO.findById(16).get()));
		restaurantsList.add(new Restaurant("Papi's Seafood and Oyster Bar", "1193 Denman St", cityDAO.findById(1).get(), areaDAO.findById(16).get()));
		restaurantsList.add(new Restaurant("Stanley's Bar and Grill", "610 Pipeline Rd", cityDAO.findById(1).get(), areaDAO.findById(16).get()));
		
		// West Vancouver
		restaurantsList.add(new Restaurant("Ambleside Bistro", "1425 Marine Dr #105", cityDAO.findById(6).get(), areaDAO.findById(17).get()));
		restaurantsList.add(new Restaurant("Amici Restaurant", "1747 Marine Dr", cityDAO.findById(6).get(), areaDAO.findById(17).get()));
		restaurantsList.add(new Restaurant("BackYard Eatery & Cafe", "1731 Marine Dr", cityDAO.findById(6).get(), areaDAO.findById(17).get()));
		restaurantsList.add(new Restaurant("Feast Neighbourhood Table", "2423 Marine Dr", cityDAO.findById(6).get(), areaDAO.findById(17).get()));
		restaurantsList.add(new Restaurant("Heirloom Vegetarian Ambleside", "1390 Marine Dr", cityDAO.findById(6).get(), areaDAO.findById(17).get()));
		restaurantsList.add(new Restaurant("Pastameli", "5369 Headland Dr", cityDAO.findById(6).get(), areaDAO.findById(17).get()));
		restaurantsList.add(new Restaurant("Savary Island Pie Company", "1533 Marine Dr", cityDAO.findById(6).get(), areaDAO.findById(17).get()));
		restaurantsList.add(new Restaurant("Temper Chocolate & Pastry", "2409 Marine Dr", cityDAO.findById(6).get(), areaDAO.findById(17).get()));
		restaurantsList.add(new Restaurant("Terroir Kitchen", "2232 Marine Dr", cityDAO.findById(6).get(), areaDAO.findById(17).get()));
		restaurantsList.add(new Restaurant("The Bakehouse", "2453 Marine Dr", cityDAO.findById(6).get(), areaDAO.findById(17).get()));
		restaurantsList.add(new Restaurant("The Red Lion Bar & Grill", "2427 Marine Dr", cityDAO.findById(6).get(), areaDAO.findById(17).get()));
		restaurantsList.add(new Restaurant("Salmon House On The Hill", "2229 Folkestone Way", cityDAO.findById(6).get(), areaDAO.findById(17).get()));
		restaurantsList.add(new Restaurant("The Truffle House & Cafe", "2452 Marine Dr", cityDAO.findById(6).get(), areaDAO.findById(17).get()));
		restaurantsList.add(new Restaurant("Zen Japanese Restaurant", "101-2232 Marine Dr", cityDAO.findById(6).get(), areaDAO.findById(17).get()));
		
		
		// Yaletown
		restaurantsList.add(new Restaurant("Cioppino's Mediterranean Grill", "1133 Hamilton St", cityDAO.findById(1).get(), areaDAO.findById(18).get()));
		restaurantsList.add(new Restaurant("Frankie's Italian Kitchen & Bar", "765 Beatty St", cityDAO.findById(1).get(), areaDAO.findById(18).get()));
		restaurantsList.add(new Restaurant("Giardino Restaurant", "1328 Hornby St", cityDAO.findById(1).get(), areaDAO.findById(18).get()));
		restaurantsList.add(new Restaurant("La Pentola", "350 Davie St, Vancouver", cityDAO.findById(1).get(), areaDAO.findById(18).get()));
		restaurantsList.add(new Restaurant("La Terrazza", "1088 Cambie St", cityDAO.findById(1).get(), areaDAO.findById(18).get()));
		restaurantsList.add(new Restaurant("Lupo Restaurant & Vinoteca", "869 Hamilton St", cityDAO.findById(1).get(), areaDAO.findById(18).get()));
		restaurantsList.add(new Restaurant("Megabite", "1005 Granville St", cityDAO.findById(1).get(), areaDAO.findById(18).get()));
		restaurantsList.add(new Restaurant("Provence Marinaside", "1177 Marinaside Crescent", cityDAO.findById(1).get(), areaDAO.findById(18).get()));
		restaurantsList.add(new Restaurant("West Oak", "1035 Mainland St", cityDAO.findById(1).get(), areaDAO.findById(18).get()));
		restaurantsList.add(new Restaurant("Banter Room", "1039 Mainland St", cityDAO.findById(1).get(), areaDAO.findById(18).get()));
		
		
		for(Restaurant rest : restaurantsList) {
			restDAO.save(rest);
		}
		
		return "Database populated";
	}
	
	@Autowired
	DeliveryDAO deliveryDAO;
	
	@GetMapping("/seed2")
	@ResponseBody
	public String seed2() {
		
		/**************** Deliveries ***************/
		ArrayList<Delivery> deliveriesList = new ArrayList<>();
		
		Date date = new Date(new Date().getTime());

		Date todaysDate = null;
		try {
			todaysDate = new SimpleDateFormat("yyyy-MM-dd").parse("2020-07-10");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Random random = new Random();
		List<String> timings =Arrays.asList("Early", "Midday", "Afternoon");
	
		for (int i = 0; i < 50; i++) {
			deliveriesList.add(new Delivery(restDAO.findById(random.nextInt(169)+1).get(), todaysDate, timings.get(random.nextInt(3)), ""));
		}
		
		for(Delivery delivery : deliveriesList) {
			deliveryDAO.save(delivery);
		}
		
		
		return null;
	
	}

}
