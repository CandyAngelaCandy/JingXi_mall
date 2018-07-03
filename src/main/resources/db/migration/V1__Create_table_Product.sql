CREATE TABLE Product(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
	description VARCHAR(255),
	price DECIMAL,
	createDate Date,
	createUser INT,
	lastEditDate Date,
	lastEditUser INT
) engine=InnoDB DEFAULT CHARSET = gbk;

CREATE TABLE Product_Log(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ActionCode INT,
	description VARCHAR(255),
	price DECIMAL,
	Notes VARCHAR(255),
	createDate Date,
	createUser INT,
) engine=InnoDB DEFAULT CHARSET = gbk;

CREATE TABLE Customer(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    address VARCHAR(255),
    createUser INT,
    lastEditDate Date,
    lastEditUser INT
) engine=InnoDB DEFAULT CHARSET = gbk;

CREATE TABLE Customer_Log(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    actionCode INT,
    Notes VARCHAR(255),
    CreateDate Date,
    createUser INT
) engine=InnoDB DEFAULT CHARSET = gbk;

CREATE TABLE Express(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    status INT,
    CreateDate Date,
    CreateUser INT,
    lastEditDate Date,
    lastEditUser INT
) engine=InnoDB DEFAULT CHARSET = gbk;

CREATE TABLE Express_Merchant(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255),
    ThirdPartReferenceId VARCHAR(255),
    CreateDate Date,
    CreateUser INT,
    lastEditDate Date,
    lastEditUser INT
) engine=InnoDB DEFAULT CHARSET = gbk;

CREATE TABLE Inventory(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Quantity INT,
    lockQuantity INT,
    orderQuantity INT,
    CreateDate Date,
    CreateUser INT,
    lastEditDate Date,
    lastEditUser INT
) engine=InnoDB DEFAULT CHARSET = gbk;

CREATE TABLE Inventory_Log(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ActionCode INT,
    Quantity INT,
    LockQuantity INT,
    orderQuantity INT,
    CreateDate Date,
    CreateUser INT,
) engine=InnoDB DEFAULT CHARSET = gbk;

CREATE TABLE Order_Items(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ProductId INT,
    ProductName VARCHAR(255),
    ItemPrice DECIMAL,
    Quantity INT,
    CreateDate Date,
    CreateUser INT,
    lastEditDate Date,
    lastEditUser INT
) engine=InnoDB DEFAULT CHARSET = gbk;

CREATE TABLE Order_Mater(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    status INT,
    Amount DECIMAL,
    CreateDate Date,
    CreateUser INT,
    lastEditDate Date,
    lastEditUser INT,
    Notes VARCHAR(255),
) engine=InnoDB DEFAULT CHARSET = gbk;

CREATE TABLE Order_Mater_Log(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ActionCode INT,
    Notes VARCHAR(255),
    CreateDate Date,
    CreateUser INT,
) engine=InnoDB DEFAULT CHARSET = gbk;

