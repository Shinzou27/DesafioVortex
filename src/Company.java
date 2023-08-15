import java.util.ArrayList;
import java.util.Scanner;

public class Company {
    protected String name;
    protected ArrayList<Worker> workers;
    protected ArrayList<Job> jobs;
    protected Searcher searcher;

    private Scanner prompt;

    public Company(String name) {
        this.name = name;
        this.workers = new ArrayList<>();
        this.jobs = new ArrayList<>();
        this.searcher = new Searcher(workers, jobs);
        this.prompt = new Scanner(System.in);
    }

    public void addJob() {
        this.dividerLine();
        System.out.println("Digite o valor em Reais do cargo a ser adicionado.");
        float value = 0;
        try {
            value = Float.parseFloat(prompt.nextLine());
            if (value > 0) {
                Job job = new Job(jobs.size(), value);
                jobs.add(job);
                System.out.println("Cargo adicionado com sucesso!");
            } else {
                System.out.println("Valor inválido. Por favor, insira um valor positivo.");
            }
            this.dividerLine();
        } catch (Exception e) {
            System.out.println("O código inserido não é um número. Tente novamente.");
        }
    }

    public void hire() {
        this.dividerLine();
        System.out.println("Digite o nome do funcionário.");
        String name = prompt.nextLine();

        System.out.printf("Qual é o código de funcionário do(a) %s?\n", name);
        int code = 0;

        while (searcher.hasCode(code) || code <= 0) {
            try {
                code = Integer.parseInt(prompt.nextLine());
            } catch (Exception e) {
                System.out.println("O código inserido não é um número. Tente novamente.");
            }
            if (searcher.hasCode(code) || code <= 0) {
                System.out.println(
                        "Este código está indisponível. Insira um código positivo e/ou que não tenha sido adicionado anteriormente.");
            }
        }

        System.out.printf("Qual é o cargo de %s na %s?\n", name, this.name);
        for (Job job : jobs) {
            System.out.println(job);
        }
        int jobCode = jobs.size() + 1;

        while (jobCode >= jobs.size() || jobCode < 0) {
            try {
                jobCode = Integer.parseInt(prompt.nextLine());
            } catch (Exception e) {
                System.out.println("O código inserido não é um número. Tente novamente.");
            }
            if (jobCode >= jobs.size() || jobCode < 0) {
                System.out.println("Código de cargo inválido. Insira um código que já exista no sistema da empresa.");
            }
        }

        Worker worker = new Worker(name, code, jobCode);
        workers.add(worker);
        System.out.println("Funcionário adicionado com sucesso!");
        this.dividerLine();
    }

    public void report() {
        this.dividerLine();
        System.out.printf("Relatório de funcionários da %s\n", this.name);
        for (Worker worker : workers) {
            Job workerJob = searcher.getJobByCode(worker.getJobCode());
            System.out.println(worker);
            System.out.println(workerJob);
        }
        this.dividerLine();
    }

    public void promote(int code) {
        this.dividerLine();
        Worker worker = searcher.getWorkerByCode(code);
        System.out.println("Insira o cargo que você deseja atribuir a este funcionário.");
        for (Job job : jobs) {
            System.out.println(job);
        }
        int newJob = worker.getJobCode();
        while (worker.getJobCode() == newJob) {
            try {
                newJob = Integer.parseInt(prompt.nextLine());
                if (newJob != worker.getJobCode()) {
                    worker.setJobCode(newJob);
                    System.out.println("Funcionário promovido com sucesso!");
                    return;
                } else {
                    System.out.println("Funcionário já exerce este cargo.");
                }
            } catch (Exception e) {
                System.out.println("O código inserido não é um número. Tente novamente.");
            }
        }
    }

    public void fire(int code) {
        this.dividerLine();
        Worker worker = searcher.getWorkerByCode(code);
        if (worker != null) {
            System.out.printf("Você tem certeza que deseja demitir o(a) funcionário(a) %s? (S/N)\n", worker.getName());
            String decision = prompt.nextLine();
            if (decision.equalsIgnoreCase("S")) {
                workers.remove(worker);
                System.out.println("Funcionário demitido com sucesso.");
                this.dividerLine();
            } else if (!decision.equalsIgnoreCase("N")) {
                System.out.println("Comando desconhecido.");
            } else {
                System.out.println("Operação cancelada.");
            }
        }
    }

    public void payroll(int code) {
        Job job = searcher.getJobByCode(code);
        if (job != null) {
            this.dividerLine();
            System.out.printf("Folha de gastos para o cargo %d: R$%.2f\n", job.getCode(),
                    (job.getValue() * searcher.workersPerJob(job)));
            this.dividerLine();
        } else {
            System.out.println("Código de cargo inválido. Insira um código que já exista no sistema da empresa.");
        }
    }

    private void dividerLine() {
        System.out.println("----------------------------------------------");
    }
}
