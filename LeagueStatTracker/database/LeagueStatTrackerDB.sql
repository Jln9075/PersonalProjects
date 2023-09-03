BEGIN TRANSACTION;

DROP TABLE IF EXISTS

CREATE TABLE summoner_name(
    summoner_name varchar(16) NOT NULL,
    puuid  varchar(128) NOT NULL,
    CONSTRAINT PK_summoner_name PRIMARY KEY (summoner_name),
    CONSTRAINT UQ_puuid UNIQUE (puuid)
);

CREATE TABLE match_history(
    match_history varchar(16) NOT NULL,
    summoner_name varchar(16) NOT NULL,
    CONSTRAINT PK_matches PRIMARY KEY (match_history, summoner_name),
    CONSTRAINT FK_summoner_name FOREIGN KEY (summoner_name) REFERENCES summoner_name(summoner_name)
);

CREATE TABLE match_id(
    match_id
);