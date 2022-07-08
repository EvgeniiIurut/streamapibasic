package net.iurutevgenii.streamapi.util;

import net.iurutevgenii.streamapi.model.Worker;
import net.iurutevgenii.streamapi.model.WorkerSpecialty;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPIUtil {
    // Получение начального списка рабочих
    public static List<Worker> getWorkers() {
        return List.of(
                new Worker("Ivan Ivanov", new BigDecimal(5000), WorkerSpecialty.ENGINEER),
                new Worker("Alexander Alexandrov", new BigDecimal(4000), WorkerSpecialty.ENGINEER),
                new Worker("Sergey Sergeev", new BigDecimal(3000), WorkerSpecialty.DEVOPS),
                new Worker("Fedor Fedorov", new BigDecimal(2000), WorkerSpecialty.DEVOPS),
                new Worker("Kirill Kirillov", new BigDecimal(10000), WorkerSpecialty.MANAGER),
                new Worker("Petr Petrov", new BigDecimal(10000), WorkerSpecialty.MANAGER)
        );
    }

    // Поиск по специальности работника
    public static List<Worker> filterBySpecialty(List<Worker> specialists, WorkerSpecialty specialty) {
        return specialists.stream()
                .filter(specialist -> specialist.getSpecialty().equals(specialty))
                .collect(Collectors.toList());
    }

    // Сортировка по имени работника по возрастанию
    public static List<Worker> sortWorkersByNameAsc(List<Worker> specialists) {
        return specialists.stream()
                .sorted(Comparator.comparing(Worker::getName))
                .collect(Collectors.toList());
    }

    // Сортировка по имени работника по убыванию
    public static List<Worker> sortWorkersByNameDesc(List<Worker> specialists) {
        return specialists.stream()
                .sorted(Comparator.comparing(Worker::getName).reversed())
                .collect(Collectors.toList());
    }

    // Проверка совпадений все работники - инженеры
    public static boolean matchAllEngineers(List<Worker> specialists) {
        return specialists.stream().allMatch(specialist -> specialist.getSpecialty().equals(WorkerSpecialty.ENGINEER));
    }

    // Проверка совпадений - есть ли инженеры
    public static boolean matchAnyEngineer(List<Worker> specialists) {
        return specialists.stream().anyMatch(specialist -> specialist.getSpecialty().equals(WorkerSpecialty.ENGINEER));
    }

    // Проверка совпадений - все ли имеют ЗП выше указанной
    public static boolean matchAllSalaryMoreThen(List<Worker> specialists, BigDecimal salary) {
        return specialists.stream().allMatch(specialist -> specialist.getSalary().compareTo(salary) > 0);
    }

    // Проверка совпадений - никто не имеет ЗП выше указанной
    public static boolean matchNoneSalaryMoreThen(List<Worker> specialists, BigDecimal salary) {
        return specialists.stream().noneMatch(specialist -> specialist.getSalary().compareTo(salary) > 0);
    }

    // Вывод в консоль
    public static void printWorkers(List<Worker> specialists) {
        specialists.forEach(System.out::println);
    }

    // Поиск работника с максимальной ЗП
    public static Worker findWithMaxSalary(List<Worker> specialists) {
        return specialists.stream().max(Comparator.comparing(Worker::getSalary)).orElse(null);
    }

    // Поиск работника с минимальной ЗП
    public static Worker findWithMinSalary(List<Worker> specialists) {
        return specialists.stream().min(Comparator.comparing(Worker::getSalary)).orElse(null);
    }

    // Группировка работников по специальности
    public static Map<WorkerSpecialty, List<Worker>> groupBySpecialty(List<Worker> specialists) {
        return specialists.stream().collect(Collectors.groupingBy(Worker::getSpecialty));
    }
}
