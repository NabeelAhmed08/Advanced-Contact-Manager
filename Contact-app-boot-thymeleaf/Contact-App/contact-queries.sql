 use cts_db;

drop table if exists contact_app ;
  create table contact_app(
  id integer primary key auto_increment,
  name varchar(15),
  pno  varchar(15),
  email varchar(30),
  location varchar(15)
  );

 insert INTO 
	contact_app (name, pno,email,location )
    VALUES
	('Nabeel','9490579822','nab@gmail.com','Telangana'),
    ('Abeel','8490579822','asdf@gmail.com','Andhra'),
    ('beelna','7490579822','adff@gmail.com','TN'),
    ('beael','7890579822','wert@gmail.com','Banglore'),
    ('john','7890579822','qwer@gmail.com','UP'),
    ('alex','7894479822','zxcvb@gmail.com',Null),
    ('bob','9890579822','werty@gmail.com','Telangana'),
    ('catie','8890579822','awe456@gmail.com','Andhra'),
    ('david','6890579822','23rt@gmail.com','TN'),
    ('egon','7890575822','23rtyhy@gmail.com','Telangana'),
    ('flex','7890979822','wert45@gmail.com','Andhra'),
    ('gulf','7896579822','werg4678@gmail.com','TN'),
    ('hannah','5590579822','9uytrf@gmail.com','Telangana')
    ; 
    
   select *from contact_app;
   
   