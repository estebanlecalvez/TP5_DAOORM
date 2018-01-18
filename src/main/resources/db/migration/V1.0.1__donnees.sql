#--- Editor
INSERT INTO Editor(name)
VALUES ('TrucMuche'),
	   ('MachinChose');

#--- Book
INSERT INTO Book(title, id_Editor)
VALUES ('La piscine', 1),
	   ('Le manoir', 1),
	   ('La forêt', 1),
	   ('Le monastère', 2),
	   ('La grande ville', 2);

#--- BookItem
INSERT INTO BookItem(itemCode, id_Book)
VALUES ('piscun', 1),
	   ('piscdeux', 1),
	   ('manoun', 2),
	   ('foreun', 3),
	   ('foredeux', 3),
	   ('foretrois', 3),
	   ('monaun', 4),
	   ('grdvilleun', 5);
	   
#--- Borrow
#--------- finished
INSERT INTO Borrow(borrowerName, borrowStart, borrowEnd, borrowed)
VALUES ('Martin', '2017-05-01', '2017-05-05', 1),
	   ('Jules', '2017-04-17', '2017-04-22', 2);
	   
#--------- not finished
INSERT INTO Borrow(borrowerName, borrowStart, borrowed)
VALUES ('Durand', '2016-12-16', 3),
	   ('Bernard', '2017-03-30', 4),
	   ('Michelin', '2016-11-18', 5);