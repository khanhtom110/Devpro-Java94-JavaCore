package vn.devpro.lesson07;

public class Db {
	private static Job[] jobs = { new Job("CV01", "Ke toan"), new Job("CV02", "Lai xe"),
			new Job("CV03", "Truong phong"), new Job("CV04", "Shipper"), new Job("CV05", "Giam doc") };
	private static Worker[] workers = { new Worker("E001", "Nguyen Van", "A", new Date(1, 1, 2000), "CV01", 2, 20),
			new Worker("E002", "Nguyen Van", "C", new Date(2, 1, 2000), "CV02", 1, 20),
			new Worker("E003", "Nguyen Van", "B", new Date(5, 1, 2000), "CV05", 2, 0),
			new Worker("E004", "Nguyen Van", "E", new Date(10, 1, 2000), "CV04", 3, 0),
			new Worker("E005", "Nguyen Van", "D", new Date(19, 1, 2000), "CV04", 1, 18) };

	// Them phan tu moi
	public static void insertWorker(int index, Worker newWorker) {
		if (index < 0 || index >= workers.length) {
			System.out.println("Vi tri khong hop le");
			return;
		}
		Worker[] w = workers.clone();
		workers = new Worker[workers.length + 1];
		for (int i = 0; i < index; i++) {
			workers[i] = w[i];
		}
		workers[index] = newWorker;
		for (int i = index + 1; i < workers.length; i++) {
			workers[i] = w[i - 1];
		}
	}

	public static Job[] getJobs() {
		return jobs;
	}

	public static void setJobs(Job[] jobs) {
		Db.jobs = jobs;
	}

	public static Worker[] getWorkers() {
		return workers;
	}

	public static void setWorkers(Worker[] workers) {
		Db.workers = workers;
	}

	public static Job findJobByCode(String jobCode) {
		for (Job job : jobs) {
			if (job.getCode().equals(jobCode)) {
				return job;
			}
		}
		return null;
	}
}
