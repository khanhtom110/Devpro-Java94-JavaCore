package vn.devpro.java94.service;

import java.util.List;

import vn.devpro.java94.database.StoreDb;
import vn.devpro.java94.model.Provider;

public class ProviderService {
	public static List<Provider> findAll() {
		return StoreDb.getProviders();
	}

	public static boolean existsByName(String name) {
		for (Provider provider : StoreDb.getProviders()) {
			if (name.trim().equalsIgnoreCase(provider.getName().trim())) {
				return true;
			}
		}
		return false;
	}

	public static void save(Provider provider) {
		StoreDb.getProviders().add(provider);
	}

	public static int findByCode(String code) {
		for (int i = 0; i < StoreDb.getProviders().size(); i++) {
			if (code.trim().equalsIgnoreCase(StoreDb.getProviders().get(i).getCode())) {
				return i;
			}
		}
		return -1;
	}

	public static Provider getByCode(String code) {
		for (int i = 0; i < StoreDb.getProviders().size(); i++) {
			if (code.trim().equalsIgnoreCase(StoreDb.getProviders().get(i).getCode())) {
				return StoreDb.getProviders().get(i);
			}
		}
		return null;
	}

	public static Provider getById(int id) {
		for (Provider provider : StoreDb.getProviders()) {
			if (provider.getId() == id) {
				return provider;
			}
		}
		return null;
	}

	public static void update(int index, Provider provider) {
		StoreDb.getProviders().set(index, provider);
	}

	public static void delete(int index) {
		StoreDb.getProviders().remove(index);
	}

}
