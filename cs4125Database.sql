DROP TABLE IF EXISTS bookings;
DROP TABLE IF EXISTS seats;
DROP TABLE IF EXISTS movieListings;
DROP TABLE IF EXISTS bookings;
DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Movies;


create table Users(
userId int(11) NOT NULL AUTO_INCREMENT,
username varchar(15) not null,
password varchar(15) not null,
typeOfUser char(1) not null,
primary key(userId)
);

INSERT INTO Users values(default, 'username', 'password', '1');

CREATE TABLE Movies(
	movieId int(11) NOT NULL AUTO_INCREMENT,
	movieName varchar(15) NOT NULL,
	genre varchar(10) NOT NULL,
	PRIMARY KEY(movieId)
);

INSERT INTO Movies values(default, 'The Conjuring', 'horror');

CREATE TABLE movieListings(
	listId int(11) NOT NULL AUTO_INCREMENT,
	movie int(11) NOT NULL,
	date date,
	time char(5) NOT NULL,
	PRIMARY KEY(listId),
	FOREIGN KEY (movie) REFERENCES Movies(movieId) ON DELETE CASCADE
);

INSERT INTO movieListings values(default, 1, '2018-12-07', '09-15');
INSERT INTO movieListings values(default, 1, '2018-12-05', '12-15');

create table seats(
     seatsId int(11) NOT NULL AUTO_INCREMENT,
     listingId int(11) NOT NULL,
     seat char(19) NOT NULL,
     PRIMARY KEY(seatsId),
     FOREIGN KEY(listingId) REFERENCES movielistings(listId) ON DELETE CASCADE
);
	 
insert into seats values(default, 1, '0-0-0-0-0-0-0-0-0-0');

create table bookings(
	bookingId int(11) NOT NULL AUTO_INCREMENT,
	userId int(11) NOT NULL,
	listingId int(11) NOT NULL,
	seatNo int(11) NOT NULL,
	paymentTyp varchar(11) NOT NULL,
	refundRq tinyint(1) DEFAULT 0,
	PRIMARY KEY(bookingId),
	FOREIGN KEY(userId) REFERENCES Users(userId),
	FOREIGN KEY(listingId) REFERENCES movielistings(listId) ON DELETE CASCADE
);