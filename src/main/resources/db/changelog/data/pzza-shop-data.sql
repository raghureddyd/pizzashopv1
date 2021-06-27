INSERT INTO PSO_PIZZA (CODE, NAME, BASE_PRICE) VALUES ('NEAP', 'Neapolitan Pizza', 10.00);
INSERT INTO PSO_PIZZA (CODE, NAME, BASE_PRICE) VALUES ('CHIC', 'Chicago Pizza', 12.00);
INSERT INTO PSO_PIZZA (CODE, NAME, BASE_PRICE) VALUES ('NYSP', 'New York-Style Pizza', 10.00);
INSERT INTO PSO_PIZZA (CODE, NAME, BASE_PRICE) VALUES ('SICI', 'Sicilian Pizza', 14.00);
/*INSERT INTO PSO_PIZZA (CODE, NAME, BASE_PRICE) VALUES ('GREK', 'Greek Pizza', 16.00);
INSERT INTO PSO_PIZZA (CODE, NAME, BASE_PRICE) VALUES ('CALI', 'California Pizza', 20.00);
INSERT INTO PSO_PIZZA (CODE, NAME, BASE_PRICE) VALUES ('DETR', 'Detroit Pizza', 16.00);
INSERT INTO PSO_PIZZA (CODE, NAME, BASE_PRICE) VALUES ('LOUS', 'St. Louis Pizza', 16.00);*/

INSERT INTO PSO_INGREDIENT (CODE, NAME, PRICE) VALUES ('TOMA', 'tomatoes', 1.00);
INSERT INTO PSO_INGREDIENT (CODE, NAME, PRICE) VALUES ('GARL', 'garlic', 1.00);
INSERT INTO PSO_INGREDIENT (CODE, NAME, PRICE) VALUES ('OREG', 'oregano', 1.00);
INSERT INTO PSO_INGREDIENT (CODE, NAME, PRICE) VALUES ('OLIV', 'virgin olive oil', 1.00);
INSERT INTO PSO_INGREDIENT (CODE, NAME, PRICE) VALUES ('MOZZ', 'mozzarella', 1.00);
INSERT INTO PSO_INGREDIENT (CODE, NAME, PRICE) VALUES ('BASL', 'basil', 1.00);

INSERT INTO PSO_INGREDIENT (CODE, NAME, PRICE) VALUES ('BEEF', 'beef', 1.00);
INSERT INTO PSO_INGREDIENT (CODE, NAME, PRICE) VALUES ('PERI', 'pepperoni', 2.00);
INSERT INTO PSO_INGREDIENT (CODE, NAME, PRICE) VALUES ('ONIN', 'onion', 1.00);
INSERT INTO PSO_INGREDIENT (CODE, NAME, PRICE) VALUES ('MUSH', 'mushrooms', 2.00);
INSERT INTO PSO_INGREDIENT (CODE, NAME, PRICE) VALUES ('TSAU', 'robust tomato sauce', 1.00);
INSERT INTO PSO_INGREDIENT (CODE, NAME, PRICE) VALUES ('FCHE', 'feta cheese', 2.00);

INSERT INTO PSO_PIZZA_INGREDIENTS (PIZZA_CODE, INGREDIENT_CODE) VALUES ('NEAP', 'TOMA');
INSERT INTO PSO_PIZZA_INGREDIENTS (PIZZA_CODE, INGREDIENT_CODE) VALUES ('NEAP', 'GARL');
INSERT INTO PSO_PIZZA_INGREDIENTS (PIZZA_CODE, INGREDIENT_CODE) VALUES ('NEAP', 'OREG');
INSERT INTO PSO_PIZZA_INGREDIENTS (PIZZA_CODE, INGREDIENT_CODE) VALUES ('NEAP', 'OLIV');

INSERT INTO PSO_PIZZA_INGREDIENTS (PIZZA_CODE, INGREDIENT_CODE) VALUES ('CHIC', 'MOZZ');
INSERT INTO PSO_PIZZA_INGREDIENTS (PIZZA_CODE, INGREDIENT_CODE) VALUES ('CHIC', 'BASL');
INSERT INTO PSO_PIZZA_INGREDIENTS (PIZZA_CODE, INGREDIENT_CODE) VALUES ('CHIC', 'BEEF');
INSERT INTO PSO_PIZZA_INGREDIENTS (PIZZA_CODE, INGREDIENT_CODE) VALUES ('CHIC', 'OLIV');

