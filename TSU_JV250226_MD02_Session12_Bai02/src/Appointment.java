
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Appointment {
    private String appointmentId;
    private String patientName;
    private String phoneNumber;
    private LocalDate appointmentDate;
    private String doctor;

    public Appointment() {}

    public Appointment(String appointmentId, String patientName, String phoneNumber, LocalDate appointmentDate, String doctor) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.phoneNumber = phoneNumber;
        this.appointmentDate = appointmentDate;
        this.doctor = doctor;
    }

    public String getAppointmentId() { return appointmentId; }
    public void setAppointmentId(String appointmentId) { this.appointmentId = appointmentId; }

    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public LocalDate getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(LocalDate appointmentDate) { this.appointmentDate = appointmentDate; }

    public String getDoctor() { return doctor; }
    public void setDoctor(String doctor) { this.doctor = doctor; }

    public void inputData(Scanner scanner) {
        System.out.print("Nhập tên bệnh nhân (10-50 ký tự): ");
        while (true) {
            String name = scanner.nextLine();
            if (name.length() >= 10 && name.length() <= 50) {
                this.patientName = name;
                break;
            } else {
                System.out.print("Tên không hợp lệ. Nhập lại: ");
            }
        }

        System.out.print("Nhập số điện thoại (bắt đầu bằng 0 và có 10 số): ");
        while (true) {
            String phone = scanner.nextLine();
            if (Pattern.matches("0\\d{9}", phone)) {
                this.phoneNumber = phone;
                break;
            } else {
                System.out.print("Số điện thoại không hợp lệ. Nhập lại: ");
            }
        }

        System.out.print("Nhập ngày hẹn (dd/MM/yyyy): ");
        while (true) {
            String dateStr = scanner.nextLine();
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                this.appointmentDate = LocalDate.parse(dateStr, formatter);
                break;
            } catch (Exception e) {
                System.out.print("Ngày không hợp lệ. Nhập lại: ");
            }
        }

        System.out.print("Nhập tên bác sĩ (tối đa 200 ký tự): ");
        while (true) {
            String doc = scanner.nextLine();
            if (doc.length() <= 200) {
                this.doctor = doc;
                break;
            } else {
                System.out.print("Tên bác sĩ quá dài. Nhập lại: ");
            }
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("Mã: %s | Bệnh nhân: %s | SĐT: %s | Ngày hẹn: %s | Bác sĩ: %s",
                appointmentId, patientName, phoneNumber, appointmentDate.format(formatter), doctor);
    }
}
