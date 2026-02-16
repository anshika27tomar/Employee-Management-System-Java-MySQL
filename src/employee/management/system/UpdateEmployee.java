

package employee.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class UpdateEmployee extends JFrame implements ActionListener{
    JTextField tfeducation,tfaddr,tfphn,tffname,tfan,tfdesig,tfem,tfsal;
   String empid;
     
        JLabel lbleid;
    JButton add,back;
   
    UpdateEmployee(String empid){
        this.empid=empid;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading=new JLabel("Update Employe Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        JLabel labelname=new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);
        
      JLabel lblname=new JLabel();
        lblname.setBounds(200,150,150,30);
        add(lblname);
        
        
        JLabel labelfname=new JLabel("Father's Name");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelfname);
        
        tffname=new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
        
          
        JLabel labeldob=new JLabel("Date of Birth");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldob);
        
       JLabel lbldob=new JLabel();
      lbldob.setBounds(200,200,150,30);
       add(lbldob);
       
         
        JLabel labelsal=new JLabel("Salary");
        labelsal.setBounds(400,200,150,30);
        labelsal.setFont(new Font("serif",Font.PLAIN,20));
        add(labelsal);
        
         tfsal=new JTextField();
        tfsal.setBounds(600,200,150,30);
        add(tfsal);
        
         JLabel labeladdr=new JLabel("Address");
        labeladdr.setBounds(50,250,150,30);
        labeladdr.setFont(new Font("serif",Font.PLAIN,20));
        add(labeladdr);
      
        tfaddr=new JTextField();
        tfaddr.setBounds(200,250,150,30);
        add(tfaddr);
          
        JLabel labelphn=new JLabel("Phone");
        labelphn.setBounds(400,250,150,30);
        labelphn.setFont(new Font("serif",Font.PLAIN,20));
        add(labelphn);
        
        tfphn=new JTextField();
        tfphn.setBounds(600,250,150,30);
        add(tfphn);
        
       
        JLabel labelemail=new JLabel("Email");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("serif",Font.PLAIN,20));
        add(labelemail);
        
       tfem=new JTextField();
        tfem.setBounds(200,300,150,30);
        add(tfem);
        
          
        JLabel labelhe=new JLabel("Highest Education");
        labelhe.setBounds(400,300,150,30);
        labelhe.setFont(new Font("serif",Font.PLAIN,20));
        add(labelhe);
       
        tfeducation=new JTextField();
          tfeducation.setBounds(600,300,150,30);
          add(tfeducation);
          
         JLabel labeldesig=new JLabel("Designation");
        labeldesig.setBounds(50,350,150,30);
        labeldesig.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldesig);
        
      tfdesig=new JTextField();
        tfdesig.setBounds(200,350,150,30);
        add(tfdesig);
          
        JLabel labelan=new JLabel("Aadhar Number");
        labelan.setBounds(400,350,150,30);
        labelan.setFont(new Font("serif",Font.PLAIN,20));
        add(labelan);
    JLabel lblaadhar=new JLabel();
       lblaadhar.setBounds(600,350,150,30);
        add(lblaadhar);
       
        JLabel labeleid=new JLabel("Employee ID:");
        labeleid.setBounds(50,400,150,30);
        labeleid.setFont(new Font("serif",Font.PLAIN,20));
        add(labeleid);
                
    lbleid=new JLabel();
        lbleid.setBounds(200,400,150,30);
        lbleid.setFont(new Font("serif",Font.PLAIN,20));
        add(lbleid);
        
        try{
            conn c=new conn();
            String query="select * from employee where empid = '"+empid+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfaddr.setText(rs.getString("address"));
                tfsal.setText(rs.getString("salary"));
               tfphn.setText(rs.getString("phone"));
             tfem.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
             lblaadhar.setText(rs.getString("aadhar"));
                tfdesig.setText(rs.getString("designation"));  
                     lbleid.setText(rs.getString("empid")); 
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
           add=new JButton("Update Details");
         add.setBounds(250,550,150,40);
         add.addActionListener(this);
         add.setBackground(Color.BLACK);
         add.setForeground(Color.WHITE);
         add(add);
         
         back=new JButton("Back");
         back.setBounds(450,550,150,40);
         back.addActionListener(this);
         back.setBackground(Color.BLACK);
         back.setForeground(Color.WHITE);
         add(back);
         
         
       
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
           // String name=tfname.getText();
            String fname=tffname.getText();
            //String dob=((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String salary=tfsal.getText();
            String address=tfaddr.getText();
            String phone=tfphn.getText();
              String email=tfem.getText();
                String education=tfeducation.getText();
                  String designation=tfdesig.getText();
                   
                      try{
                          conn con=new conn();
                          String query="update employee set fname='"+fname+"',salary='"+salary+"',address='"+address+"',phone='"+phone+"',email='"+email+"',education='"+education+"',designation='"+designation+"' where empid='"+empid+"'";
                          con.s.executeUpdate(query);
                          JOptionPane.showMessageDialog(null,"Details updated successfully");
                          setVisible(false);
                          new Home();
                      }catch(Exception e){
                          e.printStackTrace();
                      }
        }else
        {
            setVisible(false);
            new Home();
        }
    }
    public static void main(String args[]){
       new UpdateEmployee("");
    }
}