INSERT INTO PSO_PIZZA_INGREDIENTS (PIZZA_CODE, INGREDIENT_CODE) VALUES ('NYSP', 'PERI');
INSERT INTO PSO_PIZZA_INGREDIENTS (PIZZA_CODE, INGREDIENT_CODE) VALUES ('NYSP', 'ONIN');
INSERT INTO PSO_PIZZA_INGREDIENTS (PIZZA_CODE, INGREDIENT_CODE) VALUES ('NYSP', 'MUSH');
INSERT INTO PSO_PIZZA_INGREDIENTS (PIZZA_CODE, INGREDIENT_CODE) VALUES ('NYSP', 'TSAU');

INSERT INTO PSO_PIZZA_INGREDIENTS (PIZZA_CODE, INGREDIENT_CODE) VALUES ('SICI', 'PERI');
INSERT INTO PSO_PIZZA_INGREDIENTS (PIZZA_CODE, INGREDIENT_CODE) VALUES ('SICI', 'ONIN');
INSERT INTO PSO_PIZZA_INGREDIENTS (PIZZA_CODE, INGREDIENT_CODE) VALUES ('SICI', 'MUSH');
INSERT INTO PSO_PIZZA_INGREDIENTS (PIZZA_CODE, INGREDIENT_CODE) VALUES ('SICI', 'FCHE');

INSERT INTO PSO_USER (CODE, PASSWORD,PHONE_NUMBER,FIRST_NAME,LAST_NAME,STREET,STREET_NO,PIN_CODE) VALUES ('RDH', 'rdhRDH','0767184424','Raghavendra','Dhanugonda','Rosslimatte',12,6207);
INSERT INTO PSO_USER (CODE, PASSWORD,PHONE_NUMBER,FIRST_NAME,LAST_NAME,STREET,STREET_NO,PIN_CODE) VALUES ('CTA', 'ctaCTA','0123456789','Colin','Talimania','Luzernerstrasse',14,6210);
INSERT INTO PSO_USER (CODE, PASSWORD,PHONE_NUMBER,FIRST_NAME,LAST_NAME,STREET,STREET_NO,PIN_CODE) VALUES ('SWA', 'swaSWA','0987654321','Sandra','Warsback','Kantonalstrasse',15,6209);


INSERT INTO PSO_ROLE(CODE,NAME) VALUES ('USER','Customer');
INSERT INTO PSO_ROLE(CODE,NAME) VALUES ('STAFF','Working staff');
INSERT INTO PSO_ROLE(CODE,NAME) VALUES ('ADMIN','System Administrator');

INSERT INTO PSO_USER_ROLES (USER_CODE,ROLE_CODE)VALUES ('CTA','USER');
INSERT INTO PSO_USER_ROLES (USER_CODE,ROLE_CODE)VALUES ('SWA','STAFF');
INSERT INTO PSO_USER_ROLES (USER_CODE,ROLE_CODE)VALUES ('RDH','ADMIN');

INSERT INTO PSO_ORDER (CUSTOMER_CODE,CREATED_ON) VALUES ('RDH', ${now});

INSERT INTO PSO_ORDER_DETAIL (ORDER_ID,PIZZA_CODE,QUANTITY,PRICE) VALUES (1,'CHIC',1,12.00);
INSERT INTO PSO_ORDER_DETAIL (ORDER_ID,PIZZA_CODE,QUANTITY,PRICE) VALUES (1,'NEAP',1,10.00);
INSERT INTO PSO_ORDER_DETAIL (ORDER_ID,PIZZA_CODE,QUANTITY,PRICE) VALUES (1,'NYSP',1,10.00);
INSERT INTO PSO_ORDER_DETAIL (ORDER_ID,PIZZA_CODE,QUANTITY,PRICE) VALUES (1,'SICI',1,14.00);

INSERT INTO PSO_ORDER_TRACKING(ORDER_ID,STATUS,ACTIVE,CREATED_ON,COMMENTS) VALUES (1,'RECEIVED','1',${now},'Order received will process ASAP');










