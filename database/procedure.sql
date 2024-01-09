CREATE DEFINER=`root`@`localhost` PROCEDURE `checkLoginAccount`(IN inUsername varchar(50), IN `inPassword` varchar(40))
BEGIN
select a.id, a.userName, a.urlImage, a.`role`
from accounts a
where a.userName = inUsername and a.password = inPassword;
END
-----------------------------------------------------------------------------------------------
CREATE DEFINER=`root`@`localhost` PROCEDURE `checkStatusDescriptionTour`()
BEGIN
    DECLARE description_tour_id_var INT;
    DECLARE start_date_var DATE;
    DECLARE end_date_var DATE;

    DECLARE done INT DEFAULT FALSE;
    DECLARE description_tour_cursor CURSOR FOR
SELECT id, dateStart, dateEnd FROM description_tours;

DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

OPEN description_tour_cursor;
read_loop: LOOP
        FETCH description_tour_cursor INTO description_tour_id_var, start_date_var, end_date_var;

        IF done THEN
            LEAVE read_loop;
END IF;

        IF end_date_var < CURDATE() THEN
            -- Tour đã kết thúc, cập nhật trạng thái là "Quá hạn"
UPDATE description_tours SET status = 'END' WHERE id = description_tour_id_var;
ELSEIF start_date_var > CURDATE() THEN
            -- Tour chưa bắt đầu, cập nhật trạng thái là "Chưa bắt đầu"
UPDATE description_tours SET status = 'PROCESSING' WHERE id = description_tour_id_var;
ELSEIF CURDATE() between start_date_var and end_date_var THEN
UPDATE description_tours SET status = 'START' WHERE id = description_tour_id_var;
END IF;
SELECT description_tour_id_var, start_date_var, end_date_var;
END LOOP;

CLOSE description_tour_cursor;

END
-----------------------------------------------------------------------------------------------
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteDescriptionTour`(IN idDescription int)
BEGIN
DELETE FROM `db_manager_tour`.`description_tours` WHERE `id` = idDescription;
END
-----------------------------------------------------------------------------------------------
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteTour`(IN idTour INT)
BEGIN
IF exists (Select * from description_tours dt where dt.tours_id = idTour) then delete from `db_manager_tour`.`description_tours` where tours_id = idTour;
end if;
DELETE FROM `db_manager_tour`.`tours` WHERE (`id` = idTour);
END
-----------------------------------------------------------------------------------------------
CREATE DEFINER=`root`@`localhost` PROCEDURE `handleProcessingTour`(IN idBooking INT, IN idEmployee int, IN statusBooking VARCHAR(15))
BEGIN
    IF statusBooking = 'PROCESSING' THEN
UPDATE `db_manager_tour`.`bookings` SET `status` = 'PROCESSING', `employees_id` = idEmployee WHERE `id` = idBooking;
END IF;

    IF statusBooking = 'CANCEL' THEN
UPDATE `db_manager_tour`.`bookings` SET `status` = 'CANCEL', `employees_id` = idEmployee WHERE `id` = idBooking;
END IF;

    IF statusBooking = 'PROCESSED' THEN
UPDATE `db_manager_tour`.`bookings` SET `status` = 'PROCESSED', `employees_id` = idEmployee WHERE `id` = idBooking;
END IF;
END
-----------------------------------------------------------------------------------------------
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertCustomerAndAccountData`(
    IN p_customer_name VARCHAR(255),
    IN p_customer_phone VARCHAR(20),
    IN p_customer_address VARCHAR(255),
    IN p_customer_email VARCHAR(255),
    IN p_account_username VARCHAR(255),
    IN p_account_password VARCHAR(255)
)
BEGIN
    DECLARE account_id INT;

    -- Thêm dữ liệu vào bảng `account`
INSERT INTO `accounts` (`username`, `password`, `role`)
VALUES (p_account_username, p_account_password, 'CUSTOMER');

-- Lấy ID của account vừa thêm vào
SET account_id = LAST_INSERT_ID();

    -- Thêm dữ liệu vào bảng `customers` với accounts_id
INSERT INTO `customers` (`name`, `phone`, `address`, `email`, `accounts_id`)
VALUES (p_customer_name, p_customer_phone, p_customer_address, p_customer_email, account_id);
END
-----------------------------------------------------------------------------------------------
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertIntoBooking`(IN seatPlace int, IN totalPrice int, IN pay varchar(20), IN idCustomer int, IN idDescription_id int)
BEGIN
INSERT INTO `db_manager_tour`.`bookings` (`seat`, `totalPrice`, `dateBooking`, `status`, `payment`, `customers_id`, `description_tours_id`) VALUES (seatPlace, totalPrice, CURDATE(), 'PROCESSED', pay, idCustomer, idDescription_id);
END
-----------------------------------------------------------------------------------------------
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertIntoDescriptionTour`(IN dateStart DATE, IN dateEnd DATE, IN seat int, IN price int, IN `descriptions` varchar(250), IN idTour int)
BEGIN
INSERT INTO `db_manager_tour`.`description_tours` (`dateStart`, `dateEnd`, `seat`, `price`, `status`, `description`, `tours_id`) VALUES (dateStart, dateEnd, seat, price, 'PROCESSING', `descriptions`, idTour);
END
-----------------------------------------------------------------------------------------------
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertIntoDescriptionTour`(IN dateStart DATE, IN dateEnd DATE, IN seat int, IN price int, IN `descriptions` varchar(250), IN idTour int)
BEGIN
INSERT INTO `db_manager_tour`.`description_tours` (`dateStart`, `dateEnd`, `seat`, `price`, `status`, `description`, `tours_id`) VALUES (dateStart, dateEnd, seat, price, 'PROCESSING', `descriptions`, idTour);
END
-----------------------------------------------------------------------------------------------
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertIntoTour`(IN tourName VARCHAR(255), IN imageUrl VARCHAR(350), IN tourType VARCHAR(20))
BEGIN
INSERT INTO Tours(name, urlImage, type) VALUES(tourName, imageUrl, tourType);
END
-----------------------------------------------------------------------------------------------
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateDescriptionTour`(IN dateStart DATE, IN dateEnd DATE, IN seat int, IN price int, IN descriptions varchar(250), IN idDescription int)
BEGIN
UPDATE `db_manager_tour`.`description_tours` SET `dateStart` = dateStart, `dateEnd` = dateEnd, `seat` = seat, `price` = price, `description` = descriptions WHERE (`id` = idDescription);
END
-----------------------------------------------------------------------------------------------
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateTour`(IN tourName VARCHAR(255), IN imageUrl VARCHAR(50), IN tourType VARCHAR(20), IN idTour INT)
BEGIN
UPDATE `db_manager_tour`.`tours` SET `name` = tourName, `urlImage` = imageUrl, `type` = tourType WHERE (`id` = idTour);
END