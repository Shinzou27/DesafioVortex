import java.util.ArrayList;

public class Searcher {
    ArrayList<Worker> workers;
    ArrayList<Job> jobs;

    public Searcher(ArrayList<Worker> workers, ArrayList<Job> jobs) {
        this.workers = workers;
        this.jobs = jobs;
    }

    public boolean hasCode(int code) {
        for (Worker Worker : workers) {
            if (Worker.getCode() == code) {
                return true;
            }
        }
        return false;
    }

    public int workersPerJob(Job job) {
        int counter = 0;
        for (Worker Worker : workers) {
            if (Worker.getJobCode() == job.getCode()) {
                counter++;
            }
        }
        return counter;
    }

    public Job getJobByCode(int jobCode) {
        for (Job job : jobs) {
            if (job.getCode() == jobCode) {
                return job;
            }
        }
        return null;
    }

    public Worker getWorkerByCode(int code) {
        for (Worker worker : workers) {
            if (worker.getCode() == code) {
                return worker;
            }
        }
        return null;
    }
}
