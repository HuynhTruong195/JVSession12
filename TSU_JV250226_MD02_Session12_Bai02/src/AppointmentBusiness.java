
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class AppointmentBusiness {
    private final List<Appointment> appointmentList = new ArrayList<>();
    private final Set<String> generatedIds = new HashSet<>();
    private final Scanner scanner = new Scanner(System.in);

    private String generateUniqueId() {
        String id;
        do {
            id = UUID.randomUUID().toString().substring(0, 6).toUpperCase();
        } while (generatedIds.contains(id));
        generatedIds.add(id);
        return id;
    }

    public void addAppointment() {
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(generateUniqueId());
        appointment.inputData(scanner);
        appointmentList.add(appointment);
        System.out.println(" Lịch hẹn đã được thêm.");
    }

    public void displayAppointments() {
        appointmentList.stream()
                .sorted(Comparator.comparing(Appointment::getAppointmentDate))
                .forEach(System.out::println);
    }

    public void searchByPatientName() {
        System.out.print("Nhập tên bệnh nhân cần tìm: ");
        String keyword = scanner.nextLine().toLowerCase();
        List<Appointment> result = appointmentList.stream()
                .filter(a -> a.getPatientName().toLowerCase().contains(keyword))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy lịch hẹn nào.");
        } else {
            result.forEach(System.out::println);
        }
    }

    public void updateAppointment() {
        System.out.print("Nhập mã lịch hẹn cần cập nhật: ");
        String id = scanner.nextLine();
        Optional<Appointment> optional = appointmentList.stream()
                .filter(a -> a.getAppointmentId().equalsIgnoreCase(id)).findFirst();

        optional.ifPresentOrElse(ap -> {
            System.out.println("Cập nhật thông tin lịch hẹn:");
            ap.inputData(scanner);
            System.out.println(" Cập nhật thành công.");
        }, () -> System.out.println(" Không tìm thấy mã lịch hẹn."));
    }

    public void deleteAppointment() {
        System.out.print("Nhập mã lịch hẹn cần xoá: ");
        String id = scanner.nextLine();
        Optional<Appointment> optional = appointmentList.stream()
                .filter(a -> a.getAppointmentId().equalsIgnoreCase(id)).findFirst();

        optional.ifPresentOrElse(ap -> {
            System.out.print("Bạn có chắc muốn xoá? (Y/N): ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("Y")) {
                appointmentList.remove(ap);
                generatedIds.remove(ap.getAppointmentId());
                System.out.println(" Đã xoá lịch hẹn.");
            } else {
                System.out.println(" Huỷ thao tác xoá.");
            }
        }, () -> System.out.println(" Không tìm thấy mã lịch hẹn."));
    }

    public void statistic() {
        System.out.println(" Tổng số lịch hẹn: " + appointmentList.size());
        Map<String, Long> countByDoctor = appointmentList.stream()
                .collect(Collectors.groupingBy(Appointment::getDoctor, Collectors.counting()));

        System.out.println("🩺 Số lịch hẹn theo từng bác sĩ:");
        countByDoctor.forEach((doctor, count) ->
                System.out.println(" - " + doctor + ": " + count + " lịch hẹn"));
    }
}
