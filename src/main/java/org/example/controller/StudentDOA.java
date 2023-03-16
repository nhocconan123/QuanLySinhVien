package org.example.controller;

import org.example.connection.MyConnection;
import org.example.model.Students;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDOA {
    public List<Students> getAll1()
    {
        List<Students> productsList=new ArrayList<>();
        try{
            Connection conn= MyConnection.getConnection();
            String sql="select * from Students";

            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);

            while (rs.next())
            {
                Students students= new Students();
                students.setId(rs.getString("id"));
                students.setFull_name(rs.getString("full_name"));
                String gioitinh="nu";

                students.setGender(rs.getInt("gender"));
                students.setAddress(rs.getString("address"));
                productsList.add(students);
            }
            stmt.close();
            conn.close();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return productsList;
    }
    public Students getById(String id) {
        final String sql = "SELECT * FROM `Students` WHERE  `id` = '"+id+"'";
        Students s = null;

        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                s = new Students();
                s.setId(rs.getString("id"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
    public void insertStudent(Students student)
    {
        Students tmp=getById(student.getId());
        if(tmp==null)
        {
            try{
                Connection conn= MyConnection.getConnection();
                String sql= "INSERT INTO `bkacad`.`students` (`id`, `full_name`, `gender`, `ngaysinh`, `phone`, `email`, `address`, `marks`) VALUES ('"+student.getId()+"', '"+student.getFull_name()+"', '"+student.getGender()+"', '"+student.getNgaysinh()+"', '"+student.getPhone()+"', '"+student.getEmail()+"', '"+student.getAddress()+"', '"+student.getMarks()+"')";
            Statement stmt=conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Thêm thất bại");
            }
            stmt.close();
            conn.close();
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else {
            System.out.println(" da ton tai ma sinh vien nay trong he thong");
        }

    }
    public void update(Students p,String id)
    {
        Students tmp=getById(id);
        if(tmp==null)
        {
            System.out.println("cap nhat that bai");
            return;
        }
        try {
            Connection conn = MyConnection.getConnection();
            String sql="UPDATE `bkacad`.`students` SET  `full_name` = '"+p.getFull_name()+"', `gender` = '"+p.getGender()+"', `ngaysinh` = '"+p.getNgaysinh()+"', `phone` = '"+p.getPhone()+"', `email` = '"+p.getEmail()+"', `address` = '"+p.getAddress()+"', `marks` = '"+p.getMarks()+"' WHERE (`id` = '"+id+"')";
            Statement stmt=conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Cập nhật thất bại");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delete(String id)
    {
        Students tmp=getById(id);
        if(tmp==null)
        {
            System.out.println("cap nhat that bai");
            return;
        }
        try {
            Connection conn= MyConnection.getConnection();
            String sql="DELETE FROM `Students` WHERE (`id` = '"+id+"')";
            Statement stmt=conn.createStatement();
            long rs= stmt.executeUpdate(sql);
            if(rs==0)
            {
                System.out.println("xoa that bai");
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
