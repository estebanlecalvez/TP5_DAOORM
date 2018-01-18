#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------

#------------------------------------------------------------
# Table: Editor
#------------------------------------------------------------

DROP TABLE if exists editor;

CREATE TABLE Editor(
        id   Int Auto_increment  NOT NULL ,
        name Varchar (25) ,
        PRIMARY KEY (id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Book
#------------------------------------------------------------

DROP TABLE if exists Book;

CREATE TABLE Book(
        id        Int Auto_increment  NOT NULL ,
        title     Varchar (25) NOT NULL ,
        id_Editor Int NOT NULL ,
        PRIMARY KEY (id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: BookItem
#------------------------------------------------------------

DROP TABLE if exists BookItem;

CREATE TABLE BookItem(
        id       Int Auto_increment NOT NULL ,
        itemCode Varchar (25) NOT NULL ,
        id_Book  Int NOT NULL ,
        PRIMARY KEY (id)
)ENGINE=InnoDB;



#------------------------------------------------------------
# Table: Borrow
#------------------------------------------------------------

DROP TABLE if exists Borrow;

CREATE TABLE Borrow(
        id           Int Auto_increment  NOT NULL ,
        borrowerName Varchar (25) NOT NULL ,
        borrowStart  Datetime NOT NULL ,
        borrowEnd    Datetime ,
        borrowed     Int NOT NULL ,
        PRIMARY KEY (id)
)ENGINE=InnoDB;

ALTER TABLE Book ADD CONSTRAINT FK_Book_id_Editor FOREIGN KEY (id_Editor) REFERENCES Editor(id);
ALTER TABLE BookItem ADD CONSTRAINT FK_BookItem_id_Book FOREIGN KEY (id_Book) REFERENCES Book(id);
ALTER TABLE Borrow ADD CONSTRAINT FK_Borrow_borrowed FOREIGN KEY (borrowed) REFERENCES BookItem(id);