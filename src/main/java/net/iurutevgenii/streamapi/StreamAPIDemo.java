package net.iurutevgenii.streamapi;

import net.iurutevgenii.streamapi.model.Worker;
import net.iurutevgenii.streamapi.model.WorkerSpecialty;
import net.iurutevgenii.streamapi.util.StreamAPIUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


public class StreamAPIDemo {
    public static void main(String[] args) {
        //List<Worker> specialists = OldApproachUtil.getSpecialists();
        List<Worker> specialists = StreamAPIUtil.getWorkers();

        // Filter
//        List<Worker> engineers = OldApproachUtil.filterBySpecialty(specialists, WorkerSpecialty.ENGINEER);
        List<Worker> engineers = StreamAPIUtil.filterBySpecialty(specialists, WorkerSpecialty.ENGINEER);
        StreamAPIUtil.printWorkers(engineers);

        // Sorting
        List<Worker> sortedSpecialistsAsc = StreamAPIUtil.sortWorkersByNameAsc(specialists);
        List<Worker> sortedSpecialistsDesc = StreamAPIUtil.sortWorkersByNameDesc(specialists);
        StreamAPIUtil.printWorkers(sortedSpecialistsAsc);
        StreamAPIUtil.printWorkers(sortedSpecialistsDesc);

        // Max salary
        Worker withMaxSalary = StreamAPIUtil.findWithMaxSalary(specialists);
        System.out.println(withMaxSalary);
        // Min salary
        Worker withMinSalary = StreamAPIUtil.findWithMinSalary(specialists);
        System.out.println(withMinSalary);

        // Grouping
        Map<WorkerSpecialty, List<Worker>> groupedBySpecialty = StreamAPIUtil.groupBySpecialty(specialists);
        System.out.println(groupedBySpecialty);

        // All engineers
//        boolean allEngineers = OldApproachUtil.matchAllEngineers(specialists);
        boolean allEngineers = StreamAPIUtil.matchAllEngineers(specialists);
        System.out.println(allEngineers);

        // Any engineers
//        boolean anyEngineer = OldApproachUtil.matchAnyEnginner(specialists);
        boolean anyEngineer = StreamAPIUtil.matchAnyEngineer(specialists);
        System.out.println(anyEngineer);

        // All salary more then
        //boolean allSalaryMoreThen1000 = OldApproachUtil.matchAllSalaryMoreThen(specialists, new BigDecimal(10000));
        boolean allSalaryMoreThen1000 = StreamAPIUtil.matchAllSalaryMoreThen(specialists, new BigDecimal(10000));
        System.out.println(allSalaryMoreThen1000);

        // No one with salary more then
//        boolean noOneWithSalaryMoreThen10000 = OldApproachUtil.matchNoneSalaryMoreThen(specialists, new BigDecimal(10000));
        boolean noOneWithSalaryMoreThen10000 = StreamAPIUtil.matchNoneSalaryMoreThen(specialists, new BigDecimal(10000));
        System.out.println(noOneWithSalaryMoreThen10000);
    }
}