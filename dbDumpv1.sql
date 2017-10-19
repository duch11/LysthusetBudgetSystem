CREATE TABLE LysthusetBudgetSystem.user
(
  ID INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  pass VARCHAR(50) NOT NULL,
  active TINYINT(1) DEFAULT '1',
  admin TINYINT(1) DEFAULT '0'
);

INSERT INTO lysthusetbudgetsystem.user (name, pass, active, admin) VALUES ('Jonas', '123', 1, 0);
INSERT INTO lysthusetbudgetsystem.user (name, pass, active, admin) VALUES ('Stine', '123', 1, 0);
INSERT INTO lysthusetbudgetsystem.user (name, pass, active, admin) VALUES ('Røde', '123', 1, 0);
INSERT INTO lysthusetbudgetsystem.user (name, pass, active, admin) VALUES ('Tine', '123', 1, 0);
INSERT INTO lysthusetbudgetsystem.user (name, pass, active, admin) VALUES ('Michael', '123', 1, 0);
INSERT INTO lysthusetbudgetsystem.user (name, pass, active, admin) VALUES ('Marie', '123', 1, 0);