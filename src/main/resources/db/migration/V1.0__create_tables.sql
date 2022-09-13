

create table profile (
  id int not null
  primary key
  auto_increment,
  firstName varchar(255) null,
  lastName varchar(255) null,
  phoneNumber varchar(255) null
);


create table user (
  id int not null
  primary key
  auto_increment,
  created time not null,
  email varchar(255) null
  unique key,
  hasTemporaryPassword tinyint default 0,
  isConfirmedByEmail tinyint default 0,
  last_update datetime(6) null,
  password varchar(255) null,
  profile_id int null,
  foreign key  (profile_id) references  profile (id)
);

create table book (
  id int not null
  primary key
  auto_increment,
  createdOn datetime(6)  null,
  description varchar(255)  null,
  shelfNumber varchar(255)  null,
  bookStatus varchar(255)  null,
  title varchar(255)  null,
  user_id int null,
  foreign key  (user_id) references  user (id)
);

create table author (
  id int not null
  primary key
  auto_increment,
  biography varchar(1000) null,
  birthDate datetime(6) null,
  firstName varchar(255) null,
  lastName varchar(255) null
);

create table book_author (
  book_id int not null,
  author_id int not null,
  foreign key  (author_id) references  author (id),
  foreign key (book_id) references  book (id)
);

create table category (
  id int not null
  auto_increment
  primary key,
  title varchar(255) null
  unique key
);

create table book_category (
  book_id int null,
  category_id int null,
  foreign key (category_id) references  category (id),
  foreign key  (book_id) references  book (id)
);

create table history (
  id int not null
  primary key
  auto_increment,
  actionName varchar(255) null,
  date datetime(6) null,
  book_id int null,
  user_id int null,
  foreign key  (user_id) references  user (id),
  foreign key  (book_id) references  book (id)
);


create table user_role (
  user_id int not null,
  roles varchar(255) not null,
  foreign key  (user_id) references  user (id)
);

create table confirmation_token (
  id int not null
  auto_increment
  primary key,
  confirmedAt datetime(6)  null,
  createdAt datetime(6)  null,
  expiresAt datetime(6)  null,
  status varchar(255) null,
  token varchar(255)  null,
  user_id int not null,
  foreign key (user_id) references  user (id)
);
INSERT INTO profile (firstName, lastName, phoneNumber)
VALUES ('John', 'Smith', '+3736901254'),
       ('Charlotte', 'Brown', '+3736912455');

INSERT INTO user (created, email, isConfirmedByEmail, last_update, password, profile_id)
VALUES (NOW(), 'admin@gmail.com', 1,  NOW(), '$2a$12$d0xSkVIXVYUiRB8tYvHhVuNNnaDHknkjO453z6yeQDRPcnB5CKE72', 1),
       (NOW(), 'librarian@gmail.com', 1, NOW(), '$2a$12$B3oQ6bIBSCTnYd98uQfaAe3f1HGXGvJjYzCc0Sa7Q1TC9w4Dm8zbS', 2);


INSERT INTO user_role VALUES (1, 'USER'),
                             (1, 'ADMIN'),
                             (2, 'USER'),
                             (2, 'LIBRARIAN');

INSERT INTO book (createdOn, description, shelfNumber, bookStatus, title)
VALUES (NOW(), 'Murder on the Orient Express is a work of detective fiction by English writer Agatha Christie featuring the Belgian detective Hercule Poirot.',
             "00001", 'AVAILABLE', 'Murder on the Orient Express');

INSERT INTO author (biography, birthDate, firstName, lastName)
VALUES ('Agatha Mary Clarissa Miller was born on 15 September 1890, into a wealthy upper middle class family in Torquay, Devon. She was the youngest of three children born to Frederick Alvah Miller, "a gentleman of substance", and his wife Clarissa Margaret "Clara" Miller, née Boehmer.',
             "1890-09-15", 'Agatha', 'Christie');

INSERT INTO book_author VALUES (1, 1),
                               (1, 1);

INSERT INTO category (title) VALUES ('Detective');
INSERT INTO book_category VALUES (1, 1);