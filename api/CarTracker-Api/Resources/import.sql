insert into AlertPriority (id, name) values ("ap-01", "LOW");
insert into AlertPriority (id, name) values ("ap-02", "MEDIUM");
insert into AlertPriority (id, name) values ("ap-03", "HIGH");

insert into AlertType (id, description, alertPriority_id) values ("at-01", "Low Engine Coolant Level", "ap-01");
insert into AlertType (id, description, alertPriority_id) values ("at-02", "Improper Tire Pressure", "ap-01");
insert into AlertType (id, description, alertPriority_id) values ("at-03", "Low Fuel", "ap-02");
insert into AlertType (id, description, alertPriority_id) values ("at-04", "High Engine RPM", "ap-03");