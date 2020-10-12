--select * from state;
insert into state(name,uf) values('ceará','ce');

--select * from city;
insert into city(name,state_id) values('sobral',1);
insert into city(name,state_id) values('fortaleza',1);

--select * from address;
insert into address(complement,neighborhood,number,street,city_id) values('perto do mucambinho','padre palhano',320,'rua do canal',1);
insert into address(complement,neighborhood,number,street,city_id) values('proximo aos bradesco','centro',117,'av. oriano mendes',2);
insert into address(complement,neighborhood,number,street,city_id) values('vizinho ao posto de saude','alto do cristo',263,'rua padre jose',1);

--select * from patient;
insert into patient(cpf,birth_date,name,sex,address_id) values(05041113340,'1994-06-09','José Araujo','masculino',1);
insert into patient(cpf,birth_date,name,sex,address_id) values(74196081300,'1969-07-12','Marlene Silva','feminino',2);
insert into patient(cpf,birth_date,name,sex,address_id) values(38974144430,'1990-04-25','Gil Aragão','feminino',4);

--select * from comorbidity;
insert into comorbidity(name) values('obesidade');
insert into comorbidity(name) values('diabetes');
insert into comorbidity(name) values('hipertensão');

--select * from patient_comorbidity;
insert into patient_comorbidity(patient_id,comorbidity_id) values(05041113340,1);
insert into patient_comorbidity(patient_id,comorbidity_id) values(74196081300,2);
insert into patient_comorbidity(patient_id,comorbidity_id) values(74196081300,3);

--select * from patient_phones;
insert into patient_phones(patient_cpf,phones) values(05041113340,'88992919535');
insert into patient_phones(patient_cpf,phones) values(74196081300,'88994327444');

--select * from hospital;
insert into address(complement,neighborhood,number,street,city_id) values('proximo ao arco','centro',23,'av. dom jose',1);
insert into hospital(name, address_id) values('hospital de campanha',3);

--select * from doctor;
insert into doctor(crm,name,speciality,hospital_id) values(2075,'Ricardo Neves','Clinico geral',1);
insert into doctor(crm,name,speciality,hospital_id) values(3425,'Moura Carvalho','Ginecologista',1);

--select * from disease;
insert into disease(name) values('COVID19');
insert into disease(name) values('Infecção urinaria');

--select * from disease_symptons;
insert into disease_symptons(disease_id,symptons) values(1,'FEBRE,DOR DE CABECA,TOSSE');
insert into disease_symptons(disease_id,symptons) values(2,'FEBRE,DOR AO URINAR');

--select * from hospitalization;
insert into hospitalization(entrance_date,state, hospital_id,patient_id)
values('2020-04-02','GRAVE',1,'5041113340');
insert into hospitalization(entrance_date,exit_date,state, hospital_id,patient_id)
values('2020-06-28','2020-07-12','ESTAVEL',1,'74196081300');
insert into hospitalization(entrance_date,exit_date,state, hospital_id,patient_id)
values('2020-03-30','2020-04-20','ALTA',1,'38974144430');

--select * from diagnostic;
insert into diagnostic(date, status,hospitalization_id,disease_id,doctor_id)
values('2020-04-10','CONFIRMADO',5,1,2075);
insert into diagnostic(date, status,hospitalization_id,disease_id,doctor_id)
values('2020-06-30','CONFIRMADO',6,2,3425);
insert into diagnostic(date, status,hospitalization_id,disease_id,doctor_id)
values('2020-04-10','CONFIRMADO',7,2,2075);

--select * from exam;
insert into exam(description,name,type) values('Avaliação de imunidade','IgE','Amostra sanguinea');

--select * from evaluation_exam;
insert into evaluation_exam(collect_date,result,result_date,hospitalization_id,exam_id)
values('2020-04-02','POSITIVO','2020-04-10',5,1);

