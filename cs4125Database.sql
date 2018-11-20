DROP TABLE IF EXISTS Users;

create table Users(
userId int(11) NOT NULL AUTO_INCREMENT,
username varchar(15) not null,
password varchar(15) not null,
primary key(userId)
);

INSERT INTO Users values(default, 'username', 'password');

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
     FOREIGN KEY(listingId) REFERENCES movielistings(listId)
);
	 
insert into seats values(default, 1, '0-0-0-0-0-0-0-0-0-0');