DELIMITER //
CREATE PROCEDURE insertIntoTour(IN tourName VARCHAR(255), IN imageUrl VARCHAR(50), IN tourType VARCHAR(20))
BEGIN
INSERT INTO Tour(name, urlImage, type) VALUES(tourName, imageUrl, tourType);
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE updateTour(IN tourName VARCHAR(255), IN imageUrl VARCHAR(50), IN tourType VARCHAR(20), IN idTour INT)
BEGIN
UPDATE `db_manager_tour`.`tours` SET `name` = tourName, `urlImage` = imageUrl, `type` = tourType WHERE (`id` = idTour);
END //
DELIMITER ;