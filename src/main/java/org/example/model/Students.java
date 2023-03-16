package org.example.model;

public class Students  implements Comparable<Students> {
private String id;
private String full_name;
private long gender;
private String ngaysinh;
private String phone;
private String email;

private String address;
private double marks;

    public Students() {
    }

    public Students(String id, String full_name, long gender, String ngaysinh, String phone, String email, String address, double marks) {
        this.id = id;
        this.full_name = full_name;
        this.gender = gender;
        this.ngaysinh = ngaysinh;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.marks = marks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public long getGender() {
        return gender;
    }

    public void setGender(long gender) {
        this.gender = gender;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id='" + id + '\'' +
                ", full_name='" + full_name + '\'' +
                ", gender=" + gender +
                ", ngaysinh='" + ngaysinh + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", marks=" + marks +
                '}';
    }

    @Override
    public int compareTo(Students o) {
        return 0;
    }
}
