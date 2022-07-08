package net.iurutevgenii.streamapi.util;

import net.iurutevgenii.streamapi.model.Worker;
import net.iurutevgenii.streamapi.model.WorkerSpecialty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OldApproachUtil {
    // Получение начального списка работников
    public static List<Worker> getWorkers() {
        List<Worker> result = new ArrayList<>();
        result.add(new Worker("Ivan Ivanov", new BigDecimal(5000), WorkerSpecialty.ENGINEER));
        result.add(new Worker("Alexander Alexandrov", new BigDecimal(4000), WorkerSpecialty.ENGINEER));
        result.add(new Worker("Sergey Sergeev", new BigDecimal(3000), WorkerSpecialty.DEVOPS));
        result.add(new Worker("Fedor Fedorov", new BigDecimal(2000), WorkerSpecialty.DEVOPS));
        result.add(new Worker("Kirill Kirillov", new BigDecimal(10000), WorkerSpecialty.MANAGER));
        result.add(new Worker("Petr Petrov", new BigDecimal(10000), WorkerSpecialty.MANAGER));
        return result;
    }

    // Поиск по специальности
    public static List<Worker> filterBySpecialty(List<Worker> workers, WorkerSpecialty specialty) {
        List<Worker> result = new ArrayList<>();
        for (Worker worker : workers) {
            if (worker.getSpecialty().equals(specialty)) {
                result.add(worker);
            }
        }
        return result;
    }

    // Проверка совпадений все работники инженеры
    public static boolean matchAllEngineers(List<Worker> workers) {
        for (Worker worker : workers) {
            if (!worker.getSpecialty().equals(WorkerSpecialty.ENGINEER)) {
                return false;
            }
        }
        return true;
    }

    // Проверка совпадений - есть ли инженеры
    public static boolean matchAnyEnginner(List<Worker> workers) {
        for (Worker worker : workers) {
            if (worker.getSpecialty().equals(WorkerSpecialty.ENGINEER)) {
                return true;
            }
        }
        return false;
    }

    // Проверка совпадений - все ли имеют ЗП выше указанной
    public static boolean matchAllSalaryMoreThen(List<Worker> workers, BigDecimal salary) {
        for (Worker worker : workers) {
            if (worker.getSalary().compareTo(salary) < 0) {
                return false;
            }
        }
        return true;
    }

    // Проверка совпадений - никто не имеет ЗП выше указанной
    public static boolean matchNoneSalaryMoreThen(List<Worker> workers, BigDecimal salary) {
        for (Worker worker : workers) {
            if (worker.getSalary().compareTo(salary) > 0) {
                return false;
            }
        }
        return true;
    }

    // Вывод в консоль
    public static void printWorkers(List<Worker> workers) {
        workers.forEach(System.out::println);
    }

    // Группировка работников по специальности
    public static Map<WorkerSpecialty, List<Worker>> groupBySpecialty(List<Worker> workers) {
        Map<WorkerSpecialty, List<Worker>> result = new HashMap<>();
        WorkerSpecialty[] specialties = WorkerSpecialty.class.getEnumConstants();
        for (WorkerSpecialty specialty : specialties) {
            result.put(specialty, new ArrayList<>());
        }
        return result;
    }
}
