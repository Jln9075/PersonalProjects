-- Database: RecipeSaver
DROP TABLE IF EXISTS ingredient;
DROP TABLE IF EXISTS recipe_info;




CREATE TABLE recipe_info(
	recipe_id serial,
	recipe_name varchar(128) NOT NULL,
	description varchar,
	recipe_author varchar(256),
	CONSTRAINT PK_recipe_info PRIMARY KEY (recipe_id)
);

CREATE TABLE ingredient(
    ingredient_name varchar(128) NOT NULL,
    recipe_id int NOT NULL,
    quantity varchar(64),
    CONSTRAINT PK_ingredient PRIMARY KEY (ingredient_name, recipe_id),
    CONSTRAINT FK_recipe_info FOREIGN KEY(recipe_id) REFERENCES recipe_info(recipe_id)
	
);


INSERT INTO recipe_info(recipe_name, description, recipe_author) VALUES
--1
    ('Oatmeal', 'Classic bowl of oatmeal', 'Grandma'),
--2
    ('Hash Browns', null, 'Guy Fieri'),
--3
    ('Beef Wellington', 'Its beef wellington you knucklehead', 'Gordon Ramsey');

INSERT INTO ingredient(ingredient_name, recipe_id, quantity) VALUES
--Recipe 1
    ('Oats', 1, '1 cup'),
    ('Water', 1, '2 cups'),
--Recipe 2
    ('Potatoes', 2, '3 Large Russets'),
    ('Salt', 2, 'just a pinch'),
    ('Black Pepper', 2, 'to taste'),
    ('Neutral Oil', 2, '2Tbsp'),
--Recipe 3
    ('Beef', 3, '1 pound roast'),
    ('Well', 3, 'A deep one'),
	('Salt', 3, 'just a pinch'),
    ('idkington', 3, 'Lots of it');
