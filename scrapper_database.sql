drop database scrapper;
create database scrapper;
use scrapper;

create table actors(
    name VARCHAR(50),
    picture VARCHAR(100),
    description VARCHAR(50),
    born_info VARCHAR(50),
    imdb_uri VARCHAR(50) NOT NULL,
    PRIMARY KEY (imdb_uri)
);

create table movies(
    name VARCHAR(50),
    years  VARCHAR(10),
    characters VARCHAR(50),
    imdb_uri VARCHAR(50) NOT NULL,
    PRIMARY KEY (imdb_uri)
);

create table actor_movie(
    actor_id  VARCHAR(50) NOT NULL,
    movie_id  VARCHAR(50) NOT NULL,
    PRIMARY KEY (actor_id, movie_id),
    FOREIGN KEY(actor_id) REFERENCES actors(imdb_uri),
    FOREIGN KEY(movie_id) REFERENCES movies(imdb_uri)
);

# TRIGGER deletar ator
DROP TRIGGER IF EXISTS drop_actor;

DELIMITER $$

CREATE TRIGGER drop_actor
BEFORE DELETE
ON actors
    FOR EACH ROW 
    BEGIN
        DELETE FROM actor_movie WHERE actor_id = OLD.imdb_uri;
    END$$

DELIMITER ;

# TRIGGER deletar filme
DROP TRIGGER IF EXISTS drop_movie;

DELIMITER $$

CREATE TRIGGER drop_movie
BEFORE DELETE
ON movies
    FOR EACH ROW 
    BEGIN
        DELETE FROM actor_movie WHERE movie_id = OLD.imdb_uri;
    END$$

DELIMITER ;