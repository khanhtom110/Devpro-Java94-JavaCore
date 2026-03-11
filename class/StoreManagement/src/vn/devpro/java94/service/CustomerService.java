package vn.devpro.java94.service;

import java.util.List;

import vn.devpro.java94.database.StoreDb;
import vn.devpro.java94.model.Customer;

public class CustomerService {

	public static List<Customer> findAll() {
		// TODO Auto-generated method stub
		return StoreDb.getCustomers();
	}

	public static boolean existsByName(String name) {
		for (Customer customer : StoreDb.getCustomers()) {
			if (name.trim().equalsIgnoreCase(customer.getName().trim())) {
				return true;
			}
		}
		return false;
	}

	public static void save(Customer customer) {
		StoreDb.getCustomers().add(customer);
	}

	public static int findByCode(String code) {
		for (int i = 0; i < StoreDb.getCustomers().size(); i++) {
			if (code.trim().equalsIgnoreCase(StoreDb.getCustomers().get(i).getCode())) {
				return i;
			}
		}
		return -1;
	}

	public static Customer getByCode(String code) {
		for (int i = 0; i < StoreDb.getCustomers().size(); i++) {
			if (code.trim().equalsIgnoreCase(StoreDb.getCustomers().get(i).getCode())) {
				return StoreDb.getCustomers().get(i);
			}
		}
		return null;
	}

	public static Customer getById(int id) {
		for (Customer customer : StoreDb.getCustomers()) {
			if (customer.getId() == id) {
				return customer;
			}
		}
		return null;
	}

	public static void update(int index, Customer customer) {
		StoreDb.getCustomers().set(index, customer);
	}

	public static void delete(int index) {
		StoreDb.getCustomers().remove(index);
	}
}
