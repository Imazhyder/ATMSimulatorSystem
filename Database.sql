create database bankmanagementsystem;

use bankmanagementsystem;

create table signup(formno varchar(20), name  varchar(20), f_name varchar(20), gender varchar(20), email varchar(30), marital_status varchar(20), address varchar(40), city varchar(20), pincode varchar(20), state varchar(20));

show tables;

Select * from signup;

create table signuptwo(formno varchar(20), religion varchar(20), category varchar(20), income varchar(20), education varchar(20), occupation varchar(20), cnic varchar(20), seniorcitizen varchar(20), existingaccount varchar(20)); 

create table signupthree(formno varchar(20), accountType varchar(20), cardnumber varchar(25), pinnumber varchar(10), facility varchar(100));

select * from signupthree;

create table login(formno varchar(20), cardnumber varchar(20), pin varchar(20));

create table bank(pin varchar(10), date varchar(50), type varchar (20), amount varchar(20)); 